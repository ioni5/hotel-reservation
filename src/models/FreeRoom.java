package models;

public class FreeRoom extends Room {

    public FreeRoom(String number, RoomType type) {
        super(number, 0.0, type);
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
}
