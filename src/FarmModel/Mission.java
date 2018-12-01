package FarmModel;

import java.util.ArrayList;
import java.util.HashMap;

public class Mission {
    private int Reward;
    private int TimeTakeForPlayerToPlayTheMap;
    private Farm farm;
    private int time;
    private boolean isMissionCompletedBefore=false;
    private HashMap<Object,Integer> requiermentToFinishTheMission=new HashMap<>();



    public Mission(int reward, int timeTakeForPlayerToPlayTheMap, Farm farm, ArrayList<Object> ObjectForStartingTheMission) {
        Reward = reward;
        TimeTakeForPlayerToPlayTheMap = timeTakeForPlayerToPlayTheMap;
        this.farm = farm;
    }

    public void PutStartingObjectRandomlyInTheirPlace(ArrayList<Object> ObjectForStartingTheMission) {
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }

    public void GiveRewardToUser(){}
}
