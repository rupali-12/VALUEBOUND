// src/ui/MainPanel.java

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public MainPanel() {
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        JButton customerButton = new JButton("Customers");
        JButton specialOfferButton = new JButton("Special Offers");
        JButton individualTripButton = new JButton("Individual Trip");
        JButton paymentButton = new JButton("Payment Methods");
        JButton serviceDetailButton = new JButton("Service Details");
        JButton agencyControlButton = new JButton("Agency Control");
        JButton reservationButton = new JButton("Reservations");

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "CustomerPanel");
            }
        });

        specialOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "SpecialOfferPanel");
            }
        });

        individualTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "IndividualTripPanel");
            }
        });

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "PaymentPanel");
            }
        });

        serviceDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "ServiceDetailPanel");
            }
        });

        agencyControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "AgencyControlPanel");
            }
        });

        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "ReservationPanel");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
        buttonPanel.add(customerButton);
        buttonPanel.add(specialOfferButton);
        buttonPanel.add(individualTripButton);
        buttonPanel.add(paymentButton);
        buttonPanel.add(serviceDetailButton);
        buttonPanel.add(agencyControlButton);
        buttonPanel.add(reservationButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void addPanel(JPanel panel, String name) {
        contentPanel.add(panel, name);
    }
}
