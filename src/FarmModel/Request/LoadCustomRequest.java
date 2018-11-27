package FarmModel.Request;

public class LoadCustomRequest extends Request {
    private String directory;

    public LoadCustomRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void AnalyzeRequestLine(String requestLIne) {
    }
}
