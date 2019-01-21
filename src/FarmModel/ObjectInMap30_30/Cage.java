package FarmModel.ObjectInMap30_30;

import FarmModel.ObjectInMap30_30.LiveAnimals.WildAnimals;

public class Cage extends ObjectInMap15_15 {
    private WildAnimals wildAnimals;

    public Cage(WildAnimals wildAnimals) {
        setWildAnimals(wildAnimals);
    }

    public void setWildAnimals(WildAnimals wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public WildAnimals getWildAnimals() {
        return wildAnimals;
    }

    @Override
    public String toString() {
        return "Cage";
    }
}
