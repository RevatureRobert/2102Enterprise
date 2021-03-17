package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    private static Connection conn;
    private static String jdbcUrl = "jdbc:h2:mem:tcp://localhost/~/test";

    public static Connection getConnection()  throws SQLException{
        if (conn == null) {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Could not register driver!");
                e.printStackTrace();
            }
//            conn = DriverManager.getConnection("jdbc:h2:"+"./Database/my","sa", "");
            conn = DriverManager.getConnection(jdbcUrl, "sa","");
        }
        return conn;
    }
}
