import java.util.Scanner;
class Perimeter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of the rectangle: ");
        double l= sc.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        double w= sc.nextDouble();
        double p= 2*(l + w);
        System.out.println("Perimeter of the rectangle: " + p);
        sc.close();
    }
}
