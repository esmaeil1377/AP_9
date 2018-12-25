package FarmModel.ObjectInMap30_30.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Egg;

public class Chicken extends AnimalProducer {

    @Override
    public String toString() {
        return "Chicken";
    }

    public Chicken() {
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
