package JdbcTutorial.InventoryManagementSystem.Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JdbcTutorial.InventoryManagementSystem.ConnectionProvider.ConnectionProvider;
import JdbcTutorial.InventoryManagementSystem.pojo.User;

public class Login {
    public User login(String name, String password) {
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "SELECT * FROM user WHERE name=? AND password=?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                User user = new User(); // create only when needed
                user.setUId(set.getInt(1));
                user.setName(set.getString(2));
                user.setRole(set.getString(3));
                user.setAccountBalance(set.getDouble(5));
            
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
