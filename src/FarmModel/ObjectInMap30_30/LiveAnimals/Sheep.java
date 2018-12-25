package FarmModel.ObjectInMap30_30.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Wool;

public class Sheep extends AnimalProducer {

    public Sheep() {
    }

    @Override
    public void Produce() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Farm.getCellByPosition(x,y).AddCellAMapObject(new Wool());
    }


    @Override
    public String toString() {
        return "Sheep";
    }
}
