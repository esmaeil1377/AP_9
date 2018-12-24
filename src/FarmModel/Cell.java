package FarmModel;

import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;
import FarmModel.ObjectInMap15_15.ObjectInMap30_30;
import FarmModel.ObjectInMap15_15.Product.Product;

import java.util.ArrayList;

public class Cell {
    private int x;
    private int y;
    ArrayList<ObjectInMap30_30> cellObjectInMap30_30 = new ArrayList<>();


    public int getXPosition() {
        return x;
    }

    public void setXPosition(int XPosition) {
        this.x = XPosition;
    }

    public int getYPosition() {
        return y;
    }

    public void setYPosition(int YPosition) {
        this.y = YPosition;
    }

    public ArrayList<ObjectInMap30_30> getCellObjectInMap30_30() {
        return cellObjectInMap30_30;
    }

    public void AddCellAMapObject(ObjectInMap30_30 objectInMap30_30) {
        cellObjectInMap30_30.add(objectInMap30_30);
    }

    public void RemoveCellAMapObject(ObjectInMap30_30 objectInMap30_30) {
        for (ObjectInMap30_30 objectInMap30_30s : cellObjectInMap30_30) {
            if (objectInMap30_30.equals(objectInMap30_30s)) {
                cellObjectInMap30_30.remove(objectInMap30_30s);
                return;
            }
        }
    }

    public boolean HasGrass() {
        for (ObjectInMap30_30 objectInMap15_15 : getCellObjectInMap30_30()) {
            if (objectInMap15_15.toString().equals("Grass")) {
                return true;
            }
        }
        return false;
    }

    public boolean HasProduct() {
        for (ObjectInMap30_30 objectInMap15_15 : cellObjectInMap30_30) {
            if (objectInMap15_15 instanceof Product) {
                return true;
            }
        }
        return false;
    }

    public boolean HasWildAnimal() {
        for (ObjectInMap30_30 objectInMap30_30 : cellObjectInMap30_30) {
            if (objectInMap30_30 instanceof WildAnimals) {
                return true;
            }
        }
        return false;
    }
}
