package Library_system;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("The book was added to the system: " + book.getTitle());
    }

    public void showAllBooks() {
        System.out.println("\n---library collection---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
