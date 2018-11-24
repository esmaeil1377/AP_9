package FarmModel.Request;

public class SaveGame extends Request {
    private String fileName;

    public SaveGame(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
