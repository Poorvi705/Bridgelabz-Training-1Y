package com.gla.string;

public class NullPointerDemo {


    public static void generateException() {
        String text = null;   // initialized to null
        // This line will generate NullPointerException
        System.out.println(text.length());
    }


    public static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled successfully");
        }
    }

    public static void main(String[] args) {

        System.out.println("Generating NullPointerException:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main method");
        }


        System.out.println("\nHandling NullPointerException:");
        handleException();
    }
}

