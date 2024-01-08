import java.util.Scanner;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Reservation {
    String trainNumber;
    String trainName;
    String classType;
    String dateOfJourney;
    String from;
    String to;
    String pnrNumber;

    public Reservation(String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
        // Generate a random PNR number (for simplicity)
        this.pnrNumber = String.valueOf((int) (Math.random() * 100000));
    }
}

public class Task1{
    static User currentUser;
    static Reservation currentReservation;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeUser();
        login();

        while (true) {
            System.out.println("\nOnline Reservation System Menu:");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    System.out.println("Exiting Online Reservation System. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void initializeUser() {
        // Initialize user with some default values
        currentUser = new User("user123", "password123");
    }

    static void login() {
        System.out.println("Enter Username:");
        String username = scanner.next();

        System.out.println("Enter Password:");
        String password = scanner.next();

        if (username.equals(currentUser.username) && password.equals(currentUser.password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Exiting...");
            System.exit(0);
        }
    }

    static void makeReservation() {
        System.out.println("Enter Train Number:");
        String trainNumber = scanner.next();

        System.out.println("Enter Train Name:");
        String trainName = scanner.next();

        System.out.println("Enter Class Type:");
        String classType = scanner.next();

        System.out.println("Enter Date of Journey:");
        String dateOfJourney = scanner.next();

        System.out.println("Enter From (Place):");
        String from = scanner.next();

        System.out.println("Enter To (Destination):");
        String to = scanner.next();

        currentReservation = new Reservation(trainNumber, trainName, classType, dateOfJourney, from, to);

        System.out.println("Reservation successful! Your PNR number is: " + currentReservation.pnrNumber);
    }

    static void cancelReservation() {
        System.out.println("Enter PNR Number for Cancellation:");
        String pnrNumber = scanner.next();

        if (currentReservation != null && pnrNumber.equals(currentReservation.pnrNumber)) {
            System.out.println("Reservation found. Confirm cancellation? (Enter 'OK' to confirm)");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("OK")) {
                System.out.println("Reservation canceled successfully.");
                currentReservation = null;
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Invalid PNR Number or no active reservation found.");
        }
    }
}