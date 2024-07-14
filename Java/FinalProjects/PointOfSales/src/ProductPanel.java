import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ProductPanel extends JPanel {
    // widgets
    JLabel search_lbl;
    JLabel product_name_lbl;
    JLabel barcode_lbl;
    JLabel price_lbl;
    JLabel quantity_lbl;

    JTextField search_field;
    JTextField product_name_field;
    JTextField barcode_field;
    JTextField price_field;
    JTextField quantity_field;

    JButton save_Btn;
    JButton search_Btn;
    JButton update_Btn;
    JButton delete_Btn;

    // Table
    JTable table;
    DefaultTableModel defaultTableModel;;

    DB database;

    public ProductPanel() {
        database = new DB();

        search_lbl = new JLabel("Search Barcode:");
        product_name_lbl = new JLabel("Product Name");
        barcode_lbl = new JLabel("Bar Code: ");
        price_lbl = new JLabel("Price:");
        quantity_lbl = new JLabel("Quantity: ");

        product_name_field = new JTextField();
        search_field = new JTextField();
        quantity_field = new JTextField();
        barcode_field = new JTextField();
        price_field = new JTextField();

        save_Btn = new JButton("Save");
        update_Btn = new JButton("Update");
        delete_Btn = new JButton("Delete");
        search_Btn = new JButton("Search");

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 300));
        leftPanel.setLayout(new GridLayout(8, 2));

        leftPanel.add(search_lbl);
        leftPanel.add(search_field);
        leftPanel.add(product_name_lbl);
        leftPanel.add(product_name_field);
        leftPanel.add(barcode_lbl);
        leftPanel.add(barcode_field);
        leftPanel.add(quantity_lbl);
        leftPanel.add(quantity_field);
        leftPanel.add(price_lbl);
        leftPanel.add(price_field);

        leftPanel.add(save_Btn);
        leftPanel.add(search_Btn);
        leftPanel.add(update_Btn);
        leftPanel.add(delete_Btn);

        // Initializing th JTables
        table = new JTable();
        table.setPreferredSize(new Dimension(600, 500));

        loadTable();

        // Handle the click events on table rows
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int r = table.getSelectedRow();
                String barCode = table.getValueAt(r, 0).toString();
                String p_name = table.getValueAt(r, 1).toString();
                String price = table.getValueAt(r, 2).toString();
                String quantity = table.getValueAt(r, 3).toString();
                search_field.setText(barCode);
                product_name_field.setText(p_name);
                barcode_field.setText(barCode);
                price_field.setText(price);
                quantity_field.setText(quantity);

            }
        });

        // Right table: Table
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(600, 500));
        rightPanel.setLayout(new FlowLayout());

        // Handling the click event on Buttons
        save_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertProductIntoDB();
            }
        });
        search_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProductIntoDB();
            }
        });

        update_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductIntoDB();
            }
        });

        delete_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProductIntoDB();
            }
        });

        // Adding panels to the main Products
        JScrollPane sp = new JScrollPane(table);
        rightPanel.add(sp);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

    }

    private void insertProductIntoDB() {
        String product_name = product_name_field.getText();
        String bcode = barcode_field.getText();
        String price = price_field.getText();
        String quantity = quantity_field.getText();
        try (Connection con = database.mycon()) {
            Statement s = con.createStatement();
            s.executeUpdate(
                    "INSERT INTO products (product_name, bar_code, price, quantity) VALUES ('" + product_name + "', '"
                            + bcode + "', '" + price + "', '" + quantity + "')");
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting product into database", e);
        }
        loadTable();
    }

    public void updateProductIntoDB() {
        String product_name = product_name_field.getText();
        String bcode = barcode_field.getText();
        String price = price_field.getText();
        String quantity = quantity_field.getText();
        String barcode_to_search = search_field.getText();
        try {
            Statement s = database.mycon().createStatement();
            s.executeUpdate(
                    "UPDATE products SET product_name= '" + product_name + "', bar_code = '" + bcode + "', price= '"
                            + price + "', quantity = '" + quantity + "' WHERE bar_code = '" + barcode_to_search + "'");
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            throw new RuntimeException("Error in updating product" + e);
        }
        loadTable();
    }

    public void searchProductIntoDB() {
        String bcode = search_field.getText();

        try {
            defaultTableModel.setRowCount(0); // Clear existing rows

            // Create statement and execute query
            Statement s = database.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM products WHERE bar_code LIKE '%" + bcode + "%'");

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("bar_code")); // Fetch by column name
                row.add(rs.getString("product_name")); // Fetch by column name
                row.add(rs.getString("price")); // Fetch by column name
                row.add(rs.getString("quantity")); // Fetch by column name

                defaultTableModel.addRow(row); // Add row to table model
            }

            // Close ResultSet and Statement
            rs.close();
            s.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error in searching product", e);
        }
    }

    public void deleteProductIntoDB() {
        String bcode = search_field.getText();

        try (Connection con = database.mycon()) {
            Statement s = con.createStatement();
            int rowsAffected = s.executeUpdate("DELETE FROM products WHERE bar_code='" + bcode + "'");

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Product Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "No product found with the given barcode");
            }

            s.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting product from database", e);
        }
        loadTable();
    }

    private void loadTable() {
        try {
            // Create a new DefaultTableModel
            defaultTableModel = new DefaultTableModel();
            defaultTableModel.addColumn(" BarCode");
            defaultTableModel.addColumn("Product Number");
            defaultTableModel.addColumn(" Price");
            defaultTableModel.addColumn(" Quantity");

            // Retrieve data from database
            Statement s = database.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM products");
            // Process ResultSet and populate the model
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("bar_code"));
                row.add(rs.getString("product_name"));
                row.add(rs.getString("price"));
                row.add(rs.getString("quantity"));
                defaultTableModel.addRow(row);
            }

            // Set the model to the table
            table.setModel(defaultTableModel);

            // Close ResultSet and Statement
            rs.close();
            s.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error loading  product table data", e);
        }
    }

}
