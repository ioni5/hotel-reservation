import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import models.Customer;
import models.IRoom;
import models.Reservation;
import models.RoomType;
import resources.AdminResource;
import resources.HotelResource;
import views.AdminMenu;
import views.Console;
import views.MainMenu;

public class Main {

    private HotelResource hotelResource;

    private AdminResource adminResource;

    private Console console;

    public Main() {
        hotelResource = HotelResource.getInstance();
        adminResource = AdminResource.getInstance();
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
        String checkin = console.read();
        console.write("Enter CheckOut Date mm/dd/yyyy example 02/01/2023");
        String checkout = console.read();
        console.write("Room Number: 100 Single bed Room Price: $135.0");
        Date checkinDate;
        Date checkoutDate;
        try {
            checkinDate = new SimpleDateFormat("M/dd/yyyy").parse(checkin);
            checkoutDate = new SimpleDateFormat("M/dd/yyyy").parse(checkout);
        } catch (ParseException ex) {
        this.reserveRoom(checkinDate, checkoutDate);
    }

    private void reserveRoom(Date checkinDate, Date checkoutDate) {
        console.write("Do you have an account with us? y/n");
        boolean isRegistered = console.readYesOrNot();
        if (!isRegistered) {
            return;
        }
        String customerEmail = console.readEmail();
        console.write("What room number would you like to reserve");
        int roomNumber = console.readInt();
        IRoom room = hotelResource.getRoom(Integer.toString(roomNumber));
        Reservation reservation = hotelResource.bookARoom(customerEmail, room, checkinDate, checkoutDate);
        console.write("Reservation");
        console.write(reservation.toString());
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
        Collection<Customer> customers= adminResource.getAllCustomer();
        console.write("Customers:");
        console.write("------------------------------");
        for (Customer customer : customers) {
            console.write(customer.toString());
        }
        console.write("------------------------------");
    }

    private void showAllRooms() {
        Collection<IRoom> rooms = adminResource.getAllRooms();
        console.write("Rooms:");
        console.write("------------------------------");
        for (IRoom room : rooms) {
            console.write(room.toString());
        }
        console.write("------------------------------");
    }

    private void showAllReservations() {
        Collection<Reservation> reservations = adminResource.getAllReservations();
        console.write("Reservations:");
        console.write("------------------------------");
        for (Reservation reservation : reservations) {
            console.write(reservation.toString());
        }
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
            adminResource.addRoom(Integer.toString(roomNumber), RoomType.values()[roomType], roomPrice);
            console.write("Would you like to add another room y/n");
        } while (console.readYesOrNot());
    }

    public static void main(String[] args) {
        new Main().start();
    }
}