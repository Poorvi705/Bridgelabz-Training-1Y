import java.util.*;

public class CopyListDemo {


    public static void copyList(List<? super Number> dest, List<? extends Number> src) {

        for (Number num : src) {
            dest.add(num); // allowed
        }
    }

    public static void main(String[] args) {

        List<Integer> srcList = Arrays.asList(10, 20, 30);

        List<Number> destList = new ArrayList<>();

        copyList(destList, srcList);

        System.out.println("Copied List: " + destList);


        List<Object> objList = new ArrayList<>();
        copyList(objList, srcList);
        System.out.println("Copied to Object List: " + objList);
    }
}