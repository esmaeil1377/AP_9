package FarmModel.ObjectInMap15_15;

import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;

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
        return "Cage"+wildAnimals.toString();
    }
}
