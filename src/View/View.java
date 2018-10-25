package View;

import java.util.Scanner;

public class View {
    private static Scanner input = new Scanner(System.in);

    public String getCommand() {
        return input.nextLine();
    }



}
