import java.util.*;

public class RotateListDemo {

    // Method to rotate list to left by k positions
    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();

        // Handle cases where k > n
        k = k % n;

        // Store first k elements
        List<T> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(list.get(i));
        }

        // Shift remaining elements
        for (int i = k; i < n; i++) {
            list.set(i - k, list.get(i));
        }

        // Add stored elements at the end
        for (int i = 0; i < temp.size(); i++) {
            list.set(n - k + i, temp.get(i));
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        rotateList(list, 2);

        System.out.println("Rotated List: " + list);
    }
}