package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Fabric;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Sewing;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import View.GameView;

import java.util.HashMap;

public class WeavingFactory extends WorkShop {
    public final String workShopName = "WeavingFactory";

    public WeavingFactory(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Sewing(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Fabric());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[14 - i][14];
            cell.AddCellAMapObject(getNewProductByType(getResultProduct()));
          //  GameView.getGameView().getFarmView().Add
        }
    }
    public String getWorkShopName() {
        return workShopName;
    }

    public void getProductFromWareHouse() throws ObjectNotFoundInWareHouse {
        int countOfFibre = 0;
        WareHouse wareHouse = new WareHouse();
        Fabric fabric = new Fabric();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(fabric.toString()))
                countOfFibre++;
        }
        if (countOfFibre==0){
            throw new ObjectNotFoundInWareHouse();
        }
        if (getMaxNumberOfGettingInput() <= countOfFibre)
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        else
            setCurrentNumberOfProducingProduct(countOfFibre);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(fabric);
        }

    @Override
    public String toString() {
        return "WeavingFactory";
    }
    @Override
    public void ActiveWorkShop() throws MissionNotLoaded, ObjectNotFoundInWareHouse {
        getProductFromWareHouse();
        MakeAProductAndPutItInMap();
    }
}
