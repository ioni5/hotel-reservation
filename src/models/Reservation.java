package models;

import java.util.Date;

public class Reservation {

    private Customer customer;

    private IRoom room;

    private Date checkInDate;

    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate =checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return customer
                + "\nRoom: " + room.getNumber() + " - " + room.getType() + " bed"
                + "\nPrice: " + room.getPrice() + " price per night"
                + "\nCheckin Date: " + checkInDate
                + "\nCheckout Date: " + checkOutDate;
    }
}
