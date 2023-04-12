package models;

public interface IRoom {
    
    public String getNumber();

    public Double getPrice();

    public RoomType getType();

    public boolean isFree();
    
}
