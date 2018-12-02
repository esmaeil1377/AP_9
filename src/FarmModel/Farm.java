package FarmModel;

import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.LiveAnimals.*;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;
import java.util.HashMap;

public class Farm {
    private Cell Map[][] = new Cell[15][15];
    private Truck truck;
    private Helicopter helicopter;
    private ArrayList<WorkShop> workShops = new ArrayList<>();
    private WareHouse wareHouse = new WareHouse();
    private Well well = new Well();
    private int remainTurnToRandomlyAddWildAnimalToMap = 60;
    private HashMap<Class,Integer> recordNoteBookThatRecoredEveryThingAndNumbers=new HashMap<>();
    private int maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished=0;
    private int maxNumberOfCowInMapToDetermineIfTheMissionIsFinished=0;
    private int maxNumberOfShipInMapToDetermineIfTheMissionIsFinished=0;
    private int maxNumberOfCatInMapToDetermineIfTheMissionIsFinished=0;
    private int maxNumberOfDogInMapToDetermineIfTheMissionIsFinished=0;


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

    private void setMaxNumberOfChickenInMapToDetermineIfTheMissionIsFinished(int maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished) {
        this.maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished = maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished;
    }

    private void setMaxNumberOfCowInMapToDetermineIfTheMissionIsFinished(int maxNumberOfCowInMapToDetermineIfTheMissionIsFinished) {
        this.maxNumberOfCowInMapToDetermineIfTheMissionIsFinished = maxNumberOfCowInMapToDetermineIfTheMissionIsFinished;
    }

    private void setMaxNumberOfShipInMapToDetermineIfTheMissionIsFinished(int maxNumberOfShipInMapToDetermineIfTheMissionIsFinished) {
        this.maxNumberOfShipInMapToDetermineIfTheMissionIsFinished = maxNumberOfShipInMapToDetermineIfTheMissionIsFinished;
    }

    private void setMaxNumberOfCatInMapToDetermineIfTheMissionIsFinished(int maxNumberOfCatInMapToDetermineIfTheMissionIsFinished) {
        this.maxNumberOfCatInMapToDetermineIfTheMissionIsFinished = maxNumberOfCatInMapToDetermineIfTheMissionIsFinished;
    }

    private void setMaxNumberOfDogInMapToDetermineIfTheMissionIsFinished(int maxNumberOfDogInMapToDetermineIfTheMissionIsFinished) {
        this.maxNumberOfDogInMapToDetermineIfTheMissionIsFinished = maxNumberOfDogInMapToDetermineIfTheMissionIsFinished;
    }

