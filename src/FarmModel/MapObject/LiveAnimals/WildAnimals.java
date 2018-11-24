package FarmModel.MapObject.LiveAnimals;

public abstract class WildAnimals extends Animals {

    public abstract int getPriceForSell();
    public abstract int getPriceToBuy();

    public void Destroyed () {
    }
}
