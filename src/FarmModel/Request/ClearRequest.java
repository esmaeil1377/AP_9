package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;

public class ClearRequest extends Request {
    private String vehicleName;

    public ClearRequest(String request) throws MissionNotLoaded {
        AnalyzeRequestLine(request);
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        if (vehicleName.equals("truck")) {
            Truck truck = farm.getTruck();
            truck.getGoodsThatHaveToCarry().clear();
        } else if (vehicleName.equals("helicopter")) {

            Helicopter helicopter = farm.getHelicopter();
            helicopter.getGoodsThatHaveToCarry().clear();
        }
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] request = requestLine.split(" ");
        String vehicleName = request[0];
    }
}
