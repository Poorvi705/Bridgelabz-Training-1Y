import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {

        double a, b, c;
        double op1, op2, op3, op4;

        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter value of a: ");
        a = input.nextDouble();

        System.out.print("Enter value of b: ");
        b = input.nextDouble();

        System.out.print("Enter value of c: ");
        c = input.nextDouble();

       
        op1 = a + b * c;    
        op2 = a * b + c;    
        op3 = c + a / b;  
        op4 = a % b + c;    
        System.out.println(
            "The results of Double Operations are " +
            op1 + ", " + op2 + ", " + op3 + ", and " + op4   );

        input.close();
    }
}