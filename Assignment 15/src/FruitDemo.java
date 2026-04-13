
class Fruit {
    String name;

    Fruit(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}


class Apple extends Fruit {
    Apple() {
        super("Apple");
    }
}

class Mango extends Fruit {
    Mango() {
        super("Mango");
    }
}


class FruitBox<T extends Fruit> {

    private T fruit;

    public void add(T fruit) {
        this.fruit = fruit;
    }

    public void display() {
        fruit.display();
    }
}


class Car {
    String model = "Tesla";
}

public class FruitDemo {
    public static void main(String[] args) {


        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.display();


        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.add(new Mango());
        mangoBox.display();


    }
}