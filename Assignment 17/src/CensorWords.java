public class CensorWords {

    public static void main(String[] args) {

        String input = "This is a damn bad example with some stupid words.";

        // 🔹 Regex for bad words
        String regex = "(?i)\\b(damn|stupid)\\b";

        // 🔹 Replace with ****
        String result = input.replaceAll(regex, "****");

        System.out.println(result);
    }
}