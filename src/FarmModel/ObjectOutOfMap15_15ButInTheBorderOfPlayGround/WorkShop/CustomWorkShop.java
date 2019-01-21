package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.HashMap;

public class CustomWorkShop extends WorkShop {
    public final String workShopName;



    public String getWorkShopName() {
        return workShopName;
    }


    public CustomWorkShop(int currentLeve,String WorkshopName, HashMap<Product, Integer> objectNeededToProduceOne, Product resultProduct) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLeve;i++){
            Upgrade();
        }
        workShopName = WorkshopName;
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(resultProduct);
    }


    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            // allocate later location for this factory.
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[7+i][7];
            cell.AddCellAMapObject(getNewProductByType(getResultProduct()));
        }
    }


    @Override
    public String toString() {
        return getWorkShopName();
    }
}
