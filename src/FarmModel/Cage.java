package FarmModel;

import FarmModel.MapObject.LiveAnimals.WildAnimals;

public class Cage {
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
