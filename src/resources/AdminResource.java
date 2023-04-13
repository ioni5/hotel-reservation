package resources;

import models.FreeRoom;
import models.IRoom;
import models.Room;
import models.RoomType;
import services.RoomService;

public class AdminResource {

    private static AdminResource instance;

    private RoomService roomService;

    private AdminResource() {
        roomService = RoomService.getInstance();
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
