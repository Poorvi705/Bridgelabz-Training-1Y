import java.util.Scanner;

public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        
        if (num >= 0) {
            long factorial = 1;

            
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }

            System.out.println("The factorial of " + num + " is " + factorial);
        } else {
            System.out.println("The number " + num + " is not a natural number.");
        }

        sc.close();
    }
}