import java.util.ArrayList;
import java.util.Collections;

public class EmployeeProcessing {
    public static void main(String[] args) {

        // Primitive int array (employee ages)
        int[] ages = {22, 35, 18, 40, 27, 50};

        // Convert int[] → ArrayList<Integer>
        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(age); // Autoboxing (int → Integer)
        }

        // Find youngest and oldest ages
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        // Output
        System.out.println("Employee Ages: " + ageList);
        System.out.println("Youngest Employee Age: " + youngest);
        System.out.println("Oldest Employee Age: " + oldest);
    }
}