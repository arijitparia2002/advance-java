// Problem statement : you are given a table name "employees" --> print all the data of that table

import java.sql.*;

public class JDBCPrintEmployeeData {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "1234");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            String data = "";
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    data += rsmd.getColumnName(i);
                    if (rsmd.getColumnTypeName(i).equals("INT")) {
                        data += rs.getInt(i) + " ";
                    } else if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
                        data += rs.getString(i) + " ";
                    } else if (rsmd.getColumnTypeName(i).equals("DOUBLE")) {
                        data += rs.getDouble(i) + " ";
                    }
                }
                data += "\n";
            }
            System.out.println(data);
        } catch (Exception ex) {
            System.err.println(ex);

        }
    }
}
