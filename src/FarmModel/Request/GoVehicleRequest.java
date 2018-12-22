package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;

public class GoVehicleRequest extends Request {
    private String vehicleName;

    public GoVehicleRequest(String requestLine) throws MissionNotLoaded {
        AnalyzeRequestLine(requestLine);
        if (getVehicleName().equals("truck")) {
            Truck truck = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getTruck();
            if (!truck.equals(null)) {
                truck.setRemainTurnToMoveObjectToCityAndComeBack(truck.getTurnToMoveObjectToCityAndComeBack());
                truck.setVehicleActivated(true);
            } else {
                //i don't know how to react here.
            }
        } else {
            Helicopter helicopter = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getHelicopter();
            if (!helicopter.equals(null)) {
                helicopter.setRemainTurnToMoveObjectToCityAndComeBack(helicopter.getRemainTurnToMoveObjectToCityAndComeBack());
                helicopter.setVehicleActivated(true);
            } else {
                //i don't know how to react here.
            }
        }
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String vehicleName = requestLine.split(" ")[0];
        setVehicleName(vehicleName);
    }

}