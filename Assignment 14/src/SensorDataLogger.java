import java.util.ArrayList;

public class SensorDataLogger {

    // Method accepting both primitive and wrapper types
    public static void logTemperature(Double temp, ArrayList<Double> dataList) {
        if (temp == null) {
            System.out.println("Invalid sensor reading (null) skipped");
            return;
        }

        // Auto-unboxing happens here (Double → double)
        double value = temp;

        // Auto-boxing happens here (double → Double)
        dataList.add(value);

        System.out.println("Logged temperature: " + value);
    }

    public static void main(String[] args) {

        ArrayList<Double> temperatureData = new ArrayList<>();

        // Primitive double (auto-boxed)
        double temp1 = 25.5;
        logTemperature(temp1, temperatureData);

        // Wrapper Double
        Double temp2 = 30.2;
        logTemperature(temp2, temperatureData);

        // Null value (simulating sensor failure)
        Double temp3 = null;
        logTemperature(temp3, temperatureData);

        // Reading values (auto-unboxing)
        System.out.println("\nStored Temperatures:");
        for (Double t : temperatureData) {
            double val = t; // auto-unboxing
            System.out.println(val);
        }
    }
}