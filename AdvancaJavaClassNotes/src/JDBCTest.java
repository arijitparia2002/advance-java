
import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "1234");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
        } catch (Exception ex) {
            System.err.println(ex);

        }
    }

}
