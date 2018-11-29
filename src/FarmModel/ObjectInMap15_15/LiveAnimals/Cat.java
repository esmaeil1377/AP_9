package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;

public class Cat extends Animals {
    private int Level = 0;
    private Product productThatCarryToPutInWareHouse;

    public void setProduct(Product product) {
        this.productThatCarryToPutInWareHouse = product;
    }

    public Product getProduct() {
        return productThatCarryToPutInWareHouse;
    }

    public void TakeProduct() {
        int x = getX();
        int y = getY();
        for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y].getCellObjectInMap1515()) {
            if (objectInMap15_15 instanceof Product) {
                Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y].RemoveCellAMapObject(objectInMap15_15);
                setProduct((Product) objectInMap15_15);
            }
        }
    }

    public void PutProductInStore() {
        if (getProduct() != null) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getWareHouse().AddObjectToStore(getProduct());
            setProduct(null);
        }
    }

    public int getLevel() {
        return Level;
    }

    public void UpgradeCat(int level) {
    }


}