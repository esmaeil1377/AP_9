package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import java.util.ArrayList;

public abstract class TransportationVehicle extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level = 0;
    private int turnToMoveObjectToCityAndComeBack;
    private int capacity;
    private int remainTurnToMoveObjectToCityAndComeBack;
    private ArrayList<Object> goodsThatCarry = new ArrayList<>();
    private boolean isVehicleActivated = false;

    public void setLevel(int level) {
        Level = level;
    }

    public void setVehicleActivated(boolean vehicleActivated) {
        isVehicleActivated = vehicleActivated;
    }

    public boolean IsVehicleActivated() {
        return isVehicleActivated;
    }

    void setGoodsThatHaveToCarry(ArrayList<Object> goodsThatCarry) {
        this.goodsThatCarry = goodsThatCarry;
    }

    public ArrayList<Object> getGoodsThatHaveToCarry() {
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

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    void setTurnToMoveObjectToCityAndComeBack(int turnToMoveObjectToCityAndComeBack) {
        this.turnToMoveObjectToCityAndComeBack = turnToMoveObjectToCityAndComeBack;
    }

    public int getTurnToMoveObjectToCityAndComeBack() {
        return turnToMoveObjectToCityAndComeBack;
    }

    public static int CalculatePriceToBuyForHelicopter(ArrayList<Object> goods) {
        int price = 0;
        for (Object object : goods) {
            price+=InformationNeededInGame.getInformationNeededInGame().getPriceToBuy(object);
        }
        return price;
    }

    public static int CalculatePriceForSellForTruck(ArrayList<Object> goods) {
        int price = 0;
        for (Object object : goods) {
            price+=InformationNeededInGame.getInformationNeededInGame().getPriceForSell(object);
            // add new if for other workshop product
        }
        return price;
    }
}
