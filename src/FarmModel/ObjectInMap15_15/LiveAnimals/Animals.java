package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.FarmMap;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public class Animals extends ObjectInMap15_15 {

    public static void WalkRandomlyForOneTurn(Animals animals) {
        int currentX = animals.getX();
        int currentY = animals.getY();
        int nextRandomDirection = getNextRandomDirection(currentX, currentY);
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().RemoveCellAMapObject(animals, currentX, currentY);
        if (nextRandomDirection == 1) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX + 1, currentY);
        } else if (nextRandomDirection == 2) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX + 1, currentY+1);
        } else if (nextRandomDirection == 3) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX, currentY +1);
        } else if (nextRandomDirection == 4) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX-1, currentY +1);
        } else if (nextRandomDirection == 5) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX-1, currentY);
        } else if (nextRandomDirection == 6) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX-1, currentY -1);
        } else if (nextRandomDirection == 7) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX, currentY -1);
        } else if (nextRandomDirection == 8) {
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().AddCellMapObject(animals, currentX+1, currentY-1);
        }
    }

    public static int getNextRandomDirection(int currentX, int currentY) {
        int nextDir = getNumberBetween0_9();
        if (currentX == 0 && currentY == 0) {
            while (nextDir == 4 || nextDir == 5 || nextDir == 6 || nextDir == 7 || nextDir == 8) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 0 && currentY == 14) {
            while (nextDir == 2 || nextDir == 3 || nextDir == 4 || nextDir == 5 || nextDir == 6) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 14 && currentY == 0) {
            while (nextDir == 6 || nextDir == 7 || nextDir == 8 || nextDir == 1 || nextDir == 2) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 14 && currentY == 14) {
            while (nextDir == 8 || nextDir == 1 || nextDir == 2 || nextDir == 3 || nextDir == 4) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 0) {
            while(nextDir==4 || nextDir==5 || nextDir==6){
                nextDir=getNumberBetween0_9();
            }
        } else if (currentX == 14) {
            while(nextDir==8 || nextDir==1 || nextDir==2){
                nextDir=getNumberBetween0_9();
            }
        } else if (currentY == 0) {
            while(nextDir==6 || nextDir==7 || nextDir==8){
                nextDir=getNumberBetween0_9();
            }
        } else if (currentY == 14) {
            while(nextDir==2 || nextDir==3 || nextDir==4){
                nextDir=getNumberBetween0_9();
            }
        }
        return nextDir;
    }

    public static int getNumberBetween0_9() {
        return ((int) (Math.random() * 8) + 1);
    }

}
