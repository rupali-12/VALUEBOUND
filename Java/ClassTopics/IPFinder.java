import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class IPFinder extends JFrame {
    private JTextField txtFieldIP;
    private JButton btnFindIP;
    private JLabel lblHostName;

    public IPFinder() {
        // Set the title of the frame
        setTitle("IP Finder");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        setSize(400, 200);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a label
        lblHostName = new JLabel("Enter Hostname:");

        // Create a text field
        txtFieldIP = new JTextField(20);

        // Create a button
        btnFindIP = new JButton("Find IP");

        // Add action listener to the button
        btnFindIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findIP();
            }
        });

        // Add components to the panel
        panel.add(lblHostName);
        panel.add(txtFieldIP);
        panel.add(btnFindIP);

        // Add panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    // Method to find IP address
    private void findIP() {
        try {
            String hostName = txtFieldIP.getText();
            InetAddress ip = InetAddress.getByName(hostName);
            JOptionPane.showMessageDialog(this, "IP Address of " + hostName + " is: " + ip.getHostAddress());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create an instance of IPFinder
        new IPFinder();
    }
}