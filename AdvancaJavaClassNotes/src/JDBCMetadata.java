import java.sql.*;

public class JDBCMetadata {
    public static void main(String[] args) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "1234");

            DatabaseMetaData dbmd = con.getMetaData();
            //Metadata of the database
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("Table Name Length; " + dbmd.getMaxTableNameLength());
            System.out.println("Max Number of columns length: " + dbmd.getMaxColumnsInTable());
            System.out.println();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");

            // Metadata of the result set
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total number of columns: "+ rsmd.getColumnCount());
            System.out.println("Names of all the columns and type: ");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + " --> " + rsmd.getColumnTypeName(i));
            }
            System.out.println();

            // print all the data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        } catch (Exception ex) {
            System.err.println(ex);

        }
    }

}
