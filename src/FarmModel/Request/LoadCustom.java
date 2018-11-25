package FarmModel.Request;

public class LoadCustom extends Request {
    private String directory;

    public LoadCustom(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void AnalyzeRequestLine(String requestLIne){}
}
