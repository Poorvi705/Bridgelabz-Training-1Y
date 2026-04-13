import java.util.*;

public class SymmetricDifferenceDemo {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Step 1: Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Step 2: Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Step 3: Symmetric Difference = Union - Intersection
        union.removeAll(intersection);

        System.out.println("Symmetric Difference: " + union);
    }
}