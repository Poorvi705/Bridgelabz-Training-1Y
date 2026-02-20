// Base class (widely used)
class Logger {

    void log(String message) {
        System.out.println("LOG: " + message);
    }
}

// Subclass depending on base class behavior
class FileLogger extends Logger {

    @Override
    void log(String message) {
        // Relies on superclass behavior
        System.out.println("FileLogger -> " + message);
    }
}

// Another subclass
class DatabaseLogger extends Logger {

    @Override
    void log(String message) {
        System.out.println("DatabaseLogger -> " + message);
    }
}

// Main class
public class FragileBaseClassDemo {
    public static void main(String[] args) {

        Logger l1 = new FileLogger();
        Logger l2 = new DatabaseLogger();

        l1.log("Saving to file");
        l2.log("Saving to database");
    }
}