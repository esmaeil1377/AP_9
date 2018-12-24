package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.Mission;
import com.gilecode.yagson.YaGson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class SaveGameRequest extends Request {
    //    public ObjectMapper mapper=new ObjectMapper();
    private String pathToJsonFile;


    public SaveGameRequest(String requestLine) throws MissionNotLoaded {
        AnalyzeRequestLine(requestLine);

        Mission currentMission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
        File file = new File(getPathToJsonFile()+"\\"+currentMission.getMissionName()+".txt");
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            YaGson mapper = new YaGson();
            String objectJson = mapper.toJson(currentMission, Mission.class);

            byte[] bytesObject = objectJson.getBytes();
            fileOutputStream.write(bytesObject);
            fileOutputStream.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
        }
    }

    public String getPathToJsonFile() {
        return pathToJsonFile;
    }

    public void setPathToJsonFile(String pathToJsonFile) {
        this.pathToJsonFile = pathToJsonFile;
    }

    private void AnalyzeRequestLine(String requestLine) {
        String pathToJsonFile = requestLine.substring(10);
        setPathToJsonFile(pathToJsonFile);
    }
    private String changeToPath(String path){
        String res="";
        for(int character=0;character<path.length();character++){
            if(path.charAt(character)=='\\'){

            }
        }
        return res;
    }
}
