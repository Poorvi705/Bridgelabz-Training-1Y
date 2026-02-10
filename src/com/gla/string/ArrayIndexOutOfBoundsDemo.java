package com.gla.string;

import java.util.Scanner;

    public class ArrayIndexOutOfBoundsDemo {


        public static void generateException(String[] names) {

            System.out.println(names[names.length]);
        }


        public static void handleException(String[] names) {
            try {

                System.out.println(names[names.length]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException handled successfully");
            } catch (RuntimeException e) {
                System.out.println("Generic RuntimeException handled");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            System.out.print("Enter number of names: ");
            int size = sc.nextInt();

            String[] names = new String[size];

            System.out.println("Enter the names:");
            for (int i = 0; i < size; i++) {
                names[i] = sc.next();
            }


            System.out.println("\nGenerating ArrayIndexOutOfBoundsException:");
            try {
                generateException(names);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception caught in main method");
            }


            System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
            handleException(names);

            sc.close();
        }
    }

