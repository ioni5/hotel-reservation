package services;

import java.util.Collection;
import java.util.Map;

import models.IRoom;

public class ReservationService {
    
    private static ReservationService instance;

    private Map<String, IRoom> rooms;

    private Map<String, Reservation> reservations;

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

    public static getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }
}