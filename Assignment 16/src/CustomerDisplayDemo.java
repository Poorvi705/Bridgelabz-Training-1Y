import java.util.*;
import java.util.stream.*;

public class CustomerDisplayDemo {

    public static void main(String[] args) {

        List<String> customers = Arrays.asList(
                "rahul", "Amit", "neha", "Priya", "rohit"
        );

        System.out.println("Formatted Customer Names:");

        customers.stream()

                // 🔹 Convert to uppercase
                .map(String::toUpperCase)

                // 🔹 Sort alphabetically
                .sorted()

                // 🔹 Print
                .forEach(System.out::println);
    }
}