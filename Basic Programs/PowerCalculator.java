import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power (positive integer): ");
        int power = sc.nextInt();

        if (power < 0) {
            System.out.println("Power should be a positive integer.");
        } else {
            int result = 1;

            for (int i = 1; i <= power; i++) {
                result = result * number;
            }

            System.out.println(number + " raised to the power " + power + " is " + result);
        }

        sc.close();
    }
}