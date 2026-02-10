package com.gla.string;

import java.util.Scanner;

    public class NumberFormatDemo {


        public static void generateException(String text) {

            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);
        }


        public static void handleException(String text) {
            try {
                int number = Integer.parseInt(text);
                System.out.println("Number is: " + number);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException handled successfully");
            } catch (RuntimeException e) {
                System.out.println("Generic RuntimeException handled");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a value: ");
            String text = sc.next();


            System.out.println("\nGenerating NumberFormatException:");
            try {
                generateException(text);
            } catch (NumberFormatException e) {
                System.out.println("Exception caught in main method");
            }


            System.out.println("\nHandling NumberFormatException:");
            handleException(text);

            sc.close();
        }
    }

