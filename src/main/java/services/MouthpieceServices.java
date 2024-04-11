package services;

import models.Mouthpieces;
import models.Saxophones;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;

public class MouthpieceServices {
    private int nextId;
    ArrayList<Mouthpieces> inventory = new ArrayList<>();
    public Mouthpieces create(String manufacturer, String model, String type, String material, int quantity, double price) {
        nextId++;
        Mouthpieces createMouthpiece = new Mouthpieces(nextId, manufacturer, model, type, material, quantity, price);
        inventory.add(createMouthpiece);
        return createMouthpiece;
    }

    public Mouthpieces find(int i) {
//        for (Mouthpieces mouthpiece: inventory) {
//            if (mouthpiece.getId() == i) {
//                return mouthpiece;
//            }
//        }
        return inventory.stream().filter(mouthpiece -> mouthpiece.getId() == i).findFirst().orElse(null);
    }

    public Mouthpieces[] findAll() {
//        Mouthpieces[] mouthpiecesInventory = new Mouthpieces[inventory.size()];
//        int i = 0;
//        for (Mouthpieces mouthpiece : inventory) {
//            mouthpiecesInventory[i] = mouthpiece;
//            i++;
//        }
        return inventory.toArray(new Mouthpieces[0]);
    }

    public boolean delete(int i) {
        for (Mouthpieces mouthpiece : inventory) {
            if (mouthpiece.getId() == i) {
                inventory.remove(mouthpiece);
                return true;
            }
        }
        return false;
    }
}
