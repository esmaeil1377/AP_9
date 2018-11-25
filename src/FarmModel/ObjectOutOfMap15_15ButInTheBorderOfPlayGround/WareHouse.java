package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import java.util.ArrayList;

public class WareHouse extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private ArrayList<Object> StoreLsit=new ArrayList<>();
    private int activationPrice;

    public int getActivationPrice() {
        return activationPrice;
    }

    public void setActivationPrice(int activationPrice) {
        this.activationPrice = activationPrice;
    }

    public void AddObjectToStore(Object object){}

    public void RemoveObjectToStore(Object object){}
}
