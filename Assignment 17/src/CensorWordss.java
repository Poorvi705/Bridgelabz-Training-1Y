import java.util.*;

public class CensorWordss {

    public static void main(String[] args) {

        String input = "This is a damn bad example with some stupid words.";

        // List of bad words
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Build regex dynamically
        String regex = "(?i)\\b(" + String.join("|", badWords) + ")\\b";

        // Replace with ****
        String result = input.replaceAll(regex, "****");

        System.out.println(result);
    }
}