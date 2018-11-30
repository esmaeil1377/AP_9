package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import java.util.ArrayList;

public class Truck extends TransportationVehicle {


    public Truck() {
        setTurnToMoveObjectToCityAndComeBack();
        setCapacity();
    }

    public void SellObjectToCityAndGetMoneyToUser() {
        setGoodsThatCarry(null);
        setRemainTurnToMoveObjectToCityAndComeBack(0);
        //delete onject from warehouse and increase money;
    }

    public void TakeObjectFromWareHouse(ArrayList<Object> goods) {
        setGoodsThatCarry(goods);
        //delete from warehouse goods that are going to sell
    }
}
