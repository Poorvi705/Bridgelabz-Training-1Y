import java.util.*;

public class SetToSortedListDemo {

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list); // sort ascending
        return list;
    }

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertToSortedList(set);

        System.out.println("Sorted List: " + sortedList);
    }
}