package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import java.util.ArrayList;

public class WareHouse extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level;
    private ArrayList<Object> StoreList=new ArrayList<>();
    private int capacityOfWareHouse;

    public void setCapacityOfWareHouse(int capacityOfWareHouse) {
        this.capacityOfWareHouse = capacityOfWareHouse;
    }

    public int getCapacityOfWareHouse() {
        return capacityOfWareHouse;
    }

    public void AddObjectToStore(Object object){}

    public void RemoveObjectToStore(Object object){}

  public void UpgradadeWareHouse(){

  }
}
