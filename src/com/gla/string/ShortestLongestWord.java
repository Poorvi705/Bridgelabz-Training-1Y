package com.gla.string;
import java.util.Scanner;

public class ShortestLongestWord {


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


    public static String[][] createWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }

        return result;
    }


    public static int[] findShortestAndLongest(String[][] wordLengthArray) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordLengthArray.length; i++) {
            int currentLength = Integer.parseInt(wordLengthArray[i][1]);
            int shortestLength = Integer.parseInt(wordLengthArray[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordLengthArray[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }
            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[] { shortestIndex, longestIndex };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the text: ");
        String text = sc.nextLine();


        String[] words = splitUsingCharAt(text);


        String[][] wordLengthArray = createWordLengthArray(words);


        int[] resultIndexes = findShortestAndLongest(wordLengthArray);


        System.out.println("\nWords and their lengths:");
        for (int i = 0; i < wordLengthArray.length; i++) {
            System.out.println(wordLengthArray[i][0] + " -> " +
                    Integer.parseInt(wordLengthArray[i][1]));
        }

        System.out.println("\nShortest word: " +
                wordLengthArray[resultIndexes[0]][0]);

        System.out.println("Longest word: " +
                wordLengthArray[resultIndexes[1]][0]);

        sc.close();
    }
}
