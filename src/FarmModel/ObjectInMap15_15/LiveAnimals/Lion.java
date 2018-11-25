package FarmModel.ObjectInMap15_15.LiveAnimals;

public class Lion extends WildAnimals{
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
