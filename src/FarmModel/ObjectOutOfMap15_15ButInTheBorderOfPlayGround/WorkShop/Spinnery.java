package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cloth;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Decoration;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Fibre;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Sewing;
import com.sun.xml.internal.ws.api.pipe.Fiber;

import java.util.HashMap;

public class Spinnery extends WorkShop {
    public final String workShopName = "Spinnnery";

    public Spinnery() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Wool(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Fibre());
    }

    @Override
    public void MakeAProductAndPutItInMap() {
        Fibre fibre = new Fibre();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[15][7];
        cell.AddCellAMapObject(fibre);
    }
    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public String toString() {
        return "Spinnery";
    }
}
