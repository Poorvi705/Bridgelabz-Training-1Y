package com.gla.string;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // b. Method to find first non-repeating character using charAt()
    public static char findFirstNonRepeatingChar(String text) {

        // i. Frequency array for 256 ASCII characters
        int[] freq = new int[256];

        // ii. Loop to calculate frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // iii. Loop to find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // if no non-repeating character found
    }

    // c. Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}