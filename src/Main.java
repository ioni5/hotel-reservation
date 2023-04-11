import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public void start() {
        int option;
        do {
            System.out.println("Welcome to the Hotel Reservation Application");

            System.out.println("-------------------------------------------");
            System.out.println("1: Create an account");
            System.out.println("2: Exit");
            System.out.println("-------------------------------------------");
            System.out.println("Please select a number for the menu option");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Email format: name@domain.com");
                    String email = sc.next();
                    System.out.println("First Name");
                    String firstName = sc.next();
                    System.out.println("Last Name");
                    String lastName = sc.next();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (option != 2);
    }

    public static void main(String[] args) {
        new Main().start();
    }
}