package services;

import java.util.Collection;
import java.util.Date;

import models.IRoom;

public class RoomFinderService {
    
    private RoomService roomService;

    private ReservationService reservationService;

    public RoomFinderService() {
        roomService = RoomService.getInstance();
        reservationService = ReservationService.getInstance();
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOuDate) {
        Collection<IRoom> rooms;
        rooms = roomService.getFreeRooms();
        rooms.addAll(reservationService.findRooms(checkInDate, checkOuDate));
        return rooms;
    }
}
