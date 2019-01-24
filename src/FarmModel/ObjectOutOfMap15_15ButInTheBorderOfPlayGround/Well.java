package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import FarmController.Exceptions.*;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.Mission;
import FarmModel.User;

public class Well extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround implements Upgradeable {
    private int Level = 0;
    private int WaterOfTheBucket = 0;
//    private int turnToFillTheBucket;
//    private int remainTurnToFillTheBucket;
    private boolean isWellActivatedToFillTheBucket = false;

    public void setWellActivatedToFillTheBucket(boolean wellActivatedToFillTheBucket) {
        isWellActivatedToFillTheBucket = wellActivatedToFillTheBucket;
    }

    public boolean isWellActivatedToFillTheBucket() {
        return isWellActivatedToFillTheBucket;
    }

//    public void setRemainTurnToFillTheBucket(int remainTurnToFillTheBucket) {
//        this.remainTurnToFillTheBucket = remainTurnToFillTheBucket;
//    }

//    public int getRemainTurnToFillTheBucket() {
//        return remainTurnToFillTheBucket;
//    }
//
//    public void setTurnToFillTheBucket(int turnToFillTheBucket) {
//        this.turnToFillTheBucket = turnToFillTheBucket;
//    }
//
//    public int getTurnToFillTheBucket() {
//        return turnToFillTheBucket;
//    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getWaterOfTheBucket() {
        return WaterOfTheBucket;
    }

    public void setWaterOfTheBucket(int waterOfTheBucket) {
        WaterOfTheBucket = waterOfTheBucket;
    }

    public void FillTheBucket(int waterOfTheBucket) {
        WaterOfTheBucket = waterOfTheBucket;
    }

    public void Upgrade() throws MaxLevelExceeded, NotEnoughMoney, UnknownObjectException, MissionNotLoaded {
        User user=Game.getGameInstance().getCurrentUserAccount();
        Mission currentMission = user.getCurrentPlayingMission();
        int maxLevel = 3;
        int missionMoney = currentMission.getMissionMoney();
        int priceTOUpgradeWell = user.getInformationNeededInGame().getPriceForUpgrade(this);
        if (getLevel() < maxLevel) {
            if (missionMoney > priceTOUpgradeWell) {
                currentMission.setMissionMoney(missionMoney - priceTOUpgradeWell);
                InformationNeededInGame.PriceToFillTheBucket -= 2;
                setLevel(getLevel() + 1);
            } else {
                throw new NotEnoughMoney();
            }
        } else {
            throw new MaxLevelExceeded();
        }
        // edit after
    }

    public void FillTheBucket() throws MissionNotLoaded, WellIsNotEmpty {
        Mission currentMission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
        int priceToFillTheBucket = InformationNeededInGame.PriceToFillTheBucket;

        if (getWaterOfTheBucket() == 0 && currentMission.getMissionMoney() >= priceToFillTheBucket) {
            setWaterOfTheBucket(InformationNeededInGame.CapacityOfTheBucket);
            currentMission.setMissionMoney(currentMission.getMissionMoney() - priceToFillTheBucket);
        }
        else{
            try {
                throw new WellIsNotEmpty();
            }catch (WellIsNotEmpty e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Well";
    }
}

