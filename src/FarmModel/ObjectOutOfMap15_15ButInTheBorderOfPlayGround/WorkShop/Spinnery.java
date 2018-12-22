package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Fabric;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Sewing;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class Spinnery extends WorkShop {
    public final String workShopName = "Spinnnery";

    public Spinnery() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Wool(),getMaxNumberOfGettingInput());
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Sewing());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[15 - i][7];
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
