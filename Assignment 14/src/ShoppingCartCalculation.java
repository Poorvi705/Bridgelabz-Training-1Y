public class ShoppingCartCalculation {
    public static void main(String[] args) {

        // Prices stored as Strings
        String[] prices = {"250", "499", "99", "abc", "150"};

        int totalPrice = 0;

        for (String price : prices) {
            try {
                // Convert String to int using wrapper class
                int value = Integer.parseInt(price);
                totalPrice += value;

            } catch (NumberFormatException e) {
                // Handle invalid price
                System.out.println("Invalid price ignored: " + price);
            }
        }

        // Display total price
        System.out.println("Total Price: " + totalPrice);
    }
}