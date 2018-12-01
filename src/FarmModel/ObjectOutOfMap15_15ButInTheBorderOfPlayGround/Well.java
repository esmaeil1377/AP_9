package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

public class Well extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level = 0;
    private int WaterOfTheBucket = 0;
    private int turnToFillTheBucket;
    private int remianTurnToFillTheBucket;
    private boolean isWellActivatedToFillTheBucket =false;

    public void setWellActivatedToFillTheBucket(boolean wellActivatedToFillTheBucket) {
        isWellActivatedToFillTheBucket = wellActivatedToFillTheBucket;
    }
    public boolean isWellActivatedToFillTheBucket(){
        return isWellActivatedToFillTheBucket;ٌ
    }
    public void setRemianTurnToFillTheBucket(int remianTurnToFillTheBucket) {
        this.remianTurnToFillTheBucket = remianTurnToFillTheBucket;
    }

    public int getRemianTurnToFillTheBucket() {
        return remianTurnToFillTheBucket;
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

    public void FillTheBucket(int waterOfTheBucket) {
        WaterOfTheBucket = waterOfTheBucket;
    }

    public void UpgradeWell() {
    }

    public void FillTheBucket() {
        //decrease money of the user
    }
}

