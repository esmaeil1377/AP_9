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
import java.util.Objects;

public class UpgradeRequest extends Request {
    private String objectString;

    public UpgradeRequest(String requestLine) throws UnknownObjectException {
        try {
            AnalyzeRequestlIne(requestLine);
            if (objectString.equals("cat")) {
                ArrayList<Animals> animals = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm()
                        .getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal();
                for (Animals animals1 : animals) {
                    if (animals1.toString().equals("Cat")) {
                        Cat cat = (Cat) animals1;
                        cat.UpgradeCat();
                    }
                }
            } else if (objectString.equals("truck")) {
                Truck truck = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getTruck();
                truck.UpgradeVehicle();
            } else if (objectString.equals("well")) {
                Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
                well.UpgradeWell();
            } else if (objectString.equals("helicopter")) {
                Helicopter helicopter = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getHelicopter();
                helicopter.UpgradeVehicle();
            } else if (objectString.equals("warehouse")) {
                WareHouse wareHouse = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWareHouse();
                wareHouse.UpgradeWareHouse();
            } else {
                Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
                WorkShop workShop = farm.getspecifiedWorkShop(objectString);
                workShop.UpgradeWorkShop();
                try {
                    Objects.requireNonNull(workShop);
                } catch (NullPointerException e) {
                    throw new UnknownObjectException();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getObjectString() {
        return objectString;
    }

    public void setObjectString(String objectString) {
        this.objectString = objectString;
    }

    public void AnalyzeRequestlIne(String requestLine) {
        String[] params = requestLine.split(" ");
        setObjectString(params[1]);
    }
}
