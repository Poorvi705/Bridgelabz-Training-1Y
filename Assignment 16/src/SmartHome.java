// Functional Interface
@FunctionalInterface
interface LightAction {
    void execute();
}

// Smart Light System Class
class SmartLightSystem {

    public void triggerLight(LightAction action) {
        action.execute();
    }
}

// Main Class
public class SmartHome {

    public static void main(String[] args) {

        SmartLightSystem system = new SmartLightSystem();

        // Motion trigger
        system.triggerLight(() ->
                System.out.println("Motion detected: Turning ON bright white lights")
        );

        // Time-based trigger (night)
        system.triggerLight(() ->
                System.out.println("Night mode: Turning ON dim warm lights")
        );

        // Voice command trigger
        system.triggerLight(() ->
                System.out.println("Voice command: Activating PARTY mode lights")
        );
    }
}