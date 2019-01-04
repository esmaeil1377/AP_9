package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.*;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.ObjectOutOfMap30_30ButInTheBorderOfPlayGround;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.User;

import java.util.HashMap;

public abstract class WorkShop extends ObjectOutOfMap30_30ButInTheBorderOfPlayGround {
    private int maxNumberOfGettingInput = 1;
    private int currentNumberOfProducingProduct = 1;
    //number are maybe right nut this unknown initialization help.(18)
    private int turnNeededToProduceOneProduct = 18;
    private int remainTurnToProduce;
    private boolean isWorkShopActivatedToMakeProduct = false;
    //it is static because it should save the level
    public int level=0;
    private HashMap<Product, Integer> objectNeededToProduceAProduct = new HashMap<>();
    private Product resultProduct;

    public HashMap<Product, Integer> getObjectNeededToProduceAProduct() {
        return objectNeededToProduceAProduct;
    }

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

    public void getProductFromWareHouse() throws MissionNotLoaded {
        User user=Game.getGameInstance().getCurrentUserAccount();
        WareHouse wareHouse = user.getCurrentPlayingMission().getFarm().getWareHouse();
        int numberOfAccessInputPackageInWareHouse = getMaxNumberOfGettingInput();
        for (Product productRequirement : objectNeededToProduceAProduct.keySet()) {
            int numberofProductInWareHouse = 0;
            for (Object objectInWareHouse : wareHouse.getWareHouseList()) {
                if (objectInWareHouse.toString().equals(productRequirement.toString())) {
                    numberofProductInWareHouse++;
                }
            }
            int spaceNeededInWareHouseForThisProduct = user.getInformationNeededInGame().getSpaceNeededInWareHouse(productRequirement);
            int numberOfPackageForObjectInWareHouse = (numberofProductInWareHouse
                    / (objectNeededToProduceAProduct.get(productRequirement) * spaceNeededInWareHouseForThisProduct));
            if (numberOfPackageForObjectInWareHouse < numberOfAccessInputPackageInWareHouse) {
                numberOfAccessInputPackageInWareHouse = numberOfPackageForObjectInWareHouse;
            }
        }

        for (int i = 0; i < Math.min(numberOfAccessInputPackageInWareHouse, getMaxNumberOfGettingInput()); i++) {
            for (Product productRequirement : objectNeededToProduceAProduct.keySet()) {
                int spaceNeededInWareHouseForThisProduct = user.getInformationNeededInGame().getSpaceNeededInWareHouse(productRequirement);
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

    public abstract void MakeAProductAndPutItInMap() throws MissionNotLoaded;

    public void setObjectNeededToProduceAProduct(HashMap<Product, Integer> objectNeededToProduceAProduct) {
        this.objectNeededToProduceAProduct = objectNeededToProduceAProduct;
    }

    public void Upgrade() throws NotEnoughMoney, UnknownObjectException, MissionNotLoaded {
        User user=Game.getGameInstance().getCurrentUserAccount();
        int priceNeeded = user.getInformationNeededInGame().getPriceForUpgrade(this);
        Mission mission = user.getCurrentPlayingMission();
        int missionMoney = mission.getMissionMoney();

        if (missionMoney > priceNeeded) {
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
            mission.setMissionMoney(missionMoney - priceNeeded);
        } else {
            throw new NotEnoughMoney();
        }
    }

    public Product getNewProductByType(Product product){
        if(product instanceof Cake){
            return new Cake();
        }
        else if(product instanceof CarnivalDress){
            return new CarnivalDress();
        }
        else if(product instanceof Cookie){
            return new Cookie();
        }
        else if(product instanceof Decoration){
            return new Decoration();
        }
        else if(product instanceof Fabric){
            return new Fabric();
        }
        else if(product instanceof Sewing) {
            return new Sewing();
        }
        else if(product instanceof Powder){
            return new Powder();
        }
        return null;
    }
}
