package FarmModel;

import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.LiveAnimals.*;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;


public class Farm {
    private Cell Map[][] = new Cell[16][16];
    private Truck truck;
    private Helicopter helicopter;
    private ArrayList<WorkShop> workShops = new ArrayList<>();
    private WareHouse wareHouse = new WareHouse();
    private Well well = new Well();
    private int remainTurnToRandomlyAddWildAnimalToMap = 60;
//    private int maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished = 0;
//    private int maxNumberOfCowInMapToDetermineIfTheMissionIsFinished = 0;
//    private int maxNumberOfShipInMapToDetermineIfTheMissionIsFinished = 0;
//    private int maxNumberOfCatInMapToDetermineIfTheMissionIsFinished = 0;
//    private int maxNumberOfDogInMapToDetermineIfTheMissionIsFinished = 0;

//    public int getMaxNumberOfChickenInMapToDetermineIfTheMissionIsFinished() {
//        return maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    public int getMaxNumberOfCowInMapToDetermineIfTheMissionIsFinished() {
//        return maxNumberOfCowInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    public int getMaxNumberOfShipInMapToDetermineIfTheMissionIsFinished() {
//        return maxNumberOfShipInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    public int getMaxNumberOfCatInMapToDetermineIfTheMissionIsFinished() {
//        return maxNumberOfCatInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    public int getMaxNumberOfDogInMapToDetermineIfTheMissionIsFinished() {
//        return maxNumberOfDogInMapToDetermineIfTheMissionIsFinished;
//    }

    public void setWorkShops(ArrayList<WorkShop> workShops) {
        this.workShops = workShops;
    }

    public Farm(Helicopter helicopter,Truck truck,ArrayList<WorkShop> workShops) {
        setHelicopter(helicopter);
        setTruck(truck);
        setWorkShops(workShops);
    }

    public int getRemainTurnToRandomlyAddWildAnimalToMap() {
        return remainTurnToRandomlyAddWildAnimalToMap;
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setHelicopter(Helicopter helicopter) {
        this.helicopter = helicopter;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

//    private void setMaxNumberOfChickenInMapToDetermineIfTheMissionIsFinished(int maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished) {
//        this.maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished = maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    private void setMaxNumberOfCowInMapToDetermineIfTheMissionIsFinished(int maxNumberOfCowInMapToDetermineIfTheMissionIsFinished) {
//        this.maxNumberOfCowInMapToDetermineIfTheMissionIsFinished = maxNumberOfCowInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    private void setMaxNumberOfShipInMapToDetermineIfTheMissionIsFinished(int maxNumberOfShipInMapToDetermineIfTheMissionIsFinished) {
//        this.maxNumberOfShipInMapToDetermineIfTheMissionIsFinished = maxNumberOfShipInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    private void setMaxNumberOfCatInMapToDetermineIfTheMissionIsFinished(int maxNumberOfCatInMapToDetermineIfTheMissionIsFinished) {
//        this.maxNumberOfCatInMapToDetermineIfTheMissionIsFinished = maxNumberOfCatInMapToDetermineIfTheMissionIsFinished;
//    }
//
//    private void setMaxNumberOfDogInMapToDetermineIfTheMissionIsFinished(int maxNumberOfDogInMapToDetermineIfTheMissionIsFinished) {
//        this.maxNumberOfDogInMapToDetermineIfTheMissionIsFinished = maxNumberOfDogInMapToDetermineIfTheMissionIsFinished;
//    }

    public ArrayList<Animals> getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal() {
//        int currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfCowInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfShipInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfCatInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfDogInMapToDetermineIfTheMissionIsFinished = 0;
        ArrayList<Animals> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Animals) {
                        animalsInMap.add((Animals) objectInMap15_15);
//                        if (objectInMap15_15.toString().equals("Chicken"))
//                            currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished += 1;
//                        else if (objectInMap15_15.getClass().equals("Cow"))
//                            currentNumberOfCowInMapToDetermineIfTheMissionIsFinished += 1;
//                        else if (objectInMap15_15.getClass().equals("Ship"))
//                            currentNumberOfShipInMapToDetermineIfTheMissionIsFinished += 1;
//                        else if (objectInMap15_15.getClass().equals("Cat"))
//                            currentNumberOfCatInMapToDetermineIfTheMissionIsFinished += 1;
//                        else if (objectInMap15_15.getClass().equals("Dog"))
//                            currentNumberOfDogInMapToDetermineIfTheMissionIsFinished += 1;

                    }
                }
            }
        }
