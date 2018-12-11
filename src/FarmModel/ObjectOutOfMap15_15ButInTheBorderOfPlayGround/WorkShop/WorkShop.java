package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public abstract class WorkShop extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int maxNumberOfGettingInput = 1;
    private int currentNumberOfProducingProduct = 1;
    //number are maybe right nut this unknown initialization help.(18)
    private int turnNeededToProduceOneProduct = 18;
    private int remainTurnToProduce;
    private boolean isWorkShopActivatedToMakeProduct = false;
    private int level;
    private HashMap<Product, Integer> objectNeededToProduceAProduct = new HashMap<>();
    private Product resultProduct;

    public void setCurrentNumberOfProducingProduct(int currentNumberOfProducingProduct) {
        this.currentNumberOfProducingProduct = currentNumberOfProducingProduct;
    }

    public int getCurrentNumberOfProducingProduct() {
        return currentNumberOfProducingProduct;
    }

    public Product getResultProduct() {
        return resultProduct;
    }

    public void setResultProduct(Product resultProduct) {
        this.resultProduct = resultProduct;
    }

    public int getMaxNumberOfGettingInput() {
        return maxNumberOfGettingInput;
    }

    public void setMaxNumberOfGettingInput(int maxNumberOfGettingInput) {
        this.maxNumberOfGettingInput = maxNumberOfGettingInput;
    }

    public abstract String getWorkShopName();

    public int getTurnNeededToProduceOneProduct() {
        return turnNeededToProduceOneProduct;
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

    public void setTurnNeededToProduceOneProduct(int turnNeededToProduceOneProduct) {
        this.turnNeededToProduceOneProduct = turnNeededToProduceOneProduct;
    }

    public void setRemainTurnToProduce(int remainTurnToProduce) {
        this.remainTurnToProduce = remainTurnToProduce;
    }

    public void getProductFromWareHouse() {
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        int numberOfAccessInputPackageInWareHouse = getMaxNumberOfGettingInput();
        for (Product productRequirement : objectNeededToProduceAProduct.keySet()) {
            int numberofProductInWareHouse = 0;
            for (Object objectInWareHouse : wareHouse.getWareHouseList()) {
                if (objectInWareHouse.toString().equals(productRequirement.toString())) {
                    numberofProductInWareHouse++;
                }
            }
            int spaceNeededInWareHouseForThisProduct = InformationNeededInGame.GetData();
            int numberOfPackageForObjectInWareHouse = (numberofProductInWareHouse
                    / (objectNeededToProduceAProduct.get(productRequirement) * spaceNeededInWareHouseForThisProduct));
            if (numberOfPackageForObjectInWareHouse < numberOfAccessInputPackageInWareHouse) {
                numberOfAccessInputPackageInWareHouse = numberOfPackageForObjectInWareHouse;
            }
        }

        for (int i = 0; i < Math.min(numberOfAccessInputPackageInWareHouse, getMaxNumberOfGettingInput()); i++) {
            for (Product productRequirement : objectNeededToProduceAProduct.keySet()) {
                int spaceNeededInWareHouseForThisProduct = InformationNeededInGame.GetData();
                for (int j = 0; j < spaceNeededInWareHouseForThisProduct; j++) {
                    wareHouse.RemovePieceOfObjectFromWareHouse(productRequirement);
                }
            }
        }
        setCurrentNumberOfProducingProduct(Math.min(numberOfAccessInputPackageInWareHouse, getMaxNumberOfGettingInput()));
        setWorkShopActivatedToMakeProduct(true);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public abstract void MakeAProductAndPutItInMap();

    public void setObjectNeededToProduceAProduct(HashMap<Product, Integer> objectNeededToProduceAProduct) {
        this.objectNeededToProduceAProduct = objectNeededToProduceAProduct;
    }

    public void UpgradeWorkShop() {
        setLevel(getLevel() + 1);
        setMaxNumberOfGettingInput(getMaxNumberOfGettingInput() + 1);
        setTurnNeededToProduceOneProduct();
        InformationNeededInGame.SetData();
        //needed a String);
        //some change in Information class and data because of changing price for them to upgrade or change.
    }
}
