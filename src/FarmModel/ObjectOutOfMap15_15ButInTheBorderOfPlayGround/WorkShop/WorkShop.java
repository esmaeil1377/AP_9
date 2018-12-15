package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.NotEnoughMoney;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.Mission;
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
            int spaceNeededInWareHouseForThisProduct =InformationNeededInGame.getInformationNeededInGame().getSpaceNeededInWareHouse(productRequirement);
            int numberOfPackageForObjectInWareHouse = (numberofProductInWareHouse
                    / (objectNeededToProduceAProduct.get(productRequirement) * spaceNeededInWareHouseForThisProduct));
            if (numberOfPackageForObjectInWareHouse < numberOfAccessInputPackageInWareHouse) {
                numberOfAccessInputPackageInWareHouse = numberOfPackageForObjectInWareHouse;
            }
        }

        for (int i = 0; i < Math.min(numberOfAccessInputPackageInWareHouse, getMaxNumberOfGettingInput()); i++) {
            for (Product productRequirement : objectNeededToProduceAProduct.keySet()) {
                int spaceNeededInWareHouseForThisProduct = InformationNeededInGame.getInformationNeededInGame().getSpaceNeededInWareHouse(productRequirement);
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
        int priceNeeded=InformationNeededInGame.getInformationNeededInGame().getPriceForUpgrade(this);
        Mission mission=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission();
        int missionMoney=mission.getStartMoneyInMission();

        if(missionMoney>priceNeeded) {
            setLevel(getLevel() + 1);
            setMaxNumberOfGettingInput(getMaxNumberOfGettingInput() + 1);
            if (getLevel() == 1) {
                setTurnNeededToProduceOneProduct(getTurnNeededToProduceOneProduct() - 1);
            } else if (getLevel() == 2) {
                setTurnNeededToProduceOneProduct(getTurnNeededToProduceOneProduct() - 1);
            } else if (getLevel() == 3) {
                setTurnNeededToProduceOneProduct(getTurnNeededToProduceOneProduct() - 2);
            } else if (getLevel() == 4) {
                setTurnNeededToProduceOneProduct(getTurnNeededToProduceOneProduct() - 3);
            }
            InformationNeededInGame.getInformationNeededInGame().IncraesePriceForUpgrade(toString());
            mission.setStartMoneyInMission(missionMoney-priceNeeded);
        }else{
            throw new NotEnoughMoney();
        }
    }
}
