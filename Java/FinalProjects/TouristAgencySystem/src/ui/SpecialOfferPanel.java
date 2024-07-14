// src/ui/SpecialOfferPanel.java

package ui;

import models.SpecialOffer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class SpecialOfferPanel extends JPanel {
    private List<SpecialOffer> specialOffers;
    private JTextField offerNameField;
    private JTextField descriptionField;
    private JTextField discountField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JList<SpecialOffer> offerList;

    public SpecialOfferPanel() {
        specialOffers = new ArrayList<>();

        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.add(new JLabel("Offer Name:"));
        offerNameField = new JTextField();
        formPanel.add(offerNameField);
        formPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        formPanel.add(descriptionField);
        formPanel.add(new JLabel("Discount:"));
        discountField = new JTextField();
        formPanel.add(discountField);
        formPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField();
        formPanel.add(startDateField);
        formPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField();
        formPanel.add(endDateField);

        JButton addButton = new JButton("Add Special Offer");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSpecialOffer();
            }
        });

        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        // List panel
        offerList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(offerList);
        add(scrollPane, BorderLayout.CENTER);

        updateOfferList();
    }

    private void addSpecialOffer() {
        String offerName = offerNameField.getText();
        String description = descriptionField.getText();
        double discount = Double.parseDouble(discountField.getText());
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();

        SpecialOffer specialOffer = new SpecialOffer(offerName, description, discount, new Date(), new Date());
        specialOffers.add(specialOffer);
        updateOfferList();
    }

    private void updateOfferList() {
        DefaultListModel<SpecialOffer> listModel = new DefaultListModel<>();
        for (SpecialOffer offer : specialOffers) {
            listModel.addElement(offer);
        }
        offerList.setModel(listModel);
    }
}
