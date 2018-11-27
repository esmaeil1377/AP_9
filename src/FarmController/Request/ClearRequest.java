package FarmController.Request;

public class ClearRequest extends Request {
    private String vehicleName;

    public ClearRequest(String requestLine) {
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
