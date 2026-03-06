package Library_system;

public class Book {
    //1. Atrybuty
    private String title;
    private String author;
    private String isbn;
    private Client borrowedBy;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public void setBorrowedBy(Client client) {
        this.borrowedBy = client;
    }

    public Client getBorrowedBy() {
        return borrowedBy;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "[Available]" : "[Borrowed]";
        return String.format("%s - %s (ISBN: %s) %s", author, title, isbn, status);
    }
}
