package FarmModel.Request;

import FarmController.Exceptions.BucketIsEmptyException;
import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;

public class PlantRequest extends Request {
    private int x;
    private int y;

    public PlantRequest(String requestlIne) throws MissionNotLoaded, BucketIsEmptyException {
        AnalyzeRequestLine(requestlIne);
        Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
        if (well.getWaterOfTheBucket() > 0) {
            well.setWaterOfTheBucket(well.getWaterOfTheBucket() - 1);
            int x = getX();
            int y = getY();
            if (getX() < 30 && getX() >= 0 && getY() < 30 && getY() >= 0) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (x + i >= 0 && x + i < 30 && y + j >= 0 && y + j < 30) {
                            Cell cell = Farm.getCellByPosition(y + j, x + i);
                            Grass grass=new Grass();
                            grass.setX(y+j);
                            grass.setY(x+i);
                            cell.AddCellAMapObject(grass);
                        }
                    }
                }
            } else {
                System.out.println("Wrong Input");
            }
        } else {
            throw new BucketIsEmptyException();
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
