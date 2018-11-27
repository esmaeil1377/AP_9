package FarmModel.ObjectInMap15_15.AnimalProductAndWorkShopProduct.AnimalsProduct;

public class Egg extends  AnimalsProduct{
    private int priceForSell;
    private int priceToBuy;

    @Override
    public int getPriceForSell() {
        return priceForSell;
    }

    @Override
    public int getPriceToBuy() {
        return priceToBuy;
    }
}
