import io.Console;
import models.Mouthpieces;
import models.Saxophones;
import services.MouthpieceServices;
import services.SaxophoneServices;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;


public class App {

    private static Console console = new Console(System.in, System.out);



    public static void main(String[] args) {
        App app = new App();
        console.menu();
        console.userInput = console.getUserInput("\nChoose from menu");
        console.run();

    }
}
