import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {

        double unitPrice;
        int quantity;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter unit price (INR): ");
        unitPrice = input.nextDouble();

        System.out.print("Enter quantity: ");
        quantity = input.nextInt();
        double totalPrice = unitPrice * quantity;

        System.out.println(
            "The total purchase price is INR " + totalPrice +
            " if the quantity " + quantity +
            " and unit price is INR " + unitPrice  );

        input.close();
    }
}