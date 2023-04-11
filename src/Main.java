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
            System.out.println("2: Admin");
            System.out.println("3: Exit");
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
                    this.adminMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (option != 3);
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

    private void adminMenu() {
        int option;
        do {
            System.out.println("Admin Menu");
            System.out.println("------------------------------");
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. Add a Room");
            System.out.println("4. Back to Main Menu");
            System.out.println("------------------------------");
            System.out.println("Please select a number for the menu option");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Customers:");
                    System.out.println("------------------------------");
                    System.out.println("First Name: Ana Last Name: García Email: ana.garcia23@example.com");
                    System.out.println("First Name: Javier Last Name: Rodríguez Email: javier.rodriguez89@example.com");
                    System.out.println("First Name: Laura Last Name: Sánchez Email: laura.sanchez67@example.com");
                    System.out.println("First Name: Pedro Last Name: Martínez Email: pedro.martinez45@example.com");
                    System.out.println("First Name: Marta Last Name: González Email: marta.gonzalez12@example.com");
                    System.out.println("------------------------------");
                    break;
                case 2:
                    System.out.println("Rooms:");
                    System.out.println("------------------------------");
                    System.out.println("Room Number: 100 Single bed Room Price: $135.0");
                    System.out.println("Room Number: 105 Double bed Room Price: $215.0");
                    System.out.println("Room Number: 110 Single bed Room Price: $135.0");
                    System.out.println("------------------------------");
                    break;
                case 3:
                    this.addRoom();
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }

    private void addRoom() {
        do {
            System.out.println("Enter room number");
            int roomNumber = sc.nextInt();
            System.out.println("Enter price per night");
            int roomPrice = sc.nextInt();
            System.out.println("Enter room type: 1 for single bed, 2 for double bed");
            int roomType = sc.nextInt();
        } while (this.getYesOrNot());
    }

    private boolean getYesOrNot() {
        String yesOrNot;
        boolean error = false;
        System.out.println("Would you like to add another room y/n");
        do {
            yesOrNot = sc.next();
            error = !yesOrNot.equalsIgnoreCase("y") && !yesOrNot.equalsIgnoreCase("n");
            if (error) {
                System.out.println("Please enter Y (Yes) or N (No)");
            }
        } while(error);
        return yesOrNot.equalsIgnoreCase("y");
    }

    public static void main(String[] args) {
        new Main().start();
    }
}