package com.gla.string;

import java.util.Scanner;

    public class IllegalArgumentDemo {


        public static void generateException(String text) {

            System.out.println(text.substring(5, 2));
        }
        public static void handleException(String text) {
            try {

                System.out.println(text.substring(5, 2));
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException handled successfully");
            } catch (RuntimeException e) {
                System.out.println("Generic RuntimeException handled");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            System.out.print("Enter a string: ");
            String text = sc.next();


            System.out.println("\nGenerating IllegalArgumentException:");
            try {
                generateException(text);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception caught in main method");
            }


            System.out.println("\nHandling IllegalArgumentException:");
            handleException(text);

            sc.close();
        }
    }

