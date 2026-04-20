import java.util.regex.*;

public class SSNValidatorrr {

    public static void main(String[] args) {

        String text = "My SSN is 123-45-6789.";
        String invalid = "123456789";

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        // 🔹 Extract & validate from sentence
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
        }

        // 🔹 Direct validation
        if (invalid.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("❌ \"" + invalid + "\" is invalid");
        }
    }
}