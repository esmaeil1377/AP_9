package FarmModel;

import FarmModel.MapObject.MapObject;

import java.util.ArrayList;

public class Cell {
    private int XPosition;
    private int YPsition;
    ArrayList<MapObject> cellMapObject=new ArrayList<>();


    public void AddCellAMapObject(MapObject mapObject){}

    public int getXPosition() {
        return XPosition;
    }

    public void setXPosition(int XPosition) {
        this.XPosition = XPosition;
    }

    public int getYPsition() {
        return YPsition;
    }

    public void setYPsition(int YPsition) {
        this.YPsition = YPsition;
    }

    public void RremoveCellAMapObject(MapObject mapObject){}

}
