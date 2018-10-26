package Controller;

import Model.AddDefense;
import Model.City;
import Model.Requests;
import java.util.Scanner;

import static Controller.RequestAnalyzer.getRequest;
import static View.View.getCommand;

public class CityController {
    public static Scanner scanner=new Scanner(System.in);
    private static CityController cityController=new CityController();
    private CityController(){}

    public static CityController getCityController() {
        return cityController;
    }

    public static void lookingForCommand(){
        String str=scanner.nextLine();
        while(true){
            getRequest(str);
            if((str.matches("[Y|y][I|i][E|e][L|l][D|d]"))) {
                break;
            }
            Scanner scanner1=new Scanner(System.in);
            str=scanner1.nextLine();
        }
    }
}
