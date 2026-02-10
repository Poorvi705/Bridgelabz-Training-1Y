package com.gla.string;
import java.util.Scanner;

public class CharacterFrequency {

    // a. Method to find character frequencies and return 2D array
    public static String[][] findCharacterFrequency(String text) {

        // i. Frequency array for 256 ASCII characters
        int[] freq = new int[256];

        // ii. Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] != 0) {
                uniqueCount++;
                freq[text.charAt(i)] = -freq[text.charAt(i)]; // mark counted
            }
        }

        // iii. Create 2D array to store characters and frequencies
        String[][] result = new String[uniqueCount][2];

        // iv. Store characters and their frequencies
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            int ascii = text.charAt(i);
            if (freq[ascii] < 0) {
                result[index][0] = String.valueOf(text.charAt(i));
                result[index][1] = String.valueOf(-freq[ascii]);
                freq[ascii] = 0;
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

        String[][] frequency = findCharacterFrequency(input);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("----------------------");

        for (int i = 0; i < frequency.length; i++) {
            System.out.println(frequency[i][0] + "\t\t" + frequency[i][1]);
        }

        sc.close();
    }
}
