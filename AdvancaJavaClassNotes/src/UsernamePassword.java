import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UsernamePassword {
    // Database connection details
    public static final String DB_URL = "jdbc:mysql://localhost:3306/students";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "1234";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static Connection con = null;
    public static PreparedStatement ps = null;

    public static void main(String[] args) {
        try {
            // Connect with database
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            ps = con.prepareStatement("select * from creds where username = ?");

            // Create and set up the window
            JFrame frame = new JFrame("Change Password");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            // Create panel for the form
            JPanel formPanel = new JPanel(new GridBagLayout());
            formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Create constraints
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = GridBagConstraints.RELATIVE;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);

            // Create fields for username, current password, and new password
            JTextField usernameField = new JTextField(20);
            JPasswordField currentPasswordField = new JPasswordField(20);
            JPasswordField newPasswordField = new JPasswordField(20);

            // Add components to the form panel
            formPanel.add(new JLabel("Username:"), gbc);
            formPanel.add(usernameField, gbc);
            formPanel.add(new JLabel("Current Password:"), gbc);
            formPanel.add(currentPasswordField, gbc);
            formPanel.add(new JLabel("Password:"), gbc);
            formPanel.add(newPasswordField, gbc);

            // Create panel for buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton submitButton = new JButton("Submit");
            JButton cancelButton = new JButton("Cancel");
            buttonPanel.add(submitButton);
            buttonPanel.add(cancelButton);

            // Add action listener to the submit button
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String currentPassword = new String(currentPasswordField.getPassword());
                    String newPassword = new String(newPasswordField.getPassword());

                    // Check if the current password is correct
                    if (checkPassword(username, currentPassword)) {
                        // If correct, update the password
                        updatePassword(username, newPassword);
                        JOptionPane.showMessageDialog(frame, "Password updated successfully.");
                    } else {
                        // If not correct, show an error message
                        JOptionPane.showMessageDialog(frame, "Current password is incorrect.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // Add action listener to the cancel button
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });

            // Add form panel and button panel to the frame
            frame.add(formPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            // Center the frame on the screen
            frame.setLocationRelativeTo(null);

            // Display the window
            frame.setVisible(true);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static boolean checkPassword(String username, String password) {
        try {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(2).equals(password)) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static void updatePassword(String username, String newPassword) {
        // Implement password update logic here
    }
}
