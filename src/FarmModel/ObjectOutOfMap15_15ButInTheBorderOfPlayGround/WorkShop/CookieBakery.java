package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class CookieBakery extends WorkShop {
    public final String WorkShopName="CookieBakery";

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public void getProductFromWareHouse() {
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
