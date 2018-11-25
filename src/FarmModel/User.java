package FarmModel;

import java.util.ArrayList;

public class User {
    private int money;
    ArrayList<Mission> Missions=new ArrayList<>();
    private GameShop gameShop=new GameShop();


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
    public void AddMissionToMissionsForUser(Mission mission){}

}
