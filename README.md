# 📚 Library Management System

A robust, console-based **Library Management System** written in Java. This application simulates real-world interactions between a library's collection and its clients, focusing on clean code and Object-Oriented Programming (OOP) principles.

## 🚀 Features

### For Users:
* **User Authentication**: Register a new account or log in to an existing one.
* **Browse Collection**: View all books available in the library with their current status (Available/Borrowed).
* **Borrowing System**: Borrow books using their unique ISBN. The system automatically assigns the book to your profile.
* **Return System**: Return borrowed books to make them available for others.
* **Personal Bookshelf**: A dedicated "My Books" section to track all items currently borrowed by the user.
* **Book Donations**: Contribute to the library by adding new books (Title, Author, ISBN) to the system during runtime.

### Technical Features:
* **Input Validation**: Implements `try-catch` blocks to handle `NumberFormatException`, ensuring the app doesn't crash on invalid menu inputs.
* **Data Consistency**: Prevents users from returning books they didn't borrow or borrowing already taken items.
* **OOP Architecture**: Utilizes Encapsulation, Association (linking Books to Clients), and custom `toString()` overrides.

## 🛠️ Technologies Used
* **Language**: Java (compatible with Java 17+)
* **Tooling**: Scanner API for user input, ArrayList for dynamic data storage.

## 📁 Project Structure

* `Main.java` - The core engine handling the UI and application logic.
* `Library.java` - Manages the collection of books.
* `Book.java` - Defines the book entity and its state.
* `Client.java` - Manages user data and their personal borrowed list.
* `ClientsList.java` - Handles user registration and authentication.

## 💻 How to Run

1.  **Clone the repository**:
    ```bash
    git clone [https://github.com/YOUR_USERNAME/Library_system.git](https://github.com/YOUR_USERNAME/Library_system.git)
    ```
2.  **Navigate to the source folder**:
    ```bash
    cd Library_system/src
    ```
3.  **Compile the project**:
    ```bash
    javac Library_system/*.java
    ```
4.  **Run the application**:
    ```bash
    java Library_system.Main
    ```

## 📝 Future Improvements
* [ ] Integration with a SQL database for persistent storage.

---
Created as part of a Java programming exercise.
