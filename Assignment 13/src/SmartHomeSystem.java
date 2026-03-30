import java.time.LocalTime;

class SmartDevice implements Runnable {

    private String deviceName;
    private int interval; // in seconds

    public SmartDevice(String deviceName, int interval) {
        this.deviceName = deviceName;
        this.interval = interval;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "[" + LocalTime.now() + "] " +
                            deviceName + " is running | Cycle: " + i +
                            " | Priority: " + Thread.currentThread().getPriority()
            );

            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(deviceName + " finished execution.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {

        // Create devices
        SmartDevice tempSensor = new SmartDevice("Temperature Sensor", 5);
        SmartDevice securityCam = new SmartDevice("Security Camera", 3);
        SmartDevice lightControl = new SmartDevice("Light Controller", 4);
        SmartDevice doorMonitor = new SmartDevice("Door Lock Monitor", 6);

        // Create threads
        Thread t1 = new Thread(securityCam);
        Thread t2 = new Thread(tempSensor);
        Thread t3 = new Thread(lightControl);
        Thread t4 = new Thread(doorMonitor);

        // Set priorities
        t1.setPriority(10); // Security
        t2.setPriority(7);  // Temperature
        t3.setPriority(5);  // Light
        t4.setPriority(5);  // Door

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("All devices completed. System shutting down.");
    }
}