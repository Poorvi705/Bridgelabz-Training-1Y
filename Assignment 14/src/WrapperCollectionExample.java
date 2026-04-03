import java.util.ArrayList;

public class WrapperCollectionExample {
    public static void main(String[] args) {

        // Given array
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        // Convert to ArrayList<Double>
        ArrayList<Double> priceList = new ArrayList<>();

        for (double p : prices) {
            priceList.add(p); // Autoboxing (primitive → Double)
        }

        // Find highest price
        double max = priceList.get(0);
        for (double p : priceList) {
            if (p > max) {
                max = p;
            }
        }

        // Calculate average price
        double sum = 0;
        for (double p : priceList) {
            sum += p;
        }
        double average = sum / priceList.size();

        // Output
        System.out.println("Prices: " + priceList);
        System.out.println("Highest Price: " + max);
        System.out.println("Average Price: " + average);
    }
}