package JdbcTutorial.InventoryManagementSystem.ConsoleOpe;

import java.util.Scanner;

import JdbcTutorial.InventoryManagementSystem.DaoImpl.ProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.DaoImpl.PurchasedProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.DaoImpl.UserDaoImpl;
import JdbcTutorial.InventoryManagementSystem.Exception.InputUtil;
import JdbcTutorial.InventoryManagementSystem.pojo.Product;

public class BuyProduct {
    public static void buyProduct(Scanner sc, ProductDaoImpl productService, int uId,
            PurchasedProductDaoImpl purchasedProductService, UserDaoImpl userService) {

        int id = InputUtil.takeIntInput(sc, "Enter product id: ");
        int quantity = InputUtil.takeIntInput(sc, "Enter quantity: ");
        System.out.println();

        Product product = productService.viewProduct(id);
        double total_amount = product.getPrice() * quantity;

        System.out.println("Your total amount: " + total_amount);
        System.out.println();

        boolean inStock = (product.getQuantity() >= quantity) ? true : false;
        boolean availBalance = (userService.checkBalance(uId) >= total_amount) ? true : false;

        if (inStock && availBalance) {
            System.out.println("YOUR ORDER");
            System.out.println("Product name: " + product.getName());
            System.out.println("price: " + product.getPrice());
            System.out.println("Quantity: " + quantity);
            System.out.println();

            System.out.print("Please confirm your order(1. 'YES'), (2. 'NO'): ");
            String confirm = sc.nextLine();
            System.out.println();

            if (confirm.equals("1")) {

                if (userService.deductAmount(uId, total_amount)) {

                    if (productService.decreaseQuantity(id, quantity)) {

                        purchasedProductService.buyProduct(uId, id, quantity, total_amount);
                        System.out.println("YOUR ORDER CONFIRMED!");
                        System.out.println("Remaining balance in your account: " + userService.checkBalance(uId));
                        System.out.println();
                    }
                }
            } else if (confirm.equals("2")) {
                return;
            }
        } else if (inStock == true && availBalance == false) {
            System.out.println("You don't have enough balance!");
            System.out.println();
        } else if (inStock == false && availBalance == true) {
            System.out.println("OUT OF STOCK");
            System.out.println();
        }

    }
}