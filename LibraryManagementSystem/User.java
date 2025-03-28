package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userId;
    private List<BookCopy> borrowedBooks;
    private String userName;

    public User(String userId,String userName) {
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
        this.userName = userName;
    }

    public void borrowBook(Book book){
        if(borrowedBooks.size()>=5)
        {
            System.out.println("Maximum of 5 books can only be issued");
            return;
        }
        for(BookCopy copy: book.getBookCopies()){
            if(copy.isAvailable()){
                borrowedBooks.add(copy);
                copy.setAvailable(false);
                return;
            }
        }
        System.out.println("No copy is available for this book");
    }


    public void returnBook(Book book) {
        for(BookCopy copy:borrowedBooks){
            if(book.getBookCopies().contains(copy)){
                copy.setAvailable(true);
                borrowedBooks.remove(copy);
                return;
            }
        }
        System.out.println("User does not have this book");
    }
}
