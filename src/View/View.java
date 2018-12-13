package View;

import FarmController.RequestAnalayzer;
import FarmModel.Farm;

import java.util.Scanner;

public class View {
    public Scanner scanner = new Scanner(System.in)

    public void getRequest() {
        String input;
        while(true){
            input =scanner.nextLine();
            RequestAnalayzer requestAnalayzer = new RequestAnalayzer();
            requestAnalayzer.RequestAnalayzer(input);
        }
    }

    public static void ShowMap() {
    }

    public static void ShowShop() {
    }
}
