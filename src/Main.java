import Controller.CityController;
import View.View.*;

public class Main {
    public static void main(String[] args) {
        CityController.lookingForCommand();

        for(String str:View.View.getInstance().getOutPutToPrint()){
            System.out.println(str);
        }

    }
}
