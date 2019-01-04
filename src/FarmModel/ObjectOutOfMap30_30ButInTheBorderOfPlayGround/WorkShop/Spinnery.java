package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Sewing;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class Spinnery extends WorkShop {
    public final String workShopName = "Spinnnery";

    public Spinnery(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Wool(),getMaxNumberOfGettingInput());
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Sewing());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[15 - i][7];
            cell.AddCellAMapObject(getNewProductByType(getResultProduct()));
        }
    }
    public void getProductFromWareHouse() {
        int countOfWool = 0;
        WareHouse wareHouse = new WareHouse();
        Wool wool = new Wool();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(wool.toString()))
                countOfWool++;
        }
        if (getMaxNumberOfGettingInput() <= countOfWool)
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        else
            setCurrentNumberOfProducingProduct(countOfWool);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(wool);
    }
    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public String toString() {
        return "Spinnery";
    }
}
