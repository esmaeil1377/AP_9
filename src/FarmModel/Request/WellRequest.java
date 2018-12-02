package FarmModel.Request;

import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;

public class WellRequest extends Request {
    private int AmountOfWaterInBucket;

    public WellRequest() {
        Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
        well.FillTheBucket(5);
    }

    public void setAmountOfWaterInBucket(int amountOfWaterInBucket) {
        AmountOfWaterInBucket = amountOfWaterInBucket;
    }

    public int getAmountOfWaterInBucket() {
        return AmountOfWaterInBucket;
    }
}
