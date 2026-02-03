import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();
        double[] physics = new double[number];
        double[] chemistry = new double[number];
        double[] maths = new double[number];
        double[] percentage = new double[number];
        char[] grade = new char[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Physics marks: ");
            physics[i] = sc.nextDouble();

            if (physics[i] < 0) {
                System.out.println("Invalid marks. Enter positive values.");
                i--;
                continue;
            }

            System.out.print("Enter Chemistry marks: ");
            chemistry[i] = sc.nextDouble();

            if (chemistry[i] < 0) {
                System.out.println("Invalid marks. Enter positive values.");
                i--;
                continue;
            }

            System.out.print("Enter Maths marks: ");
            maths[i] = sc.nextDouble();

            if (maths[i] < 0) {
                System.out.println("Invalid marks. Enter positive values.");
                i--;
                continue;
            }
        }
        for (int i = 0; i < number; i++) {
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }
        System.out.println("\n--- STUDENT RESULT ---");
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Maths: " + maths[i]);
            System.out.println("Percentage: " + percentage[i] + "%");
            System.out.println("Grade: " + grade[i]);
            System.out.println();
        }

        sc.close();
    }
}