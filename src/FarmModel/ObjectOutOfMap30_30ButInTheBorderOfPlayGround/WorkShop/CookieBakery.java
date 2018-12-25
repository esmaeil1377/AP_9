package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop;


import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.*;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class CookieBakery extends WorkShop {
    public final String WorkShopName = "CookieBakery";

    public CookieBakery() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Powder(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Cookie());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[ i][15];
            cell.AddCellAMapObject(getResultProduct());
        }
    }
    public void getProductFromWareHouse() {
        int countOfPowder = 0;
        WareHouse wareHouse = new WareHouse();
        Powder powder = new Powder();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(powder.toString()))
                countOfPowder++;
        }
        if (getMaxNumberOfGettingInput() <= countOfPowder)
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        else
            setCurrentNumberOfProducingProduct(countOfPowder);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(powder);
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public String toString() {
        return "CookieBakery";
    }
}