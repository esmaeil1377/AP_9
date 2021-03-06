package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import View.GameView;

public abstract class AnimalProducer extends Animals {
    //*2 is just for better playing
    private final int minOfHungerToGoToFindTheGrass=3*2;
    private  int animalAmountOfHunger=8*2;
    private int healthyAnimalAmountOfHunger;
    private boolean wantToEatGrass = false;
    private int remainTurnToProduce=18;
    private final int turnToProduce=18;
    private final int turnNeededToEatGrassInTheCell=1;
    private int remainTurnNeededTOeatGrassInTheCell=1;

    public int getHealthyAnimalAmountOfHunger() {
        return healthyAnimalAmountOfHunger;
    }

    public void setHealthyAnimalAmountOfHunger(int healthyAnimalAmountOfHunger) {
        this.healthyAnimalAmountOfHunger = healthyAnimalAmountOfHunger;
    }


    public int getTurnToProduce() {
        return turnToProduce;
    }

    public int getMinOfHungerToGoToFindTheGrass() {
        return minOfHungerToGoToFindTheGrass;
    }

    public void setWantToEatGrass(boolean wantToEatGrass) {
        this.wantToEatGrass = wantToEatGrass;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    public boolean WantToEat() {
        return wantToEatGrass;
    }


    public abstract void Produce() throws MissionNotLoaded;

    public void EatGrass() throws MissionNotLoaded {
        if(remainTurnNeededTOeatGrassInTheCell==0) {
            int x = getX();
            int y = getY();
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
            for (ObjectInMap15_15 objectInMap15_15 : cell.getCellObjectInMap15_15()) {
                if (objectInMap15_15 instanceof Grass) {
                    cell.RemoveCellAMapObject(objectInMap15_15);
                    GameView.getGameView().getFarmView().RemoveGrassAndProductFromMap("Grass",x,y);
                    setAnimalAmountOfHunger(getAnimalAmountOfHunger() + 5);
                    if (getAnimalAmountOfHunger() == healthyAnimalAmountOfHunger) {
                        setWantToEatGrass(false);
                    }
                    return;
                }
            }
            remainTurnNeededTOeatGrassInTheCell=1;
        }else{
            remainTurnNeededTOeatGrassInTheCell-=1;

        }
    }


    public int getAnimalAmountOfHunger() {
        return animalAmountOfHunger;
    }

    public int getRemainTurnToProduce() {
        return remainTurnToProduce;
    }

    public void setAnimalAmountOfHunger(int animalAmountOfHunger) {
        this.animalAmountOfHunger = animalAmountOfHunger;
    }

    public void setRemainTurnToProduce(int remainTurnToProduce) {
        this.remainTurnToProduce = remainTurnToProduce;
    }

}
