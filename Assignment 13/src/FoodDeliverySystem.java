class Order implements Runnable {

    private int orderId;
    private String restaurant;
    private int deliveryTime; // in seconds

    public Order(int orderId, String restaurant, int deliveryTime) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        String agent = Thread.currentThread().getName();

        try {
            System.out.println(agent + " picked up Order " + orderId +
                    " from " + restaurant);

            Thread.sleep(1000);

            System.out.println(agent + " Order " + orderId +
                    " is In Transit...");

            Thread.sleep(deliveryTime * 1000);

            System.out.println(agent + " delivered Order " + orderId);

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;

        System.out.println("Order " + orderId +
                " completed in " + totalTime + " seconds\n");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        // Create Orders
        Order o1 = new Order(101, "Pizza Hut", 3);
        Order o2 = new Order(102, "KFC", 5);
        Order o3 = new Order(103, "Dominos", 2);
        Order o4 = new Order(104, "McDonalds", 4);
        Order o5 = new Order(105, "Burger King", 6);

        // Create Threads (Delivery Agents)
        Thread t1 = new Thread(o1, "Agent-1 (Express)");
        Thread t2 = new Thread(o2, "Agent-2 (Standard)");
        Thread t3 = new Thread(o3, "Agent-3 (Express)");
        Thread t4 = new Thread(o4, "Agent-4 (Economy)");
        Thread t5 = new Thread(o5, "Agent-5 (Standard)");

        // Set Priorities
        t1.setPriority(10); // Express
        t3.setPriority(10); // Express

        t2.setPriority(5);  // Standard
        t5.setPriority(5);  // Standard

        t4.setPriority(3);  // Economy

        // Start Threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}