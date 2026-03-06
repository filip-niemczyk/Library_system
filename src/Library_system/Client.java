package Library_system;

import java.util.ArrayList;

public class Client {
    private static int idCounter = 1;
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();


    public Client(String login, String password, String name, String surname) {
        this.id = idCounter++;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public boolean verifyLogin(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return String.format("Client [ID: %s] | %s %s (Login: %s", id, name, surname, login);
    }
}