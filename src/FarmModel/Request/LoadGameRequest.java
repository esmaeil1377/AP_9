package FarmModel.Request;

import FarmModel.Game;
import com.gilecode.yagson.YaGson;

import java.io.*;
import FarmModel.User;

public class LoadGameRequest extends Request {
    private String pathToJsonFile;
    private User newUser;

    public LoadGameRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        //We should consider something liked this
//        for(File file:new File(getPathToJsonFiles()))
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(getPathToJsonFile());
            User currentUser;
            YaGson mapper = new YaGson();
            byte missionByte[]=fileInputStream.readAllBytes();
            StringBuilder stringBuilder=new StringBuilder();
            for(byte b:missionByte){
                stringBuilder.append(String.valueOf((char)b));
            }
            String userString=stringBuilder.toString();
            fileInputStream.close();

            currentUser=mapper.fromJson(userString,User.class);
//            Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(currentUser);
//            Game.getGameInstance().getCurrentUserAccount().AddMissionToMissionsForUser(currentUser);
            Game.getGameInstance().setCurrentUserAccount(currentUser);


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
