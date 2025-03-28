package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String isbn;
    private String authorName;
    private String title;
    private List<BookCopy> bookCopies;

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public Book(String isbn, String authorName, String title) {
        this.isbn = isbn;
        this.authorName = authorName;
        this.title = title;
        this.bookCopies = new ArrayList<>();
    }

    public void addCopy(String copyId){
        BookCopy bookCopy=new BookCopy(copyId);
        bookCopies.add(bookCopy);
    }
}
