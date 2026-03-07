import java.io.*;

// Customer class marked as Serializable for backup
class Customer implements Serializable {

    private static final long serialVersionUID = 1L; // optional but recommended
    private String name;
    private int age;

    Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString() for display
    @Override
    public String toString() {
        return "Customer{name='" + name + "', age=" + age + "}";
    }
}

// Main class
public class DataSerializationBackup {

    public static void main(String[] args) {

        Customer customer = new Customer("Alice", 30);

        String filename = "customer_backup.ser";

        // Serialize the customer object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(customer);
            System.out.println("Customer data serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the customer object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Customer deserializedCustomer = (Customer) in.readObject();
            System.out.println("Deserialized Customer: " + deserializedCustomer);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}