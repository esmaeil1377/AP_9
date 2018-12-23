package FarmModel.Request;

import FarmModel.Game;
import FarmModel.Mission;

public class RunRequest extends Request {
    private String mapName;

    public RunRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        for(Mission mission: Game.getGameInstance().getCurrentUserAcount().getMissions()){
            if(mission.getMissionName().equals(getMapName())){
                Game.getGameInstance().getCurrentUserAcount().setCurrentPlayingMission(mission);
                return;
            }
        }
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String MapName=requestLine.substring(4);
        setMapName(MapName);
    }
}
