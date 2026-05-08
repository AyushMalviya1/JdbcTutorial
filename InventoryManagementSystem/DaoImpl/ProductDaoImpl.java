package JdbcTutorial.InventoryManagementSystem.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JdbcTutorial.InventoryManagementSystem.ConnectionProvider.ConnectionProvider;
import JdbcTutorial.InventoryManagementSystem.Dao.ProductDao;
import JdbcTutorial.InventoryManagementSystem.pojo.Product;

public class ProductDaoImpl implements ProductDao {

    Connection connection = ConnectionProvider.getConnection();

    @Override
    public boolean addProduct(Product product) {
        try {
            String q = "Insert into product(name, quantity, price) values(?,?,?);";

            PreparedStatement pstmt = connection.prepareStatement(q);
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setDouble(3, product.getPrice());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product viewProduct(int pId) {
        try {
            String q = "Select * from product where pId=?;";
            PreparedStatement pstmt = connection.prepareStatement(q);
            pstmt.setInt(1, pId);
            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                Product product = new Product();
                product.setPId(set.getInt("pId"));
                product.setName(set.getString("name"));
                product.setPrice(set.getDouble("price"));
                product.setQuantity(set.getInt("quantity"));

                return product;
            } else {
                throw new RuntimeException("There is no Product.");
            }

        } catch (Exception e) {
            System.out.println("Database error.");
            return null;
        }
    }

    @Override
    public List<Product> viewAllProduct() {
        try {
            String q = "Select * from product;";

            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery(q);
            List<Product> list = new ArrayList<>();

            while (set.next()) {
                Product product = new Product();

                product.setPId(set.getInt("pId"));
                product.setName(set.getString("name"));
                product.setPrice(set.getDouble("price"));
                product.setQuantity(set.getInt("quantity"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean removeProduct(int pId) {
        try {
            String q = "delete from product where pId=?";
            PreparedStatement pstmt = connection.prepareStatement(q);
            pstmt.setInt(1, pId);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int checkInStock(int pId) {
        try {
            String q = "SELECT quantity FROM product where pId=?;";
            PreparedStatement pstmt = connection.prepareStatement(q);
            pstmt.setInt(1, pId);
            ResultSet set = pstmt.executeQuery();
            int stock ;
            if(set.next()){
                stock = set.getInt(1);
                return stock;
            }
        } catch (Exception e) {
            System.out.println("Database error!");
            return 0;
        }
        return 0;
    }

    @Override
    public boolean decreaseQuantity(int pId, int quantity) {
        try {
            String q = "UPDATE product SET quantity=quantity-? where pId=?;";
            PreparedStatement pstmt = connection.prepareStatement(q);
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, pId);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Database error!");
            return false;
        }
    }

}