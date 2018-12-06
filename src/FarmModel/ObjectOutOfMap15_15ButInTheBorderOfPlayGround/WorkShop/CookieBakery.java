package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class CookieBakery extends WorkShop {
    public final String WorkShopName="CookieBakery";

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        WareHouse wareHouse= Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        int NumberOfInputPackageInWareHouse=0;
        for(Object object:wareHouse.getWareHouseList()){
            if(object.toString().equals("Powder")){
                NumberOfInputPackageInWareHouse++;
            }
        }
        if(NumberOfInputPackageInWareHouse<getNumberOfGettingInput()){
            for(int i=0;i<NumberOfInputPackageInWareHouse;i++){
                wareHouse.RemoveObjectFromWareHouse(new Powder());
            }
        }
        else{
            for(int i=0;i<getNumberOfGettingInput();i++){
                wareHouse.RemoveObjectFromWareHouse(new Powder());
            }
        }
    }

    @Override
    public String toString() {
        return "CookieBakery";
    }

    @Override
    public void MakeAProductAndPutItInMap() {

    }

    @Override
    public void UpgradeWorkShop() {

    }
}
