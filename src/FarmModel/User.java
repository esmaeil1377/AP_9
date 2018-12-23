package FarmModel;
import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.CakeBakery;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String acountName;
    private int money;
    private Mission mission1=new Mission("mission1",1000,new Farm(null,null,null));
    private Mission mission2=new Mission("mission2",1000,new Farm(null,null,new ArrayList<WorkShop>(Arrays.asList(new CakeBakery()))));
    private Mission mission3=new Mission("mission3",500,new Farm(null,new Truck(),null));
    private Mission mission4=new Mission("mission4",700,new Farm(new Helicopter(),null,null));
    private Mission currentPlayingMission;
    //inja bayad tamam mission ha ro baraye missions az rouye ye pushe bezarim.
    private ArrayList<Mission> missions = new ArrayList<>();
    private GameShop gameShop = new GameShop();

    public User(String accountName) {
        setAccountName(accountName);
        AddMissionToMissionsForUser(mission1);
        AddMissionToMissionsForUser(mission2);
        AddMissionToMissionsForUser(mission3);
        AddMissionToMissionsForUser(mission4);
        // Add users its missions
    }

    public GameShop getGameShop() {
        return gameShop;
    }

    public Mission getCurrentPlayingMission() throws MissionNotLoaded {
        try {
            int startMoney=currentPlayingMission.getStartMoneyInMission();
            return currentPlayingMission;

        }catch (NullPointerException e){
            throw new MissionNotLoaded();
        }
    }

    public void setCurrentPlayingMission(Mission currentPlayingMission) {
        this.currentPlayingMission = currentPlayingMission;
    }

    private void setAccountName(String acountName) {
        this.acountName = acountName;
    }

    public String getAcountName() {
        return acountName;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public void setGameShop(GameShop gameShop) {
        this.gameShop = gameShop;
    }

    private int getMoney() {
        return money;
    }

    public void AddMoney(int amountIncreaseMoney) {
        int nowMoney = getMoney();
        setMoney(nowMoney + amountIncreaseMoney);
    }

    public void AddMissionToMissionsForUser(Mission mission) {
        missions.add(mission);
    }

}
