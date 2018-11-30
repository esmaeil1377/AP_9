package FarmModel;

import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.LiveAnimals.Animals;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.TransportationVehicle;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;

public class Farm {
    private Cell Map[][] = new Cell[15][15];
    private Truck truck;
    private Helicopter helicopter;
    private ArrayList<WorkShop> workShops = new ArrayList<>();
    private WareHouse wareHouse = new WareHouse();
    private Well well = new Well();
    private int remainTurnToRandomlyAddWildAnimalToMap = 60;

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

    public ArrayList<Animals> getCurrentAnimalInTheMap() {
        ArrayList<Animals> animalsInMap = new ArrayList<>();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (ObjectInMap15_15 objectInMap15_15 : Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].getCellObjectInMap1515()) {
                    if (objectInMap15_15 instanceof Animals) {
                        animalsInMap.add((Animals) objectInMap15_15);
                    }
                }
            }
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

    public void AddCellMapObject(ObjectInMap15_15 objectInMap15_15, int cellX, int celly) {
        Map[cellX][celly].getCellObjectInMap1515().add(objectInMap15_15);
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
    }

    public void RemoveFromWorkShops(WorkShop workShop) {
    }

    public void RemoveFromWareHouse(Object object) {
    }


    public static double DistanceBetweenTwoCell(int xCell1, int yCell1, int xCell2, int yCell2) {
        return (Math.pow(Math.pow(xCell1 - xCell2, 2) + Math.pow(yCell1 - yCell2, 2), 0.5));
    }


}
