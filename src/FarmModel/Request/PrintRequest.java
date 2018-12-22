package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.LiveAnimals.Cat;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import java.util.ArrayList;

public class PrintRequest extends Request {
    private String commandName;

    public PrintRequest(String requestLine) throws MissionNotLoaded {
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
        setCommandName(params[1]);
    }

    public void PrintInfo() {

    }

    public void PrintMap() throws MissionNotLoaded {
        //Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[2][3];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Cell cell = Farm.getCellByPosition(i,j);
                ArrayList<ObjectInMap15_15> cellObject = cell.getCellObjectInMap1515();
                System.out.print("[");
                for (ObjectInMap15_15 objectInMap15_15 : cellObject) {
                    System.out.print(objectInMap15_15.toString() + ",");
                }
                System.out.print("]  ");
            }
            System.out.println();
        }
    }

    private void PrintLevels() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse = farm.getWareHouse();
        Truck truck = farm.getTruck();
        Helicopter helicopter = farm.getHelicopter();
        Well well = farm.getWell();
        ArrayList<WorkShop> workShops = farm.getWorkShops();
        ArrayList<Cat> catInMap = farm.getCurrentCatInMap();
        System.out.println("WareHosue Level: " + wareHouse.getLevel());
        System.out.println("Truck Level: " + truck.getLevel());
        System.out.println("Helicopter Level :" + helicopter.getLevel());
        System.out.println("Well Level:" + well.getLevel());
        System.out.println("Cat Level: " + catInMap.get(0).getLevel());
        for (WorkShop workShop : workShops) {
            System.out.println(workShop.toString() + " Level :" + workShop.getLevel());
        }
    }

    private void PrintWareHouse() throws MissionNotLoaded {
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
        ArrayList<Object> wareHouseList = wareHouse.getWareHouseList();
        for (Object object : wareHouseList) {
            System.out.println(object.toString());
        }
    }

    private void PrintWell() throws MissionNotLoaded {
        Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
        System.out.println("water of bucket:" + well.getWaterOfTheBucket());
        System.out.println("activated or No " + well.isWellActivatedToFillTheBucket());
    }

    private void PrintWorkShop() throws MissionNotLoaded {
        ArrayList<WorkShop> workShops = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWorkShops();
        for (WorkShop workShop : workShops) {
            System.out.println(workShop.toString() + "Output Product: " + workShop.getResultProduct());
            for (Object object : workShop.getObjectNeededToProduceAProduct().keySet())
                System.out.println(workShop.toString() + "Input Product: " + workShop.getResultProduct());
        }

    }

    private void PrintTruck() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        Truck truck = farm.getTruck();
        for (Object object : truck.getGoodsThatHaveToCarry()) {
            System.out.println(object.toString());
        }
    }

    private void PrintHelicopter() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        Helicopter helicopter = farm.getHelicopter();
        for (Object object : helicopter.getGoodsThatHaveToCarry()) {
            System.out.println(object.toString());
        }
    }
}
