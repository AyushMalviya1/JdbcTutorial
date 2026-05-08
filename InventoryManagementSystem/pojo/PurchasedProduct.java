package JdbcTutorial.InventoryManagementSystem.pojo;

import java.sql.Timestamp;

public class PurchasedProduct {
    int id; 
    int pId;
    int uId;
    int quantity;
    double total_amount;
    Timestamp purchased_date;

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setPId(int pId){
        this.pId = pId;
    }
    public void setUId(int uId){
        this.uId = uId;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setTotal_amount(double total_amount){
        this.total_amount = total_amount;
    }
    public void setTimestamp(Timestamp purchased_date){
        this.purchased_date = purchased_date;
    }

    //Getters
    public int getId(){
        return id;
    }
    public int getPId(){
        return pId;
    }
    public int getUId(){
        return uId;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getTotal_amount(){
        return total_amount;
    }
    public Timestamp getTimestamp(){
        return purchased_date;
    }
}
