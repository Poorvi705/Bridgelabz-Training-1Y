import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nChecking each number:");
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } 
            else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative.");
            } 
            else {
                System.out.println(numbers[i] + " is zero.");
            }
        }
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("\nComparing first and last elements:");

        if (first == last) {
            System.out.println("First and last elements are equal.");
        } 
        else if (first >