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
import java.util.HashMap;
import java.util.Map;

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
        } else if (commandName.equals("workshops")) {
            PrintWorkShop();
        } else if (commandName.equals("truck")) {
            PrintTruck();
        } else if (commandName.equals("helicopter")) {
            PrintHelicopter();
        }
    }

    private String getCommandName() {
        return commandName;
    }

    private void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] params = requestLine.split(" ");
        setCommandName(params[1]);
    }

    private void PrintInfo() throws MissionNotLoaded {
        System.out.println("Money : " + Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionMoney());
        System.out.println("Turn : " + Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getTimeTakeForPlayerToFinishTheMap());
        System.out.print("Requirement : ");
        HashMap<Object, Integer> hashMap = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getRequirementToFinishTheMission();
        for (Map.Entry<Object, Integer> entry : hashMap.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue());
            System.out.print(" ");
        }
        System.out.println();
        WareHouse wareHouse=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        System.out.print("WareHouse List:");
        for(Object object:wareHouse.getWareHouseList()){
            System.out.print(object.toString()+",");
        }
        System.out.println();
    }

    private void PrintMap() throws MissionNotLoaded {
        for (int i = 0; i < 30; i++) {
            System.out.print((i)+":");
            for (int j = 0; j < 30; j++) {
                Cell cell = Farm.getCellByPosition(i,j);
                ArrayList<ObjectInMap15_15> cellObject = cell.getCellObjectInMap15_15();
                System.out.print("[");
                int numOfCellObject=cellObject.size();
                int count = 0;
                for (ObjectInMap15_15 objectInMap15_15 : cellObject) {
                    System.out.print(objectInMap15_15.toString());
                    if (count < numOfCellObject - 1) {
                        System.out.print(",");
                    }
                    count++;
                }
//                if(numOfCellObject<3){
//                    for(int ii=0;ii<3-numOfCellObject;ii++){
//                        System.out.print("   ,");
//                    }
//                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    private void PrintLevels() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse = farm.getWareHouse();
        Truck truck = farm.getTruck();
        Helicopter helicopter = farm.getHelicopter();
        Well well = farm.getWell();
        ArrayList<WorkShop> workShops = farm.getWorkShops();
        ArrayList<Cat> catInMap = farm.getCurrentCatInMap();
        System.out.println("WareHouse level: " + wareHouse.getLevel());
        System.out.println("Truck level: " + truck.getLevel());
        System.out.println("Helicopter level :" + helicopter.getLevel());
        System.out.println("Well level:" + well.getLevel());
        if(catInMap.size() != 0)
        System.out.println("Cat level: " + catInMap.get(0).getLevel());
        else
            System.out.println("There are not cats in map");
        for (WorkShop workShop : workShops) {
            System.out.println(workShop.toString() + " level :" + workShop.getLevel());
        }
    }

    private void PrintWareHouse() throws MissionNotLoaded {
        System.out.print("Warehouse: ");
        WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        ArrayList<Object> wareHouseList = wareHouse.getWareHouseList();
        for (Object object : wareHouseList) {
            System.out.print(object.toString());
        }
    }

    private void PrintWell() throws MissionNotLoaded {
        Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
        System.out.println("water of bucket:" + well.getWaterOfTheBucket());
        System.out.println("activated: " + well.isWellActivatedToFillTheBucket());
    }

    private void PrintWorkShop() throws MissionNotLoaded {
        ArrayList<WorkShop> workShops = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWorkShops();
        for (WorkShop workShop : workShops) {
            System.out.println(workShop.toString() + "Output Product: " + workShop.getResultProduct());
            for (Object object : workShop.getObjectNeededToProduceAProduct().keySet())
                System.out.println(workShop.toString() + "Input Product: " + object.toString());
        }

    }

    private void PrintTruck() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        Truck truck = farm.getTruck();
        System.out.print("Truck :");
        for (Object object : truck.getGoodsThatHaveToCarry()) {
            System.out.print(object.toString()+",");
        }
        System.out.println();
    }

    private void PrintHelicopter() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        Helicopter helicopter = farm.getHelicopter();
        System.out.print("Helicopter :");
        for (Object object : helicopter.getGoodsThatHaveToCarry()) {
            System.out.print(object.toString()+",");
        }
        System.out.println();
    }
}
