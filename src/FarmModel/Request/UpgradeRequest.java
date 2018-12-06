package FarmModel.Request;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.LiveAnimals.Animals;
import FarmModel.ObjectInMap15_15.LiveAnimals.Cat;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;

import java.util.ArrayList;

public class UpgradeRequest extends Request {
    private String object;

    public UpgradeRequest(String requestLine) {
        AnalyzeRequestlIne(requestLine);
        if (object.equals("cat")) {
            ArrayList<Animals> animals =  Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm()
                    .getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal();
            for (Animals animals1 : animals) {
                if (animals1.toString().equals("Cat")) {
                    Cat cat = (Cat)animals1;
                    cat.UpgradeCat();
                }
            }
        } else if (object.equals("truck")) {
            Truck truck = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getTruck();
            truck
        } else if (object.equals("well")) {
            Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
            well.UpgradeWell();
        } else if (object.equals("helicopter")) {

        } else if (object.equals("warehouse")) {

        } else if (object.equals("cakeBakery")) {

        } else if (object.equals("cookieBakery")) {

        } else if (object.equals("eggPowerPlant")) {

        } else if (object.equals("spinnery")) {

        } else if (object.equals("weavinFactory")) {

        } else {
            // fill after
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
