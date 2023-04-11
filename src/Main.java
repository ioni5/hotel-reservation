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
                    String email = this.getValidEmail();
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

    private String getValidEmail() {
        String regex = "^(.)+@(.)+\\.com$";
        Pattern pattern = Pattern.compile(regex);
        boolean error = false;
        String email;
        do {
            System.out.println("Enter Email format: name@domain.com");
            email = sc.next();
            error = !pattern.matcher(email).matches();
            if (error) {
                System.out.println("Error: Invalid Email format");
            }
        } while (error);
        return email;
    }

    public static void main(String[] args) {
        new Main().start();
    }
}