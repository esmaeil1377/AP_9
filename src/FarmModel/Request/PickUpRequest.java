package FarmModel.Request;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

import java.util.ArrayList;

public class PickUpRequest extends Request {
    private int x;
    private int y;

    public PickUpRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[getX()][getY()];
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        ArrayList<ObjectInMap15_15> currentObjectInMap = new ArrayList<>(cell.getCellObjectInMap1515());
        for (ObjectInMap15_15 object : currentObjectInMap) {
            if (object instanceof Product) {
                cell.RemoveCellAMapObject(object);
                wareHouse.AddWholeObjectToStore(object);
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
