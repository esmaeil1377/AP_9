package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

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
        Farm farm= Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse=farm.getWareHouse();
        if(wareHouse.getWareHouseList().contains(good)){
            getGoodsThatHaveToCarry().add(good);
            wareHouse.RemoveObjectFromWareHouse(good);
            //delete from warehouse goods that are going to sell
        }else{
            throw new ObjectNotFoundInWareHouse();
        }
    }

    public void UpgradeTruck() {

    }

    @Override
    public String toString() {
        return "Truck";
    }
}
