import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
}

class Library {
    private Map<Integer, Book> books = new HashMap<>();
    
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    
    public Book findBook(int bookId) {
        return books.get(bookId);
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    
    public void removeBook(int bookId) {
        books.remove(bookId);
    }
}

class UserModule {
    public static void userMenu(Library library) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nUser Menu");
            System.out.println("1. View all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    List<Book> books = library.getAllBooks();
                    System.out.println("\nAvailable Books:");
                    for (Book book : books) {
                        System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                    }
                    break;
                case 2:
                    System.out.print("\nEnter the book ID: ");
                    int bookId = scanner.nextInt();
                    Book foundBook = library.findBook(bookId);
                    if (foundBook != null) {
                        System.out.println("\nBook Found - Title: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor());
                    } else {
                        System.out.println("\nBook not found.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nInvalid choice. Please enter a valid option.");
            }
        }
    }
}

class AdminModule {
    public static void adminMenu(Library library) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("\nEnter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    System.out.println("\nBook added successfully.");
                    break;
                case 2:
                    System.out.print("\nEnter the book ID to remove: ");
                    int bookId = scanner.nextInt();
                    Book removedBook = library.findBook(bookId);
                    if (removedBook != null) {
                        library.removeBook(bookId);
                        System.out.println("\nBook removed successfully.");
                    } else {
                        System.out.println("\nBook not found.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nInvalid choice. Please enter a valid option.");
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Example books
        library.addBook(new Book(1, "MAMTA", "JAYSANKAR PRASHAD"));
        library.addBook(new Book(2, "KAMAYANI", "JAYSANKAR PRASHAD"));
        library.addBook(new Book(3, "KRISHNA GEETAWALI", "TULIDAS"));
        library.addBook(new Book(4, "RAMCHARITMANAS", "TULSIDAS"));

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. User Module");
            System.out.println("2. Admin Module");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    UserModule.userMenu(library);
                    break;
                case 2:
                    AdminModule.adminMenu(library);
                    break;
                case 3:
                    System.out.println("\nGoodbye!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please enter a valid option.");
            }
        }
    }
}
