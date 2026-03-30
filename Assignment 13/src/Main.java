class BankAccount implements Runnable {

    private String userName;
    private String accountType;

    public BankAccount(String userName, String accountType) {
        this.userName = userName;
        this.accountType = accountType;
    }

    @Override
    public void run() {
        // Each user checks balance 3 times
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    userName + " (" + accountType + ") is checking balance | " +
                            "Priority: " + Thread.currentThread().getPriority()
            );

            try {
                Thread.sleep(2000); // 2 seconds delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Create Runnable objects
        BankAccount premiumUser = new BankAccount("Alice", "Premium");
        BankAccount regularUser = new BankAccount("Bob", "Regular");
        BankAccount basicUser = new BankAccount("Charlie", "Basic");

        // Create Threads
        Thread t1 = new Thread(premiumUser);
        Thread t2 = new Thread(regularUser);
        Thread t3 = new Thread(basicUser);

        // Set Priorities
        t1.setPriority(10); // Premium
        t2.setPriority(5);  // Regular
        t3.setPriority(1);  // Basic

        // Start Threads
        t1.start();
        t2.start();
        t3.start();
    }
}