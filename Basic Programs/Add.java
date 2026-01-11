import java.util.Scanner;
class Add{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int res = a + b;
        System.out.println("Sum is: " + res);
        sc.close();
    }
}
