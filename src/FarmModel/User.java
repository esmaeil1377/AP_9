package FarmModel;

import java.util.ArrayList;

public class User {
    private String acountName;
    private int money;
    private Mission currentPlayingMission;
    //inja bayad tamam mission ha ro baraye Missions az rouye ye pushe bezarim.
    private ArrayList<Mission> Missions = new ArrayList<>();
    private GameShop gameShop = new GameShop();

    public User(String acountName) {
        this.acountName = acountName;
    }

    public GameShop getGameShop() {
        return gameShop;
    }

    public Mission getCurrentPlayingMission() {
        return currentPlayingMission;
    }

    public void setCurrentPlayingMission(Mission currentPlayingMission) {
        this.currentPlayingMission = currentPlayingMission;
    }

    public void setAcountName(String acountName) {
        this.acountName = acountName;
    }

    public String getAcountName() {
        return acountName;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Mission> getMissions() {
        return Missions;
    }

    public void setGameShop(GameShop gameShop) {
        this.gameShop = gameShop;
    }

    public int getMoney() {
        return money;
    }

    public void AddMoney(int amountIncreaseMoney) {
        int nowMoney = getMoney();
        setMoney(nowMoney + amountIncreaseMoney);
    }

    public void AddMissionToMissionsForUser(Mission mission) {
    }

}
