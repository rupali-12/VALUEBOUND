import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Invoice extends JPanel {
    // Widgets
    JLabel product_barcode_lbl;
    JTextField product_barcode_field;

    JLabel customer_name_lbl;
    JTextField customer_name_field;

    JButton addToCartBtn;
    JButton removeFromCartBtn;
    JButton confirmBtn;
    JButton saveInvoice;

    public JLabel totalPricelbl;

    // Cart Table
    JTable jTable;
    DefaultTableModel dt;

    // Cart
    ArrayList<String> selectedItems;
    DB database;

    public Invoice() {
        database = new DB();
        selectedItems = new ArrayList<>();

        // Initializing the widgets
        product_barcode_lbl = new JLabel("Product Barcode");
        product_barcode_field = new JTextField();
        product_barcode_field.setOpaque(false);

        customer_name_lbl = new JLabel("Customer Name");
        customer_name_field = new JTextField();
        customer_name_field.setOpaque(false);

        addToCartBtn = new JButton("Add To Cart");
        removeFromCartBtn = new JButton("Remove From Cart");
        confirmBtn = new JButton("Display Products Details");
        saveInvoice = new JButton("Save Invoice");

        totalPricelbl = new JLabel("Total Price: 0 $");
        totalPricelbl.setFont(new Font("Serif", Font.PLAIN, 18));

        // Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(9, 1, 5, 5));
        leftPanel.add(product_barcode_lbl);
        leftPanel.add(product_barcode_field);
        leftPanel.add(customer_name_lbl);
        leftPanel.add(customer_name_field);
        leftPanel.add(addToCartBtn);
        leftPanel.add(removeFromCartBtn);
        leftPanel.add(confirmBtn);
        leftPanel.add(saveInvoice);
        leftPanel.add(totalPricelbl);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(600, 500));
        rightPanel.setLayout(new FlowLayout());

        // Handling click event to buttons
        addToCartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String product_barcode = product_barcode_field.getText();
                selectedItems.add(product_barcode);
                displaySelectedItemsInTable(selectedItems);
                product_barcode_field.setText("");
            }
        });

        removeFromCartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String product_barcode = product_barcode_field.getText();
                selectedItems.remove(product_barcode);
                displaySelectedItemsInTable(selectedItems);
            }
        });

        confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get selected items into JTable
                dt.setRowCount(0);
                try {
                    String query = "SELECT product_name, price FROM products WHERE bar_code = ?";
                    PreparedStatement statement = database.mycon().prepareStatement(query);

                    // Iterate through selectedItems and fetch data
                    for (String barcode : selectedItems) {
                        statement.setString(1, barcode);
                        ResultSet rs = statement.executeQuery();
                        while (rs.next()) {
                            Vector<Object> row = new Vector<>();
                            row.add(barcode);
                            row.add(rs.getString("product_name"));
                            row.add(rs.getString("price"));
                            dt.addRow(row);
                        }
                    }
                    // calculating price
                    calculateTotalPrice();
                } catch (SQLException se) {
                    throw new RuntimeException("Error in Invoice confirm btn" + se);
                }

            }
        });

        // Initialize table
        dt = new DefaultTableModel();
        jTable = new JTable(dt);
        jTable.setPreferredSize(new Dimension(650, 500));
        jTable.setOpaque(false);

        // Load table with initial columns
        dt.addColumn("Product Barcode");
        dt.addColumn("Product Name");
        dt.addColumn("Product Price");

        saveInvoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cus_name = customer_name_field.getText();

                // Getting an array of selected products
                // 1. Getting name of products int the form of array
                ArrayList<String> products_names = new ArrayList<>();
                for (int i = 0; i < jTable.getRowCount(); i++) {
                    Object productName = jTable.getValueAt(i, 1);
                    if (productName != null) {
                        products_names.add(productName.toString());
                    }
                }

                // 2. Converting the arraylist to string
                StringBuilder sb = new StringBuilder();
                for (String s : products_names) {
                    sb.append(s);
                    sb.append(" , ");
                }

                // Getting the Current Date
                Timestamp timestamp = new Timestamp(new Date().getTime());

                // Total price
                int totalPrice = calculateTotalPrice();

                // Query to insert the data into the table
                String insertInvoice = "INSERT INTO invoice "
                        + "(customer_name, products_sold, date, total_price) VALUES (?, ?, ?, ?)";

                try (PreparedStatement ps = database.mycon().prepareStatement(insertInvoice)) {

                    if (!cus_name.equals("") && !selectedItems.isEmpty()) {
                        ps.setString(1, cus_name);
                        ps.setString(2, sb.toString());
                        ps.setTimestamp(3, timestamp);
                        ps.setInt(4, totalPrice);
                        ps.executeUpdate();
                    } else {
                        JOptionPane.showMessageDialog(null, "One or More fields are Empty");
                    }
                } catch (SQLException se) {
                    throw new RuntimeException("Error in saving Invoice" + se);
                }
                calculateTotalPrice();
            }
        });

        // Adding widgets to main panel
        JScrollPane sp = new JScrollPane(jTable);
        rightPanel.add(sp);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    private void displaySelectedItemsInTable(ArrayList<String> selectedItems) {
        try {
            // Resetting the table
            dt.setRowCount(0);

            // Inserting items from ArrayList to JTable
            for (String barcode : selectedItems) {
                dt.addRow(new Object[] { barcode, null, null });
            }
            calculateTotalPrice();
        } catch (Exception e) {
            throw new RuntimeException("Error in showing result in Invoice: " + e.getMessage(), e);
        }
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < jTable.getRowCount(); i++) {
            Object priceObj = jTable.getValueAt(i, 2);
            if (priceObj != null) {
                try {
                    totalPrice += Integer.parseInt(priceObj.toString());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid price at row " + i + ": " + priceObj);
                }
            }
        }
        totalPricelbl.setText("Total Price: " + totalPrice + " $");
        totalPricelbl.revalidate();
        totalPricelbl.repaint();
        this.revalidate(); // Revalidate the entire panel
        this.repaint(); // Repaint the entire panel
        return totalPrice;
    }
}
