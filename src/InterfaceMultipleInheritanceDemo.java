// First interface
interface Printable {
    void print();
}

// Second interface
interface Scannable {
    void scan();
}

// Class implementing multiple interfaces
class MultiFunctionPrinter implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("Printing document");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document");
    }
}

// Main class
public class InterfaceMultipleInheritanceDemo {
    public static void main(String[] args) {

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print();
        mfp.scan();
    }
}