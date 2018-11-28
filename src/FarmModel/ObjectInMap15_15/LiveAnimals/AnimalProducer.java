package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.FarmMap;
import FarmModel.FarmMap.*;
import FarmModel.Game;
import FarmModel.Mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class AnimalProducer extends Animals {
    private int animalAmountOfHunger;

    public abstract void Produce();

    public void EatGrass() {
    }

    public int getAnimalHealth() {
        return animalAmountOfHunger;
    }

    public void setAnimalHealth(int animalAmountOfHunger) {
        this.animalAmountOfHunger = animalAmountOfHunger;
    }

    public static void WalkWithEveryTurnWhenTheyAreHungry(AnimalProducer animalProducer){
        int currentX=animalProducer.getX();
        int currentY=animalProducer.getY();
        int nextX;
        int nextY;
        ArrayList<Integer> PointOfNearestGrass=animalProducer.FindNearGrass();
        int xPositionOfTheGrass=PointOfNearestGrass.get(0);
        int yPositionOfTheGrass=PointOfNearestGrass.get(1);
        if(xPositionOfTheGrass<currentX){
            nextX=currentX-1;
        }
        else{
            nextX=currentX+1;
        }
        if(yPositionOfTheGrass<currentY){
            nextY=currentY-1;
        }
        else{
            nextY=currentY+1;
        }
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[currentX][currentY].RemoveCellAMapObject(animalProducer);
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[currentX][currentY].AddCellAMapObject(animalProducer);
    }

    public ArrayList<Integer> FindNearGrass(){
        int currentX=getX();
        int currentY=getY();
        HashMap<Integer,Integer> XAndYOfGrassInMap=new HashMap<>();
        for(int x=0;x<15;x++){
            for(int y=0;y<15;y++){
                if(Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y].HasGrass()){
                    XAndYOfGrassInMap.put(x,y);
                }
            }
        }
        int nearestXGrass=100;
        int nearestYGrass=100;
        for(Integer xGrass:XAndYOfGrassInMap.keySet()){
            double distanceBetweenAnimalAndNearestGrass=FarmMap.DistanceBetweenTwoCell(nearestXGrass,nearestYGrass,currentX,currentY);
            double distanceBetweenAnimalAndGrass=FarmMap.DistanceBetweenTwoCell(xGrass,XAndYOfGrassInMap.get(xGrass),currentX,currentY);
            if(distanceBetweenAnimalAndGrass<distanceBetweenAnimalAndNearestGrass){
                nearestXGrass=xGrass;
                nearestYGrass=XAndYOfGrassInMap.get(xGrass);
            }
        }
        return new ArrayList<>(Arrays.asList(nearestXGrass,nearestYGrass));
    }
}
