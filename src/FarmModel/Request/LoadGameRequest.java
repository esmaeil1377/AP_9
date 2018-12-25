package FarmModel.Request;

import FarmModel.Game;
import FarmModel.Mission;
import com.gilecode.yagson.YaGson;

import java.io.*;

public class LoadGameRequest extends Request {
    private String pathToJsonFile;

    public LoadGameRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        //We should consider something liked this
//        for(File file:new File(getPathToJsonFiles()))
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(getPathToJsonFile());
            Mission currentMission;
            YaGson mapper = new YaGson();
            byte missionByte[]=fileInputStream.readAllBytes();
            StringBuilder stringBuilder=new StringBuilder();
            for(byte b:missionByte){
                stringBuilder.append(String.valueOf((char)b));
            }
            String missionString=stringBuilder.toString();
            fileInputStream.close();

            currentMission=mapper.fromJson(missionString,Mission.class);
            Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(currentMission);
            Game.getGameInstance().getCurrentUserAccount().AddMissionToMissionsForUser(currentMission);


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
        String pathToJsonFile = requestLine.substring(10);
        setPathToJsonFile(pathToJsonFile);
    }


}
