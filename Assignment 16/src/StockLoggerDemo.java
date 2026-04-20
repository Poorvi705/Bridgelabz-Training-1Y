import java.util.*;

public class StockLoggerDemo {

    public static void main(String[] args) {

        // Simulated stock price feed
        List<Double> stockPrices = Arrays.asList(
                245.50, 246.75, 244.90, 247.30, 248.10
        );

        System.out.println("Live Stock Price Updates:");

        // 🔹 Using forEach to print each price
        stockPrices.forEach(price ->
                System.out.println("Stock Price: ₹" + price)
        );
    }
}