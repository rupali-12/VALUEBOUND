// src/ui/PaymentPanel.java

package ui;

import patterns.CreditCardPayment;
import patterns.PayPalPayment;
import patterns.PaymentContext;
import services.PaymentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends JPanel {
    private PaymentService paymentService;
    private JTextField amountField;
    private JTextField cardNumberField;
    private JTextField cardHolderNameField;
    private JTextField expiryDateField;
    private JTextField cvvField;
    private JTextField emailField;
    private JTextField passwordField;

    public PaymentPanel(PaymentService paymentService) {
        this.paymentService = paymentService;

        setLayout(new BorderLayout());

        // Form panel for Credit Card
        JPanel creditCardPanel = new JPanel(new GridLayout(5, 2));
        creditCardPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        creditCardPanel.add(amountField);
        creditCardPanel.add(new JLabel("Card Number:"));
        cardNumberField = new JTextField();
        creditCardPanel.add(cardNumberField);
        creditCardPanel.add(new JLabel("Card Holder Name:"));
        cardHolderNameField = new JTextField();
        creditCardPanel.add(cardHolderNameField);
        creditCardPanel.add(new JLabel("Expiry Date:"));
        expiryDateField = new JTextField();
        creditCardPanel.add(expiryDateField);
        creditCardPanel.add(new JLabel("CVV:"));
        cvvField = new JTextField();
        creditCardPanel.add(cvvField);

        JButton payWithCardButton = new JButton("Pay with Credit Card");
        payWithCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payWithCreditCard();
            }
        });

        creditCardPanel.add(payWithCardButton);

        // Form panel for PayPal
        JPanel paypalPanel = new JPanel(new GridLayout(3, 2));
        paypalPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        paypalPanel.add(emailField);
        paypalPanel.add(new JLabel("Password:"));
        passwordField = new JTextField();
        paypalPanel.add(passwordField);

        JButton payWithPayPalButton = new JButton("Pay with PayPal");
        payWithPayPalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payWithPayPal();
            }
        });

        paypalPanel.add(payWithPayPalButton);

        add(creditCardPanel, BorderLayout.NORTH);
        add(paypalPanel, BorderLayout.SOUTH);
    }

    private void payWithCreditCard() {
        double amount = Double.parseDouble(amountField.getText());
        String cardNumber = cardNumberField.getText();
        String cardHolderName = cardHolderNameField.getText();
        String expiryDate = expiryDateField.getText();
        String cvv = cvvField.getText();

        paymentService.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName, expiryDate, cvv));
        paymentService.processPayment(amount);
    }

    private void payWithPayPal() {
        double amount = Double.parseDouble(amountField.getText());
        String email = emailField.getText();
        String password = passwordField.getText();

        paymentService.setPaymentStrategy(new PayPalPayment(email, password));
        paymentService.processPayment(amount);
    }
}
