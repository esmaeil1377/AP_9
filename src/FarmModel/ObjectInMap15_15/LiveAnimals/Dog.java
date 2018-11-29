package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public class Dog extends Animals {

    public static void KillWildAnimalAndDie(Dog dog) {
        int x=dog.getX();
        int y=dog.getY();
        Cell cell=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y];
        cell.RemoveCellAMapObject(dog);
        for(ObjectInMap15_15 objectInMap15_15:cell.getCellObjectInMap1515()){
            if(objectInMap15_15 instanceof WildAnimals){
                cell.RemoveCellAMapObject(objectInMap15_15);
                //below return means that dog just kill one WildAnimal in the cell
                return;
            }
        }

    }

}
