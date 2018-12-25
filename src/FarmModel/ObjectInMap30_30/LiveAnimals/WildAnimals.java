package FarmModel.ObjectInMap30_30.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Grass;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;

import java.util.ArrayList;

public abstract class WildAnimals extends Animals {

    public void Destroyed() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
        ArrayList<ObjectInMap30_30> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap30_30());
        for (ObjectInMap30_30 objectInMap15_15 : currentObjectInMap) {
            if (!(objectInMap15_15 instanceof WildAnimals) && !(objectInMap15_15 instanceof Grass)) {
                cell.RemoveCellAMapObject(objectInMap15_15);
            }
        }
    }

}