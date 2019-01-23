package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import View.GameView;

public class Sheep extends AnimalProducer {

    public Sheep() {
    }

    @Override
    public void Produce() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        GameView.getGameView().getFarmView().AddWool(x,y);
        Farm.getCellByPosition(x,y).AddCellAMapObject(new Wool());
    }


    @Override
    public String toString() {
        return "Sheep";
    }
}
