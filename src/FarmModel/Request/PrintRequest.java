package FarmModel.Request;

import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.LiveAnimals.Animals;
import FarmModel.ObjectInMap15_15.LiveAnimals.Cat;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
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
        String[][] map = new String[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[i][j];
                ArrayList cellObject = cell.getCellObjectInMap1515();

            }
        }
    }

    public void PrintLevels() {
        Farm farm=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse=farm.getWareHouse();
        Truck truck=farm.getTruck();
        Helicopter helicopter=farm.getHelicopter();
        Well well =farm.getWell();
        ArrayList<WorkShop> workShops=farm.getWorkShops();
        ArrayList<Cat> catInMap= farm.getCurrentCatInMap();
        System.out.println("WareHosue Level: "+wareHouse.getLevel());
        System.out.println("Truck Level: "+truck.getLevel());
        System.out.println("Helicopter Level :"+helicopter.getLevel());
        System.out.println("Well Level:"+well.getLevel());
        System.out.println("Cat Level: "+catInMap.get(0).getLevel());
        for(WorkShop workShop:workShops){
            System.out.println(workShop.toString()+" Level :"+workShop.getLevel());
        }
    }

    public void PrintWareHouse() {

    }

    public void PrintWell() {

    }

    public void PrintWorkShop() {

    }

    public void PrintTruck() {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        Truck truck = farm.getTruck();
        for(Object object:truck.getGoodsThatHaveToCarry()){
            System.out.println(object.toString());
        }
    }

    public void PrintHelicopter() {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        Helicopter helicopter = farm.getHelicopter();
        for(Object object:helicopter.getGoodsThatHaveToCarry()){
            System.out.println(object.toString());
        }
    }
}
