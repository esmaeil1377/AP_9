package FarmModel.Request;

public class RunRequest extends Request {
    private String mapName;

    public RunRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String MapName=requestLine.substring(4);
        setMapName(MapName);
    }
}