//        if (currentNumberOfCatInMapToDetermineIfTheMissionIsFinished > maxNumberOfCatInMapToDetermineIfTheMissionIsFinished) {
//            maxNumberOfCatInMapToDetermineIfTheMissionIsFinished = currentNumberOfCatInMapToDetermineIfTheMissionIsFinished;
//        }
//        if (currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished > maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished) {
//            maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished = currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished;
//        }
//        if (currentNumberOfCowInMapToDetermineIfTheMissionIsFinished > maxNumberOfCowInMapToDetermineIfTheMissionIsFinished) {
//            maxNumberOfCowInMapToDetermineIfTheMissionIsFinished = currentNumberOfCowInMapToDetermineIfTheMissionIsFinished;
//        }
//        if (currentNumberOfDogInMapToDetermineIfTheMissionIsFinished > maxNumberOfDogInMapToDetermineIfTheMissionIsFinished) {
//            maxNumberOfDogInMapToDetermineIfTheMissionIsFinished = currentNumberOfDogInMapToDetermineIfTheMissionIsFinished;
//        }
//        if (currentNumberOfShipInMapToDetermineIfTheMissionIsFinished > maxNumberOfShipInMapToDetermineIfTheMissionIsFinished) {
//            maxNumberOfShipInMapToDetermineIfTheMissionIsFinished = currentNumberOfShipInMapToDetermineIfTheMissionIsFinished;
//        }
        return animalsInMap;
    }

    public ArrayList<Cat> getCurrentCatInMap() {
        ArrayList<Cat> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Cat) {
                        animalsInMap.add((Cat) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Dog> getCurrnetDogInMap() {
        ArrayList<Dog> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Dog) {
                        animalsInMap.add((Dog) objectInMap15_15);
                    }
                }
        return animalsInMap;

    }

    public ArrayList<Chicken> getCurrentChickenInMap() {
        ArrayList<Chicken> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Chicken) {
                        animalsInMap.add((Chicken) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Cow> getCurrnetCowInMap() {
        ArrayList<Cow> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Cow) {
                        animalsInMap.add((Cow) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Ship> getCurrnetShipInMap() {
        ArrayList<Ship> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Ship) {
                        animalsInMap.add((Ship) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Lion> getCurrnetLionInMap() {
        ArrayList<Lion> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Lion) {
                        animalsInMap.add((Lion) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Bear> getCurrentBearInMap() {
        ArrayList<Bear> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Bear) {
                        animalsInMap.add((Bear) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }


    public ArrayList<Grass> getCurrentGrassInMap() {
        ArrayList<Grass> grassInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Grass) {
                        grassInMap.add((Grass) objectInMap15_15);
                    }
                }
            }
        }
        return grassInMap;
    }

    public ArrayList<Product> AgetCurrentProductInMap() {
        ArrayList<Product> productInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Product) {
                        productInMap.add((Product) objectInMap15_15);
                    }
                }
            }
        }
        return productInMap;
    }

    public void setRemainTurnToRandomlyAddWildAnimalToMap(int remainTurnToRandomlyAddWildAnimalToMap) {
        this.remainTurnToRandomlyAddWildAnimalToMap = remainTurnToRandomlyAddWildAnimalToMap;
    }

    public Cell[][] getMap() {
        return Map;
    }

    public ArrayList<WorkShop> getWorkShops() {
        return workShops;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public Well getWell() {
        return well;
    }

    public void AddToWorkShops(WorkShop workShop) {
    }


    public static double DistanceBetweenTwoCell(int xCell1, int yCell1, int xCell2, int yCell2) {
        return (Math.pow(Math.pow(xCell1 - xCell2, 2) + Math.pow(yCell1 - yCell2, 2), 0.5));
    }

    public WorkShop getspecifiedWorkShop(String WorkshopName) {
        for (WorkShop workshop : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWorkShops()) {
            if (workshop.getWorkShopName().equals(WorkshopName)) {
                return workshop;
            }
        }
        return null;
    }

        //i don't think that it  could work but i'll look after.
    public Object getObjectInWareHouse(Object object){
        for (Object objectinWareHouse : wareHouse.getWareHouseList()) {
            if (objectinWareHouse.toString().equals(object.toString())) {
                return objectinWareHouse;
            }
        }
        throw new ObjectNotFoundInWareHouse();

    }

}
