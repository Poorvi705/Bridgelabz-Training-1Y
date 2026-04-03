import java.util.ArrayList;

public class PerformanceTest {
    public static void main(String[] args) {

        int size = 1_000_000;

        // ----------- int[] -----------
        long startArray = System.nanoTime();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        long sumArray = 0;
        for (int i = 0; i < size; i++) {
            sumArray += arr[i];
        }

        long endArray = System.nanoTime();

        // ----------- ArrayList<Integer> -----------
        long startList = System.nanoTime();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i); // Autoboxing (int → Integer)
        }

        long sumList = 0;
        for (int i = 0; i < size; i++) {
            sumList += list.get(i); // Auto-unboxing (Integer → int)
        }

        long endList = System.nanoTime();

        // ----------- Results -----------
        System.out.println("Array Sum: " + sumArray);
        System.out.println("Array Time: " + (endArray - startArray) + " ns");

        System.out.println("List Sum: " + sumList);
        System.out.println("ArrayList Time: " + (endList - startList) + " ns");
    }
}