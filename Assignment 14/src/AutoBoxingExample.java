import java.util.ArrayList;

public class AutoBoxingExample {
    public static void main(String[] args) {

        // Creating ArrayList of Integer
        ArrayList<Integer> list = new ArrayList<>();

        // Adding elements (Auto-boxing: int → Integer)
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(5);

        int sum = 0;

        // Calculating sum (Auto-unboxing: Integer → int)
        for (Integer num : list) {
            sum += num;
        }

        // Printing result
        System.out.println("Sum of numbers = " + sum);
    }
}