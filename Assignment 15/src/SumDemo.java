import java.util.*;

public class SumDemo {


    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;

        for (Number num : list) {
            sum += num.doubleValue(); // convert to double
        }

        return sum;
    }

    public static void main(String[] args) {


        List<Integer> intList = Arrays.asList(10, 20, 30);
        System.out.println("Sum of Integers: " + sumNumbers(intList));


        List<Double> doubleList = Arrays.asList(5.5, 2.2, 3.3);
        System.out.println("Sum of Doubles: " + sumNumbers(doubleList));
    }
}