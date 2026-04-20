import java.util.*;
import java.time.LocalDateTime;

public class TransactionLoggerDemo {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001", "TXN1002", "TXN1003"
        );

        // 🔹 Logging each transaction with timestamp
        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() +
                        " - Transaction: " + id)
        );
    }
}