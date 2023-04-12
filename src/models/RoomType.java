package models;

public enum RoomType {

    SINGLE("Single"),
    DOUBLE("Double");

    private String name;

    private RoomType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
