package com.gla.string;

import java.util.Scanner;

public class StringLengthDemo {


    public static int findLengthWithoutLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {

            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String text = sc.next();


        int manualLength = findLengthWithoutLength(text);

        int builtInLength = text.length();


        System.out.println("Length without using length(): " + manualLength);
        System.out.println("Length using built-in length(): " + builtInLength);

        sc.close();
    }
}

