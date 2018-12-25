package FarmModel.Request;

import FarmController.Exceptions.FullWareHouse;
import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

import java.util.ArrayList;

public class PickUpRequest extends Request {
    private int x;
    private int y;

    public PickUpRequest(String requestLine) throws MissionNotLoaded {
        AnalyzeRequestLine(requestLine);
        Cell cell = Farm.getCellByPosition(getX(),getY());
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        ArrayList<ObjectInMap30_30> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap30_30());
        for (ObjectInMap30_30 object : currentObjectInMap) {
            if (object instanceof Product) {
                try {
                    wareHouse.AddWholeObjectToStore(object);
                    cell.RemoveCellAMapObject(object);
                }catch (FullWareHouse e){
                    e.printStackTrace();
                }
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
