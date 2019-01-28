package FarmModel;
import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.ObjectInMap15_15.LiveAnimals.Chicken;
import FarmModel.ObjectInMap15_15.LiveAnimals.Cow;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.FlouryCake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.*;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String acountName;
    private int money=1000;

    private int CatLevel;
    private int CakeBakeryLevel;
    private int CookieBakeryLevel;
    private int EggPowderPlantLevel;
    private int SewingFactoryLevel;
    private int SpinneryLevel;
    private int WeavingFactoryLevel;
    private int warehouseLevel;
    private int wellLevel;
    private int truckLevel;
    private int HelicopterLevel;
    private Mission mission1;
    private Mission mission2;
    private Mission mission3;
    private Mission mission4;
    private Mission currentPlayingMission;
    private ArrayList<WorkShop> customWorkShops=new ArrayList<>();
    //inja bayad tamam mission ha ro baraye missions az rouye ye pushe bezarim.
    private ArrayList<Mission> missions = new ArrayList<>();
    private GameShop gameShop = new GameShop();
    private InformationNeededInGame informationNeededInGame=new InformationNeededInGame();

    public void ReNewMissions() throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded, MaxLevelExceeded {
        try {
            Mission currentMission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
            if (currentMission.getMissionName().equals("mission1")) {
                mission1 = new Mission("mission1", 500, new Farm(null, new Truck(0), null, null));
                mission1.Addrequierment(new Egg(), 10);
            } else if (currentMission.getMissionName().equals("mission2")) {
                mission2 = new Mission("mission2", 700, new Farm(null, new Truck(0), null, null));
                mission2.Addrequierment(new Chicken(), 5);

            } else if (currentMission.getMissionName().equals("mission3")) {
                mission3 = new Mission("mission3", 50000, new Farm(new Helicopter(0), new Truck(0), null, new ArrayList<>(Arrays.asList(new EggPowderPlant(0)))));
                mission3.Addrequierment(new Powder(), 5);

            } else if (currentMission.getMissionName().equals("mission4")) {
                mission4 = new Mission("mission4", 100000, new Farm(new Helicopter(0), new Truck(0), new Well(0), new ArrayList<WorkShop>(Arrays.asList(new EggPowderPlant(0), new CakeBakery(0), new SewingFactory(0), new CookieBakery(0), new Spinnery(0), new WeavingFactory(0)))));
                mission4.Addrequierment(new Cow(), 3);
                mission4.Addrequierment(new FlouryCake(), 3);
            }
        }catch (Exception e){
            mission1 = new Mission("mission1", 500, new Farm(null, new Truck(0), null, null));
            mission1.Addrequierment(new Egg(), 10);
            mission2 = new Mission("mission2", 700, new Farm(null, new Truck(0), null, null));
            mission2.Addrequierment(new Chicken(), 5);
            mission3 = new Mission("mission3", 50000, new Farm(new Helicopter(0), new Truck(0), null, new ArrayList<>(Arrays.asList(new EggPowderPlant(0)))));
            mission3.Addrequierment(new Powder(), 5);
            mission4 = new Mission("mission4", 100000, new Farm(new Helicopter(0), new Truck(0), new Well(0), new ArrayList<WorkShop>(Arrays.asList(new EggPowderPlant(0), new CakeBakery(0), new SewingFactory(0), new CookieBakery(0), new Spinnery(0), new WeavingFactory(0)))));
            mission4.Addrequierment(new Cow(), 3);
            mission4.Addrequierment(new FlouryCake(), 3);

        }
        missions = new ArrayList<>();
        AddMissionToMissionsForUser(mission1);
        AddMissionToMissionsForUser(mission2);
        AddMissionToMissionsForUser(mission3);
        AddMissionToMissionsForUser(mission4);
    }



    public User(String accountName) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded, MaxLevelExceeded {
        ReNewMissions();
        setAccountName(accountName);

        // Add users its missions
    }

    public Mission getMission1() {
        return mission1;
    }

    public int getHelicopterLevel() {
        return HelicopterLevel;
    }

    public int getTruckLevel() {
        return truckLevel;
    }

    public void setHelicopterLevel(int helicopterLevel) {
        HelicopterLevel = helicopterLevel;
    }

    public void setTruckLevel(int truckLevel) {
        this.truckLevel = truckLevel;
    }

    public int getWarehouseLevel() {
        return warehouseLevel;
    }

    public int getWellLevel() {
        return wellLevel;
    }

    public void setWellLevel(int wellLevel) {
        this.wellLevel = wellLevel;
    }

    public void setWarehouseLevel(int warehouseLevel) {
        this.warehouseLevel = warehouseLevel;
    }

    public Mission getMission2() {
        return mission2;
    }

    public Mission getMission3() {
        return mission3;
    }

    public Mission getMission4() {
        return mission4;
    }

    public int getCatLevel() {
        return CatLevel;
    }

    public void setCatLevel(int catLevel) {
        CatLevel = catLevel;
    }

    public int getCakeBakeryLevel() {
        return CakeBakeryLevel;
    }

    public void setCakeBakeryLevel(int cakeBakeryLevel) {
        CakeBakeryLevel = cakeBakeryLevel;
    }

    public int getCookieBakeryLevel() {
        return CookieBakeryLevel;
    }

    public void setCookieBakeryLevel(int cookieBakeryLevel) {
        CookieBakeryLevel = cookieBakeryLevel;
    }

    public int getEggPowderPlantLevel() {
        return EggPowderPlantLevel;
    }

    public void setEggPowderPlantLevel(int eggPowderPlantLevel) {
        EggPowderPlantLevel = eggPowderPlantLevel;
    }

    public int getSewingFactoryLevel() {
        return SewingFactoryLevel;
    }

    public void setSewingFactoryLevel(int sewingFactoryLevel) {
        SewingFactoryLevel = sewingFactoryLevel;
    }

    public int getSpinneryLevel() {
        return SpinneryLevel;
    }

    public void setSpinneryLevel(int spinneryLevel) {
        SpinneryLevel = spinneryLevel;
    }

    public int getWeavingFactoryLevel() {
        return WeavingFactoryLevel;
    }

    public void setWeavingFactoryLevel(int weavingFactoryLevel) {
        WeavingFactoryLevel = weavingFactoryLevel;
    }
    public InformationNeededInGame getInformationNeededInGame() {
        return informationNeededInGame;
    }

    public void AddcustomWorkshops(WorkShop custom){
        customWorkShops.add(custom);
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

    public String getAccountName() {
        return acountName;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
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
