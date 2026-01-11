import java.util.Scanner;
class Circle{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double r= sc.nextDouble();
        double pi= 3.14159;
        double a= pi*r*r;
        System.out.println("Area of the circle: " + a);
        sc.close();
    }
}
