package FarmModel.ObjectInMap30_30.LiveAnimals;

import FarmController.Exceptions.*;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.ObjectInMap15_15;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.User;

import java.util.ArrayList;

public class Cat extends Animals implements Upgradeable {
    public int level = 0;
    private Product productThatCarryToPutInWareHouse;


    public Cat(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MaxLevelExceeded, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
    }


    public void setProduct(Product product) {
        this.productThatCarryToPutInWareHouse = product;
    }

    public Product getProduct() {
        return productThatCarryToPutInWareHouse;
    }

    public void TakeProduct() throws MissionNotLoaded {
        Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[getX()][getY()];
        ArrayList<ObjectInMap15_15> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap15_15());
        for (ObjectInMap15_15 objectInMap15_15 : currentObjectInMap) {
            if (objectInMap15_15 instanceof Product && getProduct() == null ) {
                cell.RemoveCellAMapObject(objectInMap15_15);
                setProduct((Product) objectInMap15_15);
                return;
            }
        }
    }

    public void PutProductInStore() throws FullWareHouse, MissionNotLoaded {
        if (getProduct() != null) {
            Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse().AddWholeObjectToStore(getProduct());
            setProduct(null);
        }
    }

    public int getLevel() {
        return level;
    }


    public void Upgrade() throws NotEnoughMoney, MaxLevelExceeded, UnknownObjectException, MissionNotLoaded {
        int maxLevel = 4; // edit maxLevel
        User user=Game.getGameInstance().getCurrentUserAccount();
        int priceNeed = user.getInformationNeededInGame().getPriceForUpgrade(this);
        int missionMoney = user.getCurrentPlayingMission().getMissionMoney();
        if (level < maxLevel) {
            if (priceNeed < missionMoney) {
                level++;
                user.getCurrentPlayingMission().setMissionMoney(missionMoney - priceNeed);
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