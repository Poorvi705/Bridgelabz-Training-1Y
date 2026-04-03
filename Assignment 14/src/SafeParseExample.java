public class SafeParseExample {

    // Method to safely parse integer
    public static int safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // return -1 if conversion fails
        }
    }

    public static void main(String[] args) {

        String[] testInputs = {"123", "abc", "45.6", "0"};

        for (String input : testInputs) {
            int result = safeParseInt(input);
            System.out.println("Input: " + input + " → Output: " + result);
        }
    }
}