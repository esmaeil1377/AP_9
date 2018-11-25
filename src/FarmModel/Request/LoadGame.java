package FarmModel.Request;

public class LoadGame extends Request {
    private String fileName;

    public LoadGame(String requestLine){
        AnalyzeRequestLine(requestLine);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void AnalyzeRequestLine(String requestLine){}


}
