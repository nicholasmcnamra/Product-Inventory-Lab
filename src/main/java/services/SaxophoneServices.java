package services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Saxophones;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaxophoneServices {
   private static int nextId;
    ArrayList<Saxophones> inventory = new ArrayList<>();
    String csvFile = "/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/saxophoneInventory.csv";
    String line = "";
    String splitBy = ",";
    static String nextIds = "/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/saxophoneNextIds.txt";


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
        // if true, return the first instance, other wise return null
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

    public void saveInventory() throws IOException {
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));

        for (Saxophones s : inventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(s.getId()));
            list.add(s.getManufacturer());
            list.add(s.getModel());
            list.add(s.getType());
            list.add(String.valueOf(s.getQuantity()));
            list.add((String.valueOf(s.getPrice())));

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
                String [] saxophoneLoad = line.split(splitBy);

                int id = Integer.parseInt(saxophoneLoad[0]);
                String saxManufacturer = saxophoneLoad[1];
                String saxModel = saxophoneLoad[2];
                String saxType = saxophoneLoad[3];
                int saxQuantity = Integer.parseInt(saxophoneLoad[4]);
                double saxPrice = Double.parseDouble(saxophoneLoad[5]);

                inventory.add(new Saxophones(id, saxManufacturer, saxModel, saxType, saxQuantity, saxPrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/saxophones.json"), inventory);
    }

    public void readJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.inventory = mapper.readValue(new File("/Users/nicholas/Dev/toDoLabs/Product-Inventory-Lab/src/main/java/saxophones.json"), new TypeReference<ArrayList<Saxophones>>() {
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
