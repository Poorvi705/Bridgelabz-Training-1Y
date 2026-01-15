import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {

        int a, b, c;
        int op1, op2, op3, op4;

        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter value of a: ");
        a = input.nextInt();

        System.out.print("Enter value of b: ");
        b = input.nextInt();

        System.out.print("Enter value of c: ");
        c = input.nextInt();

      
        op1 = a + b * c;   
        op2 = a * b + c;    
        op3 = c + a / b;    
        op4 = a % b + c;    
        System.out.println(
            "The results of Int Operations are " +
            op1 + ", " + op2 + ", " + op3 + ", and " + op4   );

        input.close();
    }
}