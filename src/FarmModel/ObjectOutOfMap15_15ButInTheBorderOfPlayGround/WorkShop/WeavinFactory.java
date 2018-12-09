package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cloth;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Decoration;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Fibre;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Sewing;

import java.util.HashMap;

public class WeavinFactory extends WorkShop {
    public final String workShopName = "WeavingFactory";

    public WeavinFactory() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Fibre(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Cloth());
    }

    @Override
    public void MakeAProductAndPutItInMap() {
        Cloth cloth =new Cloth();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[15][15];
        cell.AddCellAMapObject(cloth);
    }
    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
    }

    @Override
    public String toString() {
        return "WeavinFactory";
    }
}
