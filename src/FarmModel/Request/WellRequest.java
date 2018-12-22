package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;

public class WellRequest extends Request {
    private int AmountOfWaterInBucket;

    public WellRequest() throws MissionNotLoaded {
        Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
        well.FillTheBucket();
    }

    public void setAmountOfWaterInBucket(int amountOfWaterInBucket) {
        AmountOfWaterInBucket = amountOfWaterInBucket;
    }

    public int getAmountOfWaterInBucket() {
        return AmountOfWaterInBucket;
    }
}
