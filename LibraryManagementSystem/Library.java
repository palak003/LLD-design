package LibraryManagementSystem;


public class Library {

    public void addBook(Book book, String copyId){
        book.addCopy(copyId);
    }

    public void showBookCopies(Book book){
        System.out.println("This book has "+ book.getBookCopies().stream().filter(BookCopy::isAvailable).count()+ " available copies");
    }

    public void issueBook(User user, Book book){
        user.borrowBook(book);
    }

    public void returnBook(User user,Book book){
        user.returnBook(book);
    }
}
