package FarmModel;

import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

import java.util.ArrayList;

public class CellInMap {
    private int x;
    private int y;
    ArrayList<ObjectInMap15_15> cellObjectInMap1515 =new ArrayList<>();



    public int getXPosition() {
        return x;
    }

    public void setXPosition(int XPosition) {
        this.x = XPosition;
    }

    public int getYPsition() {
        return y;
    }

    public void setYPsition(int YPsition) {
        this.y = YPsition;
    }

    public ArrayList<ObjectInMap15_15> getCellObjectInMap1515() {
        return cellObjectInMap1515;
    }

    public void AddCellAMapObject(ObjectInMap15_15 objectInMap15_15){
        cellObjectInMap1515.add(objectInMap15_15);
    }
    public void RemoveCellAMapObject(ObjectInMap15_15 objectInMap15_15){
        for(ObjectInMap15_15 objectInMap15_15s:cellObjectInMap1515){
            if(objectInMap15_15.equals(objectInMap15_15s)){
                cellObjectInMap1515.remove(objectInMap15_15s);
                return;
            }
        }
    }

    public boolean HasGrass(){
        for(ObjectInMap15_15 objectInMap15_15:cellObjectInMap1515){
            if(objectInMap15_15.equals(new Grass())){
                return true;
            }
        }
        return false;
    }


}
