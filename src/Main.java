import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public void start() {
        int option = 0;
        do {
            System.out.println("Admin Menu");
            System.out.println("------------------------------");
            System.out.println("1. See all Customers");
            System.out.println("------------------------------");
            System.out.println("Please select a number for the menu option");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Option 1 selected.");
                    break;
                default:
                    break;
            }
        } while (true);
        
    }

    public static void main(String[] args) {
        new Main().start();
    }
}