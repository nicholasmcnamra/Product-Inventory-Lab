package services;
import models.Saxophones;

import java.util.ArrayList;
import java.util.Arrays;

public class SaxophoneServices {
    int nextId;
    ArrayList<Saxophones> inventory = new ArrayList<>();


    public Saxophones create(String manufacturer, String model, String type, int quantity, double price) {
        nextId++;
        Saxophones createdSaxophone = new Saxophones(nextId, manufacturer, model, type, quantity, price);
        inventory.add(createdSaxophone);
        return createdSaxophone;
    }

    public Saxophones find(int i) {
//        for (Saxophones saxophone : inventory) {
//            if (saxophone.getId() == i)
//                return saxophone;
//        }
//        return null;
        // saxophone ids should not be duplicated
        // saxophone -> saxophone.getId() == i -- for each saxophone compare saxophone.getId() to i.
        // if true, return the first instance, otherwise return null
        return inventory.stream().filter(saxophone -> saxophone.getId() == i).findFirst().orElse(null);
    }

    public Saxophones[] findAll() {
//        Saxophones[] saxophonesInventory = new Saxophones[inventory.size()];
//        int i = 0;
//        for (Saxophones saxophone : inventory) {
//            saxophonesInventory[i] = saxophone;
//            i++;
//        }
//        return saxophonesInventory;
        return inventory.toArray(new Saxophones[0]);
    }

    public boolean delete(int id) {
        for (Saxophones saxophone : inventory) {
            if (saxophone.getId() == id) {
                inventory.remove(saxophone);
                return true;
            }
        }
        return false;
    }
}
