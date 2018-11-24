package FarmModel.MapObject.LiveAnimals;

public class Cat extends Animals {
    private int Level=0;
    private int activationPrice;

    public void Walk(int xPositioneOfProduct, int yPositioneOfProduct) {
    }

    public void FindProduct() {
    }

    public void PutProductInStore() {
    }

    public void WalkRandom() {
    }

    public int getActivationPrice() {
        return activationPrice;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public void setActivationPrice(int activationPrice) {
        this.activationPrice = activationPrice;
    }
}