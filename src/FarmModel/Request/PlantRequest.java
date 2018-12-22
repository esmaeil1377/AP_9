package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;

public class PlantRequest extends Request {
    private int x;
    private int y;

    public PlantRequest(String requestlIne) throws MissionNotLoaded {
        AnalyzeRequestLine(requestlIne);
        Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
        if (well.getWaterOfTheBucket() > 0) {
            well.setWaterOfTheBucket(well.getWaterOfTheBucket() - 1);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (getX() + i >= 0 && getX() + i < 16 && getY() + j >= 0 && getY() + j < 16) {
                        Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[getX() + i][getY() + j];
                        cell.AddCellAMapObject(new Grass());
                    }
                }
            }
        } else {
            // doing something is wrong
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
