package resources;

import java.util.Date;

import models.Customer;
import models.IRoom;
import models.Reservation;
import services.CustomerService;
import services.ReservationService;

public class HotelResource {

    private static HotelResource instance;

    private CustomerService customerService;

    private ReservationService reservationService;

    private HotelResource() {
        customerService = CustomerService.getInstance();
        reservationService = ReservationService.getInstance();
    }

    public void createACustomer(String firstName, String lastName, String email) {
        customerService.addCustomer(firstName, lastName, email);
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public Reservation bookARoom(String email, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = this.getCustomer(email);
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
        }
        return instance;
    }
}
