package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;

public class Cow extends AnimalProducer {

    public Cow(){
        setAnimalAmountOfHunger();
        setMinOfHungerToGoToFindTheGrass();
        setTurnToProduce();

    }
    @Override
    public void Produce() {
        int x=getX();
        int y=getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y].AddCellAMapObject(new Milk());
    }
    @Override
    public boolean IsHungry(){
        if(getAnimalAmountOfHunger()<=){
            return true;
        }
        return false;
    }


}
