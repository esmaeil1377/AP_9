package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;

public class Ship extends AnimalProducer {

    public Ship() {
        setAnimalAmountOfHunger(8);
        setMinOfHungerToGoToFindTheGrass(3);
        setTurnToProduce(18);
    }

    @Override
    public void Produce() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].AddCellAMapObject(new Wool());
    }

    @Override
    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <= getMinOfHungerToGoToFindTheGrass()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ship";
    }
}
