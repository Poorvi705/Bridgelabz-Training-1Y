import java.util.Scanner;
class Si{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Principal amount: ");
        double p= sc.nextDouble();
        System.out.print("Enter Rate of interest: ");
        double r= sc.nextDouble();
        System.out.print("Enter Time (in years): ");
        double t= sc.nextDouble();
        double s= (p*r*t)/100;
        System.out.println("Simple Interest is: " + s);
        sc.close();
    }
}
