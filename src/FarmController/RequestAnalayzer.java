package FarmController;

import FarmModel.Request.*;

public class RequestAnalayzer {
    private String BuyAnimals = "buy (cat|dog)";
    private String PickUp = " pickup [0-9] [0-9]";
    private String Cage = "cage [0-9][0-9]";
    private String Plant = "plant [0-9][0-9]";
    private String Well = "well";
    private String StartWorkShop = "start .*";
    private String Upgrade = "upgrade .*";
    private String LoadCustom = "load custom .*";
    private String RunMap = "run .*";
    private String SaveGame = "save game .*";
    private String LoadGame = "load game .*";
    private String Print = "print .*";
    private String Turn = "turn [0-9]*";
    private String GoVehicle = "(truck|helicopter) go";

    public void RequestAnalayzer(String requestString) {
        if (requestString.matches(BuyAnimals)) {
            new BuyRequest(requestString);
        } else if (requestString.matches(PickUp)) {
            new PickUpRequest(requestString);
        } else if (requestString.matches(Cage)) {
            new CageRequest(requestString);
        } else if (requestString.matches(Plant)) {
            new PlantRequest(requestString);
        } else if (requestString.matches(Well)) {
            new WellRequest(requestString);
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
