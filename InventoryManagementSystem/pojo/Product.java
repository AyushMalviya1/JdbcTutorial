package JdbcTutorial.InventoryManagementSystem.pojo;

public class Product {
    int pId;
    String name;
    int quantity;
    double price;

    public Product(){}

    public Product(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //Setters
    public void setPId(int pId){
        this.pId = pId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }

    //Getters
    public int getPId(){
        return pId;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
}
