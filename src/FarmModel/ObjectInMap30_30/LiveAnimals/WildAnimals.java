package FarmModel.ObjectInMap30_30.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Grass;
import FarmModel.ObjectInMap30_30.ObjectInMap15_15;

import java.util.ArrayList;

public abstract class WildAnimals extends Animals {

    public void Destroyed() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
        ArrayList<ObjectInMap15_15> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap15_15());
        for (ObjectInMap15_15 objectInMap15_15 : currentObjectInMap) {
            if (!(objectInMap15_15 instanceof WildAnimals) && !(objectInMap15_15 instanceof Grass)) {
                cell.RemoveCellAMapObject(objectInMap15_15);
            }
        }
    }

}
