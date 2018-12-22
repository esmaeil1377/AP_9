package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmController.Exceptions.UnknownObjectException;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.Mission;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class Truck extends TransportationVehicle implements Upgradeable {


    public Truck() {
        setTurnToMoveObjectToCityAndComeBack(20);
        setCapacity(20);
    }

    public void SellObjectToCityAndGetMoneyToUser() throws UnknownObjectException, MissionNotLoaded {
        int priceToSellTheObject=CalculatePriceForSellForTruck(getGoodsThatHaveToCarry());
        Mission mission=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission();
        mission.setStartMoneyInMission(mission.getStartMoneyInMission()+priceToSellTheObject);
        setGoodsThatHaveToCarry(null);
        setRemainTurnToMoveObjectToCityAndComeBack(0);
        //delete object from ware  house and increase money;
    }

    public void TakeObjectFromWareHouse(Object good) throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse = farm.getWareHouse();
        if (wareHouse.getWareHouseList().contains(good)) {
            getGoodsThatHaveToCarry().add(good);
            wareHouse.RemovePieceOfObjectFromWareHouse(good);
            setRemainTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack());
        } else {
            try {
                throw new ObjectNotFoundInWareHouse();
            }catch (ObjectNotFoundInWareHouse e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Truck";
    }
}
