package JdbcTutorial.InventoryManagementSystem.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/jdbctutorial";
                String username = "root";
                String password = "root";

                con = DriverManager.getConnection(url, username, password);
                System.out.println("Database Connected Successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection is not established!");
        }
        return con;
    }
}