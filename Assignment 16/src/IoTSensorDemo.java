import java.util.*;
import java.util.stream.*;

public class IoTSensorDemo {

    public static void main(String[] args) {

        List<Double> readings = Arrays.asList(
                25.5, 30.2, 18.7, 35.0, 40.3, 22.1
        );

        double threshold = 30.0;

        System.out.println("Sensor readings above threshold:");

        readings.stream()

                // 🔹 Filter readings > threshold
                .filter(r -> r > threshold)

                // 🔹 Print using forEach
                .forEach(r -> System.out.println("Reading: " + r));
    }
}