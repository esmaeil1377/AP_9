package FarmController;

import FarmModel.Request.*;

public class RequestAnalayzer {
    private RequestAnalayzer requestAnalayzer=new RequestAnalayzer();
    private RequestAnalayzer(){}


    private static String BuyAnimals = "buy (cat|dog)";
    private static String PickUp = " pickup [0-9] [0-9]";
    private static String Cage = "cage [0-9][0-9]";
    private static String Plant = "plant [0-9][0-9]";
    private static String Well = "well";
    private static String StartWorkShop = "start .*";
    private static String Upgrade = "upgrade .*";
    private static String LoadCustom = "load custom .*";
    private static String RunMap = "run .*";
    private static String SaveGame = "save game .*";
    private static String LoadGame = "load game .*";
    private static String Print = "print .*";
    private static String Turn = "turn [0-9]*";
    private static String GoVehicle = "(truck|helicopter) go";

    public static void RequestAnalayzer(String requestString) {
        if (requestString.matches(BuyAnimals)) {
            new BuyRequest(requestString);
        } else if (requestString.matches(PickUp)) {
            new PickUpRequest(requestString);
        } else if (requestString.matches(Cage)) {
            new CageRequest(requestString);
        } else if (requestString.matches(Plant)) {
            new PlantRequest(requestString);
        } else if (requestString.matches(Well)) {
            new WellRequest();
        } else if (requestString.matches(StartWorkShop)) {
            new StartRequest(requestString);
        } else if (requestString.matches(Upgrade)) {
            new UpgradeRequest(requestString);
        } else if (requestString.matches(LoadCustom)) {
            new LoadCustomRequest(requestString);
        } else if (requestString.matches(RunMap)) {
            new RunRequest(requestString);
        } else if (requestString.matches(SaveGame)) {
            new SaveGameRequest(requestString);
        } else if (requestString.matches(LoadGame)) {
            new LoadGameRequest(requestString);
        } else if (requestString.matches(Print)) {
            new PrintRequest(requestString);
        } else if (requestString.matches(Turn)) {
            new TurnRequest(requestString);
        } else if (requestString.matches(GoVehicle)) {
            new GoVehicleRequest(requestString);
        }
    }
}
