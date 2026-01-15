import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        double base;
        double height;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter base of the triangle (in inches): ");
        base = input.nextDouble();

        System.out.print("Enter height of the triangle (in inches): ");
        height = input.nextDouble();
        double areaInSqInches = 0.5 * base * height;
        double areaInSqCm = areaInSqInches * 2.54 * 2.54;

        System.out.println(
            "The area of the triangle is " + areaInSqInches + " square inches " +
            "and " + areaInSqCm + " square centimeters" );

        input.close();
    }
}