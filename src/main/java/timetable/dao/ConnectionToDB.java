package timetable.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/time_table";
            String username = "postgres";
            String password = "postgres";
            Class.forName("org.postgresql.Driver");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
            conn.createStatement();
                System.out.println("Connection to Store DB succesfull!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }
}
