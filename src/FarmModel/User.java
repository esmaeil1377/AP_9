package FarmModel;
import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.ObjectInMap30_30.LiveAnimals.Chicken;
import FarmModel.ObjectInMap30_30.LiveAnimals.Cow;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.CakeBakery;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.EggPowderPlant;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String acountName;
    private int money;
    private Mission mission1=new Mission("mission1",50000,new Farm(null,null,null,null));
    private Mission mission2=new Mission("mission2",100000,new Farm(new Helicopter(),new Truck(),new Well(),new ArrayList<WorkShop>(Arrays.asList(new EggPowderPlant(),new CakeBakery(),new SewingFactory()))));
    private Mission mission3=new Mission("mission3",500,new Farm(null,new Truck(),null,null));
    private Mission mission4=new Mission("mission4",700,new Farm(new Helicopter(),null,null,null));
    private Mission currentPlayingMission;
    private ArrayList<WorkShop> customWorkShops=new ArrayList<>();
    //inja bayad tamam mission ha ro baraye missions az rouye ye pushe bezarim.
    private ArrayList<Mission> missions = new ArrayList<>();
    private GameShop gameShop = new GameShop();
    private InformationNeededInGame informationNeededInGame=new InformationNeededInGame();

    public InformationNeededInGame getInformationNeededInGame() {
        return informationNeededInGame;
    }
    public void AddcustomWorkshops(WorkShop custom){
        customWorkShops.add(custom);
    }

    public User(String accountName) {
        mission1.Addrequirement(new Egg(),10);
        mission2.Addrequirement(new Chicken(),15);
        mission3.Addrequirement(new Powder(),5);
        mission4.Addrequirement(new Cow(),3);
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
        if(currentPlayingMission!=null){
            return currentPlayingMission;
        }
        throw new MissionNotLoaded();
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
        for(Mission missions:getMissions()){
            if(missions.getMissionName().equals(mission.getMissionName())){
                getMissions().remove(missions);
                getMissions().add(mission);
                return;
            }
        }
        missions.add(mission);
    }

}
