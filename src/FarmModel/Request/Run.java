package FarmModel.Request;

public class Run extends Request {
    private String mapName;

    public Run(String mapName) {
        this.mapName = mapName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
