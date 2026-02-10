package com.gla.string;

import java.util.Scanner;

    public class CharArrayCompare {


        public static char[] getCharsUsingCharAt(String text) {
            char[] chars = new char[text.length()];

            for (int i = 0; i < text.length(); i++) {
                chars[i] = text.charAt(i);
            }

            return chars;
        }


        public static boolean compareCharArrays(char[] arr1, char[] arr2) {
            if (arr1.length != arr2.length) {
                return false;
            }

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }

            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            System.out.print("Enter a string: ");
            String text = sc.next();


            char[] userDefinedArray = getCharsUsingCharAt(text);


            char[] builtInArray = text.toCharArray();


            boolean result = compareCharArrays(userDefinedArray, builtInArray);


            System.out.println("Characters using user-defined method:");
            for (char c : userDefinedArray) {
                System.out.print(c + " ");
            }

            System.out.println("\nCharacters using toCharArray():");
            for (char c : builtInArray) {
                System.out.print(c + " ");
            }

            System.out.println("\nAre both character arrays equal? " + result);

            sc.close();
        }
    }

