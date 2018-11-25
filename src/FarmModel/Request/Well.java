package FarmModel.Request;

public class Well extends Request {
    private int AmountOfWaterInBucket;

    public Well(){}

    public void setAmountOfWaterInBucket(int amountOfWaterInBucket) {
        AmountOfWaterInBucket = amountOfWaterInBucket;
    }

    public int getAmountOfWaterInBucket() {
        return AmountOfWaterInBucket;
    }
}
