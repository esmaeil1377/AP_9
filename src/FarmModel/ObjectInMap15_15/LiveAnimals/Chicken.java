package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;

public class Chicken extends AnimalProducer {

    public Chicken(){
        setAnimalAmountOfHunger(8);
        setMinOfHungerToGoToFindTheGrass(3);
        setTurnToProduce(20);
    }
    @Override
    public void Produce() {
        int x=getX();
        int y=getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y].AddCellAMapObject(new Egg());
    }

    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <= 3) {
            return true;
        }
        return false;
    }

}
