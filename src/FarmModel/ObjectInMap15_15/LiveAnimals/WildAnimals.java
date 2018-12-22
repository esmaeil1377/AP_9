package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

import java.util.ArrayList;

public abstract class WildAnimals extends Animals {

    public void Destroyed() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y];
        ArrayList<ObjectInMap15_15> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap1515());
        for (ObjectInMap15_15 objectInMap15_15 : currentObjectInMap) {
            if (!(objectInMap15_15 instanceof WildAnimals) && !(objectInMap15_15 instanceof Grass)) {
                cell.RemoveCellAMapObject(objectInMap15_15);
            }
        }
    }

}
