package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.HashMap;

public class WeavinFactory extends WorkShop {
    public final String workShopName = "WeavingFactory";

    public WeavinFactory(HashMap<Product, Integer> objectNeededToProduceOne, Product resultProduct) {
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(resultProduct);
    }

    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
    }

    @Override
    public String toString() {
        return "WeavinFactory";
    }
}
