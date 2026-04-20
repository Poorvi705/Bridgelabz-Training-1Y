import java.util.*;

public class EmployeeUppercaseDemo {

    public static void main(String[] args) {

        List<String> employees = Arrays.asList(
                "Amit", "Neha", "Ravi", "Priya"
        );

        System.out.println("Uppercase Names:");

        // 🔹 Using method reference
        employees.stream()
                .map(String::toUpperCase)   // method reference
                .forEach(System.out::println);
    }
}