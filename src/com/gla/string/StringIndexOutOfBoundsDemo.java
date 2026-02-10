package com.gla.string;

import java.util.Scanner;

    public class StringIndexOutOfBoundsDemo {


        public static void generateException(String text) {

            System.out.println(text.charAt(text.length()));
        }


        public static void handleException(String text) {
            try {

                System.out.println(text.charAt(text.length()));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("StringIndexOutOfBoundsException handled successfully");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            System.out.print("Enter a string: ");
            String text = sc.next();


            System.out.println("\nGenerating StringIndexOutOfBoundsException:");
            try {
                generateException(text);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Exception caught in main method");
            }


            System.out.println("\nHandling StringIndexOutOfBoundsException:");
            handleException(text);

            sc.close();
        }
    }

