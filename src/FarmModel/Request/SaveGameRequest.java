package FarmModel.Request;

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


    public SaveGameRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);

        File file = new File(pathToJsonFile);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            Mission currentMission = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission();
            YaGson mapper = new YaGson();
            String objectJson = mapper.toJson(currentMission, Mission.class);

            byte[] bytesobject = objectJson.getBytes();
            fileOutputStream.write(bytesobject);
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
}
