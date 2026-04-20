import java.util.regex.*;

public class LinkExtractorr {

    public static void main(String[] args) {

        String text = "Visit https://www.google.com and http://example.org for more info.";

        String regex = "https?://\\S+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Links:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}