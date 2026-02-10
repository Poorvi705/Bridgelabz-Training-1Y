package com.gla.string;

import java.util.Scanner;

public class CharacterFrequencyNested {

    // a. Method to find character frequencies using nested loops
    public static String[] findFrequency(String text) {

        // i. Store characters using toCharArray()
        char[] chars = text.toCharArray();
        int n = chars.length;

        // array to store frequency of characters
        int[] freq = new int[n];

        // ii. Nested loops to calculate frequency
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0')
                continue;

            freq[i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // count unique characters
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // iii. 1D String array to store character and frequency
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " -> " + freq[i];
                index++;
            }
        }

        return result;
    }

    // b. Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] frequency = findFrequency(input);

        System.out.println("\nCharacter Frequencies:");
        System.out.println("----------------------");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(frequency[i]);
        }

        sc.close();
    }
}