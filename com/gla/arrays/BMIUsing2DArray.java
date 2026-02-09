import java.util.Scanner;

public class BMIUsing2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter height (in meters): ");
            double height = sc.nextDouble();

            if (height <= 0) {
                System.out.println("Invalid height. Enter positive value.");
                i--;
                continue;
            }

            System.out.print("Enter weight (in kg): ");
            double weight = sc.nextDouble();

            if (weight <= 0) {
                System.out.println("Invalid weight. Enter positive value.");
                i--;
                continue;
            }

            personData[i][0] = height;
            personData[i][1] = weight;
        }
        for (int i = 0; i < number; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];

            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\n--- BMI REPORT ---");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + personData[i][0] + " m");
            System.out.println("Weight: " + personData[i][1] + " kg");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }

        sc.close();
    }
}