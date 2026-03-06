import Library_system.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Book book1 = new Book("In Desert and Wilderness", "Henryk Sienkiewicz", "123-456-789");
        Book book2 = new Book("The Hobbit", "J.R.R.Tolkien", "234-567-890");
        Book book3 = new Book("Harry Potter and the Sorcerer's Stone", "J.K.Rowling", "345-678-901");
        Book book4 = new Book("Harry Potter and the Chamber of Secrets", "J.K.Rowling", "456-789-012");

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);

        myLibrary.showAllBooks();

        System.out.print("Enter the ISBN of the book you are looking for: ");
        Scanner scanner = new Scanner(System.in);
        String inputIsbn = scanner.nextLine();

        Book foundBook = myLibrary.searchBook(inputIsbn);

        if(foundBook != null){
            if(foundBook.isAvailable()){
                foundBook.setAvailable(false);
                System.out.println("You managed to borrow a book: " + foundBook.getTitle());
            } else {
                System.out.println("The book is already on loan");
            }
        } else {
            System.out.println("Such a book doesn't exist");
        }

        System.out.println("\n");

        Clients_list clientsList = new Clients_list();

        Client client1 = new Client("1", "Alex", "Bell");
        Client client2 = new Client("2", "Christopher", "King");
        Client client3 = new Client("3", "Alan", "Hull");
        Client client4 = new Client("4", "Damian", "Paige");

        clientsList.addClient(client1);
        clientsList.addClient(client2);
        clientsList.addClient(client3);
        clientsList.addClient(client4);

        clientsList.showAllClients();

        System.out.print("Podaj Id klienta: ");
        String inputId = scanner.nextLine();
        scanner.close();

        Client foundClient = clientsList.searchClient(inputId);

        System.out.println("Znaleziony klient: " + foundClient.getName() + " " + foundClient.getSurname());
    }
}