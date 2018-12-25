package FarmController;

import FarmController.Exceptions.*;
import FarmModel.Request.*;

public class RequestAnalayzer {
    private RequestAnalayzer requestAnalayzer=new RequestAnalayzer();
    private RequestAnalayzer(){}


    private static final String Buy_Animals_Regex = "buy (Cat|Dog|Chicken|Sheep|Cow)";
    private static final String Pick_Up_Regex = "pickup [0-9]+ [0-9]+";
    private static final String Cage__Regex = "cage [0-9]+ [0-9]+";
    private static final String Plant__Regex = "plant [0-9]+ [0-9]+";
    private static final String Well_Regex = "well";
    private static final String Start_WorkShop__Regex = "start .*";
    private static final String Upgrade_Regex = "upgrade .*";
    private static final String Load_Custom_Regex = "load custom .*";
    private static final String Run_Map_Regex = "run .*";
    private static final String Save_Game_Regex = "save game .*";
    private static final String Load_Game_Regex = "load game .*";
    private static final String Print_Regex = "print (info|map|levels|warehouse|well|workshops|truck|helicopter)";
    private static final String Turn_Regex = "turn [0-9]*";
    private static final String Go_Vehicle_Regex = "(Truck|Helicopter) go";

    public static void RequestAnalayzer(String requestString) throws UnknownObjectException, MissionNotLoaded, FullWareHouse, BucketIsEmptyException, NotEnoughMoney, NotEmptyWell {
        if (requestString.matches(Buy_Animals_Regex)) {
            new BuyRequest(requestString);
        } else if (requestString.matches(Pick_Up_Regex)) {
            new PickUpRequest(requestString);
        } else if (requestString.matches(Cage__Regex)) {
            new CageRequest(requestString);
        } else if (requestString.matches(Plant__Regex)) {
            new PlantRequest(requestString);
        } else if (requestString.matches(Well_Regex)) {
            new WellRequest();
        } else if (requestString.matches(Start_WorkShop__Regex)) {
            new StartRequest(requestString);
        } else if (requestString.matches(Upgrade_Regex)) {
            new UpgradeRequest(requestString);
        } else if (requestString.matches(Load_Custom_Regex)) {
            new LoadCustomRequest(requestString);
        } else if (requestString.matches(Run_Map_Regex)) {
            new RunRequest(requestString);
        } else if (requestString.matches(Save_Game_Regex)) {
            new SaveGameRequest(requestString);
        } else if (requestString.matches(Load_Game_Regex)) {
            new LoadGameRequest(requestString);
        } else if (requestString.matches(Print_Regex)) {
            new PrintRequest(requestString);
        } else if (requestString.matches(Turn_Regex)) {
            new TurnRequest(requestString);
        } else if (requestString.matches(Go_Vehicle_Regex)) {
            new GoVehicleRequest(requestString);
        }else{
            System.out.println("Unknown1 Request");
        }
    }
}
