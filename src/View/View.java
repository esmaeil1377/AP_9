package View;

import FarmController.RequestAnalayzer;
import FarmModel.Farm;

import java.util.Scanner;

public class View {
    public static Scanner scanner = new Scanner(System.in);

    public static void  getRequest() {
        String input;
        while(true){
            input =scanner.nextLine();
            RequestAnalayzer requestAnalayzer = new RequestAnalayzer();
            requestAnalayzer.RequestAnalayzer(input);
        }
    }

}
