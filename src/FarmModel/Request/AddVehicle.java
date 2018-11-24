package FarmModel.Request;

public class AddVehicle extends Request {
    private String vehicleName;
    private String itemName;
    private int count;

    public AddVehicle(String vehicleName, String itemName, int count) {
        this.vehicleName = vehicleName;
        this.itemName = itemName;
        this.count = count;
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
}
