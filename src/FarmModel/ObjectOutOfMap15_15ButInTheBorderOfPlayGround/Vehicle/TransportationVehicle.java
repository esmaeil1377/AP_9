package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

public class TransportationVehicle extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level=0;
    private double TimeToMoveThePath;

    public void setTimeToMoveThePath(double timeToMoveThePath) {
        TimeToMoveThePath = timeToMoveThePath;
    }

    public double getTimeToMoveThePath() {
        return TimeToMoveThePath;
    }

    public void UpgradeVehicle(){}
}
