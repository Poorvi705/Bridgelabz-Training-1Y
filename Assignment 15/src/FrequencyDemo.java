import java.util.*;

public class FrequencyDemo {

    // Method to count frequency
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFrequency(fruits);

        System.out.println(result);
    }
}