package Model;

import java.util.ArrayList;

public class House {
    public static Floor[] ArrayListFloors;
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

    public static void setArrayListFloors(Floor[] arrayListFloors) {
        ArrayListFloors = arrayListFloors;
    }

    public static Floor[] getArrayListFloors() {
        return ArrayListFloors;
    }
}
