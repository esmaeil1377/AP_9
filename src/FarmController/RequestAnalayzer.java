package FarmController;

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

    public void RequestAnalayzer(String requestString){
    }
}