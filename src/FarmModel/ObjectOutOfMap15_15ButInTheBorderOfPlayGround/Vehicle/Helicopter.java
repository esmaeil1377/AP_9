package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import java.util.ArrayList;

public class Helicopter extends TransportationVehicle {
    private ArrayList<Object> goodsThatCarry = new ArrayList<>();

    public void setGoodsThatCarry(ArrayList<Object> goodsThatCarry) {
        this.goodsThatCarry = goodsThatCarry;
    }

    public ArrayList<Object> getGoodsThatCarry() {
        return goodsThatCarry;
    }

    public Helicopter() {
        setCapacity();
        setTurnToMoveObjectToCity();
    }


    //some method to buy or sell object
}
