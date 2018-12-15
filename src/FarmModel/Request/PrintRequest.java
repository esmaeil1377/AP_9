package FarmModel.Request;

import FarmModel.Cell;
import FarmModel.Game;

import java.util.ArrayList;

public class PrintRequest extends Request {
    private String commandName;

    public PrintRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        if (commandName.equals("info")) {
            PrintInfo();
        } else if (commandName.equals("map")) {
            PrintMap();
        } else if (commandName.equals("levels")) {
            PrintLevels();
        } else if (commandName.equals("warehouse")) {
            PrintWareHouse();
        } else if (commandName.equals("well")) {
            PrintWell();
        } else if (commandName.equals("workshop")) {
            PrintWorkShop();
        } else if (commandName.equals("truck")) {
            PrintTruck();
        } else if (commandName.equals("helicopter")) {
            PrintHelicopter();
        }
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] params = requestLine.split(" ");
        setCommandName(params[1].substring(1, params[1].length() - 1));
    }

    public void PrintInfo() {

    }

    public void PrintMap() {
        //Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[2][3];
        String[][] map = new String[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[i][j];
                ArrayList cellObject = cell.getCellObjectInMap1515();

            }
        }
    }

    public void PrintLevels() {

    }

    public void PrintWareHouse() {

    }

    public void PrintWell() {

    }

    public void PrintWorkShop() {

    }

    public void PrintTruck() {

    }

    public void PrintHelicopter() {

    }
}
