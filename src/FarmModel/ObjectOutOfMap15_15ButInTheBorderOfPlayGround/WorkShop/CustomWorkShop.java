package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

public class CustomWorkShop extends WorkShop {
    public final String workShopName;
    public int NumberOfGettingInput=1;

    public String getWorkShopName() {
        return workShopName;
    }
    public CustomWorkShop(String WorkshopName,){
        workShopName=WorkshopName;
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
