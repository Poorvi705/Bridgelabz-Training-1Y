import java.util.*;
import java.util.stream.*;

// Invoice Class
class Invoice {
    int transactionId;

    public Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice for Transaction ID: " + transactionId;
    }
}

// Main Class
public class InvoiceDemo {

    public static void main(String[] args) {

        List<Integer> transactionIds = Arrays.asList(1001, 1002, 1003, 1004);

        // 🔹 Using Constructor Reference
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)   // constructor reference
                .collect(Collectors.toList());

        // Print invoices
        invoices.forEach(System.out::println);
    }
}