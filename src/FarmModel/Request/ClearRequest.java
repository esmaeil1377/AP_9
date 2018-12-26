package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;

public class ClearRequest extends Request {
    private String vehicleName;

    public ClearRequest(String request) throws MissionNotLoaded {
        AnalyzeRequestLine(request);
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        if (getVehicleName().equals("truck")) {
            Truck truck = farm.getTruck();
            truck.getGoodsThatHaveToCarry().clear();
        } else if (vehicleName.equals("helicopter")) {

            Helicopter helicopter = farm.getHelicopter();
            helicopter.getGoodsThatHaveToCarry().clear();
        }
    }

    private String getVehicleName() {
        return vehicleName;
    }

    private void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] request = requestLine.split(" ");
        setVehicleName(request[0]);
    }
}
