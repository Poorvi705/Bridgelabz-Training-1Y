import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

// Member Class
class Member {
    String name;
    LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " | Expiry: " + expiryDate;
    }
}

// Main Class
public class GymMembershipDemo {

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("Amit", LocalDate.now().plusDays(10)),
                new Member("Neha", LocalDate.now().plusDays(40)),
                new Member("Ravi", LocalDate.now().plusDays(25)),
                new Member("Priya", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        System.out.println("Members expiring within next 30 days:");

        members.stream()

                // 🔹 Filter condition
                .filter(m -> !m.expiryDate.isBefore(today) &&
                        !m.expiryDate.isAfter(next30Days))

                // 🔹 Print result
                .forEach(System.out::println);
    }
}