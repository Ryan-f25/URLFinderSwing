import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;

//Use scrollpane to put links in text area
//Try to put links into the text area


public class InterfaceStructure {

    private JFrame mainFrame;
    private JPanel controlPanel;
    private JLabel statusLabel;
    public JTextArea ta1;
//    public JTextArea ta;
    private JButton button;
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    //private TextField tf;



    public InterfaceStructure() {
        PrepareGUI();
    }

    public static void main(String[] args) {
        InterfaceStructure swingControlDemo = new InterfaceStructure();
    }

    public void HtmlRead(){

        try{
            System.out.println();
            String URLString = tf1.getText();
            String Keyword = tf2.getText();
            URL url = new URL(URLString);//"https://en.wikipedia.org/wiki/Barack_Obama"
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line;
            //String line = "The part I want to extract 1 is the following:href = \"https:www.wikipedia.com/Obama/1";
            while ((line = reader.readLine()) != null) {
                if(line.contains("href") && line.contains("https")) {
                    //System.out.println(line);

                    int start = line.indexOf("http");
                    //System.out.println(start);
                    int end = line.indexOf(
                            "\"", start);
                    //System.out.println(line.substring(start, end));

                    //int start1 = line.indexOf("http");
                    int end1 = line.indexOf(
                            "\'", start);
                    //System.out.println(line.substring(start, end1));
                    String link;
                    String link1;

                    if (end1==-1){
                        link = (line.substring(start, end));
                        if (link.contains(Keyword)){
                            ta1.append(line.substring(start, end) + "\n");
                        }

                    } else {
                        link1 = (line.substring(start,end1));
                        if(link1.contains(Keyword)) {
                            ta1.append(line.substring(start, end1) + "\n");
                        }
                    }

                }

            }
            reader.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void PrepareGUI() {
        mainFrame = new JFrame("Example With Border Layout");
        mainFrame.setBounds(0,0,500,400);
        mainFrame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        JLabel statusLabel2 = new JLabel("URL Box:");
        JLabel statusLabel3 = new JLabel("Search Box:");

        controlPanel.add(statusLabel2);
        controlPanel.add(tf1);
        controlPanel.add(statusLabel3);
        controlPanel.add(tf2);


        JButton button4 = new JButton("GO");
        button4.setActionCommand("GO");
        button4.addActionListener(new ButtonClickListener());

        //JTextField tf1 = new JTextField("URL Box:");
        //JTextField tf2 = new JTextField("Search Box:");
        mainFrame.add(new JSeparator());


        controlPanel.add(button4);

        mainFrame.add(controlPanel, BorderLayout.NORTH);
        ta1 = new JTextArea();
        ta1.setSize(350, 100);

        ta1.setEditable(true);

        JScrollPane scrollbar = new JScrollPane(ta1);
        mainFrame.add(scrollbar, BorderLayout.CENTER);



        mainFrame.setVisible(true);

    }


    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("GO")) {
                HtmlRead();
            }
//              else if (command.equals("Submit")) {
                //statusLabel.setText("Submit Button clicked.");
//            } else {
//                statusLabel.setText("Cancel Button clicked.");
//            }
        }
    }
}
