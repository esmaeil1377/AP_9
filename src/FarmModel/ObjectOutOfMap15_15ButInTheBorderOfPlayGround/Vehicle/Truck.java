package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import java.util.ArrayList;

public class Truck extends TransportationVehicle {


    public Truck() {
        setTurnToMoveObjectToCityAndComeBack();
        setCapacity();
    }

    public void SellObjectToCityAndGetMoneyToUser() {
        setGoodsThatHaveToCarry(null);
        setRemainTurnToMoveObjectToCityAndComeBack(0);
        //delete onject from warehouse and increase money;
    }

    public void TakeObjectFromWareHouse(Object good) {
        getGoodsThatHaveToCarry().add(good);
        //delete from warehouse goods that are going to sell
    }

    @Override
    public String toString() {
        return "Truck";
    }
}
