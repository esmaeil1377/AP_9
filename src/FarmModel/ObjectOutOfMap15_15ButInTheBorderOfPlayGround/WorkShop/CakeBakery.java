package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.FlouryCake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Flour;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import View.GameView;

import java.util.HashMap;

public class CakeBakery extends WorkShop {
    public final String WorkShopName = "CakeBakery";
    int levelCakeBakery = 0;

    public CakeBakery(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Flour(),getMaxNumberOfGettingInput());
        objectNeededToProduceOne.put(new Cake(),getMaxNumberOfGettingInput());
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new FlouryCake());
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[i][7];
            FlouryCake flouryCake=new FlouryCake();
            flouryCake.setX(i);
            flouryCake.setY(7);
            cell.AddCellAMapObject(flouryCake);
            GameView.getGameView().getFarmView().AddFlouryCake(14-i,7);
        }
    }

    @Override
    public void ActiveWorkShop() throws MissionNotLoaded, ObjectNotFoundInWareHouse {
        getProductFromWareHouse();
        MakeAProductAndPutItInMap();
    }

    public void getProductFromWareHouse() throws ObjectNotFoundInWareHouse, MissionNotLoaded {
        int countOfFlour = 0;
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        Flour flour = new Flour();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(flour.toString()))
                countOfFlour++;
        }
        int countOfCookie = 0;
        int min = 0;
        Cake cookie = new Cake();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(cookie.toString()))
                countOfCookie++;
        }
        if (countOfCookie==0 | countOfFlour==0){
            throw new ObjectNotFoundInWareHouse();
        }
        if (getMaxNumberOfGettingInput() <= countOfFlour)
           min = getMaxNumberOfGettingInput() ;
        else
            min = countOfFlour;
        if (min <= countOfCookie)
             setCurrentNumberOfProducingProduct(min);
        else
           setCurrentNumberOfProducingProduct(countOfCookie);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(flour);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(cookie);
    }


    @Override
    public String toString() {
        return "CakeBakery";
    }
}
