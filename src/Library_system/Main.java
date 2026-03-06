package Library_system;

import java.util.Scanner;

public class Main {
    private static Client loggedInUser = null;

    public static void main(String[] args) {
        Library myLibrary = new Library();
        ClientsList users = new ClientsList();
        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book("In Desert and Wilderness", "Henryk Sienkiewicz", "123-456-789");
        Book book2 = new Book("The Hobbit", "J.R.R.Tolkien", "234-567-890");
        Book book3 = new Book("Harry Potter and the Sorcerer's Stone", "J.K.Rowling", "345-678-901");
        Book book4 = new Book("Harry Potter and the Chamber of Secrets", "J.K.Rowling", "456-789-012");

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);

        users.addClient(new Client("admin", "admin1", "Adam", "Kowalski"));

        while (true) {
            if (loggedInUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                    continue;
                }


                if (choice == 1) {
                    while (true) {
                        System.out.println("Login: ");
                        String newLog = scanner.nextLine();

                        if (users.isLoginTaken(newLog)) {
                            System.out.println("This login is already taken");
                            continue;
                        }

                        System.out.println("Password: ");
                        String newPass = scanner.nextLine();

                        System.out.println("Confirm your password: ");
                        String conPass = scanner.nextLine();

                        if (newPass.equals(conPass)) {
                            System.out.println("Name: ");
                            String name = scanner.nextLine();

                            System.out.println("Surname: ");
                            String surname = scanner.nextLine();

                            users.addClient(new Client(newLog, newPass, name, surname));
                            break;
                        } else {
                            System.out.println("The passwords aren't the same");
                        }
                    }
                } else if (choice == 2) {
                    System.out.print("Login: ");
                    String log = scanner.nextLine();

                    System.out.print("Password: ");
                    String pass = scanner.nextLine();

                    loggedInUser = users.login(log, pass);

                    if (loggedInUser == null) {
                        System.out.println("Wrong data");
                    }
                } else if (choice == 3) {
                    break;
                } else System.out.println("You choice doesn't exist");
            } else {
                System.out.println("Welcome " + loggedInUser.getName());

                System.out.println("---MENU---");
                System.out.println("1. Show Books");
                System.out.println("2. Borrow a book ");
                System.out.println("3. return the book");
                System.out.println("4. Donate a book to the library");
                System.out.println("5. Show your books");
                System.out.println("6. Logout");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                    continue;
                }

                Book selectedBook;

                switch (choice) {
                    case 1:
                        myLibrary.showAllBooks();
                        break;
                    case 2:
                        System.out.print("Enter ISBN: ");
                        selectedBook = myLibrary.searchBook(scanner.nextLine());

                        if (selectedBook != null && selectedBook.isAvailable()) {
                            selectedBook.setAvailable(false);
                            selectedBook.setBorrowedBy(loggedInUser);

                            loggedInUser.addBorrowedBook(selectedBook);
                            System.out.println("Borrowed");
                        } else {
                            System.out.println("Not available");
                        }
                        break;
                    case 3:
                        System.out.print("Enter ISBN: ");
                        selectedBook = myLibrary.searchBook(scanner.nextLine());

                        if (selectedBook != null && !selectedBook.isAvailable() && selectedBook.getBorrowedBy() == loggedInUser) {
                            selectedBook.setAvailable(true);
                            selectedBook.setBorrowedBy(null);

                            loggedInUser.removeBorrowedBook(selectedBook);
                            System.out.println("Returned");
                        } else {
                            System.out.println("You can't return this book");
                        }
                        break;
                    case 4:
                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        myLibrary.addBook(new Book(title, author, isbn));
                        break;
                    case 5:
                        System.out.println("Your books:");
                        if (loggedInUser.getBorrowedBooks().isEmpty()) {
                            System.out.println("You have no borrowed books.");
                        } else {
                            for (Book b : loggedInUser.getBorrowedBooks()) {
                                System.out.println("- " + b.getTitle() + " (ISBN: " + b.getIsbn() + ")");
                            }
                        }
                        break;

                    case 6:
                        loggedInUser = null;
                        break;
                    default:
                        System.out.println("You choice doesn't exist");
                        break;
                }
            }
        }
    }
}