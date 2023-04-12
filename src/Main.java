import resources.HotelResource;
import views.AdminMenu;
import views.Console;
import views.MainMenu;

public class Main {

    private HotelResource hotelResource;

    private Console console;

    public Main() {
        hotelResource = HotelResource.getInstance();
        console = new Console();
    }

    public void start() {
        MainMenu mainMenu = new MainMenu();
        int option;
        do {
            mainMenu.show();
            option = mainMenu.getOption();
            switch (option) {
                case 1:
                    this.findRoomByCheckinAndCheckout();
                    this.reserveRoom();
                    break;
                case 2:
                    this.createAccount();
                    break;
                case 3:
                    this.showAdminMenu();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (option != 4);
    }

    private void showAdminMenu() {
        AdminMenu adminMenu = new AdminMenu();
        int option;
        do {
            adminMenu.show();
            option = adminMenu.getOption();
            switch (option) {
                case 1:
                    this.showAllCustomers();
                    break;
                case 2:
                    this.showAllRooms();
                    break;
                case 3:
                    this.showAllReservations();
                    break;
                case 4:
                    this.addRoom();
                    break;
                default:
                    break;
            }
        } while (option != 5);
    }

    private void findRoomByCheckinAndCheckout() {
        console.write("Enter CheckIn Date mm/dd/yyyy example 02/01/2023");
        String checkinDate = console.read();
        console.write("Enter CheckOut Date mm/dd/yyyy example 02/01/2023");
        String checkoutDate = console.read();
        console.write("Room Number: 100 Single bed Room Price: $135.0");
    }

    private void reserveRoom() {
        console.write("Do you have an account with us? y/n");
        boolean isRegistered = console.readYesOrNot();
        if (!isRegistered) {
            return;
        }
        String customerEmail = console.readEmail();
        console.write("What room number would you like to reserve");
        int roomNumber = console.readInt();
        console.write("Reservation");
        console.write("Ana García");
        console.write("Room: 100 - Single bed");
        console.write("Price: $135.0 price per night");
        console.write("Checkin Date: Sun Jan 10 2023");
        console.write("Checkout Date: Wed Jan 20 2023");
    }

    private void createAccount() {
        String email = console.readEmail();
        console.write("First Name");
        String firstName = console.read();
        console.write("Last Name");
        String lastName = console.read();
        hotelResource.createACustomer(firstName, lastName, email);
    }

    private void showAllCustomers() {
        console.write("Customers:");
        console.write("------------------------------");
        console.write("First Name: Ana Last Name: García Email: ana.garcia23@example.com");
        console.write("First Name: Javier Last Name: Rodríguez Email: javier.rodriguez89@example.com");
        console.write("First Name: Laura Last Name: Sánchez Email: laura.sanchez67@example.com");
        console.write("First Name: Pedro Last Name: Martínez Email: pedro.martinez45@example.com");
        console.write("First Name: Marta Last Name: González Email: marta.gonzalez12@example.com");
        console.write("------------------------------");
    }

    private void showAllRooms() {
        console.write("Rooms:");
        console.write("------------------------------");
        console.write("Room Number: 100 Single bed Room Price: $135.0");
        console.write("Room Number: 105 Double bed Room Price: $215.0");
        console.write("Room Number: 110 Single bed Room Price: $135.0");
        console.write("------------------------------");
    }

    private void showAllReservations() {
        console.write("Reservations:");
        console.write("------------------------------");
        console.write("Ana García");
        console.write("Room: 100 - Single bed");
        console.write("Price: $135.0 price per night");
        console.write("Checkin Date: Sun Apr 23 2023");
        console.write("Checkout Date: Wed Apr 25 2023");
        console.write("------------------------------");
    }

    private void addRoom() {
        do {
            console.write("Enter room number");
            int roomNumber = console.readInt();
            console.write("Enter price per night");
            int roomPrice = console.readInt();
            console.write("Enter room type: 1 for single bed, 2 for double bed");
            int roomType = console.readInt();
            console.write("Would you like to add another room y/n");
        } while (console.readYesOrNot());
    }

    public static void main(String[] args) {
        new Main().start();
    }
}