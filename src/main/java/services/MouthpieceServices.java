package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Mouthpieces;
import models.Saxophones;

import java.io.*;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MouthpieceServices {
    private static int nextId;
    ArrayList<Mouthpieces> inventory = new ArrayList<>();
    String csvFile = "/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/mouthpieceInventory.csv";
    String line = "";
    String splitBy = ",";
    static String nextIds = "/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/mouthpieceNextIds.txt";

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

    public void saveInventory() throws IOException {
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));

        for (Mouthpieces m : inventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(m.getId()));
            list.add(m.getManufacturer());
            list.add(m.getModel());
            list.add(m.getType());
            list.add(m.getMaterial());
            list.add(String.valueOf(m.getQuantity()));
            list.add((String.valueOf(m.getPrice())));

            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }

    public void loadData() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            try {
                nextId = Integer.parseInt(br.readLine());
            }
            catch (NumberFormatException e) {

            }
            while ((line = br.readLine()) != null) {
                //split line with comma
                String [] mouthpieceLoad = line.split(splitBy);

                int id = Integer.parseInt(mouthpieceLoad[0]);
                String mouthpieceManufacturer = mouthpieceLoad[1];
                String mouthpieceModel = mouthpieceLoad[2];
                String mouthpieceType = mouthpieceLoad[3];
                String mouthpieceMaterial = mouthpieceLoad[4];
                int mouthpieceQuantity = Integer.parseInt(mouthpieceLoad[5]);
                double mouthpiecePrice = Double.parseDouble(mouthpieceLoad[6]);

                inventory.add(new Mouthpieces(id, mouthpieceManufacturer, mouthpieceModel, mouthpieceType, mouthpieceMaterial, mouthpieceQuantity, mouthpiecePrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/mouthpieces.json"), inventory);
    }

    public void readJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.inventory = mapper.readValue(new File("/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/mouthpieces.json"), new TypeReference<ArrayList<Mouthpieces>>() {
        });
    }

    public static void loadNextId() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nextIds));
        nextId = Integer.valueOf(reader.readLine());
        reader.close();
    }

    public static void writeNextId() throws IOException {
        FileWriter writer = new FileWriter(nextIds);
        writer.write(String.valueOf(nextId));
        writer.close();
    }
}
