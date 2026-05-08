package JdbcTutorial.InventoryManagementSystem.ConsoleOpe;

import java.util.Scanner;

import JdbcTutorial.InventoryManagementSystem.DaoImpl.UserDaoImpl;

public class CheckBalanceOpe {

    public static void checkBalance(Scanner sc, int uId, UserDaoImpl userService) {
        try {
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.println();

            double balance = userService.checkBalance(uId, password);
            System.out.println("Balance: "+ balance);
            System.out.println();

        } catch (Exception e) {
            System.out.println("Invalid password!");
            e.printStackTrace();
            System.out.println();
        }
    }
}
