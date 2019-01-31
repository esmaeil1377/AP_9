package FarmModel;
import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.ObjectInMap15_15.LiveAnimals.Chicken;
import FarmModel.ObjectInMap15_15.LiveAnimals.Cow;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.CarnivalDress;
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
    private int isMission1Ficnished=0;
    private int isMission2Ficnished=0;
    private int isMission3Ficnished=0;
    private int isMission4Ficnished=0;
    private int money=100000;

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

    public void setMissionFinished(Mission mission){
        String missionName=mission.getMissionName();
        if (missionName.equals("mission1")){
            isMission1Ficnished=1;
        }else if (missionName.equals("mission2")){
            isMission2Ficnished=1;
        }else if (missionName.equals("mission3")){
            isMission3Ficnished=1;
        }else if (missionName.equals("mission4")){
            isMission4Ficnished=1;
        }
    }

    public int getUserLevel(){
        int result=0;
        result+=isMission1Ficnished;
        result +=isMission2Ficnished;
        result+=isMission3Ficnished;
        result+=isMission4Ficnished;
        return result;
    }

    public void RenewMissions() throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded, MaxLevelExceeded {
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
        RenewMissions();
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

    public void setHelicopterLevel(int helicopterLevel) throws MaxLevelExceeded {
        if(helicopterLevel == 4)
            throw new MaxLevelExceeded();
        HelicopterLevel = helicopterLevel;
    }

    public void setTruckLevel(int truckLevel) throws MaxLevelExceeded {
        if(truckLevel == 4)
            throw new MaxLevelExceeded();
        this.truckLevel = truckLevel;
    }

    public int getWarehouseLevel() {
        return warehouseLevel;
    }

    public int getWellLevel() {
        return wellLevel;
    }

    public void setWellLevel(int wellLevel) throws MaxLevelExceeded {
        if (wellLevel == 3) {
            throw new MaxLevelExceeded();
        }
        this.wellLevel = wellLevel;
    }

    public void setWarehouseLevel(int warehouseLevel) throws MaxLevelExceeded {
        if(warehouseLevel == 4)
            throw new MaxLevelExceeded();
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

    public void setCatLevel(int catLevel) throws MaxLevelExceeded {
        if (CatLevel==1){
            throw new MaxLevelExceeded();
        }
        CatLevel = catLevel;
    }

    public int getCakeBakeryLevel() {
        return CakeBakeryLevel;
    }

    public void setCakeBakeryLevel(int cakeBakeryLevel) throws MaxLevelExceeded {
        if (CakeBakeryLevel==4){
            throw new MaxLevelExceeded();
        }
        CakeBakeryLevel = cakeBakeryLevel;
    }

    public int getCookieBakeryLevel() {
        return CookieBakeryLevel;
    }

    public void setCookieBakeryLevel(int cookieBakeryLevel) throws MaxLevelExceeded {
        if (CookieBakeryLevel==4){
            throw new MaxLevelExceeded();
        }
        CookieBakeryLevel = cookieBakeryLevel;
    }

    public int getEggPowderPlantLevel() {
        return EggPowderPlantLevel;
    }

    public void setEggPowderPlantLevel(int eggPowderPlantLevel) throws MaxLevelExceeded {
        if (EggPowderPlantLevel==4){
            throw new MaxLevelExceeded();
        }
        EggPowderPlantLevel = eggPowderPlantLevel;
    }

    public int getSewingFactoryLevel() {
        return SewingFactoryLevel;
    }

    public void setSewingFactoryLevel(int sewingFactoryLevel) throws MaxLevelExceeded {
        if (SewingFactoryLevel==4){
            throw new MaxLevelExceeded();
        }
        SewingFactoryLevel = sewingFactoryLevel;
    }

    public int getSpinneryLevel() {
        return SpinneryLevel;
    }

    public void setSpinneryLevel(int spinneryLevel) throws MaxLevelExceeded {
        if (SpinneryLevel==4){
            throw new MaxLevelExceeded();
        }
        SpinneryLevel = spinneryLevel;
    }

    public int getWeavingFactoryLevel() {
        return WeavingFactoryLevel;
    }

    public void setWeavingFactoryLevel(int weavingFactoryLevel) throws MaxLevelExceeded {
        if (WeavingFactoryLevel==4){
            throw new MaxLevelExceeded();
        }
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
