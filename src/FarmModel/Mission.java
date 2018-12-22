package FarmModel;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.CityShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Mission implements Serializable {
    private String missionName;
    private int startMoneyInMission;
    private int TimeTakeForPlayerToFinishTheMap;
    private Farm farm;
    private boolean isMissionCompletedBefore = false;
    private HashMap<Object, Integer> requirementToFinishTheMission = new HashMap<>();
    //determine for first mission what to buy from the city.
    private CityShop cityShop =new CityShop(new ArrayList<>(Arrays.asList()));
    // add time for player where is the time.


    public CityShop getCityShop() {
        return cityShop;
    }

    public Mission(String missionName,int startMoneyInMission, int timeTakeForPlayerToPlayTheMap, Farm farm) {
        this.missionName=missionName;
        TimeTakeForPlayerToFinishTheMap = timeTakeForPlayerToPlayTheMap;
        this.farm = farm;
        this.startMoneyInMission = startMoneyInMission;
    }

    public int getStartMoneyInMission() {
        return startMoneyInMission;
    }

    public void setStartMoneyInMission(int startMoneyInMission) {
        this.startMoneyInMission = startMoneyInMission;
    }

    public int getTimeTakeForPlayerToFinishTheMap() {
        return TimeTakeForPlayerToFinishTheMap;
    }

    public void setTimeTakeForPlayerToFinishTheMap(int timeTakeForPlayerToFinishTheMap) {
        TimeTakeForPlayerToFinishTheMap = timeTakeForPlayerToFinishTheMap;
    }

    public boolean isMissionCompletedBefore() {
        return isMissionCompletedBefore;
    }

    public void setMissionCompletion(boolean missionCompletedBefore) {
        isMissionCompletedBefore = missionCompletedBefore;
    }

    public void PutStartingObjectRandomlyInTheirPlace(ArrayList<Object> ObjectForStartingTheMission) {
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }


    public int CalculateMoneyToGiveUserAfterCompletingTheMission() {
        //it is a function of timeplayerfinished the mission and other thing that i don't know
        int money=getStartMoneyInMission()+100*(1/getTimeTakeForPlayerToFinishTheMap());
        return money;
    }

    public boolean CheckIfMissionIsFinished() throws MissionNotLoaded {
        boolean result = true;
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        for (Object object : requirementToFinishTheMission.keySet()) {
            if (object.toString().equals("Chicken")) {
                int numberofchicken = farm.getCurrentChickenInMap().size();
                if (!(numberofchicken < requirementToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Cow")) {
                int numberOfCow = farm.getCurrnetCowInMap().size();
                if (!(numberOfCow < requirementToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Sheep")) {
                int numberOfShip = farm.getCurrnetShipInMap().size();
                if (!(numberOfShip < requirementToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Cat")) {
                int numberOfCat = farm.getCurrentCatInMap().size();
                if (!(numberOfCat < requirementToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Dog")) {
                int numberOfDog = farm.getCurrentCatInMap().size();
                if (!(numberOfDog < requirementToFinishTheMission.get(object))) {
                    result = false;
                }
            } else {
                int numberOfObjectInMapNeededForMissionToBeFinished = farm.getWareHouse().getRecordNoteBookThatRecordEveryThingAndNumbers().get(object.getClass());
                if (numberOfObjectInMapNeededForMissionToBeFinished < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            }
        }
        return result;
    }
}
