// src/ui/Main.java
import ui.MainPanel;
import ui.CustomerPanel;
import ui.SpecialOfferPanel;
import ui.IndividualTripPanel;
import ui.PaymentPanel;
import ui.ServiceDetailPanel;
import ui.ReservationPanel;
import ui.AgencyControlPanel;
import services.CustomerService;
import services.ReservationService;
import services.PaymentService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        ReservationService reservationService = new ReservationService();
        PaymentService paymentService = new PaymentService();

        JFrame frame = new JFrame("Tourist Agency System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        MainPanel mainPanel = new MainPanel();

        mainPanel.addPanel(new CustomerPanel(customerService), "CustomerPanel");
        mainPanel.addPanel(new SpecialOfferPanel(), "SpecialOfferPanel");
        mainPanel.addPanel(new IndividualTripPanel(reservationService), "IndividualTripPanel");
        mainPanel.addPanel(new PaymentPanel(paymentService), "PaymentPanel");
        mainPanel.addPanel(new ServiceDetailPanel(), "ServiceDetailPanel");
        mainPanel.addPanel(new AgencyControlPanel(customerService, reservationService), "AgencyControlPanel");
        mainPanel.addPanel(new ReservationPanel(reservationService), "ReservationPanel");

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
