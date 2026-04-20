import java.util.regex.*;

public class RepeatingWords {

    public static void main(String[] args) {

        String text = "This is is a repeated repeated word test.";

        String regex = "\\b(\\w+)\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Repeating Words:");

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}