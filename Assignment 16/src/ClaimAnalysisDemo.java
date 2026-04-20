import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

// Claim Class
class Claim {
    String type;     // e.g., "Health", "Vehicle", "Life"
    double amount;

    public Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

// Main Class
public class ClaimAnalysisDemo {

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
                new Claim("Health", 5000),
                new Claim("Vehicle", 8000),
                new Claim("Health", 7000),
                new Claim("Life", 10000),
                new Claim("Vehicle", 6000),
                new Claim("Health", 9000)
        );

        // 🔹 Grouping + Averaging
        Map<String, Double> avgClaimByType = claims.stream()
                .collect(Collectors.groupingBy(
                        c -> c.type,                        // group by type
                        Collectors.averagingDouble(c -> c.amount) // average
                ));

        // Print result
        System.out.println("Average Claim Amount by Type:");
        avgClaimByType.forEach((type, avg) ->
                System.out.println(type + " → " + avg));
    }
}