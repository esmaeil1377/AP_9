package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;

public class Ship extends AnimalProducer {

    public Ship() {
        setAnimalAmountOfHunger();
        setMinOfHungerToGoToFindTheGrass();
        setTurnToProduce();
    }

    @Override
    public void Produce() {
        int x = getX();
        int y = getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].AddCellAMapObject(new Wool());
    }

    @Override
    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <=) {
            return true;
        }
        return false;
    }
}
