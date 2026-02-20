// Interface for reserving items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {

    // Encapsulation: private fields
    private int itemId;
    private String title;
    private String author;

    // Sensitive borrower data (restricted)
    private String borrowerName;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        isAvailable = available;
    }

    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Book class
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrowerName(borrowerName);
            setAvailable(false);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrowerName(borrowerName);
            setAvailable(false);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrowerName(borrowerName);
            setAvailable(false);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class
public class LibraryApp {

    // Polymorphism demonstration
    public static void processLibraryItems(LibraryItem[] items) {

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
            }

            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {

        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book(101, "Java Programming", "James Gosling");
        items[1] = new Magazine(102, "Tech Today", "Editorial Team");
        items[2] = new DVD(103, "Inception", "Christopher Nolan");

        processLibraryItems(items);

        // Reserving items
        ((Reservable) items[0]).reserveItem("Poorvi");
        ((Reservable) items[2]).reserveItem("Amit");
    }
}