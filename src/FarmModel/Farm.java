package FarmModel;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmModel.ObjectInMap30_30.Grass;
import FarmModel.ObjectInMap30_30.LiveAnimals.*;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;


public class Farm {
    private Cell map[][] = new Cell[30][30];
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

    private void setWorkShops(ArrayList<WorkShop> workShops) {
        this.workShops = workShops;
    }

    public Farm(Helicopter helicopter,Truck truck,ArrayList<WorkShop> workShops) {
        setHelicopter(helicopter);
        setTruck(truck);
        setWorkShops(workShops);
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                Cell cell=new Cell();
                cell.setXPosition(i);
                cell.setYPosition(j);
                getMap()[i][j]=cell;
            }
        }
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

    private void setHelicopter(Helicopter helicopter) {
        this.helicopter = helicopter;
    }

    private void setTruck(Truck truck) {
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

    public ArrayList<Animals> getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal() throws MissionNotLoaded {
//        int currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfCowInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfShipInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfCatInMapToDetermineIfTheMissionIsFinished = 0;
//        int currentNumberOfDogInMapToDetermineIfTheMissionIsFinished = 0;
        ArrayList<Animals> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Animals) {
                        animalsInMap.add((Animals) objectInMap15_15);
//                        if (objectInMap15_15.toString().equals("Chicken"))
//                            currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished += 1;
//                        else if (objectInMap15_15.getClass().equals("Cow"))
//                            currentNumberOfCowInMapToDetermineIfTheMissionIsFinished += 1;
//                        else if (objectInMap15_15.getClass().equals("Sheep"))
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

    public ArrayList<Cat> getCurrentCatInMap() throws MissionNotLoaded {
        ArrayList<Cat> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Cat) {
                        animalsInMap.add((Cat) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Dog> getCurrnetDogInMap() throws MissionNotLoaded {
        ArrayList<Dog> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Dog) {
                        animalsInMap.add((Dog) objectInMap15_15);
                    }
                }
        return animalsInMap;

    }

    public ArrayList<Chicken> getCurrentChickenInMap() throws MissionNotLoaded {
        ArrayList<Chicken> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Chicken) {
                        animalsInMap.add((Chicken) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Cow> getCurrnetCowInMap() throws MissionNotLoaded {
        ArrayList<Cow> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Cow) {
                        animalsInMap.add((Cow) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public static Cell getCellByPosition(int x,int y) throws MissionNotLoaded {
        return Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
    }

    public ArrayList<Sheep> getCurrentShipInMap() throws MissionNotLoaded {
        ArrayList<Sheep> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Sheep) {
                        animalsInMap.add((Sheep) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Lion> getCurrnetLionInMap() throws MissionNotLoaded {
        ArrayList<Lion> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Lion) {
                        animalsInMap.add((Lion) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }

    public ArrayList<Bear> getCurrentBearInMap() throws MissionNotLoaded {
        ArrayList<Bear> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 30; y++)
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Bear) {
                        animalsInMap.add((Bear) objectInMap15_15);
                    }
                }
        return animalsInMap;
    }


    public ArrayList<Grass> getCurrentGrassInMap() throws MissionNotLoaded {
        ArrayList<Grass> grassInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
                    if (objectInMap15_15 instanceof Grass) {
                        grassInMap.add((Grass) objectInMap15_15);
                    }
                }
            }
        }
        return grassInMap;
    }

    public ArrayList<Product> getCurrentProductInMap() throws MissionNotLoaded {
        ArrayList<Product> productInMap = new ArrayList<>();
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                for (ObjectInMap30_30 objectInMap15_15 : getCellByPosition(x,y).getCellObjectInMap30_30()) {
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
        return map;
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

    public WorkShop getspecifiedWorkShop(String WorkshopName) throws MissionNotLoaded {
        Farm farm=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        for (WorkShop workshop : farm.getWorkShops()) {
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
        try {
            throw new ObjectNotFoundInWareHouse();
        }catch (ObjectNotFoundInWareHouse e){
            e.printStackTrace();
        }
        return null;
    }

}
