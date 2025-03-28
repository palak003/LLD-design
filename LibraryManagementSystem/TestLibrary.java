package LibraryManagementSystem;

import java.util.UUID;

public class TestLibrary {

    public static void main(String[] args){

        Book book1=new Book(UUID.randomUUID().toString(),"Author1","book1");
        Book book2=new Book(UUID.randomUUID().toString(),"Author2","book2");

        Library library=new Library();
        library.addBook(book1,"1");
        library.addBook(book1,"2");
        library.addBook(book2,"1");
        library.addBook(book2,"2");

        library.showBookCopies(book1);
        library.showBookCopies(book2);

        User user1=new User("1","David");
        User user2=new User("2","John");

        library.issueBook(user1,book1);
        library.issueBook(user1,book1);
        library.issueBook(user2,book1);

        library.showBookCopies(book1);
        library.showBookCopies(book2);

        library.returnBook(user1,book1);

        library.showBookCopies(book1);
        library.showBookCopies(book2);


    }
}
