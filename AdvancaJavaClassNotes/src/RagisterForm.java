import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RagisterForm {

    public static String imagepath = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wipro Ragistration Form");
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel name = new JLabel("Name:");
        JTextField namefield = new JTextField(19);
        name.setBounds(10, 10, 100, 15);
        namefield.setBounds(120, 10, 200, 20);
        frame.add(name);
        frame.add(namefield);

        JLabel age = new JLabel("Age");
        JTextField agefield = new JTextField(19);
        age.setBounds(10, 40, 100, 15);
        agefield.setBounds(120, 40, 200, 20);
        frame.add(age);
        frame.add(agefield);

        JLabel cgpa = new JLabel("CGPA");
        JTextField cgpafield = new JTextField(19);
        cgpa.setBounds(10, 70, 100, 15);
        cgpafield.setBounds(120, 70, 200, 20);
        frame.add(cgpa);
        frame.add(cgpafield);

        JLabel address = new JLabel("Address");
        JTextArea addressfield = new JTextArea();
        address.setBounds(10, 100, 100, 15);
        addressfield.setBounds(120, 100, 200, 100);
        frame.add(address);
        frame.add(addressfield);

        JLabel image = new JLabel("Image");
        JButton imagefield = new JButton("Upload Image");
        image.setBounds(10, 210, 100, 15);
        imagefield.setBounds(120, 210, 200, 20);
        frame.add(image);
        frame.add(imagefield);

        imagefield.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println(path);
            imagepath = path;
        });

        JCheckBox sem1 = new JCheckBox("Sem1");
        JCheckBox sem2 = new JCheckBox("Sem2");
        JCheckBox sem3 = new JCheckBox("Sem3");
        JCheckBox sem4 = new JCheckBox("Sem4");
        JCheckBox sem5 = new JCheckBox("Sem5");

        sem1.setBounds(10, 240, 100, 20);
        sem2.setBounds(120, 240, 100, 20);
        sem3.setBounds(230, 240, 100, 20);
        sem4.setBounds(10, 270, 100, 20);
        sem5.setBounds(120, 270, 100, 20);

        frame.add(sem1);
        frame.add(sem2);
        frame.add(sem3);
        frame.add(sem4);
        frame.add(sem5);

        // output panel
        JPanel output = new JPanel();
        output.setBounds(10, 330, 400, 400);
        output.setBackground(Color.white);
        frame.add(output);

        JButton submit = new JButton("Submit");
        submit.setBounds(10, 300, 100, 20);
        frame.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name = namefield.getText();
                String age = agefield.getText();
                String cgpa = cgpafield.getText();
                String address1 = addressfield.getText();
                String sem = "";

                if (sem1.isSelected()) {
                    sem += "Sem1 ";
                }
                if (sem2.isSelected()) {
                    sem += "Sem2 ";
                }
                if (sem3.isSelected()) {
                    sem += "Sem3 ";
                }
                if (sem4.isSelected()) {
                    sem += "Sem4 ";
                }
                if (sem5.isSelected()) {
                    sem += "Sem5 ";
                }

                String outputString = "Name: " + name + "\nAge: " + age + "\nCGPA: " + cgpa
                        + "\nAddress: " + address1 + "\nSem: " + sem;

                JOptionPane.showMessageDialog(frame, outputString);

                // show all the data in frame + the image
                JLabel outputData = new JLabel(outputString);

                output.setBounds(10, 330, 400, 400);
                output.add(outputData);

                ImageIcon image = new ImageIcon(imagepath);
                JLabel outputImage = new JLabel(image);

                outputImage.setBounds(10, 330, 50, 50);
                output.add(outputImage);

                frame.revalidate();
                frame.repaint();

            }
        });
        frame.setVisible(true);
    }

}
