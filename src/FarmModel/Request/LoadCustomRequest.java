package FarmModel.Request;

public class LoadCustomRequest extends Request {
    private String pathToJsonFile;

    public LoadCustomRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);

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
