package com.gla.string;


import java.util.Scanner;

public class UpperCaseCompare {

    public static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);


            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase using ASCII difference (32)
                ch = (char) (ch - 32);
            }

            result = result + ch;
        }

        return result;
    }


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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the complete text: ");
        String text = sc.nextLine();


        String manualUpper = convertToUpperCase(text);


        String builtInUpper = text.toUpperCase();


        boolean result = compareStrings(manualUpper, builtInUpper);


        System.out.println("Uppercase using charAt(): " + manualUpper);
        System.out.println("Uppercase using toUpperCase(): " + builtInUpper);
        System.out.println("Are both results equal? " + result);

        sc.close();
    }
}

