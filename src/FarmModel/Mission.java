package FarmModel;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.CityShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Mission implements Serializable {
    private String missionName;
    private int missionMoney;
    private Integer minute_1 = 0;
    private Integer minute_2 = 0;
    private Integer second_1 = 0;
    private Integer second_2 = 0;
    private Farm farm;
    private boolean isMissionCompletedBefore = false;
    private HashMap<Object, Integer> requirementToFinishTheMission = new HashMap<>();
    //determine for first mission what to buy from the city.
    private CityShop cityShop =new CityShop(new ArrayList<>(Arrays.asList()));
    // add time for player where is the time.

    void Addrequierment(Object object, int number){
        requirementToFinishTheMission.put(object,number);
    }

    public HashMap<Object, Integer> getRequirementToFinishTheMission() { return requirementToFinishTheMission; }

    public Integer getSecond_1() {
        return second_1;
    }

    public Integer getSecond_2() {
        return second_2;
    }

    public Integer getMinute_1() {
        return minute_1;
    }

    public Integer getMinute_2() {
        return minute_2;
    }

    public void setMinute_1(Integer minute_1) {
        this.minute_1 = minute_1;
    }

    public void setMinute_2(Integer minute_2) {
        this.minute_2 = minute_2;
    }

    public void setSecond_1(Integer second_1) {
        this.second_1 = second_1;
    }

    public void setSecond_2(Integer second_2) {
        this.second_2 = second_2;
    }

    public CityShop getCityShop() {
        return cityShop;
    }

    public String getMissionName() {
        return missionName;
    }
    public void ChangeMissionMoney(int Money){
        missionMoney+=Money;
    }


    public Mission(String missionName, int missionMoney, Farm farm) {
        this.missionName=missionName;
        this.farm = farm;
        this.missionMoney = missionMoney;
    }

    public int getMissionMoney() {
        return missionMoney;
    }

    public void setMissionMoney(int missionMoney) {
        this.missionMoney = missionMoney;
    }


    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }


    public int CalculateMoneyToGiveUserAfterCompletingTheMission() {
        //it is a function of timeplayerfinished the mission and other thing that i don't know
        int money= getMissionMoney()+100*(1/(minute_1*600+minute_2*60+second_1*10+second_2));
        return money;
    }

    public boolean CheckIfMissionIsFinished() throws MissionNotLoaded {
        boolean result = true;
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        for (Object object : requirementToFinishTheMission.keySet()) {
            if (object.toString().equals("Chicken")) {
                int numberofchicken = farm.getCurrentChickenInMap().size();
                if (numberofchicken < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            } else if (object.toString().equals("Cow")) {
                int numberOfCow = farm.getCurrentCowInMap().size();
                if (numberOfCow < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            } else if (object.toString().equals("Sheep")) {
                int numberOfShip = farm.getCurrentShipInMap().size();
                if (numberOfShip < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            } else if (object.toString().equals("Cat")) {
                int numberOfCat = farm.getCurrentCatInMap().size();
                if (numberOfCat < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            } else if (object.toString().equals("Dog")) {
                int numberOfDog = farm.getCurrentCatInMap().size();
                if (numberOfDog < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            } else {
                int numberOfObjectInMapNeededForMissionToBeFinished =0;
                try {
                    numberOfObjectInMapNeededForMissionToBeFinished = farm.getWareHouse().getRecordNoteBookThatRecordEveryThingAndNumbers().get(object.getClass());
                }catch (Exception e){}
                if (numberOfObjectInMapNeededForMissionToBeFinished < requirementToFinishTheMission.get(object)) {
                    result = false;
                }
            }
        }
        return result;
    }
}
