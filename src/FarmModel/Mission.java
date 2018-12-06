package FarmModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class Mission {
    private int startMoneyInMission;
    private int constantRewardAfterFinishingtheMission;
    private int TimeTakeForPlayerToFinishTheMap;
    private Farm farm;
    private boolean isMissionCompletedBefore = false;
    private HashMap<Object, Integer> requiermentToFinishTheMission = new HashMap<>();


    public Mission(int startMoneyInMission, int timeTakeForPlayerToPlayTheMap, Farm farm) {
        TimeTakeForPlayerToFinishTheMap = timeTakeForPlayerToPlayTheMap;
        this.farm = farm;
        this.startMoneyInMission=startMoneyInMission;
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

    public void GiveRewardToUser() {
    }

    public int CalcualteMoneyToGiveUserAfterCompletingTheMission(){
        //it is a function of timeplayerfinished the mission and other thing that i don't know
    }

    public boolean CheckIfMissionIsFinished() {
        boolean result = true;
        for (Object object : requiermentToFinishTheMission.keySet()) {
            if (object.toString().equals("Chicken")) {
                int numberofchicken = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMaxNumberOfChickenInMapToDetermineIfTheMissionIsFinished();
                if (!(numberofchicken < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Cow")) {
                int numberOfCow = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMaxNumberOfCowInMapToDetermineIfTheMissionIsFinished();
                if (!(numberOfCow < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Ship")) {
                int numberOfShip = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMaxNumberOfShipInMapToDetermineIfTheMissionIsFinished();
                if (!(numberOfShip < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Cat")) {
                int numberOfCat = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMaxNumberOfCatInMapToDetermineIfTheMissionIsFinished();
                if (!(numberOfCat < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Dog")) {
                int numberOfDog = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMaxNumberOfDogInMapToDetermineIfTheMissionIsFinished();
                if (!(numberOfDog < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else {
                int numberOfObjectInMapNeededForMissionToBeFinished=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getRecordNoteBookThatRecoredEveryThingAndNumbers().get(object.getClass());
                if(numberOfObjectInMapNeededForMissionToBeFinished<requiermentToFinishTheMission.get(object)){
                    result=false;
                }
            }
        }
        return result;
    }


}
