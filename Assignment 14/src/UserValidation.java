public class UserValidation {

    // Method to validate age
    public static boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput); // Convert String → int

            if (age >= 18) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            // Invalid input (not a number)
            return false;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        System.out.println(isValidAge("20"));   // true
        System.out.println(isValidAge("17"));   // false
        System.out.println(isValidAge("abc"));  // false
        System.out.println(isValidAge("18"));   // true
    }
}