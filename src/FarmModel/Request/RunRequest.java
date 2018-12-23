package FarmModel.Request;

import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.Mission;

public class RunRequest extends Request {
    private String mapName;

    public RunRequest(String requestLine) throws UnknownObjectException {
        AnalyzeRequestLine(requestLine);
        for(Mission mission: Game.getGameInstance().getCurrentUserAccount().getMissions()){
            if(mission.getMissionName().equals(getMapName())){
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(mission);
                return;
            }
        }
        throw new UnknownObjectException();
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
