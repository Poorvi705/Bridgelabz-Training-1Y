// Base class Contact
class Contact {

    protected String name;
    protected String phoneNumber;

    // Constructor
    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Display contact information
    void display() {
        System.out.println(String.format("Contact: %s, Phone: %s", name, phoneNumber));
    }
}

// Subclass BusinessContact
class BusinessContact extends Contact {

    private String companyName;

    BusinessContact(String name, String phoneNumber, String companyName) {
        super(name, phoneNumber);
        this.companyName = companyName;
    }

    @Override
    void display() {
        // Display name in uppercase with company
        System.out.println(String.format("Business Contact: %s, Phone: %s, Company: %s",
                name.toUpperCase(), phoneNumber, companyName));
    }
}

// Main class
public class MobilePhoneContactApp {

    public static void main(String[] args) {

        Contact c1 = new Contact("Alice", "9876543210");
        BusinessContact c2 = new BusinessContact("Bob", "9123456780", "TechCorp");

        c1.display();
        c2.display();
    }
}