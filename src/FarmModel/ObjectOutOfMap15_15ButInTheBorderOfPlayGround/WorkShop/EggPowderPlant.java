package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import View.GameView;

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
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[ 14][14-i];
            cell.AddCellAMapObject(getResultProduct());
            GameView.getGameView().getFarmView().AddEggPowder(14,14-i);
        }
    }
    public void getProductFromWareHouse() throws ObjectNotFoundInWareHouse {
        int countOfEgg = 0;
        WareHouse wareHouse = new WareHouse();
        Egg egg = new Egg();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(egg.toString()))
                countOfEgg++;
        }
        if (countOfEgg==0){
            throw new ObjectNotFoundInWareHouse();
        }
        if (getMaxNumberOfGettingInput() <= countOfEgg) {
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        }
        else {
            setCurrentNumberOfProducingProduct(countOfEgg);
        }
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(egg);
    }

    public String getWorkShopName() {
        return workShopName;
    }
    @Override
    public void ActiveWorkShop() throws MissionNotLoaded, ObjectNotFoundInWareHouse {
        getProductFromWareHouse();
        MakeAProductAndPutItInMap();
    }

    @Override
    public String toString() {
        return "EggPowderPlant";
    }
}
