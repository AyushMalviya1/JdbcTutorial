package JdbcTutorial.InventoryManagementSystem.pojo;

public class User {
    int uId;
    String name;
    String password;
    String role;
    double accountBalance;

    // Setters
    public void setUId(int uId) {
        this.uId = uId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Getters
    public int getUId() {
        return uId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
