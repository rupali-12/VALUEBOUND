import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    // Widgets
    JToggleButton customer_btn;
    JToggleButton employee_btn;
    JToggleButton product_btn;
    JToggleButton sales_btn;
    JToggleButton invoice_btn;

    // Panel Loader
    JPanelLoader loader = new JPanelLoader();

    public MainScreen() throws HeadlessException {
        createNavButtonsPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("POS System");
        setSize(1200, 800);
        setVisible(true);

    }

    public void createNavButtonsPanel() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        Color.GRAY,
                        1),
                "Navigation Buttons ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION);

        p1.setBorder(titledBorder);
        p1.setBounds(15, 50, 150, 250);
        p1.setLayout(new GridLayout(5, 1));
        // setLayout(null);

        // panel 2
        JPanel p2 = new JPanel();
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        Color.GRAY,
                        1),
                "Dashboard ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION);

        p2.setBorder(titledBorder2);
        p2.setBounds(200, 50, 900, 580);
        p2.setLayout(new GridLayout(5, 1));
        // setLayout(null);

        customer_btn = new JToggleButton("Customers");
        employee_btn = new JToggleButton("Employees");
        sales_btn = new JToggleButton("Sales");
        invoice_btn = new JToggleButton("Invoice");
        product_btn = new JToggleButton("Product");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(customer_btn);
        buttonGroup.add(employee_btn);
        buttonGroup.add(sales_btn);
        buttonGroup.add(invoice_btn);
        buttonGroup.add(product_btn);
        p1.add(customer_btn);
        p1.add(employee_btn);
        p1.add(product_btn);
        p1.add(invoice_btn);
        p1.add(sales_btn);

        // Customer button
        customer_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomersPanel c = new CustomersPanel();
                loader.jPanelLoader(p2, c);
            }
        });

        product_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductPanel p = new ProductPanel();
                loader.jPanelLoader(p2, p);
            }
        });
        invoice_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Invoice i = new Invoice();
                loader.jPanelLoader(p2, i);
            }
        });
        sales_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalesPanel s = new SalesPanel();
                loader.jPanelLoader(p2, s);
            }
        });

        add(p1);
        add(p2);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainScreen();
        });
    }
}
