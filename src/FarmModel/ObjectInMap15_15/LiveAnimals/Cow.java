package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import View.GameView;

public class Cow extends AnimalProducer {

    public Cow() {
    }

    @Override
    public void Produce() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        GameView.getGameView().getFarmView().AddMilk(x,y);
        Farm.getCellByPosition(x,y).AddCellAMapObject(new Milk());
        setRemainTurnToProduce(getTurnToProduce());
    }

    @Override
    public String toString() {
        return "Cow";
    }

}
