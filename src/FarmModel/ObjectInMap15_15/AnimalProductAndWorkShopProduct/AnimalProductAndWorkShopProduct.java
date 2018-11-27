package FarmModel.ObjectInMap15_15.AnimalProductAndWorkShopProduct;

import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public class AnimalProductAndWorkShopProduct extends ObjectInMap15_15 {
    private int priceForSell;
    private int priceForBuy;

    public void setPriceForBuy(int priceForBuy) {
        this.priceForBuy = priceForBuy;
    }

    public void setPriceForSell(int priceForSell) {
        this.priceForSell = priceForSell;
    }

    public int getPriceForSell() {
        return priceForSell;
    }

    public int getPriceForBuy() {
        return priceForBuy;
    }
}
