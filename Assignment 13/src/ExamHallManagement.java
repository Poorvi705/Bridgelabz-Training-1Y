class ExamTask implements Runnable {

    private String taskName;
    private int startDelay;   // when task starts (seconds)
    private int workTime;     // how long task runs (seconds)

    public ExamTask(String taskName, int startDelay, int workTime) {
        this.taskName = taskName;
        this.startDelay = startDelay;
        this.workTime = workTime;
    }

    @Override
    public void run() {

        try {
            // Delay before starting task
            Thread.sleep(startDelay * 1000);

            System.out.println(taskName + " STARTED | Thread: "
                    + Thread.currentThread().getName());

            // Simulate work
            for (int i = 1; i <= workTime; i++) {
                System.out.println(taskName + " in progress... (" + i + " sec)");
                Thread.sleep(1000);
            }

            System.out.println(taskName + " COMPLETED");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ExamHallManagement {
    public static void main(String[] args) {

        // Create tasks
        ExamTask entry = new ExamTask("Student Entry Monitoring", 0, 5);
        ExamTask questionPaper = new ExamTask("Question Paper Distribution", 5, 3);
        ExamTask attendance = new ExamTask("Attendance Marking", 10, 3);
        ExamTask collection = new ExamTask("Answer Sheet Collection", 15, 4);

        // Create threads
        Thread t1 = new Thread(entry, "Entry-Thread");
        Thread t2 = new Thread(questionPaper, "QuestionPaper-Thread");
        Thread t3 = new Thread(attendance, "Attendance-Thread");
        Thread t4 = new Thread(collection, "Collection-Thread");

        // Set priorities
        t2.setPriority(10); // Question paper
        t3.setPriority(8);  // Attendance
        t4.setPriority(7);  // Collection
        t1.setPriority(5);  // Entry

        // Show initial states
        System.out.println("Initial States:");
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());
        System.out.println(t3.getName() + ": " + t3.getState());
        System.out.println(t4.getName() + ": " + t4.getState());

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Show states after starting
        System.out.println("\nAfter Starting:");
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());
        System.out.println(t3.getName() + ": " + t3.getState());
        System.out.println(t4.getName() + ": " + t4.getState());

        // Wait for all threads
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Final states
        System.out.println("\nFinal States:");
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());
        System.out.println(t3.getName() + ": " + t3.getState());
        System.out.println(t4.getName() + ": " + t4.getState());

        System.out.println("\nAll exam activities completed.");
    }
}