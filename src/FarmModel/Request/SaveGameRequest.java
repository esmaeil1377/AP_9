package FarmModel.Request;
import org.json.*;
import 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class SaveGameRequest extends Request {
    //    public ObjectMapper mapper=new ObjectMapper();
    private String pathToJsonFile;

    public SaveGameRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        File file=new File(pathToJsonFile);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String getPathToJsonFile() {
        return pathToJsonFile;
    }

    public void setPathToJsonFile(String pathToJsonFile) {
        this.pathToJsonFile = pathToJsonFile;
    }

    private void AnalyzeRequestLine(String requestLine){
        String pathToJsonFile=requestLine.substring(10);
        setPathToJsonFile(pathToJsonFile);
    }
}
