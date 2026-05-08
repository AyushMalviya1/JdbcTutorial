package JdbcTutorial.InventoryManagementSystem.ConsoleOpe;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import JdbcTutorial.InventoryManagementSystem.DaoImpl.ProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.Exception.InputUtil;
import JdbcTutorial.InventoryManagementSystem.pojo.Product;

public class ProductsOpe {

    public static void productsOpe(Scanner sc, ProductDaoImpl productService) {

        int choice;
        boolean isContinue = true;

        while (isContinue) {

            try {
                System.out.println("Do you want to ");
                System.out.println();

                System.out.println("1. Add Product");
                System.out.println("2. View Product");
                System.out.println("3. View All Product");
                System.out.println("4. Remove Product");
                System.out.println("5. Back");
                System.out.println();

                choice = InputUtil.takeIntInput(sc, "Enter your choice: ");
                System.out.println();

                switch (choice) {

                    case 1: // Add Product
                        try {

                            System.out.print("Enter Product Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Price: ");
                            double price = sc.nextDouble();

                            System.out.print("Enter Quantity: ");
                            int quantity = sc.nextInt();

                            System.out.println();

                            Product product = new Product(name, quantity, price);

                            boolean result = productService.addProduct(product);

                            if (result) {
                                System.out.println("Product inserted successfully.");
                            } else {
                                System.out.println("Something went wrong.");
                            }

                            System.out.println();

                        } catch (InputMismatchException e) {
                            System.out.println();
                            System.out.println(
                                    "Invalid Input! Price and Quantity must be numeric values.");
                            System.out.println();

                            sc.nextLine(); // clear invalid input
                        }
                        break;

                    case 2: // View Product
                        try {
                            System.out.print("Enter Product Id: ");
                            int id = sc.nextInt();

                            System.out.println();

                            Product product2 = productService.viewProduct(id);

                            if (product2 != null) {

                                System.out.println("Product Details:");
                                System.out.println("Id: " + product2.getPId());
                                System.out.println("Name: " + product2.getName());
                                System.out.println("Price: " + product2.getPrice());
                                System.out.println("Quantity: " + product2.getQuantity());

                            } else {
                                System.out.println("Product not found.");
                            }

                            System.out.println();

                        } catch (InputMismatchException e) {

                            System.out.println();
                            System.out.println("Invalid Input! Product Id must be a number.");
                            System.out.println();

                            sc.nextLine(); // clear invalid input
                        }

                        break;

                    case 3: // View All Product

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

                        break;

                    case 4: // Remove Product
                        try {

                            System.out.print("Enter Product Id: ");
                            int id1 = sc.nextInt();

                            System.out.println();

                            if (productService.removeProduct(id1)) {

                                System.out.println("Product removed successfully.");

                            } else {

                                System.out.println("Product not found.");
                            }

                            System.out.println();

                        } catch (InputMismatchException e) {

                            System.out.println();
                            System.out.println("Invalid Input! Product Id must be a number.");
                            System.out.println();

                            sc.nextLine(); // clear invalid input
                        }

                        break;

                    case 5: // Back
                        isContinue = false;
                        break;

                    default:
                        System.out.println("Invalid Choice! Please select between 1 to 5.");
                        System.out.println();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid Input! Please enter numeric value.");
                System.out.println();

                sc.nextLine(); // clear invalid input
                
            }
        }
    }
}