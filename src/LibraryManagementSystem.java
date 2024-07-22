import java.util.ArrayList;
import java.util.Scanner;


class Book{
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Member{
    String name;

    Member(String name){
        this.name = name;
    }
}

public class LibraryManagementSystem{
    static ArrayList<Book>books = new ArrayList<>();
    static ArrayList<Member>members = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nLibraryManagementSystem");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. View Issued Books");
            System.out.println("7. Search Book");
            System.out.println("8. Remove Book");
            System.out.println("9. Remove Member");
            System.out.println("10. exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //Consume newline

            switch (choice){
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addMember(scanner);
                    break;
                case 3:
                    issueBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    viewAvailableBooks();
                    break;
                case 6:
                    viewIssuedBooks();
                    break;
                case 8:
                    removeBook(scanner);
                    break;
                case 9:
                    removeMember(scanner);
                    break;
                case 10:

                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again. ");
            }
        }
    }

    public static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully. ");
    }

    public static void addMember(Scanner scanner) {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        members.add(new Member(name));
        System.out.println("Member added successfully. ");
    }

    public static void issueBook(Scanner scanner){
        System.out.print("Enter book title to issue: ");
        String title = scanner.nextLine();
        for(Book book : books){
            if(book.title.equalsIgnoreCase(title)&&!book.isIssued){
                book.isIssued = true;
                System.out.println("Book issued successfully. ");
                return;
            }
        }
        System.out.println("Book not available or already issued. ");
    }
    public static void returnBook(Scanner scanner){
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for(Book book : books ){
            if(book.title.equalsIgnoreCase(title)&& book.isIssued){
                book.isIssued = false;
                System.out.println("Book returned successfully. ");
                return;
            }
        }
        System.out.println("Book not found or not issued. ");
    }
    public static void viewAvailableBooks(){
        System.out.println("\nAvailable Books: ");
        for(Book book : books){
            if(!book.isIssued){
                System.out.println("Title: " + book.title +",Author: " + book.author);
            }
        }
    }
    public static void viewIssuedBooks(){


        System.out.println("\nIssued Books:");
        for(Book book : books){
            if(book.isIssued){
                System.out.println("Title: " + book.title +",Author: " + book.author);
            }
        }
    }

    public static void searchBook(Scanner scanner){
        System.out.println("Enter book title or author to search: ");
        String query = scanner.nextLine().toLowerCase();
        System.out.println("\nSearch Results: ");
        for (Book book : books){
            if(book.title.toLowerCase().contains(query)|| book.author.toLowerCase().contains(query)){
                System.out.println("Title: " + book.title +",Author: " + book.author + (book.isIssued ?"(issued)":""));

            }
        }
    }
    public static void removeBook(Scanner scanner){
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        books.removeIf(book -> book.title.equalsIgnoreCase(title));
        System.out.println("Book remove successfully. ");

    }
    public static void removeMember(Scanner scanner){
        System.out.print("Enter member name to remove: ");
        String name = scanner.nextLine();
        members.removeIf(member -> member.name.equalsIgnoreCase(name));
        System.out.println("Member removed successfully. ");
    }
}

