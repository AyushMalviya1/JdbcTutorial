package JdbcTutorial.InventoryManagementSystem.Dao;

import java.util.List;

import JdbcTutorial.InventoryManagementSystem.pojo.PurchasedProduct;

public interface PurchasedProductDao {
    public void buyProduct(int uId, int pId, int quantity, double total_amount);
    public List<PurchasedProduct> getPurchasedHistory(int uId);
    
    

}
