import Library.books.Books;
import Library.members.Member;
import Library.transactions.Transaction;

public class MainLibrary {

    public static void main(String[] args) {

        // Adding a new book
        Books books1 = new Books("Java Programming", "James Gosling");
        books1.displayBook();

        System.out.println();

        // Registering a new member
        Member member1 = new Member("Rahul", 101);
        member1.displayMember();

        System.out.println();

        // Issuing book to member
        Transaction transaction = new Transaction();
        transaction.issueBook(books1, member1);
    }
}