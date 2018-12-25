package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;

public class GoVehicleRequest extends Request {
    private String vehicleName;

    public GoVehicleRequest(String requestLine) throws MissionNotLoaded {
        AnalyzeRequestLine(requestLine);
        if (getVehicleName().equals("Truck")) {
            Truck truck = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
            if (truck!=null) {
                truck.setRemainTurnToMoveObjectToCityAndComeBack(truck.getTurnToMoveObjectToCityAndComeBack());
                truck.setVehicleActivated(true);
            } else {
                System.out.println("Mission don't have truck");
            }
        } else {
            Helicopter helicopter = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getHelicopter();
            if (helicopter!=null) {
                helicopter.setRemainTurnToMoveObjectToCityAndComeBack(helicopter.getTurnToMoveObjectToCityAndComeBack());
                helicopter.setVehicleActivated(true);
            } else {
                System.out.println("Mission don't have helicopter");
            }
        }
    }

    private String getVehicleName() {
        return vehicleName;
    }

    private void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String vehicleName = requestLine.split(" ")[0];
        setVehicleName(vehicleName);
    }

}