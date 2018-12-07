package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class Spinnery extends WorkShop {
    public final String workShopName="Spinnnery";

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        WareHouse wareHouse= Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        int NumberOfInputPackageInWareHouse=0;
        for(Object object:wareHouse.getWareHouseList()){
            if(object.toString().equals("Wool")){
                NumberOfInputPackageInWareHouse++;
            }
        }
        if(NumberOfInputPackageInWareHouse<getNumberOfGettingInput()){
            for(int i=0;i<NumberOfInputPackageInWareHouse;i++){
                wareHouse.RemoveObjectFromWareHouse(new Wool());
            }
        }
        else{
            for(int i=0;i<getNumberOfGettingInput();i++){
                wareHouse.RemoveObjectFromWareHouse(new Wool());
            }
        }
        setWorkShopActivatedToMakeProduct(true);
    }

    @Override
    public void MakeAProductAndPutItInMap() {

    }

    @Override
    public String toString() {
        return "Spinnery";
    }
}
