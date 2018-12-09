package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.*;

import java.util.HashMap;

public class SewingFactory extends WorkShop {
    public final String workShopName = "SewingFactory";

    public SewingFactory() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Cloth(),1);
        objectNeededToProduceOne.put(new Decoration(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Sewing());
    }

    @Override
    public void MakeAProductAndPutItInMap() {
        Sewing sewing = new Sewing();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[15][1];
        cell.AddCellAMapObject(sewing);
    }

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
    }

    @Override
    public String toString() {
        return "SewingFactory";
    }
}
