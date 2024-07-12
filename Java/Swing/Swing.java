import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Swing {
    public static void main(String[] args) {
        Abc obj = new Abc();

    }
}

class Abc extends JFrame {

    public Abc() {
        setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Hello World");
        JLabel label2 = new JLabel("Welcome");
        add(label1);
        add(label2);
        setVisible(true);
        setSize(400, 400);
    }
}