package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEmptyWell;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Well;

public class WellRequest extends Request {
    private int AmountOfWaterInBucket;

    public WellRequest() throws MissionNotLoaded, NotEmptyWell {
        Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
        well.FillTheBucket();
    }

    public void setAmountOfWaterInBucket(int amountOfWaterInBucket) {
        AmountOfWaterInBucket = amountOfWaterInBucket;
    }

    public int getAmountOfWaterInBucket() {
        return AmountOfWaterInBucket;
    }
}
