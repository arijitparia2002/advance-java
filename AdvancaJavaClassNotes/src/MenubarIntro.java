import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MenubarIntro {
    static JTextArea textarea = new JTextArea();

    public static void main(String... rk) {
        // action listner
        class MyListener implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                String command = ae.getActionCommand();
                if (command.equals("Save")) {
                    saveFile();
                }
                if(command.equals("Open")){
                    OpenFile();
                }
            }
        }

        JFrame frame = new JFrame("Menubar Introduction");

        frame.setSize(500, 600);
        frame.getContentPane().setBackground(new Color(0, 0, 255, 20));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // add text area
        // JTextArea textarea = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(textarea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollpane);

        // menubar
        JMenuBar menubar = new JMenuBar();

        // menu 1 --> File
        JMenu menu1 = new JMenu("File");
        // menu items
        String[] menuitems1 = { "Create", "Open", "Save", "Save as" };
        for (String item : menuitems1) {

            if (item == "Save as") {
                JMenuItem submenu1 = new JMenuItem("Save as .txt");
                JMenuItem submenu2 = new JMenuItem("Save as .xlsx");

                JMenu menu = new JMenu(item);
                menu.add(submenu1);
                menu.add(submenu2);
                menu1.add(menu);
            } else {
                JMenuItem menuitem = new JMenuItem(item);
                menuitem.addActionListener(new MyListener());
                menu1.add(menuitem);
            }
        }
        menu1.insertSeparator(2); // adds a separator between the menuitems
        menubar.add(menu1);

        // menu 2 --> Edit
        JMenu menu2 = new JMenu("Edit");
        // menu items
        String[] menuitems2 = { "Cut", "Copy", "Paste" };
        for (String item : menuitems2) {
            menu2.add(new JMenuItem(item));
        }

        menubar.add(menu2);

        // menu 3 --> view
        JMenu menu3 = new JMenu("View");
        JMenuItem zoomitem = new JMenuItem("Zoom");
        // Checkbox type menu item
        JCheckBoxMenuItem checkboxitem = new JCheckBoxMenuItem("Show status bar", true);

        menu3.add(zoomitem);
        menu3.add(checkboxitem);
        menubar.add(menu3);

        // menu 4 --> Help
        JMenu menu4 = new JMenu("Help");
        menubar.add(menu4);

        frame.setJMenuBar(menubar);
        frame.setVisible(true);

    }

    // save file method
    static void saveFile() {
        // save the file to the path provided using file output stream
        JFileChooser choosefile = new JFileChooser();
        int result = choosefile.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = choosefile.getSelectedFile();
            try {
                String text = textarea.getText();
                FileOutputStream fos = new FileOutputStream(file.getPath());
                byte[] b = text.getBytes();
                fos.write(b);
                fos.close();
                JOptionPane.showMessageDialog(null, "File saved successfully");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

    // open file method
    static void OpenFile(){
        JFileChooser choosefile = new JFileChooser();
        int result = choosefile.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File file = choosefile.getSelectedFile();
            System.out.println(file);
        }

        
    }

}
