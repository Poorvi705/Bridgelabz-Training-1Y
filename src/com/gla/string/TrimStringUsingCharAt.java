package com.gla.string;
import java.util.Scanner;

public class TrimStringUsingCharAt {

    // a. Method to find start and end index without spaces
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;

        // trim leading spaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // trim trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // b. Method to create substring using charAt()
    public static String customSubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

    // c. Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // d. Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // user-defined trim logic
        int[] indexes = findTrimIndexes(input);
        String trimmedByCharAt = customSubstring(input, indexes[0], indexes[1]);

        // built-in trim
        String trimmedByBuiltIn = input.trim();

        // compare both results
        boolean isSame = compareStrings(trimmedByCharAt, trimmedByBuiltIn);

        System.out.println("Trimmed string using charAt(): \"" + trimmedByCharAt + "\"");
        System.out.println("Trimmed string using String.trim(): \"" + trimmedByBuiltIn + "\"");
        System.out.println("Are both strings equal? " + isSame);

        sc.close();
    }
}
