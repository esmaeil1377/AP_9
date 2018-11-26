package FarmModel;

import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public class Cage extends ObjectInMap15_15 {
    private double time;
    private int activationPrice;


    public Cage(WildAnimals wildAnimals){


    }
    public void RemoveFromMap(WildAnimals wildAnimals){
    }

    public int getActivationPrice() {
        return activationPrice;
    }

    public void setActivationPrice(int activationPrice) {
        this.activationPrice = activationPrice;
    }
}
