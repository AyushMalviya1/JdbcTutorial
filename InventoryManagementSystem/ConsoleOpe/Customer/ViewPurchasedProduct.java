package JdbcTutorial.InventoryManagementSystem.ConsoleOpe.Customer;

import java.util.List;

import JdbcTutorial.InventoryManagementSystem.DaoImpl.PurchasedProductDaoImpl;
import JdbcTutorial.InventoryManagementSystem.pojo.PurchasedProduct;

public class ViewPurchasedProduct {

    public static void viewPurchasedProduct(int uId,
            PurchasedProductDaoImpl purchasedProductService) {

        try {

            List<PurchasedProduct> list =
                    purchasedProductService.getPurchasedHistory(uId);

            if (list.isEmpty()) {
                System.out.println("No purchase history found.");
                return;
            }

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("ID\tProductID\tQuantity\tTotal Amount\tPurchased Date");
            System.out.println("-----------------------------------------------------------------------");

            for (PurchasedProduct purchasedProduct : list) {

                System.out.println(
                        purchasedProduct.getId() + "\t"
                                + purchasedProduct.getPId() + "\t\t"
                                + purchasedProduct.getQuantity() + "\t\t"
                                + purchasedProduct.getTotal_amount() + "\t\t"
                                + purchasedProduct.getTimestamp());
            }

            System.out.println("-----------------------------------------------------------------------");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}