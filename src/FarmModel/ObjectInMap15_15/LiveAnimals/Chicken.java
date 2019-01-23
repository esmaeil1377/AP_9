package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import View.GameView;

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
        GameView.getGameView().getFarmView().AddEgg(x,y);
        Farm.getCellByPosition(x,y).AddCellAMapObject(new Egg());
    }

    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <= 3) {
            return true;
        }
        return false;
    }

}
