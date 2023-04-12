package models;

public abstract class Room implements IRoom {
    
    private String number;

    protected Double price;

    private RoomType type;

    private boolean isFree;

    protected Room(String number, Double price, RoomType type) {
        this.number = number;
        this.price = price;
        this.type = type;
        this.isFree = true;
    }

    public String getNumber() {
        return number;
    }

    public Double getPrice() {
        return price;
    }

    public RoomType getType() {
        return type;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Room Number: " + number + " " + type + " bed Room Price: " + price;
    }
}
