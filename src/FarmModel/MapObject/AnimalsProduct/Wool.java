package FarmModel.MapObject.AnimalsProduct;

public class Wool extends AnimalsProduct {
    private int priceForSell;
    private int priceToBuy;

    @Override
    public int getPriceToBuy() {
        return priceToBuy;
    }

    @Override
    public int getPriceForSell() {
        return priceForSell;
    }
}
