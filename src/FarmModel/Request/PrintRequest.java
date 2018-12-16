package FarmModel.Request;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

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
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[i][j];
                ArrayList<ObjectInMap15_15> cellObject = cell.getCellObjectInMap1515();
                System.out.print("[");
                for (ObjectInMap15_15 objectInMap15_15 :cellObject) {
                    System.out.print(objectInMap15_15.toString()+",");
                }
                System.out.print("]  ");
            }
            System.out.println();
        }
    }

    public void PrintLevels() {

    }

    public void PrintWareHouse() {
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        ArrayList<Object> wareHouseList = wareHouse.getWareHouseList();
        for (Object object: wareHouseList) {
            System.out.println(object.toString());
        }
    }

    public void PrintWell() {
        Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
        System.out.println("water of bucket:" + well.getWaterOfTheBucket());
        System.out.println("activated or No " + well.isWellActivatedToFillTheBucket());
    }

    public void PrintWorkShop() {
        ArrayList<WorkShop> workShops = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWorkShops();
        for (:) {

        }

    }

    public void PrintTruck() {

    }

    public void PrintHelicopter() {

    }
}
