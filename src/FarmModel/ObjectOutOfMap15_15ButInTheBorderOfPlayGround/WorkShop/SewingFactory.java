package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.*;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class SewingFactory extends WorkShop {
    public final String workShopName = "SewingFactory";

    public SewingFactory() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Fabric(),1);
        objectNeededToProduceOne.put(new Decoration(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new CarnivalDress());
    }

    @Override
    public void MakeAProductAndPutItInMap() {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[29 - i][0];
            cell.AddCellAMapObject(getResultProduct());
            Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[15 - i][0];
            cell.AddCellAMapObject(getNewProductByType(getResultProduct()));
        }
    }

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        int countOfCloth = 0;
        WareHouse wareHouse = new WareHouse();
        CarnivalDress carnivalDress = new CarnivalDress();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(carnivalDress.toString()))
                countOfCloth++;
        }
        int countOfDecoration = 0;
        int min = 0;
        Decoration decoration = new Decoration();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(decoration.toString()))
                countOfDecoration++;
        }
        if (getMaxNumberOfGettingInput() <= countOfCloth)
            min = getMaxNumberOfGettingInput() ;
        else
            min = countOfCloth;
        if (min <= countOfDecoration)
            setCurrentNumberOfProducingProduct(min);
        else
            setCurrentNumberOfProducingProduct(countOfDecoration);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(carnivalDress);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(decoration);
    }

    @Override
    public String toString() {
        return "SewingFactory";
    }
}
