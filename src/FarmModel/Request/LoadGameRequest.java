package FarmModel.Request;

import FarmModel.Game;
import FarmModel.Mission;
import com.gilecode.yagson.YaGson;

import java.io.*;

public class LoadGameRequest extends Request {
    private String pathToJsonFile;

    public LoadGameRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(pathToJsonFile);
            Mission currentMission;
            YaGson mapper = new YaGson();
            String missinString=fileInputStream.toString();
            fileInputStream.close();

            currentMission=(Mission)mapper.fromJson(missinString,Mission.class);
            Game.getGameInstance().getCurrentUserAcount().setCurrentPlayingMission(currentMission);
            Game.getGameInstance().getCurrentUserAcount().AddMissionToMissionsForUser(currentMission);


        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
        }
    }

    public void setPathToJsonFile(String pathToJsonFile) {
        this.pathToJsonFile = pathToJsonFile;
    }

    public String getPathToJsonFile() {
        return pathToJsonFile;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String pathToJsonFile = requestLine.substring(12);
        setPathToJsonFile(pathToJsonFile);
    }


}
