import java.awt.*;
import javax.swing.*;

public class InterfaceStructure {

    private JFrame mainFrame;
    private JPanel controlPanel;
    private JLabel statusLabel;
    private TextArea ta;
    private JButton button;
    private TextField tf;


    public InterfaceStructure() {
        PrepareGUI();
    }

    public static void main(String[] args) {
        InterfaceStructure swingControlDemo = new InterfaceStructure();
    }

    public void PrepareGUI() {
        mainFrame = new JFrame("Example With Border Layout");
        mainFrame.setBounds(0,0,500,400);
        mainFrame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));

        JButton button4 = new JButton("GO");

        JTextField tf1 = new JTextField("URL Box:");
        JTextField tf2 = new JTextField("Search Box:");

        JLabel statusLabel1 = new JLabel("Results:", SwingConstants.CENTER);
        statusLabel1.setVerticalAlignment(SwingConstants.TOP);
        mainFrame.add(new JSeparator());

        controlPanel.add(tf1);
        controlPanel.add(tf2);
        controlPanel.add(button4);

        mainFrame.add(controlPanel, BorderLayout.NORTH);
        mainFrame.add(statusLabel1);

        mainFrame.setVisible(true);



    }
}
