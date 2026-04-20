import java.util.*;

public class EmailNotificationDemo {

    public static void main(String[] args) {

        List<String> emails = Arrays.asList(
                "amit@gmail.com",
                "neha@gmail.com",
                "ravi@gmail.com"
        );

        // 🔹 Using forEach with lambda
        emails.forEach(email -> sendEmailNotification(email));
    }

    // Method to simulate sending email
    public static void sendEmailNotification(String email) {
        System.out.println("Sending notification email to: " + email);
    }
}