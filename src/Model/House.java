package Model;

import java.util.ArrayList;

public class House {
    public static ArrayList<Floor> ArrayListFloors;
    private int Id;
    private int NumberFloor;

    public void setNumberFloor(int numberFloor) {
        NumberFloor = numberFloor;
    }

    public int getNumberFloor() {
        return NumberFloor;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public static void setArrayListFloors(ArrayList<Floor> arrayListFloors) {
        ArrayListFloors = arrayListFloors;
    }

    public static ArrayList<Floor> getArrayListFloors() {
        return ArrayListFloors;
    }

    public void AddFloorArrayList(Floor floor){
        ArrayListFloors.add(floor);
    }

    public void RemoveFloorArrayList(Floor floor){
        ArrayListFloors.remove(floor);
    }


}
