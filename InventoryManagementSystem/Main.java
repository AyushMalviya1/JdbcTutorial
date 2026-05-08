package JdbcTutorial.InventoryManagementSystem;

import java.util.Scanner;

import JdbcTutorial.InventoryManagementSystem.Authentication.Login;
import JdbcTutorial.InventoryManagementSystem.Authentication.Signup;
import JdbcTutorial.InventoryManagementSystem.ConsoleOpe.BuyProduct;
import JdbcTutorial.InventoryManagementSystem.ConsoleOpe.CheckBalanceOpe;
import JdbcTutorial.InventoryManagementSystem.ConsoleOpe.ProductsOpe;
import JdbcTutorial.InventoryManagementSystem.ConsoleOpe.Customer.ViewProduct;
import JdbcTutorial.InventoryManagementSystem.ConsoleOpe.Customer.ViewPurchasedProduct;
import JdbcTutorial.InventoryManagementSystem.DaoImpl.ProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.DaoImpl.PurchasedProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.DaoImpl.UserDaoImpl;
import JdbcTutorial.InventoryManagementSystem.Exception.InputUtil;
import JdbcTutorial.InventoryManagementSystem.pojo.User;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userService = new UserDaoImpl();
        ProductDaoImpl productService = new ProductDaoImpl();
        PurchasedProductDaoImpl purchasedProductService = new PurchasedProductDaoImpl();
        User user = new User();
        Login login = new Login();
        Signup signup = new Signup();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Inventory Management System");
        System.out.println();

        System.out.println("what do you want to, press ");
        System.out.println("1. Login");
        System.out.println("2. Signup");

        int choice = InputUtil.takeIntInput(sc, "Enter your choice: ");

        System.out.println();

        boolean isLoggedIn = false;

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.println();

        switch (choice) {
            case 1:
                // login
                user = login.login(name, password);

                if (user != null) {
                    isLoggedIn = true;
                }
                break;
            case 2:
                // singup
                user = signup.signup(name, password);

                if (user != null) {
                    isLoggedIn = true;
                }
                break;
            default:
                System.out.println("Oops! Wrong Input, please try again.");
                return;
        }

        if (isLoggedIn && user.getRole().equals("ADMIN")) {
            // Admin dashboard
            while (isLoggedIn) {
                int choice1;
                System.out.println("1. Products.");
                System.out.println("2. Customers.");
                System.out.println("3. Check Balance.");
                System.out.println("4. View Sales.");
                System.out.println("5. Logout.");
                System.out.println();

                choice1 = InputUtil.takeIntInput(sc, "Enter your choice: ");

                switch (choice1) {
                    case 1:// Products
                        ProductsOpe.productsOpe(sc, productService);
                        break;
                    case 2:// customer
                        break;
                    case 3:// Check Balance
                        CheckBalanceOpe.checkBalance(sc, user.getUId(), userService);
                        break;
                    case 4:// view sales
                        break;
                    case 5:// logout
                        isLoggedIn = false;
                        System.out.println();
                        break;
                    default:
                        System.out.println("Oops! Wrong Input, try again.");
                        break;
                }
            }
        } else if (isLoggedIn && user.getRole().equals("CUSTOMER")) {
            // customer dashboard
            System.out.println("Welcome " + user.getName());
            System.out.println();

            while (isLoggedIn) {
                int subChoice;

                System.out.println("What do you want to, press ");
                System.out.println();
                System.out.println("1. Buy Product.");
                System.out.println("2. View Products.");
                System.out.println("3. Search Product.");
                System.out.println("4. View purchased product.");
                System.out.println("5. View account balance.");
                System.out.println("6. Logout.");
                System.out.println();

                subChoice = InputUtil.takeIntInput(sc, "Enter your choice: ");
                System.out.println();

                switch (subChoice) {
                    case 1:// buy product
                        BuyProduct.buyProduct(sc, productService, user.getUId(), purchasedProductService, userService);
                        break;

                    case 2:// view products
                        ViewProduct.viewAllProduct(sc, productService);
                        break;

                    case 3:// search product.
                        ViewProduct.searchProductById(sc, productService);
                        break;

                    case 4:// view purchased product
                        ViewPurchasedProduct.viewPurchasedProduct(user.getUId(), purchasedProductService);      
                        break;

                    case 5:// view account balance.
                        CheckBalanceOpe.checkBalance(sc, user.getUId(), userService);
                        break;

                    case 6:// logout.
                        isLoggedIn = false;
                        System.out.println();
                        break;

                    default:
                        System.out.println("Oops! Wrong Input, try again.");
                        System.out.println();
                        break;
                }
            }
        } else {
            System.out.println("Invalid username or password!");
            return;
        }
        System.out.println("---------------------Thank you for using---------------------");
    }
}
