package Library.transactions;

import Library.books.BookS;
import Library.members.Member;

public class Transaction {

    public void issueBook(Book book, Member member) {
        System.out.println(member.name + " issued the book: " + book.title);
    }
}