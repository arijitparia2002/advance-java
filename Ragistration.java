import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ragistration {
    public static void main(String[] args) {
        JFrame f = new JFrame("Ragistration");
        f.setSize(500, 500);
        f.getContentPane().setBackground(new Color(30, 20, 200, 20));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(null);

        // input box
        JLabel msg = new JLabel("Enter your name");
        msg.setBounds(50, 20, 150, 20);
        JTextField name = new JTextField(50);
        name.setBounds(50, 50, 150, 25);

        // Two radio buttons
        JLabel msg_gender = new JLabel("Select your gender");
        msg_gender.setBounds(50, 75, 150, 20);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(50, 100, 100, 30);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(150, 100, 100, 30);

        // add check box for sports
        JLabel msg_sports = new JLabel("Select sports");
        msg_sports.setBounds(50, 140, 150, 20);
        JCheckBox sports1 = new JCheckBox("Cricket");
        sports1.setBounds(50, 160, 100, 30);
        JCheckBox sports2 = new JCheckBox("Football");
        sports2.setBounds(50, 200, 100, 30);
        JCheckBox sports3 = new JCheckBox("Hockey");
        sports3.setBounds(50, 240, 100, 30);

        ButtonGroup bgsports = new ButtonGroup();
        bgsports.add(sports1);
        bgsports.add(sports2);
        bgsports.add(sports3);

        // Ragistration button
        JButton ragister = new JButton("Ragister");
        ragister.setBounds(50, 300, 100, 30);
        ragister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // get all the data from the input fields
                String n = name.getText();
                // get button infos
                Boolean ifMale = male.isSelected();
                String s = ifMale ? "Mr." : "Mrs.";

                // get check box infos
                String sports = "";
                if (sports1.isSelected())
                    sports += "Cricket ";
                if (sports2.isSelected())
                    sports += "Football ";
                if (sports3.isSelected())
                    sports += "Hockey ";

                // popup a message with the data on successful ragistration
                JOptionPane.showMessageDialog(f,
                        "Hello " + s + n + "\nYou have selected " + sports + " as your sports");

                // warning message if any field is empty
                if (n.equals("")) {
                    JOptionPane.showMessageDialog(f, "Please enter your name");
                } else if (!male.isSelected() && !female.isSelected()) {
                    JOptionPane.showMessageDialog(f, "Please select your gender");
                } else if (!sports1.isSelected() && !sports2.isSelected() && !sports3.isSelected()) {
                } else if (!sports1.isSelected() && !sports2.isSelected() && !sports3.isSelected()) {
                    JOptionPane.showMessageDialog(f, "Please select your sports");
                }

                // clear all the input fields
                name.setText("");
            }
        });

        // create buttongroup
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        // place all the components in the frame with proper layout
        f.add(msg);
        f.add(name);
        f.add(msg_gender);
        f.add(male);
        f.add(female);
        f.add(msg_sports);
        f.add(sports1);
        f.add(sports2);
        f.add(sports3);
        f.add(ragister);

        f.setVisible(true);
    }
}
