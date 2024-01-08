import java.util.Scanner;

class User {
    String username;
    String password;
    String profile;

    public User(String username, String password, String profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }
}

class Question {
    String question;
    String[] options;
    int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class Task4{
    static User currentUser;
    static Question[] mcqQuestions = {
            new Question("What is the capital of France?", new String[]{"A) London", "B) Paris", "C) Berlin"}, 1),
            new Question("Which programming language is known for its portability?", new String[]{"A) Java", "B) Python", "C) C++"}, 0),
            
    };

    public static void main(String[] args) {
        initializeUser();
        login();
        mainMenu();
    }

    static void initializeUser() {
        // Initialize user with some default values
        currentUser = new User("user123", "password123", "Student");
    }

    static void login() {
        Scanner scanner = new Scanner(System.in);

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

    static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Update Profile and Password");
            System.out.println("2. Take MCQ Exam");
            System.out.println("3. Logout");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    updateProfileAndPassword();
                    break;
                case 2:
                    takeMCQExam();
                    break;
                case 3:
                    System.out.println("Logging out. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void updateProfileAndPassword() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUpdate Profile and Password:");
        System.out.println("1. Update Profile");
        System.out.println("2. Update Password");

        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter new profile:");
                String newProfile = scanner.next();
                currentUser.profile = newProfile;
                System.out.println("Profile updated successfully.");
                break;
            case 2:
                System.out.println("Enter new password:");
                String newPassword = scanner.next();
                currentUser.password = newPassword;
                System.out.println("Password updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    static void takeMCQExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMCQ Exam:");

        for (Question question : mcqQuestions) {
            System.out.println(question.question);
            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.println("Enter your answer (A, B, or C):");
            String userAnswer = scanner.next().toUpperCase();

            if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C")) {
                int selectedOption = userAnswer.equals("A") ? 0 : userAnswer.equals("B") ? 1 : 2;

                if (selectedOption == question.correctOption) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. Correct answer: " + question.options[question.correctOption]);
                }
            } else {
                System.out.println("Invalid choice. Skipping to the next question.");
            }
        }

        System.out.println("MCQ Exam completed.");
    }
}