// src/ui/IndividualTripPanel.java

package ui;

import models.Reservation;
import models.Service;
import services.ReservationService;
import models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndividualTripPanel extends JPanel {
    private ReservationService reservationService;
    private JTextField customerNameField;
    private JTextField serviceNameField;
    private JTextField serviceDescriptionField;
    private JTextField servicePriceField;
    private JList<Reservation> reservationList;

    public IndividualTripPanel(ReservationService reservationService) {
        this.reservationService = reservationService;

        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        formPanel.add(customerNameField);
        formPanel.add(new JLabel("Service Name:"));
        serviceNameField = new JTextField();
        formPanel.add(serviceNameField);
        formPanel.add(new JLabel("Service Description:"));
        serviceDescriptionField = new JTextField();
        formPanel.add(serviceDescriptionField);
        formPanel.add(new JLabel("Service Price:"));
        servicePriceField = new JTextField();
        formPanel.add(servicePriceField);

        JButton addButton = new JButton("Add Individual Trip");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIndividualTrip();
            }
        });

        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        // List panel
        reservationList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(reservationList);
        add(scrollPane, BorderLayout.CENTER);

        updateReservationList();
    }

    private void addIndividualTrip() {
        String customerName = customerNameField.getText();
        String serviceName = serviceNameField.getText();
        String serviceDescription = serviceDescriptionField.getText();
        double servicePrice = Double.parseDouble(servicePriceField.getText());

        Service service = new Service(serviceName, serviceDescription, servicePrice, true);
        List<Service> services = new ArrayList<>();
        services.add(service);

        Reservation reservation = new Reservation(new Customer(customerName, "", "", ""), services, new Date(), servicePrice);
        reservationService.addReservation(reservation);
        updateReservationList();
    }

    private void updateReservationList() {
        DefaultListModel<Reservation> listModel = new DefaultListModel<>();
        for (Reservation reservation : reservationService.getAllReservations()) {
            listModel.addElement(reservation);
        }
        reservationList.setModel(listModel);
    }
}
