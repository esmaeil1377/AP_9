package FarmController;

import FarmModel.Request.BuyRequest;

public class RequestAnalayzer {
    private String BuyAnimals="buy (cat|dog)";
    private String PickUp=" pickup [0-9] [0-9]";
    private String Cage="cage [0-9][0-9]";
    private String Plant="plant [0-9][0-9]";
    private String Well="well";
    private String StartWorkShop="start .*";
    private String Upgrade="upgrade .*";
    private String LoadCustom="load custom .*";
    private String RunMap="run .*";
    private String SaveGame="save game .*";
    private String LoadGame="load game .*";
    private String Print="print .*";
    private String Turn="turn [0-9]*";
    private String GoVehicle="(truck|helicopter) go";

    public void RequestAnalayzer(String requestString){
        if(requestString.matches(BuyAnimals)){
            new BuyRequest(requestString);
        }
        else if(requestString.matches(PickUp)){}
        else if(requestString.matches(Cage)){}
        else if(requestString.matches(Plant)){}
        else if(requestString.matches(PickUp)){}
        else if(requestString.matches(Cage)){}
        else if(requestString.matches(PickUp)){}
        else if(requestString.matches(PickUp)){}
        else if(requestString.matches(PickUp)){}
        else if(requestString.matches(PickUp)){}
        else if(requestString.matches(PickUp)){}
        else {}
    }
}
