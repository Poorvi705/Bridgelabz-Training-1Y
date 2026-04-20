import java.util.regex.*;

public class EmailExtractor {

    public static void main(String[] args) {

        String text = "Contact us at support@example.com and info@company.org";

        String regex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Emails:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}