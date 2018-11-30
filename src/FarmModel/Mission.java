package FarmModel;

import java.util.ArrayList;

public class Mission {
    private int Reward;
    private int TimeTakeForPlayerToPlayTheMap;
    private Farm farm;
    private int time;


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
}
