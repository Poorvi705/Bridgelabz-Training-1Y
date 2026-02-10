package com.gla.string;
import java.util.Scanner;

public class SplitTextCompare {


    public static int findLength(String text) {
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


    public static String[] splitUsingCharAt(String text) {

        int length = findLength(text);


        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }


        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        spaceIndexes[index++] = -1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = length;

        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the text: ");
        String text = sc.nextLine();


        String[] manualSplit = splitUsingCharAt(text);


        String[] builtInSplit = text.split(" ");


        boolean result = compareStringArrays(manualSplit, builtInSplit);


        System.out.println("\nWords using charAt():");
        for (String word : manualSplit) {
            System.out.println(word);
        }

        System.out.println("\nWords using split():");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both results equal? " + result);

        sc.close();
    }
}

