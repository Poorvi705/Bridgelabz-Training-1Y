import java.util.*;

public class RemoveDuplicatesDemo {

    // Method to remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> set = new LinkedHashSet<>(list); // maintains order
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicates(list);

        System.out.println("After removing duplicates: " + result);
    }
}