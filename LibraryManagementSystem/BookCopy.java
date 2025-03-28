package LibraryManagementSystem;

public class BookCopy {

    private String copyId;
    private boolean isAvailable;

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public BookCopy(String copyId) {
        this.copyId = copyId;
        this.isAvailable = true;
    }


}
