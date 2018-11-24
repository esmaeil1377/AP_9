package FarmModel.MapObject.LiveAnimals;

public class Bear extends WildAnimals {
    private int PriceForSell;
    private int PriceToBuy;

    @Override
    public int getPriceToBuy() {
        return PriceToBuy;
    }

    @Override
    public int getPriceForSell() {
        return PriceForSell;
    }

}
