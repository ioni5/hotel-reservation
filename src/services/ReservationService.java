package services;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import models.IRoom;
import models.Reservation;

public class ReservationService {
    
    private static ReservationService instance;

    private Map<String, IRoom> rooms;

    private Map<Customer, Reservation> reservations;

    private ReservationService() {
        rooms = new HashMap<>();
        reservations = new HashMap<>();
    }

    public void addRoom(IRoom room) {
        rooms.put(room.getNumber(), room);
    }

    public IRoom getARoom(String number) {
        return rooms.get(number);
    }

    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        reservations.put(customer, new Reservation(customer, room, checkInDate, checkOutDate));
    }

    public static getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }
}