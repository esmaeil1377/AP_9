package FarmModel.OutMapObject;

public class Well extends OutMapObject {
    private int activationPrice;
    private int Level = 0;
    private int WaterOfTheBucket = 0;

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

    public int getActivationPrice() {
        return activationPrice;
    }

    public void setActivationPrice(int activationPrice) {
        this.activationPrice = activationPrice;
    }


    public void UpgradeWell() {
    }

    public void FillTheBucket() {
    }
}

