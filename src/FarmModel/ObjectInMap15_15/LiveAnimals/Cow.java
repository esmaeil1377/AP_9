package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;

public class Cow extends AnimalProducer {

    public Cow() {
        setAnimalAmountOfHunger(8);
        setMinOfHungerToGoToFindTheGrass(3);
        setTurnToProduce(18);

    }

    @Override
    public void Produce() {
        int x = getX();
        int y = getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].AddCellAMapObject(new Milk());
    }

    @Override
    public String toString() {
        return "Cow";
    }

    @Override
    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <= getMinOfHungerToGoToFindTheGrass()) {
            return true;
        }
        return false;
    }


}
