import java.util.*;

class Ticket extends Thread {

    private int ticketId;
    private String type;
    private int priority;
    private int processingTime; // seconds

    private static long totalTime = 0;

    // For statistics
    private static Map<Integer, List<Long>> waitTimes = new HashMap<>();

    public Ticket(int ticketId, String type, int priority) {
        this.ticketId = ticketId;
        this.type = type;
        this.priority = priority;

        // Random processing time (1–5 seconds)
        this.processingTime = new Random().nextInt(5) + 1;

        waitTimes.putIfAbsent(priority, new ArrayList<>());
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();

        System.out.println(getName() + " STARTED Ticket " + ticketId +
                " | Type: " + type +
                " | Priority: " + priority +
                " | Queue Position: " + getPriority());

        try {
            Thread.sleep(processingTime * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long end = System.currentTimeMillis();
        long duration = (end - start) / 1000;

        synchronized (Ticket.class) {
            totalTime += duration;
            waitTimes.get(priority).add(duration);
        }

        System.out.println(getName() + " COMPLETED Ticket " + ticketId +
                " in " + duration + " sec");
    }

    public static void printStats() {

        System.out.println("\n--- STATISTICS ---");

        System.out.println("Total Processing Time: " + totalTime + " sec");

        for (int p : waitTimes.keySet()) {
            List<Long> times = waitTimes.get(p);

            long sum = 0;
            for (long t : times) sum += t;

            double avg = times.size() > 0 ? (double) sum / times.size() : 0;

            System.out.println("Priority " + p + " Avg Time: " + avg + " sec");
        }
    }
}

public class CustomerSupportSystem {
    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList<>();

        // Create 10 mixed tickets
        tickets.add(new Ticket(1, "Critical Bug", 10));
        tickets.add(new Ticket(2, "Feature Request", 4));
        tickets.add(new Ticket(3, "General Query", 2));
        tickets.add(new Ticket(4, "Feedback", 1));
        tickets.add(new Ticket(5, "Critical Bug", 10));
        tickets.add(new Ticket(6, "General Query", 2));
        tickets.add(new Ticket(7, "Feature Request", 4));
        tickets.add(new Ticket(8, "Feedback", 1));
        tickets.add(new Ticket(9, "Critical Bug", 10));
        tickets.add(new Ticket(10, "General Query", 2));

        // Sort tickets based on priority (descending)
        tickets.sort((a, b) -> b.getPriority() - a.getPriority());

        // Assign names and start threads
        int agentCount = 1;
        for (Ticket t : tickets) {
            t.setName("Agent-" + agentCount++);
            t.start();
        }

        // Wait for all to finish
        for (Ticket t : tickets) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        // Print statistics
        Ticket.printStats();

        System.out.println("\nAll tickets processed.");
    }
}