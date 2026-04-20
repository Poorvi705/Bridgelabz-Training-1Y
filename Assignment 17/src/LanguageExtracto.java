import java.util.*;
import java.util.regex.*;

public class LanguageExtracto {

    public static void main(String[] args) {

        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String regex = "\\b(JavaScript|Java|Python|Go)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<>();

        while (matcher.find()) {
            result.add(matcher.group());
        }

        // Print in required format
        System.out.println(String.join(", ", result));
    }
}