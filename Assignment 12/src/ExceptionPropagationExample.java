public class ExceptionPropagationExample {

    // Method 1: Generates exception
    public static void method1() {
        int result = 10 / 0; // ArithmeticException
    }

    // Method 2: Calls method1()
    public static void method2() {
        method1(); // Exception propagates from here
    }

    public static void main(String[] args) {

        try {
            method2(); // Call method2()

        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}