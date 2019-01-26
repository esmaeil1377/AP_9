package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.*;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import View.GameView;

import java.util.HashMap;

public class CookieBakery extends WorkShop {
    public final String WorkShopName = "CookieBakery";

    public CookieBakery(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Powder(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Cake());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[14-i][7];
            Cake cake=new Cake();
            cake.setX(14-i);
            cake.setY(7);
            cell.AddCellAMapObject(cake);
            GameView.getGameView().getFarmView().AddCake(14-i,7);
        }
    }
    public void getProductFromWareHouse() throws ObjectNotFoundInWareHouse, MissionNotLoaded {
        int countOfPowder = 0;
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        Powder powder = new Powder();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(powder.toString()))
                countOfPowder++;
        }
        if (countOfPowder==0){
            throw new ObjectNotFoundInWareHouse();
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

    @Override
    public void ActiveWorkShop() throws MissionNotLoaded, ObjectNotFoundInWareHouse {
        getProductFromWareHouse();
        MakeAProductAndPutItInMap();
    }
}
