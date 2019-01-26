package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import View.GameView;

import java.util.ArrayList;
import java.util.Arrays;

public class Helicopter extends TransportationVehicle implements Upgradeable {

    public Helicopter(int level) throws UnknownObjectException, NotEnoughMoney, MaxLevelExceeded, MissionNotLoaded {
        for (int i=0;i<level;i++){
            Upgrade();
        }
        setTurnToMoveObjectToCityAndComeBack(12);
        setCapacity(20);
    }

    //i have to watch out this part because object have not the same space needed and they are .
    public void AddObjectToListForBuyToHelicopter(ObjectInMap15_15 good) throws MissionNotLoaded {
        //don'd forget capacity limitation.
        Mission mission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
        int priceToBuy = CalculatePriceToBuyForHelicopter(new ArrayList<>(Arrays.asList(good)));
        if (mission.getMissionMoney() > priceToBuy) {
//            mission.ChangeMissionMoney(- priceToBuy);
            getGoodsThatHaveToCarry().add(good);
            setRemainTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack());
        }
    }

    public void PutObjectInMapRandomly() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        for (Object objectInMap15_15 : getGoodsThatHaveToCarry()) {
            int x = (int) (Math.random() * 14) + 1;
            int y = (int) (Math.random() * 14) + 1;
            ((ObjectInMap15_15)objectInMap15_15).setX(x);
            ((ObjectInMap15_15)objectInMap15_15).setY(y);
            farm.getMap()[x][y].AddCellAMapObject((ObjectInMap15_15)objectInMap15_15);
            GameView.getGameView().getFarmView().AddMapObjectIcon(objectInMap15_15,x,y);
        }
        setGoodsThatHaveToCarry(new ArrayList<>());
        //add from warehouse goods that are going to sell and something in userMoney
    }

    @Override
    public String toString() {
        return "Helicopter";
    }
}