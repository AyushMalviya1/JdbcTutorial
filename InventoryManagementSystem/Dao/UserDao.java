package JdbcTutorial.InventoryManagementSystem.Dao;

import java.util.List;

import JdbcTutorial.InventoryManagementSystem.pojo.User;

public interface UserDao {
    public void addUser(User user);
    public boolean checkUser(String name, String password);   
    public User viewUser(int uId);
    public List<User>viewAllUser();
    public double checkBalance(int uId,String password);
    public boolean deductAmount(int uId, double amount);
    public double checkBalance(int uId);
}
