import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        String[] result = new String[number + 1];
        for (int i = 1; i <= number; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            }