package FarmModel.Request;

import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.LiveAnimals.Animals;
import FarmModel.ObjectInMap30_30.LiveAnimals.Cat;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.WorkShop;
import FarmModel.User;

import java.util.ArrayList;
import java.util.Objects;

public class UpgradeRequest extends Request{
    private String objectString;

    public UpgradeRequest(String requestLine) throws UnknownObjectException {
        try {
            Farm farm=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
            AnalyzeRequestlIne(requestLine);
            if (objectString.equals("cat")) {
                ArrayList<Animals> animals = farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal();
                for (Animals animals1 : animals) {
                    if (animals1.toString().equals("Cat")) {
                        Cat cat = (Cat) animals1;
                        cat.Upgrade();
                    }
                }
                User user=Game.getGameInstance().getCurrentUserAccount();
                user.setCatLevel(user.getCatLevel()+1);
            } else if (objectString.equals("truck")) {
                Truck truck = farm.getTruck();
                truck.Upgrade();
            } else if (objectString.equals("well")) {
                Well well = farm.getWell();
                well.Upgrade();
            } else if (objectString.equals("helicopter")) {
                Helicopter helicopter = farm.getHelicopter();
                helicopter.Upgrade();
            } else if (objectString.equals("warehouse")) {
                WareHouse wareHouse = farm.getWareHouse();
                wareHouse.Upgrade();
            } else {
                WorkShop workShop = farm.getspecifiedWorkShop(objectString);
                workShop.Upgrade();
                SetLevelInUserForWorkShops(workShop);
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

    private void SetLevelInUserForWorkShops(WorkShop workShop) throws UnknownObjectException {
        User user=Game.getGameInstance().getCurrentUserAccount();
        if(workShop.getWorkShopName().equals("CakeBakery")){
            user.setCakeBakeryLevel(user.getCakeBakeryLevel()+1);
        }else if(workShop.getWorkShopName().equals("CookieBakery")){
            user.setCookieBakeryLevel(user.getCookieBakeryLevel()+1);
        }else if(workShop.getWorkShopName().equals("EggPowderPlant")){
            user.setEggPOwderPlantLevel(user.getEggPOwderPlantLevel()+1);
        }else if(workShop.getWorkShopName().equals("SewingFactory")){
            user.setWeavingFactoryLevel(user.getSewingFactoryLevel()+1);
        }else if(workShop.getWorkShopName().equals("Spinnery")){
            user.setSpinneryLevel(user.getSpinneryLevel()+1);
        }else if(workShop.getWorkShopName().equals("WeavingFactory")){
            user.setWeavingFactoryLevel(user.getWeavingFactoryLevel()+1);
        }else{
            throw new UnknownObjectException();
        }
    }
}
