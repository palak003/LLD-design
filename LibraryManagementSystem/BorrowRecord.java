package LibraryManagementSystem;

import java.time.Duration;
import java.time.LocalDateTime;

public class BorrowRecord {

    private User user;
    private BookCopy bookCopy;
    private LocalDateTime dateOfIssue;
    private LocalDateTime dateOfReturn;
    private double fine;

    public void setDateOfReturn(LocalDateTime dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }



    public BorrowRecord(User user, BookCopy bookCopy) {
        this.user = user;
        this.bookCopy = bookCopy;
        this.dateOfIssue = LocalDateTime.now();
        this.dateOfReturn = null;
        this.fine = 0;
    }

    public void calculateFine(){
        long extraDays=Duration.between(dateOfIssue,dateOfReturn).toDays();
        double fine= extraDays>7?(extraDays-7)*20:0;
        System.out.println(fine);
    }
}
