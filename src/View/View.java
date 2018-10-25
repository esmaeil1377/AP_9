package View;

import Controller.RequestAnalyzer;
import java.util.Scanner;



public class View {
    private static Scanner input = new Scanner(System.in);

    public static String getCommand()
    {
         String Console;
         Console = input.nextLine();
         return(Console);
    }
}
