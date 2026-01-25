import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Number should be positive and less than 100.");
        } else {
            int counter = 1; 
            System.out.println("Multiples of " + number + " below 100 are:");
            
            while (counter * number < 100) {
                System.out.print((counter * number) + " ");
                counter++;
            }
        }

        sc.close();
    }
}