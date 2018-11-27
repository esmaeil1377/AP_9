package FarmModel.Request;


public class SaveGameRequest extends Request {
//    public ObjectMapper mapper=new ObjectMapper();
    private String fileName;

    public SaveGameRequest(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
