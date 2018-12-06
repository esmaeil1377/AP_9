package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.Game;

import java.util.ArrayList;

public class Helicopter extends TransportationVehicle {

    public Helicopter() {
        setTurnToMoveObjectToCityAndComeBack();
        setCapacity();
    }

    public void BuyObjectFromCityAndGetMoneyFromUser(Object good) {
        getGoodsThatHaveToCarry().add(good);
        setRemainTurnToMoveObjectToCityAndComeBack(0);
        //delete object from warehouse and increase money;
    }

    public void GiveObjectToWareHouse() {
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse().AddObjectToStore(getGoodsThatHaveToCarry());
        setGoodsThatHaveToCarry(null);
        //delete from warehouse goods that are going to sell and something in userMoney
    }

    @Override
    public String toString() {
        return "Helicopter";
    }
}
