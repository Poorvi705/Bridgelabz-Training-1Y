// Parent class
class Book {

    protected int bookId;
    protected String title;
    protected double price;

    // Static variable shared by all books
    static String libraryName = "City Library";

    // Constructor
    Book(int bookId, String title, double price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }

    // Method to calculate fine (default, can be overridden)
    double calculateFine(int daysLate) {
        System.out.println("Generic book fine calculation.");
        return 0.0;
    }

    @Override
    public String toString() {
        return "Book{ID=" + bookId + ", Title='" + title + "', Price=₹" + price + "}";
    }
}

// TextBook class
class TextBook extends Book {

    TextBook(int bookId, String title, double price) {
        super(bookId, title, price);
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 2.0; // ₹2 per day
    }
}

// Magazine class
class Magazine extends Book {

    Magazine(int bookId, String title, double price) {
        super(bookId, title, price);
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 5.0; // ₹5 per day
    }
}

// Main class
public class SmartLibrarySystem {

    public static void main(String[] args) {

        // Polymorphic references
        Book book1 = new TextBook(101, "Mathematics", 500.0);
        Book book2 = new Magazine(201, "Science Monthly", 150.0);

        System.out.println("Library: " + Book.libraryName + "\n");

        System.out.println(book1);
        System.out.println("Fine for 3 late days: ₹" + book1.calculateFine(3) + "\n");

        System.out.println(book2);
        System.out.println("Fine for 3 late days: ₹" + book2.calculateFine(3));
    }
}