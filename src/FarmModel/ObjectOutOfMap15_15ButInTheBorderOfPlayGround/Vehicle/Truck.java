package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmController.Exceptions.*;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

import java.util.ArrayList;

public class Truck extends TransportationVehicle implements Upgradeable {


    public Truck(int level) throws UnknownObjectException, NotEnoughMoney, MaxLevelExceeded, MissionNotLoaded {
        for (int i=0;i<level;i++){
            Upgrade();
        }
        setTurnToMoveObjectToCityAndComeBack(20);
        setCapacity(20);
    }

//    public void SellObjectToCityAndGetMoneyToUser() throws UnknownObjectException, MissionNotLoaded {
//        int priceToSellTheObject=CalculatePriceForSellForTruck(getGoodsThatHaveToCarry());
//        Mission mission=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
//        mission.setMissionMoney(mission.getMissionMoney()+priceToSellTheObject);
//        setGoodsThatHaveToCarry(new ArrayList<>());
//        setRemainTurnToMoveObjectToCityAndComeBack(0);
//        //delete object from ware  house and increase money;
//    }

    public void TakeObjectFromWareHouse(Object good) throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse = farm.getWareHouse();
        if (wareHouse.CheckifTheWareHouseContainsObject(good)) {
//            getGoodsThatHaveToCarry().add(good);
            wareHouse.RemovePieceOfObjectFromWareHouse(good);
//            setRemainTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack());
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
