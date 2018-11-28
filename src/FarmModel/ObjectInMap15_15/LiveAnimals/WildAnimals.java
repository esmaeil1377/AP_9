package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public abstract class WildAnimals extends Animals {

    public abstract int getPriceForSell();
    public abstract int getPriceToBuy();

    public void Destroyed () {
        int x=getX();
        int y=getY();
        Cell cell =Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y];
        for(ObjectInMap15_15 objectInMap15_15:cell.getCellObjectInMap1515()){
            if(!(objectInMap15_15 instanceof WildAnimals) && !(objectInMap15_15 instanceof Grass)){
                cell.RemoveCellAMapObject(objectInMap15_15);
            }
        }
    }

    public void Walk(Animals animals){
        WalkRandomlyForOneTurn(animals);
    }
}
