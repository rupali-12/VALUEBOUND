// src/ui/AgencyControlPanel.java

package ui;

import models.Customer;
import models.Reservation;
import services.CustomerService;
import services.ReservationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgencyControlPanel extends JPanel {
    private CustomerService customerService;
    private ReservationService reservationService;
    private JTextArea reportArea;

    public AgencyControlPanel(CustomerService customerService, ReservationService reservationService) {
        this.customerService = customerService;
        this.reservationService = reservationService;

        setLayout(new BorderLayout());

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });

        add(generateReportButton, BorderLayout.SOUTH);
    }

    private void generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Agency Report\n");
        report.append("==================\n");

        report.append("Customers:\n");
        for (Customer customer : customerService.getAllCustomers()) {
            report.append(customer.toString()).append("\n");
        }

        report.append("\nReservations:\n");
        for (Reservation reservation : reservationService.getAllReservations()) {
            report.append(reservation.toString()).append("\n");
        }

        reportArea.setText(report.toString());
    }
}
