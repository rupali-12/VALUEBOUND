import java.awt.*;
import java.awt.event.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("IP Finder Program");
        // jFrame.setLayout(new FlowLayout());
        jFrame.setBounds(100, 100, 1000, 100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter URL: ");
        label.setBounds(50, 70, 150, 20);

        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 20);

        JButton button = new JButton("Find IP");
        button.setBounds(50, 150, 80, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = textField.getText();

                try {
                    InetAddress ia = InetAddress.getByName(url);
                    String ip = ia.getHostAddress();
                    JOptionPane.showMessageDialog(jFrame, ip);

                } catch (UnknownHostException unknownHostException) {
                    unknownHostException.printStackTrace();
                }
            }
        });

        jFrame.add(label);
        jFrame.add(button);
        jFrame.add(textField);
        jFrame.setLayout(new GridLayout());
    }
}