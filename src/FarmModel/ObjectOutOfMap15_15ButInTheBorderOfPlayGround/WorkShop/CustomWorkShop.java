package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

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
    public void getProductFromWareHouse() {
//        int countOfPowder = 0;
//        WareHouse wareHouse = new WareHouse();
//        Powder powder = new Powder();
//        for (Object object : wareHouse.getWareHouseList()) {
//            if (object.toString().equals(powder.toString()))
//                countOfPowder++;
//        }
//        if (getMaxNumberOfGettingInput() <= countOfPowder)
//            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
//        else
//            setCurrentNumberOfProducingProduct(countOfPowder);
//        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
//            wareHouse.RemovePieceOfObjectFromWareHouse(powder);
    }

    @Override
    public void ActiveWorkShop() throws MissionNotLoaded {
        getProductFromWareHouse();
        MakeAProductAndPutItInMap();
    }

    @Override
    public String toString() {
        return getWorkShopName();
    }
}
