import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionExamplee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Taking input
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Division
            int result = num1 / num2;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numeric values only");

        } finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}