package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;


import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.HashMap;

public class CakeBakery extends WorkShop{
    public final String WorkShopName="CakeBakery";

    public CakeBakery(HashMap<Product,Integer> objectNeededToProduceOne, Product resultProduct){
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(resultProduct);
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
