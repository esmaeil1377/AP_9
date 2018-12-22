package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.HashMap;

public class CustomWorkShop extends WorkShop {
    public final String workShopName;



    public String getWorkShopName() {
        return workShopName;
    }


    public CustomWorkShop(String WorkshopName, HashMap<Product, Integer> objectNeededToProduceOne, Product resultProduct) {
        workShopName = WorkshopName;
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(resultProduct);
    }


    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            // allocate later location for this factory.
            Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[7+i][7];
            cell.AddCellAMapObject(getNewProductByType(getResultProduct()));
        }
    }


    @Override
    public String toString() {
        return getWorkShopName();
    }
}
