import io.Console;
import models.Mouthpieces;
import models.Saxophones;
import services.MouthpieceServices;
import services.SaxophoneServices;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;


public class App {

    private SaxophoneServices saxophoneServices = new SaxophoneServices();
    private MouthpieceServices mouthpieceServices = new MouthpieceServices();
    private static Console console = new Console(System.in, System.out);

    private static String userInput;

    public static void main(String[] args) {
        App app = new App();
        console.menu();
        userInput = console.getUserInput("\nChoose from menu");
        app.run();

    }

    public void run() {
        boolean runProgram = true;
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
                    } else if (userInput.equals("2")) {
                        //manufacturer, model, type, material, quantity, price
                        String manufacturer = console.getUserInput("Enter manufacturer:\n");
                        String model = console.getUserInput("Enter model:\n");
                        String type = console.getUserInput("Enter type:\n");
                        String material = console.getUserInput("Enter material:\n");
                        int quantity = Integer.parseInt(console.getUserInput("Enter quantity:\n"));
                        double price = Double.parseDouble(console.getUserInput("Enter price:\n"));
                        mouthpieceServices.create(manufacturer, model, type, material, quantity, price);
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
                    userInput = console.getUserInput("Select a service:\n 1. Saxophone Services\n2. Mouthpiece Services\n");
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
                    userInput = console.getUserInput("Select a product type to update:\n 1. Saxophones\n2. Mouthpieces\n");
                    if (userInput.equals("1")) {
                        int saxophoneId = Integer.parseInt(console.getUserInput("Enter saxophone id: "));
                        Saxophones saxophoneToUpdate = saxophoneServices.find(saxophoneId);
                        updateSaxophone(saxophoneToUpdate);
                    } else if (userInput.equals("2")) {
                        int mouthpieceId = Integer.parseInt(console.getUserInput("Enter mouthpiece id: "));
                        Mouthpieces mouthpieceToUpdate = mouthpieceServices.find(mouthpieceId);
                        updateMouthpiece(mouthpieceToUpdate);
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
                    userInput = console.getUserInput("Select a product type to delete:\n 1. Saxophones\n2. Mouthpieces\n");
                    if (userInput.equals("1")) {
                        int saxophoneId = Integer.parseInt(console.getUserInput("Enter saxophone id: "));
                        saxophoneServices.delete(saxophoneId);
                    } else if (userInput.equals("2")) {
                        int mouthpieceId = Integer.parseInt(console.getUserInput("Enter mouthpiece id: "));
                        mouthpieceServices.delete(mouthpieceId);
                    }
                    userInput = console.getUserInput("Would you like to delete another?\n[Y/N]\n");
                    if (userInput.equals("Y")) {
                        userInput = "4";
                    } else {
                        console.menu();
                        userInput = console.getUserInput("\nChoose from menu");
                    }
                    break;
                case "5":
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
