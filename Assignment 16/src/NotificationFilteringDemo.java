import java.util.*;
import java.util.function.Predicate;

// Alert Class
class Alert {
    String message;
    String type;   // e.g., "CRITICAL", "NORMAL", "REMINDER"

    public Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

// Main Class
public class NotificationFilteringDemo {

    public static void main(String[] args) {

        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert("Heart rate critical!", "CRITICAL"));
        alerts.add(new Alert("Medicine reminder", "REMINDER"));
        alerts.add(new Alert("Normal checkup due", "NORMAL"));
        alerts.add(new Alert("Blood pressure high!", "CRITICAL"));

        // 🔹 User Preference: Only CRITICAL alerts
        Predicate<Alert> criticalOnly = alert -> alert.type.equals("CRITICAL");

        System.out.println("Showing only CRITICAL alerts:");
        filterAlerts(alerts, criticalOnly);

        // 🔹 User Preference: Exclude REMINDER alerts
        Predicate<Alert> noReminders = alert -> !alert.type.equals("REMINDER");

        System.out.println("\nExcluding REMINDER alerts:");
        filterAlerts(alerts, noReminders);
    }

    // Filtering Method
    public static void filterAlerts(List<Alert> alerts, Predicate<Alert> condition) {
        for (Alert alert : alerts) {
            if (condition.test(alert)) {
                System.out.println(alert);
            }
        }
    }
}