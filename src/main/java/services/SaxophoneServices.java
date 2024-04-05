package services;
import models.Saxophones;

import java.util.ArrayList;

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
        for (Saxophones saxophone : inventory) {
            if (saxophone.getId() == i)
                return saxophone;
        }
        return null;
    }

    public Saxophones[] findAll() {
        Saxophones[] saxophonesInventory = new Saxophones[inventory.size()];
        int i = 0;
        for (Saxophones saxophone : inventory) {
            saxophonesInventory[i] = saxophone;
            i++;
        }
        return saxophonesInventory;
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
