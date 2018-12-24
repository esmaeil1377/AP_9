package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Animals extends ObjectInMap15_15 {

    public static void WalkRandomlyForOneTurn(Animals animals) throws MissionNotLoaded {
        int currentX = animals.getX();
        int currentY = animals.getY();
        int nextX = 0;
        int nextY = 0;
        int nextRandomDirection = getNextRandomDirection(currentX, currentY);
        Farm.getCellByPosition(currentX,currentY).RemoveCellAMapObject(animals);
        if (nextRandomDirection == 1) {
            nextX = currentX + 1;
            nextY = currentY;
        } else if (nextRandomDirection == 2) {
            nextX = currentX + 1;
            nextY = currentY + 1;
        } else if (nextRandomDirection == 3) {
            nextX = currentX;
            nextY = currentY + 1;
        } else if (nextRandomDirection == 4) {
            nextX = currentX - 1;
            nextY = currentY + 1;
        } else if (nextRandomDirection == 5) {
            nextX = currentX - 1;
            nextY = currentY;
        } else if (nextRandomDirection == 6) {
            nextX = currentX - 1;
            nextY = currentY - 1;
        } else if (nextRandomDirection == 7) {
            nextX = currentX;
            nextY = currentY - 1;
        } else if (nextRandomDirection == 8) {
            nextX = currentX + 1;
            nextY = currentY - 1;
        }
        Farm.getCellByPosition(nextX,nextY).AddCellAMapObject(animals);
        animals.setX(nextX);
        animals.setY(nextY);
    }

    public static int getNextRandomDirection(int currentX, int currentY) {
        int nextDir = getNumberBetween0_9();
        if (currentX == 0 && currentY == 0) {
            while (nextDir == 4 || nextDir == 5 || nextDir == 6 || nextDir == 7 || nextDir == 8) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 0 && currentY == 29) {
            while (nextDir == 2 || nextDir == 3 || nextDir == 4 || nextDir == 5 || nextDir == 6) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 29 && currentY == 0) {
            while (nextDir == 6 || nextDir == 7 || nextDir == 8 || nextDir == 1 || nextDir == 2) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 29 && currentY == 29) {
            while (nextDir == 8 || nextDir == 1 || nextDir == 2 || nextDir == 3 || nextDir == 4) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 0) {
            while (nextDir == 4 || nextDir == 5 || nextDir == 6) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentX == 29) {
            while (nextDir == 8 || nextDir == 1 || nextDir == 2) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentY == 0) {
            while (nextDir == 6 || nextDir == 7 || nextDir == 8) {
                nextDir = getNumberBetween0_9();
            }
        } else if (currentY == 29) {
            while (nextDir == 2 || nextDir == 3 || nextDir == 4) {
                nextDir = getNumberBetween0_9();
            }
        }
        return nextDir;
    }

    public static int getNumberBetween0_9() {
        return ((int) (Math.random() * 8) + 1);
    }

    public static void Walk(Animals animals) throws MissionNotLoaded {
        if (animals instanceof AnimalProducer) {
            if (((AnimalProducer) animals).WantToEat()) {
                WalkWithEveryTurnWhenTheyAreHungryOrForDogOrForIntelligenceCat(animals);
            } else if (((AnimalProducer) animals).getAnimalAmountOfHunger() <= ((AnimalProducer) animals).getMinOfHungerToGoToFindTheGrass()) {
                WalkWithEveryTurnWhenTheyAreHungryOrForDogOrForIntelligenceCat(animals);
                ((AnimalProducer) animals).setWantToEatGrass(true);
            } else {
                WalkRandomlyForOneTurn(animals);
            }
        } else if (animals instanceof WildAnimals) {
            WalkRandomlyForOneTurn(animals);
        } else if (animals instanceof Dog) {
            WalkWithEveryTurnWhenTheyAreHungryOrForDogOrForIntelligenceCat(animals);
        } else if (animals instanceof Cat) {
            WalkWithEveryTurnWhenTheyAreHungryOrForDogOrForIntelligenceCat(animals);
        } else {
            //there is a problem.
            //Actually nothing will happen.it's true.
        }
    }

    private static void WalkWithEveryTurnWhenTheyAreHungryOrForDogOrForIntelligenceCat(Animals animal) throws MissionNotLoaded {
        int currentX = animal.getX();
        int currentY = animal.getY();
        int nextX;
        int nextY;
        ArrayList<Integer> PointOfNearestDestination = new ArrayList<>();
        if (animal instanceof AnimalProducer) {
            PointOfNearestDestination = animal.FindNearGrass();
            if (PointOfNearestDestination.get(0) == -100) {
                //i call this method because it animal producer has to walk faster than normal state.
                WalkRandomlyForOneTurn(animal);
                WalkRandomlyForOneTurn(animal);
                return;
            }
        } else if (animal instanceof Dog) {
            PointOfNearestDestination = animal.FindNearestWildAnimal();
            if (PointOfNearestDestination.get(0) == -100) {
                WalkRandomlyForOneTurn(animal);
                return;
            }
        } else if (animal instanceof Cat && ((Cat) animal).getLevel() == 1 && ((Cat) animal).getProduct() == null) {
            PointOfNearestDestination = animal.FindNearestProduct();
            if (PointOfNearestDestination.get(0) == -100) {
                WalkRandomlyForOneTurn(animal);
                return;
            }
        } else if (animal instanceof Cat && ((Cat) animal).getLevel() == 0 && ((Cat) animal).getProduct() == null) {
            PointOfNearestDestination = animal.FindProductForCatRandomly();
            if (PointOfNearestDestination.get(0) == -100) {
                WalkRandomlyForOneTurn(animal);
                return;
            }
        } else if (animal instanceof Cat && ((Cat) animal).getProduct() != null) {
            PointOfNearestDestination = animal.GivePointOfWareHouse();
        } else {
            ///////what something is missing.
            //Actually nothing will happen and it's true.
        }
        int xPositionOfTheGoal = PointOfNearestDestination.get(0);
        int yPositionOfTheGoal = PointOfNearestDestination.get(1);
        nextX=getNext(currentX,xPositionOfTheGoal);
        nextY=getNext(currentY,yPositionOfTheGoal);

        Farm.getCellByPosition(currentX,currentY).RemoveCellAMapObject(animal);
        Farm.getCellByPosition(nextX,nextY).AddCellAMapObject(animal);
        animal.setX(nextX);
        animal.setY(nextY);
    }

    private ArrayList<Integer> FindNearGrass() throws MissionNotLoaded {
        int currentX = getX();
        int currentY = getY();
        HashMap<Integer, Integer> XAndYOfGrassInMap = new HashMap<>();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Farm.getCellByPosition(currentX,currentY).HasGrass()) {
                    XAndYOfGrassInMap.put(x, y);
                }
            }
        }
        int nearestXGrass = -100;
        int nearestYGrass = -100;
        for (Integer xGrass : XAndYOfGrassInMap.keySet()) {
            double distanceBetweenAnimalAndNearestGrass = Farm.DistanceBetweenTwoCell(nearestXGrass, nearestYGrass, currentX, currentY);
            double distanceBetweenAnimalAndGrass = Farm.DistanceBetweenTwoCell(xGrass, XAndYOfGrassInMap.get(xGrass), currentX, currentY);
            if (distanceBetweenAnimalAndGrass < distanceBetweenAnimalAndNearestGrass) {
                nearestXGrass = xGrass;
                nearestYGrass = XAndYOfGrassInMap.get(xGrass);
            }
        }
        return new ArrayList<>(Arrays.asList(nearestXGrass, nearestYGrass));
    }

    private ArrayList<Integer> FindNearestProduct() throws MissionNotLoaded {
        int currentX = getX();
        int currentY = getY();
        HashMap<Integer, Integer> XAndYOfProductInMap = new HashMap<>();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Farm.getCellByPosition(currentX,currentY).HasProduct()) {
                    XAndYOfProductInMap.put(x, y);
                }
            }
        }
        int nearestXProduct = -100;
        int nearestYProduct = -100;
        for (Integer xProduct : XAndYOfProductInMap.keySet()) {
            double distanceBetweenAnimalAndNearestProduct = Farm.DistanceBetweenTwoCell(nearestXProduct, nearestYProduct, currentX, currentY);
            double distanceBetweenAnimalAndProduct = Farm.DistanceBetweenTwoCell(xProduct, XAndYOfProductInMap.get(xProduct), currentX, currentY);
            if (distanceBetweenAnimalAndProduct < distanceBetweenAnimalAndNearestProduct) {
                nearestXProduct = xProduct;
                nearestYProduct = XAndYOfProductInMap.get(xProduct);
            }
        }
        return new ArrayList<>(Arrays.asList(nearestXProduct, nearestYProduct));
    }

    private ArrayList<Integer> FindNearestWildAnimal() throws MissionNotLoaded {
        int currentX = getX();
        int currentY = getY();
        HashMap<Integer, Integer> XAndYOfWildAnimalInMap = new HashMap<>();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Farm.getCellByPosition(currentX,currentY).HasWildAnimal()) {
                    XAndYOfWildAnimalInMap.put(x, y);
                }
            }
        }
        int nearestXWildAnimal = -100;
        int nearestYWildAnimal = -100;
        for (Integer xWildAnimal : XAndYOfWildAnimalInMap.keySet()) {
            double distanceBetweenAnimalAndNearestWildAnimal = Farm.DistanceBetweenTwoCell(nearestXWildAnimal, nearestYWildAnimal, currentX, currentY);
            double distanceBetweenAnimalAndWildAnimal = Farm.DistanceBetweenTwoCell(xWildAnimal, XAndYOfWildAnimalInMap.get(xWildAnimal), currentX, currentY);
            if (distanceBetweenAnimalAndWildAnimal < distanceBetweenAnimalAndNearestWildAnimal) {
                nearestXWildAnimal = xWildAnimal;
                nearestYWildAnimal = XAndYOfWildAnimalInMap.get(xWildAnimal);
            }
        }
        return new ArrayList<>(Arrays.asList(nearestXWildAnimal, nearestYWildAnimal));
    }

    private ArrayList<Integer> FindProductForCatRandomly() throws MissionNotLoaded {
        HashMap<Integer, Integer> XAndYOfProductInMap = new HashMap<>();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Farm.getCellByPosition(x,y).HasProduct()) {
                    XAndYOfProductInMap.put(x, y);
                }
            }
        }
        int nearestXProduct = -100;
        int nearestYProduct = -100;
        if (XAndYOfProductInMap.size() == 0) {
            return new ArrayList<>(Arrays.asList(nearestXProduct, nearestYProduct));
        } else {
            int RandomIndexForProductInXAndYOfProductInMap = ((int) (Math.random() * XAndYOfProductInMap.size()));
            int x = new ArrayList<Integer>(XAndYOfProductInMap.keySet()).get(RandomIndexForProductInXAndYOfProductInMap);
            int y = new ArrayList<Integer>(XAndYOfProductInMap.values()).get(RandomIndexForProductInXAndYOfProductInMap);
            return new ArrayList<>(Arrays.asList(x, y));
        }
    }

    private ArrayList<Integer> GivePointOfWareHouse() {
        return new ArrayList<>(Arrays.asList(15, 0));
    }
    private static int getNext(int current,int goal){
        int next;
        if (goal < current) {
            if(current-goal>1){
                next = current - 2;
            }else{
                next=current-1;
            }
        } else {
            if (goal - current > 1) {
                next = current + 2;
            } else {
                next = current + 1;
            }
        }
        return next;
    }

}
