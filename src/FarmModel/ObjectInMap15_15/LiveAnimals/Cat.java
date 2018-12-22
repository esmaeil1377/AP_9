package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.*;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.ArrayList;

public class Cat extends Animals {
    private static int Level = 0;
    private Product productThatCarryToPutInWareHouse;


    public void setProduct(Product product) {
        this.productThatCarryToPutInWareHouse = product;
    }

    public Product getProduct() {
        return productThatCarryToPutInWareHouse;
    }

    public void TakeProduct() throws MissionNotLoaded {
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[getX()][getY()];
        ArrayList<ObjectInMap15_15> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap1515());
        for (ObjectInMap15_15 objectInMap15_15 : currentObjectInMap) {
            if (objectInMap15_15 instanceof Product) {
                cell.RemoveCellAMapObject(objectInMap15_15);
                setProduct((Product) objectInMap15_15);
            }
        }
    }

    public void PutProductInStore() throws FullWareHouse, MissionNotLoaded {
        if (getProduct() != null) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse().AddWholeObjectToStore(getProduct());
            setProduct(null);
        }
    }

    public int getLevel() {
        return Level;
    }

    public void UpgradeCat() throws NotEnoughMoney, MaxLevelExceeded, UnknownObjectException, MissionNotLoaded {
        int maxLevel = 4; // edit maxLevel
        int priceNeed = InformationNeededInGame.getInformationNeededInGame().getPriceForUpgrade(this);
        int missionMoney = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getStartMoneyInMission();
        if (Level < maxLevel) {
            if (priceNeed < missionMoney) {
                Level++;
                Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().setStartMoneyInMission(missionMoney - priceNeed);
            } else {
                throw new NotEnoughMoney();
            }
        }else {
            throw new MaxLevelExceeded();
        }
    }

    @Override
    public String toString() {
        return "Cat";
    }
}