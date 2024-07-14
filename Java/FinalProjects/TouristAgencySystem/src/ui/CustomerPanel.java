// src/ui/CustomerPanel.java

package ui;

import models.Customer;
import services.CustomerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPanel extends JPanel {
    private CustomerService customerService;
    private JTextField nameField;
    private JTextField mobileField;
    private JTextField emailField;
    private JTextField addressField;
    private JList<Customer> customerList;

    public CustomerPanel(CustomerService customerService) {
        this.customerService = customerService;

        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        formPanel.add(new JLabel("Mobile:"));
        mobileField = new JTextField();
        formPanel.add(mobileField);
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);
        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        formPanel.add(addressField);

        JButton addButton = new JButton("Add Customer");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        // List panel
        customerList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(customerList);
        add(scrollPane, BorderLayout.CENTER);

        updateCustomerList();
    }

    private void addCustomer() {
        String name = nameField.getText();
        String mobile = mobileField.getText();
        String email = emailField.getText();
        String address = addressField.getText();

        Customer customer = new Customer(name, mobile, email, address);
        customerService.addCustomer(customer);
        updateCustomerList();
    }

    private void updateCustomerList() {
        DefaultListModel<Customer> listModel = new DefaultListModel<>();
        for (Customer customer : customerService.getAllCustomers()) {
            listModel.addElement(customer);
        }
        customerList.setModel(listModel);
    }
}
