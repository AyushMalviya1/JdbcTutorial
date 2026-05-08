package JdbcTutorial.InventoryManagementSystem.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JdbcTutorial.InventoryManagementSystem.ConnectionProvider.ConnectionProvider;
import JdbcTutorial.InventoryManagementSystem.Dao.PurchasedProductDao;
import JdbcTutorial.InventoryManagementSystem.pojo.PurchasedProduct;

public class PurchasedProductDaoImpl implements PurchasedProductDao {
            Connection con = ConnectionProvider.getConnection();

    @Override
    public void buyProduct(int uId, int pId, int quantity, double total_amount) {
        try {

            String q = "INSERT INTO purchasedproduct(uId, pId, quantity, total_amount) VALUES(?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uId);
            pstmt.setInt(2, pId);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, total_amount);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("DataBase error");
        }
    }

    @Override
    public List<PurchasedProduct> getPurchasedHistory(int uId) {
        try {
            List<PurchasedProduct>list = new ArrayList<>();
            String q = "Select * from purchasedproduct where uId=?;";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uId);
            ResultSet set = pstmt.executeQuery();
            while(set.next()){
                PurchasedProduct entry = new PurchasedProduct();
                entry.setId(set.getInt("id"));
                entry.setPId(set.getInt("pId"));
                entry.setUId(set.getInt("uId"));
                entry.setQuantity(set.getInt("quantity"));
                entry.setTotal_amount(set.getDouble("total_amount"));
                entry.setTimestamp(set.getTimestamp("purchased_date"));
                list.add(entry);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Database error");
        }
    }
    
}
