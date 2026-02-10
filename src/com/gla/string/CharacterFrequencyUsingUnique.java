package com.gla.string;

import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    // a. Method to find unique characters using charAt() and nested loops
    public static char[] uniqueCharacters(String text) {
        int n = text.length();

        // temporary array (max size = length of text)
        char[] temp = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check with previous characters
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[count++] = current;
            }
        }

        // exact-size array for unique characters
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // b. Method to find frequency using unique characters
    public static String[][] findFrequency(String text) {

        // i. Frequency array for 256 ASCII characters
        int[] freq = new int[256];

        // ii. Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // iii. Get unique characters
        char[] unique = uniqueCharacters(text);

        // iv. 2D array to store character and frequency
        String[][] result = new String[unique.length][2];

        // v. Store characters and their frequencies
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }

        return result;
    }

    // c. Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] frequency = findFrequency(input);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("----------------------");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(frequency[i][0] + "\t\t" + frequency[i][1]);
        }

        sc.close();
    }
}