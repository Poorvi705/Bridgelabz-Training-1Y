package com.gla.string;
import java.util.Scanner;

public class LowerCaseCompare {


    public static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);


            if (ch >= 'A' && ch <= 'Z') {

                ch = (char) (ch + 32);
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


        String manualLower = convertToLowerCase(text);


        String builtInLower = text.toLowerCase();


        boolean result = compareStrings(manualLower, builtInLower);

        System.out.println("Lowercase using charAt(): " + manualLower);
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);
        System.out.println("Are both results equal? " + result);

        sc.close();
    }
}

