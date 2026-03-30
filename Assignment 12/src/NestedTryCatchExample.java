import java.util.Scanner;

public class NestedTryCatchExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Initialize array
            int[] arr = {10, 20, 30, 40, 50};

            System.out.print("Enter index: ");
            int index = sc.nextInt();

            // Outer try for array access
            try {
                int value = arr[index];

                System.out.print("Enter divisor: ");
                int divisor = sc.nextInt();

                // Inner try for division
                try {
                    int result = value / divisor;
                    System.out.println("Result: " + result);

                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            sc.close();
        }
    }
}