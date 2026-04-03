public class ShoppingCart {
    public static void main(String[] args) {

        // Prices stored as Strings
        String[] prices = {"250", "499", "99", "abc", "150"};

        int total = 0;

        for (String price : prices) {
            try {
                // Convert String to int using wrapper class
                int value = Integer.parseInt(price);
                total += value;
            } catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid price skipped: " + price);
            }
        }

        // Final total
        System.out.println("Total Price: " + total);
    }
}