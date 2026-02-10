package com.gla.string;
import java.util.Scanner;

public class PalindromeCheck {

    // b. Logic 1: Iterative comparison using start & end indexes
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // c. Logic 2: Recursive palindrome check
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        // i. Base condition
        if (start >= end) {
            return true;
        }

        // ii. If characters do not match
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // iii. Recursive call
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // d.i. Method to reverse a string using charAt()
    public static char[] reverseString(String text) {
        int n = text.length();
        char[] reverse = new char[n];

        for (int i = 0; i < n; i++) {
            reverse[i] = text.charAt(n - 1 - i);
        }
        return reverse;
    }

    // d.ii. Logic 3: Palindrome check using character arrays
    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    // e. Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean result3 = isPalindromeUsingArray(input);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("--------------------------");
        System.out.println("Logic 1 (Iterative): " + result1);
        System.out.println("Logic 2 (Recursive): " + result2);
        System.out.println("Logic 3 (Array): " + result3);

        sc.close();
    }
}
