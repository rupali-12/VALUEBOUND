// src/ui/ServiceDetailPanel.java

package ui;

import models.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetailPanel extends JPanel {
    private List<Service> services;
    private JTextField serviceNameField;
    private JTextField descriptionField;
    private JTextField priceField;
    private JCheckBox availabilityCheckBox;
    private JList<Service> serviceList;

    public ServiceDetailPanel() {
        services = new ArrayList<>();

        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Service Name:"));
        serviceNameField = new JTextField();
        formPanel.add(serviceNameField);
        formPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        formPanel.add(descriptionField);
        formPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        formPanel.add(priceField);
        formPanel.add(new JLabel("Availability:"));
        availabilityCheckBox = new JCheckBox();
        formPanel.add(availabilityCheckBox);

        JButton addButton = new JButton("Add Service");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addService();
            }
        });

        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        // List panel
        serviceList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(serviceList);
        add(scrollPane, BorderLayout.CENTER);

        updateServiceList();
    }

    private void addService() {
        String serviceName = serviceNameField.getText();
        String description = descriptionField.getText();
        double price = Double.parseDouble(priceField.getText());
        boolean availability = availabilityCheckBox.isSelected();

        Service service = new Service(serviceName, description, price, availability);
        services.add(service);
        updateServiceList();
    }

    private void updateServiceList() {
        DefaultListModel<Service> listModel = new DefaultListModel<>();
        for (Service service : services) {
            listModel.addElement(service);
        }
        serviceList.setModel(listModel);
    }
}

