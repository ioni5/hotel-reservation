package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.IRoom;

public class RoomService {
    
    private static RoomService instance;

    private Map<String, IRoom> rooms;
    
    private RoomService() {
        rooms = new HashMap<>();
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

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    public Collection<IRoom> getFreeRooms() {
        List<IRoom> freeRooms = new ArrayList<>();
        for (IRoom room : rooms.values()) {
            if (room.isFree()) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }
}