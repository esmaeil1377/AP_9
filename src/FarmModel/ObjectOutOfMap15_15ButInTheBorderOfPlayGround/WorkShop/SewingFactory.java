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

public class SewingFactory extends WorkShop {
    public final String workShopName = "SewingFactory";

    public SewingFactory(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Fabric(),1);
        objectNeededToProduceOne.put(new Decoration(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new CarnivalDress());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[i][14];
            CarnivalDress carnivalDress=new CarnivalDress();
            carnivalDress.setX(i);
            carnivalDress.setY(14);
            cell.AddCellAMapObject(carnivalDress);
            GameView.getGameView().getFarmView().AddFabric(i,14);
        }
    }

    public String getWorkShopName() {
        return workShopName;
    }

    public void getProductFromWareHouse() throws ObjectNotFoundInWareHouse, MissionNotLoaded {
        int countOfCloth = 0;
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
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
        if (countOfCloth==0 | countOfDecoration==0){
            throw new ObjectNotFoundInWareHouse();
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
    public void ActiveWorkShop() throws MissionNotLoaded, ObjectNotFoundInWareHouse {
        getProductFromWareHouse();
        MakeAProductAndPutItInMap();
    }

    @Override
    public String toString() {
        return "SewingFactory";
    }
}
