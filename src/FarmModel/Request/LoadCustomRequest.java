package FarmModel.Request;

import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.WorkShop;
import com.gilecode.yagson.YaGson;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadCustomRequest extends Request {
    private String pathToJsonFiles;

    public LoadCustomRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(getPathToJsonFiles());
            Mission customMission;
            WorkShop customWorkshop;
            YaGson mapper = new YaGson();
            byte missionByte[] = fileInputStream.readAllBytes();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : missionByte) {
                stringBuilder.append(String.valueOf((char) b));
            }
            String objectString = stringBuilder.toString();
            fileInputStream.close();
            try {
                customMission = mapper.fromJson(objectString, Mission.class);
                Game.getGameInstance().getCurrentUserAccount().AddMissionToMissionsForUser(customMission);
            }catch (Exception e){
                System.out.println("The files processed was not a mission.");
            }
            try {
                customWorkshop=mapper.fromJson(objectString,WorkShop.class);
                Game.getGameInstance().getCurrentUserAccount().AddcustomWorkshops(customWorkshop);
            }catch (Exception e){
                System.out.println("The files processed was not a Workshop.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void setPathToJsonFiles(String pathToJsonFiles) {
        this.pathToJsonFiles = pathToJsonFiles;
    }

    public String getPathToJsonFiles() {
        return pathToJsonFiles;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String pathToJsonFile = requestLine.substring(12);
        setPathToJsonFiles(pathToJsonFile);
    }
}
