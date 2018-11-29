package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import java.util.ArrayList;

public class WareHouse extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level;
    private ArrayList<Object> StoreList=new ArrayList<>();
    private int activationPriceForUpgrade;
    private int capacityOfWareHouse;

    public void setCapacityOfWareHouse(int capacityOfWareHouse) {
        this.capacityOfWareHouse = capacityOfWareHouse;
    }

    public int getCapacityOfWareHouse() {
        return capacityOfWareHouse;
    }

    public int getActivationPriceForUpgrade() {
        return activationPriceForUpgrade;
    }

    public void setActivationPriceForUpgrade(int activationPriceForUpgrade) {
        this.activationPriceForUpgrade = activationPriceForUpgrade;
    }

    public void AddObjectToStore(Object object){}

    public void RemoveObjectToStore(Object object){}

  public void UpgradadeWareHouse(){

  }
}
