public class CompareDemo {


    public static <T> boolean isEqual(T a, T b) {
        if (a == null || b == null) {
            return a == b;
        }
        return a.equals(b);
    }

    public static void main(String[] args) {

        System.out.println(isEqual(10, 10));


        System.out.println(isEqual("Hello", "Hello"));

        System.out.println(isEqual(10.5, 20.5));

        System.out.println(isEqual(null, null));
    }
}