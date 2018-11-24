package FarmModel.Request;

public class Clear extends Request {
    private String vehicleName;

    public Clear(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void AnalyzeRequestLine(String requestLine){}
}
