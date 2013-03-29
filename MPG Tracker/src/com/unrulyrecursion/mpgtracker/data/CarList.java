package com.unrulyrecursion.mpgtracker.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.R;
import android.widget.ArrayAdapter;

public class CarList {
    String[] cars = new String[] {
            "Eclipse",
            "Toyota Truck",
            "Lexus",
            "Jag",
            "Sienna",
            "Stratus",
            "Miata"
        };

    /**
     * An array of cars.
     */
    public static List<String> ITEMS = new ArrayList<String>();

    /**
     * A map of cars, by ID.
     */
    public static Map<String, String> ITEM_MAP = new LinkedHashMap<String, String>();

    static {
        // Add sample car.
        addItem(new Car("0", "Example Car Name"));
    }

    private static void addItem(Car item) {
        ITEMS.add(item.getCarName());
        ITEM_MAP.put(Long.toString(item.getId()), item.getCarName());
    }
    

    /**
     * A dummy item representing a piece of content.
     **/
//    public static class Car {
//        public String id;
//        public String carName;
//
//        public Car(String id, String carName) {
//            this.id = id;
//            this.carName = new String(carName);
//        }
//
//        @Override
//        public String toString() {
//            return carName;
//        }
//    }
}
