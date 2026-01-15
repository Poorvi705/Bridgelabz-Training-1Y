import java.util.Scanner;

public class TriangleAreaCmInch {
    public static void main(String[] args) {

        double baseCm, heightCm;
        double areaCm2, areaIn2;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle in cm: ");
        baseCm = input.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        heightCm = input.nextDouble();
        areaCm2 = 0.5 * baseCm * heightCm;
        areaIn2 = areaCm2 / (2.54 * 2.54);

        System.out.println(
            "The Area of the triangle in sq in is " + areaIn2 +
            " and sq cm is " + areaCm2 );

        input.close();
    }
}