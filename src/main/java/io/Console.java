package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.println;

public class Console {
private final Scanner input;
private final PrintStream output;

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
}
