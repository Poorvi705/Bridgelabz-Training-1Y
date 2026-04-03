import java.util.ArrayList;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {

        // Primitive ratings
        int[] primitiveRatings = {4, 5, 3, 4};

        // Wrapper ratings (may contain nulls)
        ArrayList<Integer> wrapperRatings = new ArrayList<>();
        wrapperRatings.add(5);
        wrapperRatings.add(null);
        wrapperRatings.add(3);
        wrapperRatings.add(4);

        // Combined list
        ArrayList<Integer> allRatings = new ArrayList<>();

        // Add primitive array (auto-boxing: int → Integer)
        for (int r : primitiveRatings) {
            allRatings.add(r);
        }

        // Add wrapper list (including nulls)
        allRatings.addAll(wrapperRatings);

        // Calculate average (ignoring nulls)
        int sum = 0;
        int count = 0;

        for (Integer rating : allRatings) {
            if (Objects.nonNull(rating)) {
                sum += rating;      // auto-unboxing
                count++;
            }
        }

        double average = (count == 0) ? 0.0 : (double) sum / count;

        // Output
        System.out.println("All Ratings: " + allRatings);
        System.out.println("Average Rating: " + average);
    }
}