package resources;

import java.util.Collection;

import models.Customer;
import models.FreeRoom;
import models.IRoom;
import models.Reservation;
import models.Room;
import models.RoomType;
import services.CustomerService;
import services.ReservationService;
import services.RoomService;

public class AdminResource {

    private static AdminResource instance;

    private RoomService roomService;

    private CustomerService customerService;

    private ReservationService reservationService;

    private AdminResource() {
        roomService = RoomService.getInstance();
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public Collection<IRoom> getAllRooms() {
        return roomService.getAllRooms();
    }

    public Collection<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    public Collection<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    public void addRoom(String roomNumber, RoomType type, double price) {
        IRoom room;
        if (price == 0) {
            room = new FreeRoom(roomNumber, type);
        }
        room = new Room(roomNumber, price, type);
        roomService.addRoom(room);
    }

    public static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }
    
}
