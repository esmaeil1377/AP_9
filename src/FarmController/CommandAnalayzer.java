package FarmController;

public class CommandAnalayzer {
    private String BuyAnimals="buy (cat|dog)";
    private String PickUp=" pickup [0-9] [0-9]";
    private String Cage="cage [0-9][0-9]";
    private String Plant="plant [0-9][0-9]";
    private String Well="well";
    private String StartWorkShop="start .*";
    private String Upgrade="upgrade .*";
    private String LoadCustom="load custom .*";
    private String RunMap="run .*";
}
