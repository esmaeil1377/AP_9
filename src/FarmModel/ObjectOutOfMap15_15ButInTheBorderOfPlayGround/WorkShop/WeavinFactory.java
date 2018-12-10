package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cloth;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Decoration;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Fibre;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Sewing;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class WeavinFactory extends WorkShop {
    public final String workShopName = "WeavingFactory";

    public WeavinFactory() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Fibre(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Cloth());
    }

    @Override
    public void MakeAProductAndPutItInMap() {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[15][15];
            cell.AddCellAMapObject(getResultProduct());
        }
    }
    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        int countOfFibre = 0;
        WareHouse wareHouse = new WareHouse();
        Fibre fibre = new Fibre();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(fibre.toString()))
                countOfFibre++;
        }
        if (getMaxNumberOfGettingInput() <= countOfFibre)
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        else
            setCurrentNumberOfProducingProduct(countOfFibre);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(fibre);
        }

    @Override
    public String toString() {
        return "WeavinFactory";
    }
}
