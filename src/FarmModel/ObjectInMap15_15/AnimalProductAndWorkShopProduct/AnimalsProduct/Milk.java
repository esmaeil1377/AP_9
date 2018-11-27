package FarmModel.ObjectInMap15_15.AnimalProductAndWorkShopProduct.AnimalsProduct;

public class Milk extends AnimalsProduct {
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
