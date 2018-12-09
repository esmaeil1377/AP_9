package FarmModel.Request;

import FarmController.Exceptions.UnknownObjectException;
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

public class UpgradeRequest extends Request {
    private String object;

    public UpgradeRequest(String requestLine) {
        //for every upgrade we should change the HashMap in GameShop because price should change for every upgrade.
        //
        //
        ////
        AnalyzeRequestlIne(requestLine);
        if (object.equals("cat")) {
            ArrayList<Animals> animals = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm()
                    .getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal();
            for (Animals animals1 : animals) {
                if (animals1.toString().equals("Cat")) {
                    Cat cat = (Cat) animals1;
                    cat.UpgradeCat();
                }
            }
        } else if (object.equals("truck")) {
            Truck truck = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getTruck();
            truck.UpgradeTruck();
        } else if (object.equals("well")) {
            Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
            well.UpgradeWell();
        } else if (object.equals("helicopter")) {
            Helicopter helicopter = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getHelicopter();
            helicopter.UpgradeHelicopter();
        } else if (object.equals("warehouse")) {
            WareHouse wareHouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
            wareHouse.UpgradeWareHouse();
        } else {
            Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
            WorkShop workShop = farm.getspecifiedWorkShop(object);
            workShop.UpgradeWorkShop();
            throw new UnknownObjectException();
        }
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void AnalyzeRequestlIne(String requestLine) {
        String[] params = requestLine.split(" ");
        setObject(params[1].substring(1, params[1].length() - 1));
    }
}
