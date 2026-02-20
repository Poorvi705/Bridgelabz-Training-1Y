// Superclass
class Notification {

    void send() {
        System.out.println("Sending a generic notification");
    }
}

// Subclass that DOES NOT override (no behavior change needed)
class EmailNotification extends Notification {
    // No override needed, inherited behavior is sufficient
}

// Subclass that DOES override (behavior needs modification)
class SMSNotification extends Notification {

    @Override
    void send() {
        System.out.println("Sending an SMS notification");
    }
}

// Main class
public class AvoidUnnecessaryOverridingDemo {
    public static void main(String[] args) {

        Notification n1 = new EmailNotification(); // uses superclass method
        Notification n2 = new SMSNotification();   // uses overridden method

        n1.send();
        n2.send();
    }
}