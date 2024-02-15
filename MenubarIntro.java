import javax.swing.*;
import java.awt.*;

public class MenubarIntro {
    public static void main(String... rk) {
        JFrame frame = new JFrame("Menubar Introduction");

        frame.setSize(500, 600);
        frame.getContentPane().setBackground(new Color(0, 0, 255, 20));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // add text area
        JTextArea textarea = new JTextArea();
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
                menu1.add(new JMenuItem(item));
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

}
