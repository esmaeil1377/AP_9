package FarmModel;

import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.TransportationVehicle;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;

public class FarmMap {
    private Cell Map[][]=new Cell[15][15];
    private ArrayList<TransportationVehicle> Vehicles=new ArrayList<>();
    private ArrayList<WorkShop> workShops=new ArrayList<>();
    private WareHouse wareHouse=new WareHouse();
    private Well well=new Well();

    public Cell[][] getMap() {
        return Map;
    }
    public void AddCellMapObject(ObjectInMap15_15 objectInMap15_15,int cellX,int celly){
        Map[cellX][celly].getCellObjectInMap1515().add(objectInMap15_15);
    }

    public ArrayList<TransportationVehicle> getVehicles() {
        return Vehicles;
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


    public void AddToVehicles(TransportationVehicle transportationVehicle){}

    public void AddToWorkShops(WorkShop workShop){}

    public void AddToWareHouse(Object object){}

    public void RemoveFromVehicles(TransportationVehicle transportationVehicle){}

    public void RemoveFromWorkShops(WorkShop workShop){}

    public void RemoveFromWareHouse(Object object){}


    public static double DistanceBetweenTwoCell(int xCell1,int yCell1,int xCell2,int yCell2){
        return (Math.pow(Math.pow(xCell1-xCell2,2)+Math.pow(yCell1-yCell2,2),0.5));
    }




}
