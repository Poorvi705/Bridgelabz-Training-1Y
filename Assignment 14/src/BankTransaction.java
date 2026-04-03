public class BankTransaction {

    // Method to calculate remaining limit
    public static double getRemainingLimit(Double limit, double withdrawnAmount) {

        // Handle null case
        if (limit == null) {
            return 0.0;
        }

        // Calculate remaining limit
        return limit - withdrawnAmount;
    }

    public static void main(String[] args) {

        // Test cases
        System.out.println(getRemainingLimit(5000.0, 1500.0)); // 3500.0
        System.out.println(getRemainingLimit(null, 1000.0));   // 0.0
    }
}