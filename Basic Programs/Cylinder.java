import java.util.Scanner;
class Cylinder{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter radius of the cylinder: ");
        double r= sc.nextDouble();
        System.out.print("Enter height of the cylinder: ");
        double h= sc.nextDouble();
        double pi= 3.14159;
        double v= pi*r*r*h;
        System.out.println("Volume of the cylinder: " + v);
        sc.close();
    }
}