    public ArrayList<Animals> getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal() {
        int currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished=0;
        int currentNumberOfCowInMapToDetermineIfTheMissionIsFinished=0;
        int currentNumberOfShipInMapToDetermineIfTheMissionIsFinished=0;
        int currentNumberOfCatInMapToDetermineIfTheMissionIsFinished=0;
        int currentNumberOfDogInMapToDetermineIfTheMissionIsFinished=0;
        ArrayList<Animals> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Animals) {
                        animalsInMap.add((Animals) objectInMap15_15);
                        if(objectInMap15_15.toString().equals("Chicken"))currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished+=1;
                        else if(objectInMap15_15.getClass().equals("Cow"))currentNumberOfCowInMapToDetermineIfTheMissionIsFinished+=1;
                        else if(objectInMap15_15.getClass().equals("Ship"))currentNumberOfShipInMapToDetermineIfTheMissionIsFinished+=1;
                        else if(objectInMap15_15.getClass().equals("Cat"))currentNumberOfCatInMapToDetermineIfTheMissionIsFinished+=1;
                        else if(objectInMap15_15.getClass().equals("Dog"))currentNumberOfDogInMapToDetermineIfTheMissionIsFinished+=1;

                    }
                }
            }
        }
        if(currentNumberOfCatInMapToDetermineIfTheMissionIsFinished>maxNumberOfCatInMapToDetermineIfTheMissionIsFinished){
            maxNumberOfCatInMapToDetermineIfTheMissionIsFinished=currentNumberOfCatInMapToDetermineIfTheMissionIsFinished;
        }
        if(currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished>maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished){
            maxNumberOfChickenInMapToDetermineIfTheMissionIsFinished=currentNumberOfChickenInMapToDetermineIfTheMissionIsFinished;
        }
        if(currentNumberOfCowInMapToDetermineIfTheMissionIsFinished>maxNumberOfCowInMapToDetermineIfTheMissionIsFinished){
            maxNumberOfCowInMapToDetermineIfTheMissionIsFinished=currentNumberOfCowInMapToDetermineIfTheMissionIsFinished;
        }
        if(currentNumberOfDogInMapToDetermineIfTheMissionIsFinished>maxNumberOfDogInMapToDetermineIfTheMissionIsFinished){
            maxNumberOfDogInMapToDetermineIfTheMissionIsFinished=currentNumberOfDogInMapToDetermineIfTheMissionIsFinished;
        }
        if(currentNumberOfShipInMapToDetermineIfTheMissionIsFinished>maxNumberOfShipInMapToDetermineIfTheMissionIsFinished){
            maxNumberOfShipInMapToDetermineIfTheMissionIsFinished=currentNumberOfShipInMapToDetermineIfTheMissionIsFinished;
        }
        return animalsInMap;
    }
    public ArrayList<Grass> getCurrentGrassInMap(){
        ArrayList<Grass> grassInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Grass) {
                        grassInMap.add((Grass)objectInMap15_15);
                    }
                }
            }
        }
        return grassInMap;
    }

    public ArrayList<Product> getCurrentProductInMap(){
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

    public void AddToWareHouse(Object object) {
        RecordThisTransActionThatAddedToWareHouse(object);
        //....
    }

    public void RemoveFromWorkShops(WorkShop workShop) {
    }

    public void RemoveFromWareHouse(Object object) {
    }
    public void RecordThisTransActionThatAddedToWareHouse(Object object){
        int NumberOfTheObjectThatWereInWareHouseAndThisTime=0;
        if(object.getClass()==(new Bear()).getClass()) {
            if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
                NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForBear") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
            }else{
                NumberOfTheObjectThatWereInWareHouseAndThisTime=InformationNeededInGame.GetData("SpaceNeededInWareHouseForBear");
            }

        }else if(object.getClass()==(new Lion()).getClass()){
            if (recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
                NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForLion") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
            } else {
                NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForLion");
            }
        }
        else if(object.getClass()==(new Egg()).getClass()){
            if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
                NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForEgg") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
            }else{
                NumberOfTheObjectThatWereInWareHouseAndThisTime=InformationNeededInGame.GetData("SpaceNeededInWareHouseForEgg");
            }
        }
        else if(object.getClass()==new Milk().getClass()){
            if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
                NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForMilk") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
            }else{
                NumberOfTheObjectThatWereInWareHouseAndThisTime=InformationNeededInGame.GetData("SpaceNeededInWareHouseForMilk");
            }
        }
        else if(object.getClass()==new Wool().getClass()){if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
            NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForWool") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
        }else{
            NumberOfTheObjectThatWereInWareHouseAndThisTime=InformationNeededInGame.GetData("SpaceNeededInWareHouseForWool");
        }}
        else if(object.getClass()==new Cake().getClass()){
            if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
            NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForCake") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
        }else{
            NumberOfTheObjectThatWereInWareHouseAndThisTime=InformationNeededInGame.GetData("SpaceNeededInWareHouseForCake");
        }}
        else if(object.getClass()==new Powder().getClass()){
            if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(object.getClass())) {
                NumberOfTheObjectThatWereInWareHouseAndThisTime = InformationNeededInGame.GetData("SpaceNeededInWareHouseForPowder") + recordNoteBookThatRecoredEveryThingAndNumbers.get(object.getClass());
            }else{
                NumberOfTheObjectThatWereInWareHouseAndThisTime=InformationNeededInGame.GetData("SpaceNeededInWareHouseForPowder");
            }
        }
        //.., and three other product of WorkShops

    }


    public static double DistanceBetweenTwoCell(int xCell1, int yCell1, int xCell2, int yCell2) {
        return (Math.pow(Math.pow(xCell1 - xCell2, 2) + Math.pow(yCell1 - yCell2, 2), 0.5));
    }


}
