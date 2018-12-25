package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Cage;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap30_30.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Cookie;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.CityShop;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

public class AddVehicleRequest extends Request {
    private String vehicleName;
    private int count;
    private ObjectInMap30_30 object;

    public AddVehicleRequest(String request) throws MissionNotLoaded {
        AnalyzeRequestLine(request);
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse = farm.getWareHouse();
        if (vehicleName.equals("Truck")) {
            Truck truck = farm.getTruck();
            Object object = farm.getObjectInWareHouse(this.object);
            for (int i = 0; i < count; i++)
                truck.TakeObjectFromWareHouse(object);

        } else if (vehicleName.equals("Helicopter")) {

            Helicopter helicopter = farm.getHelicopter();
//            CityShop cityShop = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getCityShop();
            for (int i = 0; i < count; i++)
                helicopter.BuyObjectFromCityAndGetMoneyFromUser(getObject());
        }
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setObject(ObjectInMap30_30 object) {
        this.object = object;
    }

    public ObjectInMap30_30 getObject() {
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
        } else if (itemName.equals("Cake")) {
            setObject(new Cake());
        } else if (itemName.equals("Cookie")) {
            setObject(new Cookie());
        } else if (itemName.equals("Powder")) {
            setObject(new Powder());
        } else if (itemName.equals("Cage")) {
            setObject(new Cage(null));
        }
    }
}
