package FarmModel.Request;

import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;

public class GoVehicleRequest extends Request {
    private String vehicleName;

    public GoVehicleRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        int lastIndexOfVehicleName = 0;
        for (int charindex = 0; charindex < requestLine.length(); charindex++) {
            if (requestLine.charAt(charindex) == ' ') {
                lastIndexOfVehicleName = charindex - 1;
                break;
            }
        }
        String vehicleName = requestLine.substring(0, lastIndexOfVehicleName);
        if (vehicleName.equals("truck")) {
            Truck truck=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getTruck();
            truck.setRemainTurnToMoveObjectToCityAndComeBack(truck.getTurnToMoveObjectToCityAndComeBack());
            truck.setVehicleActivated(true);
        } else {
            Helicopter helicopter=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getHelicopter();
            helicopter.setRemainTurnToMoveObjectToCityAndComeBack(helicopter.getRemainTurnToMoveObjectToCityAndComeBack());
            helicopter.setVehicleActivated(true);
        }
    }
}
