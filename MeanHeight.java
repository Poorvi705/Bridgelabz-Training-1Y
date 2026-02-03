import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = sc.nextDouble();
        }
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        double mean = sum / heights.length;
        System.out.println("\nMean height of the football team = " + mean);

        sc.close();
    }
}
