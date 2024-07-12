import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Word Counter");
        jFrame.setLayout(null);
        jFrame.setBounds(100, 100, 500, 500);
        jFrame.setVisible(true);
        jFrame.getDefaultCloseOperation();

        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 50, 300, 200);

        JButton button = new JButton("Count");
        button.setBounds(180, 300, 100, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // get text
                String text = textArea.getText();

                // splitting up the string and storing word into []
                if (!text.equals("")) {
                    String[] word = text.split("\\s");
                    JOptionPane.showMessageDialog(jFrame, "TotalWord Count: " + word.length);
                }
            }
        });

        jFrame.add(textArea);
        jFrame.add(button);
    }
}