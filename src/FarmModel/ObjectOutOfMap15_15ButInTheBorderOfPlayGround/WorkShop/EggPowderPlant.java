package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class EggPowderPlant extends WorkShop {
    public final String workShopName="EggPowderPlant";

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        WareHouse warehouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        int NumberOfInputPackageInWarehouse = 0;
        for(Object object : warehouse.getWareHouseList())
            if(object.toString().equals("Egg"))
                NumberOfInputPackageInWarehouse++;
        if(NumberOfInputPackageInWarehouse<getNumberOfGettingInput())
            for(int i = 0;i<NumberOfInputPackageInWarehouse ; i++)
                warehouse.RemoveObjectFromWareHouse(new Egg());
        else{
            for(int i = 0 ; i<getNumberOfGettingInput();i++)
                warehouse.RemoveObjectFromWareHouse(new Egg());
        }
          setWorkShopActivatedToMakeProduct(true);
        }

    @Override
    public void MakeAProductAndPutItInMap() {
        Powder powder = new Powder();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[0][15];
        cell.AddCellAMapObject(powder);
    }


    @Override
    public String toString() {
        return "EggPowderPlant";
    }
}
