package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle;

import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.ObjectOutOfMap30_30ButInTheBorderOfPlayGround;
import FarmModel.User;

import java.util.ArrayList;

public abstract class TransportationVehicle extends ObjectOutOfMap30_30ButInTheBorderOfPlayGround {
    private int Level = 0;
    private int turnToMoveObjectToCityAndComeBack;
    private int capacity;
    private int remainTurnToMoveObjectToCityAndComeBack;
    private ArrayList<Object> goodsThatCarry = new ArrayList<>();
    private boolean isVehicleActivated = false;

    public void setLevel(int level) {
        Level = level;
    }

    public void setVehicleActivated(boolean vehicleActivated) {
        isVehicleActivated = vehicleActivated;
    }

    public boolean IsVehicleActivated() {
        return isVehicleActivated;
    }

    void setGoodsThatHaveToCarry(ArrayList<Object> goodsThatCarry) {
        this.goodsThatCarry = goodsThatCarry;
    }



    public ArrayList<Object> getGoodsThatHaveToCarry() {
        return goodsThatCarry;
    }

    public void setRemainTurnToMoveObjectToCityAndComeBack(int remainTurnToMoveObjectToCity) {
        this.remainTurnToMoveObjectToCityAndComeBack = remainTurnToMoveObjectToCity;
    }

    public int getRemainTurnToMoveObjectToCityAndComeBack() {
        return remainTurnToMoveObjectToCityAndComeBack;
    }

    public int getLevel() {
        return Level;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    void setTurnToMoveObjectToCityAndComeBack(int turnToMoveObjectToCityAndComeBack) {
        this.turnToMoveObjectToCityAndComeBack = turnToMoveObjectToCityAndComeBack;
    }

    public int getTurnToMoveObjectToCityAndComeBack() {
        return turnToMoveObjectToCityAndComeBack;
    }

    static int CalculatePriceToBuyForHelicopter(ArrayList<Object> goods) {
        User user=Game.getGameInstance().getCurrentUserAccount();
        int price = 0;
        for (Object object : goods) {
            price+=user.getInformationNeededInGame().getPriceToBuy(object);
        }
        return price;
    }

    public void Upgrade() throws NotEnoughMoney, MaxLevelExceeded, UnknownObjectException, MissionNotLoaded {
        User user=Game.getGameInstance().getCurrentUserAccount();
        // don't think this this bellow could work correctly.
        int maxLevel = 3;
        int priceNeeded= user.getInformationNeededInGame().getPriceForUpgrade(this);
        int missionMoney= Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionMoney();
        if (getLevel() < maxLevel) {
            if (missionMoney > priceNeeded) {
                setLevel(getLevel() + 1);
                setTurnToMoveObjectToCityAndComeBack(getTurnToMoveObjectToCityAndComeBack() - 3);
                setCapacity(getCapacity() + 10);
                Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission
                        ().setMissionMoney(missionMoney - priceNeeded);
            } else {
                throw new NotEnoughMoney();
            }
        } else {
            throw new MaxLevelExceeded();
        }
    }

    public static int CalculatePriceForSellForTruck(ArrayList<Object> goods) throws UnknownObjectException {
        User user=Game.getGameInstance().getCurrentUserAccount();
        int price = 0;
        for (Object object : goods) {
            price+=user.getInformationNeededInGame().getPriceForSell(object);
            // add new if for other workshop product
        }
        return price;
    }
}
