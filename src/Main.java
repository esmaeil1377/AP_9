import Controller.CityController;
import View.View.*;

import static Controller.CityController.lookingForCommand;

public class Main {
    public static void main(String[] args) {
        lookingForCommand();

        for(String str:View.View.getOutPutToPrint()){
            System.out.println(str);
        }

    }
}
