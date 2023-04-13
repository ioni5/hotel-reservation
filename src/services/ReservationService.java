package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import models.Customer;
import models.IRoom;
import models.Reservation;

public class ReservationService {
    
    private static ReservationService instance;

    private Map<Customer, Collection<Reservation>> reservationMap;

    private ReservationService() {
        reservationMap = new HashMap<>();
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        Collection<Reservation> reservationList = reservationMap.getOrDefault(customer, new ArrayList<>());        
        reservationMap.put(customer, reservationList);
        return reservation;
    }

    public Collection<Reservation> getAllReservations() {
        Collection<Reservation> reservationList = new ArrayList<>();
        for (Collection<Reservation> reservations : reservationMap.values()) {
            reservationList.addAll(reservations);
        }
        return reservationList;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOuDate) {
        Collection<IRoom> roomList = new ArrayList<>();
        for (Reservation reservation : this.getAllReservations()) {
            if (reservation.isFreeTo(checkInDate, checkOuDate)) {
                roomList.add(reservation.getRoom());
            }
        }
        return roomList;
    }

    public Collection<Reservation> getReservations(Customer customer) {
        return reservationMap.get(customer);
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }
}