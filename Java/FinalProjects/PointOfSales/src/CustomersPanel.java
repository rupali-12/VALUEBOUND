import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Vector;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.*;

public class CustomersPanel extends JPanel {

    // Widgets
    JLabel search_lbl;
    Label name_lbl;
    JLabel tp_number_lbl;

    JTextField search_Field;
    JTextField name_Field;;
    JTextField tpNum_Field;
    JTextField searchTable_field;

    JButton save_Btn;
    JButton search_Btn;
    JButton update_Btn;
    JButton delete_Btn;
    JButton search_table_Btn;

    // Table
    JTable table;
    DefaultTableModel defaultTableModel;

    // Database

    DB database;

    public CustomersPanel() {
        database = new DB();

        // Widget initialisation
        search_lbl = new JLabel("Search by Mobile NB: ");
        name_lbl = new Label("Name:");
        tp_number_lbl = new JLabel("Mobile Number: ");

        name_Field = new JTextField();
        search_Field = new JTextField();
        tpNum_Field = new JTextField();
        searchTable_field = new JTextField();

        save_Btn = new JButton("Save");
        update_Btn = new JButton("Update");
        delete_Btn = new JButton("Delete");
        search_Btn = new JButton("Search");
        search_table_Btn = new JButton("Search Table");

        // Left panel grid

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 300));

        leftPanel.setLayout(new GridLayout(8, 2));

        leftPanel.add(search_lbl);
        leftPanel.add(search_Field);
        leftPanel.add(name_lbl);
        leftPanel.add(name_Field);
        leftPanel.add(tp_number_lbl);
        leftPanel.add(tpNum_Field);

        leftPanel.add(save_Btn);
        leftPanel.add(search_Btn);
        leftPanel.add(update_Btn);
        leftPanel.add(delete_Btn);
        leftPanel.add(searchTable_field);
        leftPanel.add(search_table_Btn);

        // Handle click event
        save_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertCustomerIntoDB();
            }

        });

        update_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCustomerIntoDB();
            }
        });
        delete_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCustomerIntoDB();
            }
        });
        search_table_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCustomerByName();
            }
        });
        search_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCustomerByMobile();
            }
        });

        // right panel: table
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(600, 500));
        rightPanel.setLayout(new BorderLayout());

        // Inititalizing table
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(650, 500));

        // load table
        loadTable();

        // adding click event on table rows
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int r = table.getSelectedRow();
                String name = table.getValueAt(r, 0).toString();

                String mobile_num = table.getValueAt(r, 1).toString();
                search_Field.setText(name);
                name_Field.setText(name);
                tpNum_Field.setText(mobile_num);

            }
        });

        JScrollPane sp = new JScrollPane(table);
        rightPanel.add(sp);
        // setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

    }

    public void updateCustomerIntoDB() {
        String name = name_Field.getText();
        String tp = tpNum_Field.getText();

        try (Connection con = database.mycon()) {
            Statement s = con.createStatement();
            s.executeUpdate("UPDATE customers SET customers_name = '" + name + "', mobile_num= '" + tp
                    + "' WHERE mobile_num='" + tp + "'");

            JOptionPane.showMessageDialog(null, "Customer Updated");
        } catch (SQLException e) {
            throw new RuntimeException("Error updating data into database", e);
        }
        loadTable();
    }

    public void deleteCustomerIntoDB() {
        String tp = tpNum_Field.getText();

        try (Connection con = database.mycon()) {
            Statement s = con.createStatement();
            s.executeUpdate("DELETE FROM customers  WHERE mobile_num='" + tp + "'");

            JOptionPane.showMessageDialog(null, "Customer Deleted");
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting data into database", e);
        }
        loadTable();
    }

    public void searchCustomerByName() {
        String name = searchTable_field.getText();

        try {
            defaultTableModel.setRowCount(0); // Clear existing rows

            // Create statement and execute query
            Statement s = database.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customers WHERE customers_name LIKE '%" + name + "%'");

            // Iterate through ResultSet and add rows to the table model
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("customers_name")); // Fetch by column name
                row.add(rs.getString("mobile_num")); // Fetch by column name

                defaultTableModel.addRow(row); // Add row to table model
            }

            // Close ResultSet and Statement
            rs.close();
            s.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error in searching customer", e);
        }
    }

    public void insertCustomerIntoDB() {
        String cus_name = name_Field.getText();
        String mobile_num = tpNum_Field.getText();
        try (Connection con = database.mycon()) {
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO customers (customers_name, mobile_num) VALUES ('" + cus_name + "', '"
                    + mobile_num + "')");
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
        loadTable();
    }

    public void searchCustomerByMobile() {
        String search = searchTable_field.getText();

        try {
            // Clear existing table data
            defaultTableModel.setRowCount(0);

            // Create statement and execute query
            Statement s = database.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customers WHERE mobile_num = '" + search + "'");

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("customers_name")); // Fetch by column name
                row.add(rs.getString("mobile_num")); // Fetch by column name

                defaultTableModel.addRow(row); // Add row to table model
            }

            // Close ResultSet and Statement
            rs.close();
            s.close();

        } catch (SQLException e) {
            throw new RuntimeException("Error in searching customer by mobile number", e);
        }

        // After fetching data, update the table UI
        table.setModel(defaultTableModel);
    }

    public void loadTable() {
        try {
            // Create a new DefaultTableModel
            defaultTableModel = new DefaultTableModel();
            defaultTableModel.addColumn("Customer Name");
            defaultTableModel.addColumn("Mobile Number");

            // Retrieve data from database
            Statement s = database.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customers");
            // Process ResultSet and populate the model
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("customers_name"));
                row.add(rs.getString("mobile_num"));
                defaultTableModel.addRow(row);
            }

            // Set the model to the table
            table.setModel(defaultTableModel);

            // Close ResultSet and Statement
            rs.close();
            s.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error loading table data", e);
        }
    }

}
