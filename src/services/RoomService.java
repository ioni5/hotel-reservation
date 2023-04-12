package services;

public class RoomService {
    
    private static RoomService instance;

    private Map<String, IRoom> rooms;
    
    private RoomService() {
        rooms = new HashMap<>();
        reservationMap = new HashMap<>();
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
            instance = new RoomService();
        }
        return instance;
    }
}