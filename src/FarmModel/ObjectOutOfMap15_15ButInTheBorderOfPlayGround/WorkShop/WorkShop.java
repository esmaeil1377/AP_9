package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

public abstract class WorkShop extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {

    public abstract int getPriceForSell();

    public abstract int getPriceToBuy();

    public abstract void getProductAndPutResultInMap();

    public abstract void UpgradeWorkShop();
}
