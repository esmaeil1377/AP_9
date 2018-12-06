package FarmModel.Request;

import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class AddVehicleRequest extends Request {
    private String vehicleName;
    private String itemName;
    private int count;

    public AddVehicleRequest(String request) {
        AnalyzeRequestLine(request);
        Farm farm=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse=farm.getWareHouse();
        if(vehicleName.equals("truck")){
            Truck truck=farm.getTruck();


        }else if(vehicleName.equals("helicopter")){
            farm.getHelicopter()
        }
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
        String[] request=requestLine.split(" ");
        String vehicleName=request[0];
        String itemName=request[2];
        int Count = Integer.valueOf(request[3]);
        setCount(Count);
        setItemName(itemName);
        setVehicleName(vehicleName);

    }
}
