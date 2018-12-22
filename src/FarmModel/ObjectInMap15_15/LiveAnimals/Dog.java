package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public class Dog extends Animals {

    public  void KillWildAnimalAndDie() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y];
        for (ObjectInMap15_15 objectInMap15_15 : cell.getCellObjectInMap1515()) {
            if (objectInMap15_15 instanceof WildAnimals) {
                cell.RemoveCellAMapObject(this);
                cell.RemoveCellAMapObject(objectInMap15_15);
                //below return means that dog just kill one WildAnimal in the cell
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
