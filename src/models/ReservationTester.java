package models;

import java.util.Date;

public class ReservationTester {
    
    public static void main(String[] args) {
        Customer customer = new Customer("Javier", "Rodríguez", "javier.rodriguez89@example.com");
        FreeRoom room = new FreeRoom("101", RoomType.SINGLE);
        room.setPrice(150.0);
        room.setFree(false);
        Date checkInDate = new Date();
        Date checkOutDate = new Date();
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        System.out.println(reservation);
    }
}
