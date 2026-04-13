class Pair<T, U> {
    private T first;
    private U second;

    // Constructor
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

public class PairDemo {
    public static void main(String[] args) {

        Pair<String, Integer> student = new Pair<>("Amol", 20);

        System.out.println("Name: " + student.getFirst());
        System.out.println("Age: " + student.getSecond());

        Pair<Integer, Double> data = new Pair<>(10, 99.5);
        System.out.println("Number: " + data.getFirst());
        System.out.println("Value: " + data.getSecond());
    }
}