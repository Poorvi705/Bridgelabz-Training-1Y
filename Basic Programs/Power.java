import java.util.Scanner;
class Power{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double b = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double e = sc.nextDouble();
        double r= Math.pow(b, e);
        System.out.println(b + " raised to the power " + e + " is: " + r);
        sc.close();
    }
}
