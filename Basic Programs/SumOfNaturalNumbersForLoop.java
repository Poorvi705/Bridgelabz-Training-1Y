import java.util.Scanner;

public class SumOfNaturalNumbersForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        
        if (n > 0) {

           
            int sumFor = 0;
            for (int i = 1; i <= n; i++) {
                sumFor += i;
            }

         
            int sumFormula = n * (n + 1) / 2;

            
            System.out.println("Sum using for loop: " + sumFor);
            System.out.println("Sum using formula: " + sumFormula);

            
            if (sumFor == sumFormula) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Both computations are not correct.");
            }

        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        sc.close();
    }
}