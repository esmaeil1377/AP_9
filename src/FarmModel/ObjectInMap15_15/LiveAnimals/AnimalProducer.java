package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;

public abstract class AnimalProducer extends Animals {
    private int animalAmountOfHunger;
    private int RemainTurnToProduce;
    private boolean wantToEatGrass = false;
    private int MinOfHungerToGoToFindTheGrass;
    private int turnToProduce;

    public void setTurnToProduce(int turnToProduce) {
        this.turnToProduce = turnToProduce;
    }

    public int getTurnToProduce() {
        return turnToProduce;
    }

    public int getMinOfHungerToGoToFindTheGrass() {
        return MinOfHungerToGoToFindTheGrass;
    }

    public void setMinOfHungerToGoToFindTheGrass(int minOfHungerToGoToFindTheGrass) {
        MinOfHungerToGoToFindTheGrass = minOfHungerToGoToFindTheGrass;
    }

    public void setWantToEatGrass(boolean wantToEatGrass) {
        this.wantToEatGrass = wantToEatGrass;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    public boolean getWantToEat() {
        return wantToEatGrass;
    }


    public abstract void Produce();

    public void EatGrass() {
        int x = getX();
        int y = getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarmMap().getMap()[x][y].RemoveCellAMapObject(new Grass());
    }


    public int getAnimalAmountOfHunger() {
        return animalAmountOfHunger;
    }

    public int getRemainTurnToProduce() {
        return RemainTurnToProduce;
    }

    public void setAnimalAmountOfHunger(int animalAmountOfHunger) {
        this.animalAmountOfHunger = animalAmountOfHunger;
    }

    public void setRemainTurnToProduce(int remainTurnToProduce) {
        RemainTurnToProduce = remainTurnToProduce;
    }

    public abstract boolean IsHungry();
}
