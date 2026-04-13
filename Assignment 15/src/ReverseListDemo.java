import java.util.*;

public class ReverseListDemo {

    // Method to reverse list manually
    public static <T> void reverseList(List<T> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            // Swap elements
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        // ArrayList Example
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // LinkedList Example
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}