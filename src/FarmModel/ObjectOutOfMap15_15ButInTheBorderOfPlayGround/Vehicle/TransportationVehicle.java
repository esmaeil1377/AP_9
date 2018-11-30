package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import java.util.ArrayList;

public class TransportationVehicle extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level = 0;
    private double turnToMoveObjectToCityAndComeBack;
    private int capacity;
    private int remainTurnToMoveObjectToCityAndComeBack;
    private ArrayList<Object> goodsThatCarry = new ArrayList<>();

    public void setGoodsThatCarry(ArrayList<Object> goodsThatCarry) {
        this.goodsThatCarry = goodsThatCarry;
    }

    public ArrayList<Object> getGoodsThatCarry() {
        return goodsThatCarry;
    }

    public void setRemainTurnToMoveObjectToCityAndComeBack(int remainTurnToMoveObjectToCity) {
        this.remainTurnToMoveObjectToCityAndComeBack = remainTurnToMoveObjectToCity;
    }

    public int getRemainTurnToMoveObjectToCityAndComeBack() {
        return remainTurnToMoveObjectToCityAndComeBack;
    }

    public int getLevel() {
        return Level;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setTurnToMoveObjectToCityAndComeBack(double turnToMoveObjectToCityAndComeBack) {
        this.turnToMoveObjectToCityAndComeBack = turnToMoveObjectToCityAndComeBack;
    }

    public double getTurnToMoveObjectToCityAndComeBack() {
        return turnToMoveObjectToCityAndComeBack;
    }

    public void UpgradeVehicle() {
        //increase in capacity
        //decrease in turnToMoveObjectToCityAndComeBack
    }
}
