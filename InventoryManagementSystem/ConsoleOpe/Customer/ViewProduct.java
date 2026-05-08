package JdbcTutorial.InventoryManagementSystem.ConsoleOpe.Customer;

import java.util.List;
import java.util.Scanner;

import JdbcTutorial.InventoryManagementSystem.DaoImpl.ProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.Exception.InputUtil;
import JdbcTutorial.InventoryManagementSystem.pojo.Product;

public class ViewProduct {
    public static void searchProductById(Scanner sc, ProductDaoImpl productService) {
        try {
            int id = InputUtil.takeIntInput(sc, "Enter product id: ");
            System.out.println();
            Product product = productService.viewProduct(id);
            System.out.println("Product id: " + product.getPId());
            System.out.println("Product name: " + product.getName());
            System.out.println("Product price: ₹" + product.getPrice());
            System.out.println("Stock: " + product.getQuantity());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    public static void viewAllProduct(Scanner sc, ProductDaoImpl productService) {
        List<Product> list = productService.viewAllProduct();

        if (list.isEmpty()) {

            System.out.println("No products available.");
            System.out.println();

        } else {

            System.out.println("---------------------------------------------------------");
            System.out.println("ID\tName\t\tPrice\t\tQuantity");
            System.out.println("---------------------------------------------------------");

            for (Product product3 : list) {

                System.out.println(
                        product3.getPId() + "\t"
                                + product3.getName() + "\t\t"
                                + product3.getPrice() + "\t\t"
                                + product3.getQuantity());
            }

            System.out.println();
        }
    }
}
