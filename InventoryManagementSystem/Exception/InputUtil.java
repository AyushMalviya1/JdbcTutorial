package JdbcTutorial.InventoryManagementSystem.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    public static int takeIntInput(Scanner sc, String message) {

        while (true) {
            try {
                System.out.print(message);
                int value = sc.nextInt();
                sc.nextLine(); // consume newline
                return value;

            } catch (InputMismatchException e) {

                System.out.println("Please enter numbers only.");
                System.out.println();

                sc.nextLine(); // clear invalid input
            }
        }
    }
}