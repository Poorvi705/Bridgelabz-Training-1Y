package com.gla.string;

 import java.util.Scanner;

public class StringCompare {

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        // Step 1: Check length
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Compare characters one by one
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare using charAt method
        boolean charAtResult = compareUsingCharAt(str1, str2);

        // Compare using built-in equals() method
        boolean equalsResult = str1.equals(str2);

        // Display results
        System.out.println("Comparison using charAt(): " + charAtResult);
        System.out.println("Comparison using equals(): " + equalsResult);

        // Check if both results are same
        if (charAtResult == equalsResult) {
            System.out.println("Both comparison results are SAME");
        } else {
            System.out.println("Both comparison results are DIFFERENT");
        }

        sc.close();
    }
}

