package timetable.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {

    private static Connection connection;

    private ConnectionToDB() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/time_table2";
                String username = "postgres";
                String password = "postgres";
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                return connection;
            } catch (Exception ex) {
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        }
        return connection;
    }
}
