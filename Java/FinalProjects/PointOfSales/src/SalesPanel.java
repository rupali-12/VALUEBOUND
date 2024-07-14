import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SalesPanel extends JPanel {
    JButton getSales;
    JLabel totalSaleslbl;

    JTable jTable;
    DefaultTableModel dt;
    DB database;

    public SalesPanel() {
        database = new DB();
        totalSaleslbl = new JLabel("Total Sales: ");
        totalSaleslbl.setFont(new Font("Serif", Font.PLAIN, 22));
        getSales = new JButton("Calculate Total Sales");

        // left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 500));
        leftPanel.setLayout(new GridLayout(6, 2));

        leftPanel.add(totalSaleslbl);
        leftPanel.add(getSales);

        // right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(600, 500));
        rightPanel.setLayout(new FlowLayout());

        // Initializing table
        dt = new DefaultTableModel();
        jTable = new JTable(dt);
        jTable.setPreferredSize(new Dimension(650, 500));
        jTable.setOpaque(false);

        // Load the table
        dt.addColumn("Invoice ID");
        dt.addColumn("Customer Name");
        dt.addColumn("Products Sold");
        dt.addColumn("Date");
        dt.addColumn("Invoice Price");

        getAllInvoicesFromDB();

        getSales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTheSales();
            }
        });

        // Adding widgets to main panel
        JScrollPane sp = new JScrollPane(jTable);
        rightPanel.add(sp);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    public void getAllInvoicesFromDB() {
        String query = "SELECT * FROM invoice";

        try {
            Statement s = database.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM invoice");

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getDate(4));
                v.add(rs.getInt(5));

                dt.addRow(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error in getting all Invoices" + e);
        }
    }

    public int calculateTheSales() {
        int totalSales = 0;

        for (int i = 0; i < jTable.getRowCount(); i++) {
            totalSales = totalSales + Integer.parseInt(jTable.getValueAt(i, 4).toString());
        }
        totalSaleslbl.setText("Total Sales: " + totalSales + " $");
        return totalSales;
    }
}
