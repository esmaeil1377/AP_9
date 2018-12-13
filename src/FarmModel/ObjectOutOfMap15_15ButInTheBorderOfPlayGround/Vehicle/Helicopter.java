package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

import java.util.ArrayList;
import java.util.Arrays;

public class Helicopter extends TransportationVehicle {

    public Helicopter() {
        setTurnToMoveObjectToCityAndComeBack(12);
        setCapacity(20);
    }

    //i have to watch out this part because object have not the same space needed and they are .
    public void BuyObjectFromCityAndGetMoneyFromUser(ObjectInMap15_15 good) {
        //don'd forget capacity limitation.
        Mission mission = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission();
        int priceToBuyMoney = CalculatePriceToBuyForHelicopter(new ArrayList<>(Arrays.asList(good)));
        if (mission.getStartMoneyInMission() > priceToBuyMoney) {
            mission.setStartMoneyInMission(mission.getStartMoneyInMission() - priceToBuyMoney);
            getGoodsThatHaveToCarry().add(good);
            setRemainTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack());
        }
    }

    public void PutObjectInMapRandomly() {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        for (Object objectInMap15_15 : getGoodsThatHaveToCarry()) {
            int x = (int) (Math.random() * 16) + 1;
            int y = (int) (Math.random() * 16) + 1;
            farm.getMap()[x][y].AddCellAMapObject((ObjectInMap15_15)objectInMap15_15);
        }
        setGoodsThatHaveToCarry(null);
        //add from warehouse goods that are going to sell and something in userMoney
    }

    public void UpgradeHelicopter() {
        setLevel(getLevel()+1);
        setTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack()-3);
        setCapacity(getCapacity()+10);
    }

    @Override
    public String toString() {
        return "Helicopter";
    }
}