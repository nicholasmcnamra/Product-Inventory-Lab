package io;

import models.Mouthpieces;
import models.Saxophones;
import services.MouthpieceServices;
import services.SaxophoneServices;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {
private final Scanner input;
private final PrintStream output;
private static final Console console = new Console(System.in, System.out);
private SaxophoneServices saxophoneServices = new SaxophoneServices();
private MouthpieceServices mouthpieceServices = new MouthpieceServices();
public static String userInput;

    public Console(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public static void printWelcome() {
        System.out.println("" +
                "**************************************************" +
                "***           Welcome and Bienvenue            ***" +
                "***                    to                      ***" +
                "***          Saxophone Inventory Manager       ***" +
                "**************************************************");
    }

    public void menu() {
        System.out.println("Select from menu options:\n1. Add to inventory\n2. Inventory catalogue\n3. Update products\n4. Remove products\n5. Get reports\n6. Exit");
    }

    public void print(String val, Object... args) {
        output.format(val, args);
    }
    public void println(String val, Object... vals) {
        print(val + "\n", val);
    }
    public String getUserInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public void run() throws IOException {
        boolean runProgram = true;
        saxophoneServices.loadData();
        mouthpieceServices.loadData();
        saxophoneServices.readJSON();
        mouthpieceServices.readJSON();
        SaxophoneServices.loadNextId();
        MouthpieceServices.loadNextId();
        while (runProgram) {
            switch (userInput) {
                case "1":
                    //Select a Service
                    userInput = console.getUserInput("Select a service:\n1. Saxophone Services\n2. Moutpiece Services\n");
                    if (userInput.equals("1")) {
                        //manufacturer, model, type, quantity, price
                        String manufacturer = console.getUserInput("Enter manufacturer:\n");
                        String model = console.getUserInput("Enter model:\n");
                        String type = console.getUserInput("Enter type:\n");
                        int quantity = Integer.parseInt(console.getUserInput("Enter quantity:\n"));
                        double price = Double.parseDouble(console.getUserInput("Enter price:\n"));
                        saxophoneServices.create(manufacturer, model, type, quantity, price);
                        saxophoneServices.saveInventory();
                        saxophoneServices.writeToJSON();
                        SaxophoneServices.writeNextId();
                    } else if (userInput.equals("2")) {
                        //manufacturer, model, type, material, quantity, price
                        String manufacturer = console.getUserInput("Enter manufacturer:\n");
                        String model = console.getUserInput("Enter model:\n");
                        String type = console.getUserInput("Enter type:\n");
                        String material = console.getUserInput("Enter material:\n");
                        int quantity = Integer.parseInt(console.getUserInput("Enter quantity:\n"));
                        double price = Double.parseDouble(console.getUserInput("Enter price:\n"));
                        mouthpieceServices.create(manufacturer, model, type, material, quantity, price);
                        mouthpieceServices.saveInventory();
                        mouthpieceServices.writeToJSON();
                        MouthpieceServices.writeNextId();
                    }
                    userInput = console.getUserInput("Would you like to add another?\n[Y/N]\n");
                    if (userInput.equals("Y")) {
                        userInput = "1";
                    } else {
                        console.menu();
                        userInput = console.getUserInput("\nChoose from menu");
                    }
                    break;
                case "2":
                    userInput = console.getUserInput("Select a service:\n1. Saxophone Services\n2. Mouthpiece Services\n");
                    if (userInput.equals("1")) {
                        Saxophones[] saxophones = saxophoneServices.findAll();
                        for (Saxophones saxophone : saxophones) {
                            System.out.println(saxophone.toString());
                        }
                    } else if (userInput.equals("2")) {
                        Mouthpieces[] mouthpieces = mouthpieceServices.findAll();
                        for (Mouthpieces mouthpiece : mouthpieces) {
                            System.out.println(mouthpiece.toString());
                        }
                    }
                    console.menu();
                    userInput = console.getUserInput("\nChoose from menu");
                    break;
                case "3":
                    userInput = console.getUserInput("Select a product type to update:\n1. Saxophones\n2. Mouthpieces\n");
                    if (userInput.equals("1")) {
                        int saxophoneId = Integer.parseInt(console.getUserInput("Enter saxophone id: "));
                        Saxophones saxophoneToUpdate = saxophoneServices.find(saxophoneId);
                        updateSaxophone(saxophoneToUpdate);
                        saxophoneServices.saveInventory();
                        saxophoneServices.writeToJSON();
                    } else if (userInput.equals("2")) {
                        int mouthpieceId = Integer.parseInt(console.getUserInput("Enter mouthpiece id: "));
                        Mouthpieces mouthpieceToUpdate = mouthpieceServices.find(mouthpieceId);
                        updateMouthpiece(mouthpieceToUpdate);
                        mouthpieceServices.saveInventory();
                        mouthpieceServices.writeToJSON();
                    }
                    userInput = console.getUserInput("Would you like to update another?\n[Y/N]\n");
                    if (userInput.equals("Y")) {
                        userInput = "3";
                    } else {
                        console.menu();
                        userInput = console.getUserInput("\nChoose from menu");
                    }
                    break;
                case "4":
                    userInput = console.getUserInput("Select a product type to delete:\n1. Saxophones\n2. Mouthpieces\n");
                    if (userInput.equals("1")) {
                        int saxophoneId = Integer.parseInt(console.getUserInput("Enter saxophone id: "));
                        saxophoneServices.delete(saxophoneId);
                        saxophoneServices.saveInventory();
                        saxophoneServices.writeToJSON();
                        SaxophoneServices.writeNextId();
                    } else if (userInput.equals("2")) {
                        int mouthpieceId = Integer.parseInt(console.getUserInput("Enter mouthpiece id: "));
                        mouthpieceServices.delete(mouthpieceId);
                        mouthpieceServices.saveInventory();
                        mouthpieceServices.writeToJSON();
                        MouthpieceServices.writeNextId();
                    }
                    userInput = console.getUserInput("Would you like to delete another?\n[Y/N]\n");
                    if (userInput.equals("Y")) {
                        userInput = "4";
                    } else {
                        console.menu();
                        userInput = console.getUserInput("\nChoose from menu");
                    }
                    break;
                case "6":
                    System.out.println("Catch ya around");
                    runProgram = false;
            }
        }
    }
    public void updateSaxophone(Saxophones saxophoneToUpdate) {
        String userSelection = console.getUserInput("What do you want to update?\n1. Manufacturer\n2 .Model\n3. Type\n4. Quantity\r5. Price");

        switch (userSelection) {
            case "1":
                String newManufacturer = console.getUserInput("Enter new manufacturer:\n");
                saxophoneToUpdate.setManufacturer(newManufacturer);
                break;
            case "2":
                String newModel = console.getUserInput("Enter new model:\n");
                saxophoneToUpdate.setManufacturer(newModel);
                break;
            case "3":
                String newType = console.getUserInput("Enter new type:\n");
                saxophoneToUpdate.setManufacturer(newType);
                break;
            case "4":
                Integer newQuantity = Integer.parseInt(console.getUserInput("Enter new quantity:\n"));
                saxophoneToUpdate.setManufacturer(String.valueOf(newQuantity));
                break;
            case "5":
                Double newPrice = Double.parseDouble(console.getUserInput("Enter new price:\n"));
                saxophoneToUpdate.setManufacturer(String.valueOf(newPrice));
                break;
        }
    }

    public void updateMouthpiece(Mouthpieces mouthpieceToUpdate) {
        String userSelection = console.getUserInput("What do you want to update?\n1. Manufacturer\n2 .Model\n3. Type\n4. Material\n5. Quantity\r6. Price");

        switch (userSelection) {
            case "1":
                String newManufacturer = console.getUserInput("Enter new manufacturer:\n");
                mouthpieceToUpdate.setManufacturer(newManufacturer);
                break;
            case "2":
                String newModel = console.getUserInput("Enter new model:\n");
                mouthpieceToUpdate.setManufacturer(newModel);
                break;
            case "3":
                String newType = console.getUserInput("Enter new type:\n");
                mouthpieceToUpdate.setManufacturer(newType);
                break;
            case "4":
                String newMaterial = console.getUserInput("Enter new material:\n");
                mouthpieceToUpdate.setManufacturer(newMaterial);
                break;
            case "5":
                Integer newQuantity = Integer.parseInt(console.getUserInput("Enter new quantity:\n"));
                mouthpieceToUpdate.setManufacturer(String.valueOf(newQuantity));
                break;
            case "6":
                Double newPrice = Double.parseDouble(console.getUserInput("Enter new price:\n"));
                mouthpieceToUpdate.setManufacturer(String.valueOf(newPrice));
                break;
        }
    }
}
