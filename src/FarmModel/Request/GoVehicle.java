package FarmModel.Request;

public class GoVehicle extends Request {
    private String vehicleName;

    public GoVehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
