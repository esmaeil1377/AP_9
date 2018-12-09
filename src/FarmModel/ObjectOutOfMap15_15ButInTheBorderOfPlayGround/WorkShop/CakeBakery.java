package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cookie;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Flour;

import java.util.HashMap;

public class CakeBakery extends WorkShop {
    public final String WorkShopName = "CakeBakery";

    public CakeBakery() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Flour(),1);
        objectNeededToProduceOne.put(new Cookie(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Cake());
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public void MakeAProductAndPutItInMap() {
    }


    @Override
    public String toString() {
        return "CakeBakery";
    }
}
