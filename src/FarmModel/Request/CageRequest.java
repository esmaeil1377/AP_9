package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.ObjectInMap30_30.Cage;
import FarmModel.ObjectInMap30_30.LiveAnimals.WildAnimals;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;

public class CageRequest extends Request {
    private int x;
    private int y;

    public CageRequest(String requestLine) throws MissionNotLoaded {
        AnalyzeRequestLine(requestLine);
        Cell cell = Farm.getCellByPosition(getX(),getY());

        for (ObjectInMap30_30 object : cell.getCellObjectInMap30_30()) {
            if (object instanceof WildAnimals) {
                cell.AddCellAMapObject(new Cage((WildAnimals) object));
                cell.RemoveCellAMapObject(object);
                return;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] params = requestLine.split(" ");
        setX(Integer.parseInt(params[1]));
        setY(Integer.parseInt(params[2]));
    }
}
