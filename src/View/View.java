package View;
import java.util.Scanner;

import static FarmController.RequestAnalayzer.RequestAnalayzer;

public abstract class View {
    private static Scanner scanner = new Scanner(System.in);

    public static void  getRequest() {
        String input;
        while(true){
            input =scanner.nextLine();
            try {
                RequestAnalayzer(input);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public abstract void Start();

}
