import java.util.ArrayList;
import java.util.Collections;

public class EmployeeData {
    public static void main(String[] args) {

        // Primitive int array (employee ages)
        int[] ages = {25, 32, 19, 45, 28, 50};

        // Convert int[] → ArrayList<Integer>
        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(age); // Autoboxing (int → Integer)
        }

        // Find youngest and oldest using Collections
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        // Output
        System.out.println("Employee Ages: " + ageList);
        System.out.println("Youngest Age: " + youngest);
        System.out.println("Oldest Age: " + oldest);
    }
}