import java.util.Scanner;
class Avg{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a= sc.nextDouble();
        System.out.print("Enter second number: ");
        double b= sc.nextDouble();
        System.out.print("Enter third number: ");
        double c= sc.nextDouble();
        double average = (c + b + a)/3;
        System.out.println("Average of the three numbers: " + average);
        sc.close();
    }
}
