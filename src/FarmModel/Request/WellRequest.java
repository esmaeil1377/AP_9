package FarmModel.Request;

public class WellRequest extends Request {
    private int AmountOfWaterInBucket;

    public WellRequest(){}

    public void setAmountOfWaterInBucket(int amountOfWaterInBucket) {
        AmountOfWaterInBucket = amountOfWaterInBucket;
    }

    public int getAmountOfWaterInBucket() {
        return AmountOfWaterInBucket;
    }
}
