package FarmController.Request;

public class LoadGameRequest extends Request {
    private String fileName;

    public LoadGameRequest(String requestLine){
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
