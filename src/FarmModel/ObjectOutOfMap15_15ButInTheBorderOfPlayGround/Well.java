package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import FarmController.Exceptions.FullLevel;
import FarmController.Exceptions.NotEnoughMoney;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.Mission;

public class Well extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level = 0;
    private int WaterOfTheBucket = 0;
    private int turnToFillTheBucket;
    private int remainTurnToFillTheBucket;
    private boolean isWellActivatedToFillTheBucket = false;

    public void setWellActivatedToFillTheBucket(boolean wellActivatedToFillTheBucket) {
        isWellActivatedToFillTheBucket = wellActivatedToFillTheBucket;
    }

    public boolean isWellActivatedToFillTheBucket() {
        return isWellActivatedToFillTheBucket;
    }

    public void setRemainTurnToFillTheBucket(int remainTurnToFillTheBucket) {
        this.remainTurnToFillTheBucket = remainTurnToFillTheBucket;
    }

    public int getRemainTurnToFillTheBucket() {
        return remainTurnToFillTheBucket;
    }

    public void setTurnToFillTheBucket(int turnToFillTheBucket) {
        this.turnToFillTheBucket = turnToFillTheBucket;
    }

    public int getTurnToFillTheBucket() {
        return turnToFillTheBucket;
    }

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

    public void UpgradeWell() {
        Mission currentMission = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission();
        int maxLevel = 3;
        int missionMoney = currentMission.getStartMoneyInMission();
        int priceTOUpgradeWell = InformationNeededInGame.getInformationNeededInGame().getPriceForUpgrade(this);
        if (getLevel() < maxLevel) {
            if (missionMoney > priceTOUpgradeWell) {
                currentMission.setStartMoneyInMission(missionMoney - priceTOUpgradeWell);
                InformationNeededInGame.getInformationNeededInGame().PriceToFillTheBucket -= 2;
                setLevel(getLevel() + 1);
            } else {
                throw new NotEnoughMoney();
            }
        } else {
            throw new FullLevel();
        }
        // edit after
    }

    public void FillTheBucket() {
        Mission currentMission = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission();
        int priceToFillTheBucket = InformationNeededInGame.getInformationNeededInGame().PriceToFillTheBucket;

        if (getWaterOfTheBucket() == 0 && currentMission.getStartMoneyInMission() >= priceToFillTheBucket) {
            setWaterOfTheBucket(InformationNeededInGame.getInformationNeededInGame().CapacityOfTheBucket);
            currentMission.setStartMoneyInMission(currentMission.getStartMoneyInMission() - priceToFillTheBucket);
        }
    }

    @Override
    public String toString() {
        return "Well";
    }
}

