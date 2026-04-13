import java.util.*;

public class NthFromEndDemo {

    // Method to find Nth element from end
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {

        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                return null; // n is greater than list size
            }
            first.next();
        }

        // Move both pointers until first reaches end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(
                Arrays.asList("A", "B", "C", "D", "E")
        );

        int n = 2;

        String result = findNthFromEnd(list, n);

        System.out.println("Nth element from end: " + result);
    }
}