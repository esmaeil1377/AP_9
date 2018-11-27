package FarmModel.Request;

public class AddVehicleRequest extends Request {
    private String vehicleName;
    private String itemName;
    private int count;

    public AddVehicleRequest(String request) {
        AnalyzeRequestLine(request);

    }


    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void AnalyzeRequestLine(String requestLine){
    }
}
