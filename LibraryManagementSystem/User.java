package LibraryManagementSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userId;
    private List<BookCopy> borrowedBooks;
    private String userName;
    private Map<BookCopy,BorrowRecord> borrowRecords;

    public User(String userId,String userName) {
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
        this.userName = userName;
        this.borrowRecords=new HashMap<>();
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
                borrowRecords.put(copy,new BorrowRecord(this,copy));
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
                BorrowRecord borrowRecord=borrowRecords.get(copy);
                borrowRecord.setDateOfReturn(LocalDateTime.of(2025,4,8,5,6)); //for example
                borrowRecord.calculateFine();
                borrowedBooks.remove(copy);
                borrowRecords.remove(copy);
                return;
            }
        }
        System.out.println("User does not have this book");
    }
}
