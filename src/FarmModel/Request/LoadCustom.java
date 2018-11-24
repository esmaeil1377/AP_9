package FarmModel.Request;

public class LoadCustom extends Request {
    private String directory;

    public LoadCustom(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
