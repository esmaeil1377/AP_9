package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class SewingFactory extends WorkShop {
    public final String workShopName="SewingFactory";

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        WareHouse warehouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        int NumberOfInputPackageInWarehouse = 0;
        for(Object object : warehouse.getWareHouseList())
            if(object.toString().equals("Wool"))
                NumberOfInputPackageInWarehouse++;
        if(NumberOfInputPackageInWarehouse<getNumberOfGettingInput())
            for(int i = 0;i<NumberOfInputPackageInWarehouse ; i++)
                warehouse.RemoveObjectFromWareHouse(new Wool());
        else{
            for(int i = 0 ; i<getNumberOfGettingInput();i++)
                warehouse.RemoveObjectFromWareHouse(new Wool());
        }
        setWorkShopActivatedToMakeProduct(true);
    }

    @Override
    public void MakeAProductAndPutItInMap() {
        Cloth cloth= new Cloth();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[0][7];
        cell.AddCellAMapObject(wool);
    }

    @Override
    public void UpgradeWorkShop() {
        setLevel(getLevel() + 1);
        setNumberOfGettingInput(getNumberOfGettingInput() + 1);
        setTurnToProduce();
    }
