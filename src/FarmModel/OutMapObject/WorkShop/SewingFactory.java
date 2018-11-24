package FarmModel.OutMapObject.WorkShop;

public class SewingFactory extends WorkShop {
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
