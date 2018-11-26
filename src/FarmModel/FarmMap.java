package FarmModel;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.TransportationVehicle;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;

public class FarmMap {
    CellInMap Map[][]=new CellInMap[15][15];
    ArrayList<TransportationVehicle> Vehicles=new ArrayList<>();
    ArrayList<WorkShop> workShops=new ArrayList<>();
    private WareHouse wareHouse=new WareHouse();
    private Well well=new Well();

    public CellInMap[][] getMap() {
        return Map;
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

    public void setMap(CellInMap[][] map) {
        Map = map;
    }

    public void AddToVehicles(TransportationVehicle transportationVehicle){}

    public void AddToWorkShops(WorkShop workShop){}

    public void AddToWareHouse(Object object){}

    public void RemoveFromVehicles(TransportationVehicle transportationVehicle){}

    public void RemoveFromWorkShops(WorkShop workShop){}

    public void RemoveFromWareHouse(Object object){}




}
