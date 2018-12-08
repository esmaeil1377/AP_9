package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomWorkShop extends WorkShop {
    public final String workShopName;



    public String getWorkShopName() {
        return workShopName;
    }


    public CustomWorkShop(String WorkshopName, HashMap<Product,Integer> objectNeededToProduceOne, Product resultProduct) {
        workShopName=WorkshopName;
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(resultProduct);
    }


    @Override
    public void getProductFromWareHouse() {

    }

    @Override
    public void MakeAProductAndPutItInMap() {

    }


    @Override
    public String toString() {
        return "CustomWorkShop";
    }
}
