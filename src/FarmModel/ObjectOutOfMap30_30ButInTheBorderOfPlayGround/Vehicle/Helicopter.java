package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;

import java.util.ArrayList;
import java.util.Arrays;

public class Helicopter extends TransportationVehicle implements Upgradeable {

    public Helicopter() {
        setTurnToMoveObjectToCityAndComeBack(12);
        setCapacity(20);
    }

    //i have to watch out this part because object have not the same space needed and they are .
    public void AddObjectToListForBuyToHelicopterAndGetMoneyFromUser(ObjectInMap30_30 good) throws MissionNotLoaded {
        //don'd forget capacity limitation.
        Mission mission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
        int priceToBuy = CalculatePriceToBuyForHelicopter(new ArrayList<>(Arrays.asList(good)));
        if (mission.getMissionMoney() > priceToBuy) {
            mission.ChangeMissionMoney(- priceToBuy);
            getGoodsThatHaveToCarry().add(good);
            setRemainTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack());
        }
    }

    public void PutObjectInMapRandomly() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        for (Object objectInMap30_30 : getGoodsThatHaveToCarry()) {
            int x = (int) (Math.random() * 30) + 1;
            int y = (int) (Math.random() * 30) + 1;
            farm.getMap()[x][y].AddCellAMapObject((ObjectInMap30_30)objectInMap30_30);
        }
        setGoodsThatHaveToCarry(null);
        //add from warehouse goods that are going to sell and something in userMoney
    }

    @Override
    public String toString() {
        return "Helicopter";
    }
}