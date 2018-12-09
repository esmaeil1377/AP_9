package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.HashMap;

public class CookieBakery extends WorkShop {
    public final String WorkShopName = "CookieBakery";

    public CookieBakery(HashMap<Product, Integer> objectNeededToProduceOne, Product resultProduct) {
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(resultProduct);
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public String toString() {
        return "CookieBakery";
    }
}
