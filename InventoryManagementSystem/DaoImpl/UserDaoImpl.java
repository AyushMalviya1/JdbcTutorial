package JdbcTutorial.InventoryManagementSystem.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JdbcTutorial.InventoryManagementSystem.ConnectionProvider.ConnectionProvider;
import JdbcTutorial.InventoryManagementSystem.Dao.UserDao;
import JdbcTutorial.InventoryManagementSystem.pojo.User;

public class UserDaoImpl implements UserDao {

    private static Connection con = ConnectionProvider.getConnection();

    @Override
    public void addUser(User user) {

        try {
            String q = "Insert into user (name, passsword, role, accountBalance) values(?,?,?,?);";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.setDouble(4, user.getAccountBalance());
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("User not added.");
        }
    }

    @Override
    public boolean checkUser(String name, String password) {
        try {
            String q = "Select * from user where name=?, password=?;";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("Database error");
        }

    }

    @Override
    public User viewUser(int uId) {
        try {
            String q = "Select * from user where name=?, password=?;";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uId);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                User user = new User();
                user.setUId(set.getInt("uId"));
                user.setName(set.getString("name"));
                user.setRole(set.getString("role"));
                user.setAccountBalance(set.getDouble("accountBalance"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Database error");
        }
    }

    @Override
    public List<User> viewAllUser() {
        List<User> list = new ArrayList<>();
        try {
            String q = "SELECT * FROM user;";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()) {
                User user = new User();
                user.setUId(set.getInt("uId"));
                user.setName(set.getString("name"));
                user.setRole(set.getString("role"));
                user.setAccountBalance(set.getDouble("accountBalance"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Database error");
        }
    }

    @Override
    public double checkBalance(int uId, String password) {
        try {
            String q = "Select accountBalance from user where uId=? AND password=?;";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uId);
            pstmt.setString(2, password);
            ResultSet set = pstmt.executeQuery();
            double balance = 0;
            if (set.next()) {
                balance = set.getDouble(1);
            }
            return balance;

        } catch (Exception e) {
            throw new RuntimeException("Database error");

        }
    }

    @Override
    public boolean deductAmount(int uId, double amount) {
        try {//deduct amount from customer
            String q ="UPDATE user SET accountBalance=accountBalance-? where uId=?;";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, uId);
            pstmt.executeUpdate();
            // add amount in admin
            q = "UPDATE user SET accountBalance=accountBalance+? where uId=1 AND role='ADMIN';";
            PreparedStatement pstmt1 = con.prepareStatement(q);
            pstmt1.setDouble(1, amount);
            pstmt1.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Database error");
            return false;
        }
    }

    @Override
    public double checkBalance(int uId) {
        try {
            String q = "Select accountBalance from user where uId=?;";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uId);
            ResultSet set = pstmt.executeQuery();
            double balance = 0;
            if (set.next()) {
                balance = set.getDouble(1);
            }
            return balance;

        } catch (Exception e) {
            throw new RuntimeException("Database error");

        }
    }
}
