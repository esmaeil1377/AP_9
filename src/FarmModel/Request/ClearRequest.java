package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.TransportationVehicle;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;

import java.util.ArrayList;

public class ClearRequest extends Request {
    private String vehicleName;

    public ClearRequest(String request) throws MissionNotLoaded {
        AnalyzeRequestLine(request);
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        if (getVehicleName().equals("truck")) {
            Truck truck = farm.getTruck();
            if(!truck.IsVehicleActivated()) {
                truck.getGoodsThatHaveToCarry().clear();
            }
        } else if (vehicleName.equals("helicopter")) {
            Helicopter helicopter = farm.getHelicopter();
            //here we should add money to user
            ArrayList<Object> list=helicopter.getGoodsThatHaveToCarry();
            int price= TransportationVehicle.CalculatePriceToBuyForHelicopter(list);
            if(!helicopter.IsVehicleActivated()) {
                helicopter.getGoodsThatHaveToCarry().clear();
            }
            Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().ChangeMissionMoney(price);
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
