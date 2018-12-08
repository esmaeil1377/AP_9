package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.Game;

public class Helicopter extends TransportationVehicle {

    public Helicopter() {
        setTurnToMoveObjectToCityAndComeBack();
        setCapacity();
    }

    //i have to watch out this part because object have not the same space needed and they are .
    public void BuyObjectFromCityAndGetMoneyFromUser(Object good) {
        getGoodsThatHaveToCarry().add(good);
        setRemainTurnToMoveObjectToCityAndComeBack(0);
        //delete object from warehouse and increase money;
    }

    public void GiveObjectToWareHouse() {
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse().AddWholeObjectToStore(getGoodsThatHaveToCarry());
        setGoodsThatHaveToCarry(null);
        //add    from warehouse goods that are going to sell and something in userMoney
    }

    public void UpgradeHelicopter() {

    }

    @Override
    public String toString() {
        return "Helicopter";
    }
}
