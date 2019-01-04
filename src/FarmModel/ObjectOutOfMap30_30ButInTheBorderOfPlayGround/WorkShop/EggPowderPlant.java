package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class EggPowderPlant extends WorkShop {
    public final String workShopName = "EggPowderPlant";

    public EggPowderPlant(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne = new HashMap<>();
        objectNeededToProduceOne.put(new Egg(), 1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Powder());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[ i][29];
            cell.AddCellAMapObject(getResultProduct());
        }
    }
    public void getProductFromWareHouse() {
        int countOfEgg = 0;
        WareHouse wareHouse = new WareHouse();
        Egg egg = new Egg();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(egg.toString()))
                countOfEgg++;
        }
        if (getMaxNumberOfGettingInput() <= countOfEgg)
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        else
            setCurrentNumberOfProducingProduct(countOfEgg);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(egg);
    }

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public String toString() {
        return "EggPowderPlant";
    }
}
