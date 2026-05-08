package JdbcTutorial.InventoryManagementSystem.Dao;

import java.util.List;

import JdbcTutorial.InventoryManagementSystem.pojo.Product;

public interface ProductDao {
    public boolean addProduct(Product product);
    public boolean removeProduct(int pId);
    public Product viewProduct(int pId);
    public List<Product>viewAllProduct();
    public int checkInStock(int pId);
    public boolean decreaseQuantity(int pId, int quantity);
}
   