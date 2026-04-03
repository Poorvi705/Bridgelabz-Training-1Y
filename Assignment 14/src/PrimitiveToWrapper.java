import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking integer input
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        // Converting primitive to wrapper (Autoboxing)
        Integer obj = num;

        // Displaying values
        System.out.println("Primitive int value: " + num);
        System.out.println("Wrapper Integer value: " + obj);

        sc.close();
    }
}