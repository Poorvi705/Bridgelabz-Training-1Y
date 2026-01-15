import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {

        double distanceInFeet;
        double yards;
        double miles;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        distanceInFeet = input.nextDouble();
        yards = distanceInFeet / 3;
        miles = yards / 1760;

        System.out.println(
            "The distance in feet is " + distanceInFeet +
            " while in yards is " + yards +
            " and miles is " + miles  );

        input.close();
    }
}