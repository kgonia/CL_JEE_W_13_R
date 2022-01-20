package org.coderslab.errors.other;



import org.coderslab.repeat.model.House;

import java.util.Arrays;
import java.util.List;

public class Error3 {

    public static void main(String[] args) {

        House house1 = new House("Duży dom");
        house1.setPrice(500000);
        house1.setSize(200);
        house1.setRooms(7);

        House house2 = new House("Domek");
        house2.setPrice(350000);
        house2.setSize(150);
        house2.setRooms(5);

        House house3 = new House("Rudera");
        house3.setPrice(10000);
        house3.setSize(120);
        house3.setRooms(6);

        List<House> houses = Arrays.asList(house1,house2,house3);

        houses.remove(house1);

    }
}
