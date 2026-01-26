import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

       
        int originalNumber = number;

        int remainder;
        int sum = 0;

        
        while (number > 0) {

     
            remainder = number % 10;

            sum = sum + (remainder * remainder * remainder);

            number = number / 10;
        }
        if (sum == originalNumber) {
            System.out.println("The number " + originalNumber + " is an Armstrong Number");
        } else {
            System.out.println("The number " + originalNumber + " is not an Armstrong Number");
        }
    }
}
