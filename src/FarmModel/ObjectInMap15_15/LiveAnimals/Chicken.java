package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;

public class Chicken extends AnimalProducer {

    @Override
    public String toString() {
        return "Chicken";
    }

    public Chicken() {
        setAnimalAmountOfHunger(8);
        setMinOfHungerToGoToFindTheGrass(3);
        setTurnToProduce(18);
    }

    @Override
    public void Produce() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Farm.getCellByPosition(x,y).AddCellAMapObject(new Egg());
    }

    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <= 3) {
            return true;
        }
        return false;
    }

}
