package FarmModel;

import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.ArrayList;

public class Cell {
    private int x;
    private int y;
    private ArrayList<ObjectInMap15_15> cellObjectInMap15_15 = new ArrayList<>();


    void setXPosition(int XPosition) {
        this.x = XPosition;
    }

    void setYPosition(int YPosition) {
        this.y = YPosition;
    }

    public ArrayList<ObjectInMap15_15> getCellObjectInMap15_15() {
        return cellObjectInMap15_15;
    }

    public void AddCellAMapObject(ObjectInMap15_15 objectInMap15_15) {
        cellObjectInMap15_15.add(objectInMap15_15);
    }

    public void RemoveCellAMapObject(ObjectInMap15_15 objectInMap15_15) {
        for (ObjectInMap15_15 objectInMap15_15s : cellObjectInMap15_15) {
            if (objectInMap15_15.equals(objectInMap15_15s)) {
                cellObjectInMap15_15.remove(objectInMap15_15s);
                return;
            }
        }
    }

    public boolean HasGrass() {
        for (ObjectInMap15_15 objectInMap15_15 : getCellObjectInMap15_15()) {
            if (objectInMap15_15.toString().equals("Grass")) {
                return true;
            }
        }
        return false;
    }

    public boolean HasProduct() {
        for (ObjectInMap15_15 objectInMap15_15 : cellObjectInMap15_15) {
            if (objectInMap15_15 instanceof Product) {
                return true;
            }
        }
        return false;
    }

    public boolean HasWildAnimal() {
        for (ObjectInMap15_15 objectInMap15_15 : cellObjectInMap15_15) {
            if (objectInMap15_15 instanceof WildAnimals) {
                return true;
            }
        }
        return false;
    }
}
