import javax.swing.*;

public class ScrollPane {
    public static void main(String arr[]) {
        JFrame frame = new JFrame("Scroll Pane");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        String[] items = { "Amazon", "Google", "TCS", "Optimyzer", "Infenion", "IndianOil", "Flipkart" };

        JList<String> ls = new JList<>(items);
        JScrollPane lsp = new JScrollPane(ls, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lsp.setBounds(250, 100, 100, 100);
        frame.add(lsp);

        // text area
        JTextArea ta = new JTextArea("Write your review...");
        JScrollPane jsp = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(jsp);
        jsp.setBounds(200, 300, 200, 100);
        ta.setLineWrap(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
