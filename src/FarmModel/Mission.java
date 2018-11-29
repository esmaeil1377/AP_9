package FarmModel;

import java.util.ArrayList;

public class Mission {
    private int Reward;
    private int TimeTakeForPlayerToPlayTheMap;
    private FarmMap farmMap;
    private int time;


    public Mission(int reward, int timeTakeForPlayerToPlayTheMap, FarmMap farmMap, ArrayList<Object> ObjectForStartingTheMission) {
        Reward = reward;
        TimeTakeForPlayerToPlayTheMap = timeTakeForPlayerToPlayTheMap;
        this.farmMap = farmMap;
    }

    public void PutStartingObjectRandomlyInTheirPlace(ArrayList<Object> ObjectForStartingTheMission) {
    }

    public void setFarmMap(FarmMap farmMap) {
        this.farmMap = farmMap;
    }

    public FarmMap getFarmMap() {
        return farmMap;
    }
}
