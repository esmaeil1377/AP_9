package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

public class TransportationVehicle extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level=0;
    private double turnToMoveObjectToCity;
    private int capacity;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setTurnToMoveObjectToCity(double turnToMoveObjectToCity) {
        this.turnToMoveObjectToCity = turnToMoveObjectToCity;
    }

    public double getTurnToMoveObjectToCity() {
        return turnToMoveObjectToCity;
    }

    public void UpgradeVehicle(){
        //increase in capacity
        //decrease in turnToMoveObjectToCity
    }
}
