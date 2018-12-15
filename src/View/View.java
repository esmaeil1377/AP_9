package View;
import java.util.Scanner;

import static FarmController.RequestAnalayzer.RequestAnalayzer;

public class View {
    public static Scanner scanner = new Scanner(System.in);

    public static void  getRequest() {
        String input;
        while(true){
            input =scanner.nextLine();
            RequestAnalayzer(input);
        }
    }

}
