package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

public abstract class WorkShop extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int NumberOfGettingInput=1;
    private int turnToProduce;
    private int remainTurnToProduce;
    private boolean isWorkShopActivatedToMakeProduct = false;
    private int level;
    private int NumberOfGettingInput=1;


    public int getNumberOfGettingInput() {
        return NumberOfGettingInput;
    }

    public void setNumberOfGettingInput(int numberOfGettingInput) {
        NumberOfGettingInput = numberOfGettingInput;
    }

    public abstract String getWorkShopName();

    public int getTurnToProduce() {
        return turnToProduce;
    }

    public void setWorkShopActivatedToMakeProduct(boolean workShopActivatedToMakeProduct) {
        isWorkShopActivatedToMakeProduct = workShopActivatedToMakeProduct;
    }

    public boolean IsWorkshopActivatedToMakeProduct() {
        return isWorkShopActivatedToMakeProduct;
    }

    public boolean isWorkShopActivatedToMakeProduct() {
        return isWorkShopActivatedToMakeProduct;
    }

    public int getRemainTurnToProduce() {
        return remainTurnToProduce;
    }

    public void setTurnToProduce(int turnToProduce) {
        this.turnToProduce = turnToProduce;
    }

    public void setRemainTurnToProduce(int remainTurnToProduce) {
        this.remainTurnToProduce = remainTurnToProduce;
    }

    public abstract void getProductFromWareHouse();

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public abstract void MakeAProductAndPutItInMap();

    public abstract void UpgradeWorkShop();
}
