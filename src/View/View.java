package View;

import Controller.RequestAnalyzer;
import java.util.Scanner;



public class View {
    private static Scanner input = new Scanner(System.in);

    public void getCommand()
    {
         String Console;
         Console = input.nextLine();
         RequestAnalyzer.getRequest(Console);
    }
}
