package JdbcTutorial.InventoryManagementSystem.Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;


import JdbcTutorial.InventoryManagementSystem.ConnectionProvider.ConnectionProvider;
import JdbcTutorial.InventoryManagementSystem.pojo.User;

public class Signup {
    public User signup(String name, String password){
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "INSERT INTO user(name, role, password) VALUES(?,?,?);";
             PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, "CUSTOMER");
            pstmt.setString(3, password);

            pstmt.executeUpdate();

            Login login = new Login();
            User user = login.login(name, password);

            if(user!=null){
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
