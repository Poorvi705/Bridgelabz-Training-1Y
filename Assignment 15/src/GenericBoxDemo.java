class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class GenericBoxDemo {
    public static void main(String[] args) {

        // Integer Box
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer value: " + intBox.get());

        // String Box
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        System.out.println("String value: " + strBox.get());

        // Double Box
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(99.99);
        System.out.println("Double value: " + doubleBox.get());
    }
}