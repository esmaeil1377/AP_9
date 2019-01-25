package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.FlouryCake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class AddVehicleRequest extends Request {
    private String vehicleName;
    private int count;
    private ObjectInMap15_15 object;

    public AddVehicleRequest(String request) throws MissionNotLoaded {
        AnalyzeRequestLine(request);
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse = farm.getWareHouse();
        if (vehicleName.equals("Truck")) {
            Truck truck = farm.getTruck();
            if(!truck.IsVehicleActivated()) {
                Object object = farm.getObjectInWareHouse(this.object);
                for (int i = 0; i < count; i++)
                    truck.TakeObjectFromWareHouse(object);
            }
        } else if (vehicleName.equals("Helicopter")) {
            Helicopter helicopter = farm.getHelicopter();
            if(!helicopter.IsVehicleActivated()) {
                for (int i = 0; i < count; i++)
                    helicopter.AddObjectToListForBuyToHelicopter(getObject());
            }
        }
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setObject(ObjectInMap15_15 object) {
        this.object = object;
    }

    public ObjectInMap15_15 getObject() {
        return object;
    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] request = requestLine.split(" ");
        String vehicleName = request[0];
        String itemName = request[2];
        int Count = Integer.valueOf(request[3]);
        setCount(Count);
        setVehicleName(vehicleName);
        if (itemName.equals("Egg")) {
            setObject(new Egg());
        } else if (itemName.equals("Milk")) {
            setObject(new Milk());
        } else if (itemName.equals("Wool")) {
            setObject(new Wool());
        } else if (itemName.equals("FlouryCake")) {
            setObject(new FlouryCake());
        } else if (itemName.equals("Cake")) {
            setObject(new Cake());
        } else if (itemName.equals("Powder")) {
            setObject(new Powder());
        } else if (itemName.equals("Cage")) {
            setObject(new Cage(null));
        }
    }
}
