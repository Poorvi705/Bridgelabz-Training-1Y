import java.util.*;

public class EventWelcomeDemo {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Amit", "Neha", "Ravi", "Priya"
        );

        System.out.println("Welcome Messages:");

        // 🔹 forEach with lambda
        attendees.forEach(name ->
                System.out.println("Welcome " + name + "! Enjoy the event 🎉")
        );
    }
}