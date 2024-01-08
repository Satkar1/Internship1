import java.util.Scanner;

public class Task5 {
    static Scanner scanner = new Scanner(System.in);
    static Book[] books = new Book[100];
    static Member[] members = new Member[100];
    static int bookCount = 0;
    static int memberCount = 0;

    static class Book {
        String title;
        String author;
        boolean isAvailable;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }
    }

    static class Member {
        String name;
        String email;

        Member(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Admin Module");
            System.out.println("2. User Module");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminModule();
                    break;
                case 2:
                    userModule();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    static void adminModule() {
        System.out.println("Admin Module");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Add Member");
        System.out.println("4. Remove Member");
        System.out.println("5. Exit Admin Module");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                addMember();
                break;
            case 4:
                removeMember();
                break;
            case 5:
                System.out.println("Exiting Admin Module.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    static void userModule() {
        System.out.println("User Module");
        System.out.println("1. Browse Books");
        System.out.println("2. Search for a Book");
        System.out.println("3. Issue a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Exit User Module");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                browseBooks();
                break;
            case 2:
                searchBook();
                break;
            case 3:
                issueBook();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                System.out.println("Exiting User Module.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter author name: ");
        String author = scanner.next();
        books[bookCount++] = new Book(title, author);
        System.out.println("Book added successfully.");
    }

    static void removeBook() {
        System.out.print("Enter the title of the book to remove: ");
        String title = scanner.next();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equals(title)) {
                // Shift books to remove the empty space
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.next();
        System.out.print("Enter member email: ");
        String email = scanner.next();
        members[memberCount++] = new Member(name, email);
        System.out.println("Member added successfully.");
    }

    static void removeMember() {
        System.out.print("Enter the name of the member to remove: ");
        String name = scanner.next();
        for (int i = 0; i < memberCount; i++) {
            if (members[i].name.equals(name)) {
                // Shift members to remove the empty space
                for (int j = i; j < memberCount - 1; j++) {
                    members[j] = members[j + 1];
                }
                memberCount--;
                System.out.println("Member removed successfully.");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    static void browseBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].title + " by " + books[i].author);
        }
    }

    static void searchBook() {
        System.out.print("Enter the title of the book to search: ");
        String title = scanner.next();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equals(title)) {
                System.out.println("Book found: " + books[i].title + " by " + books[i].author);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void issueBook() {
        System.out.print("Enter the title of the book to issue: ");
        String title = scanner.next();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equals(title)) {
                if (books[i].isAvailable) {
                    books[i].isAvailable = false;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is not available for issuance.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.next();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equals(title)) {
                if (!books[i].isAvailable) {
                    books[i].isAvailable = true;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}