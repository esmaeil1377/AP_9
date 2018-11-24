package FarmModel.Request;

public class LoadGame extends Request {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LoadGame(String fileName) {
        this.fileName = fileName;
    }
}
