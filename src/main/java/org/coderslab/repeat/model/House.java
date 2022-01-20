package org.coderslab.repeat.model;

public class House {

    public House(String description) {
        this.description = description;
    }

    private String description;

    private Integer price;

    private Integer size;

    private Integer rooms;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }
}
