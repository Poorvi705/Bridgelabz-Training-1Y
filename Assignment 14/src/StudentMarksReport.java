import java.util.ArrayList;

public class StudentMarksReport {
    public static void main(String[] args) {

        // Mixed input (String, Integer, invalid, null-like)
        Object[] inputs = {"85", 95, Integer.valueOf(88), "null", "abc", null};

        ArrayList<Integer> validMarks = new ArrayList<>();

        for (Object input : inputs) {
            if (input == null) {
                continue; // ignore null
            }

            try {
                if (input instanceof String) {
                    String str = (String) input;

                    // Ignore "null" string
                    if (str.equalsIgnoreCase("null")) {
                        continue;
                    }

                    // Convert String → Integer
                    validMarks.add(Integer.parseInt(str));

                } else if (input instanceof Integer) {
                    // Directly add Integer
                    validMarks.add((Integer) input);
                }

            } catch (NumberFormatException e) {
                // Ignore invalid values like "abc"
                System.out.println("Invalid entry skipped: " + input);
            }
        }

        // Calculate average
        int sum = 0;
        for (Integer mark : validMarks) {
            sum += mark; // auto-unboxing
        }

        double average = validMarks.isEmpty() ? 0.0 : (double) sum / validMarks.size();

        // Output
        System.out.println("Valid Marks: " + validMarks);
        System.out.println("Average Marks: " + average);
    }
}