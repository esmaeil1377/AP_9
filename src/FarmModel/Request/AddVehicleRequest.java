package FarmModel.Request;

import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cookie;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;

public class AddVehicleRequest extends Request {
    private String vehicleName;
    private String itemName;
    private int count;
    private Object object;

    public AddVehicleRequest(String request) {
        AnalyzeRequestLine(request);
        Farm farm=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        WareHouse wareHouse=farm.getWareHouse();
        if(vehicleName.equals("truck")){
            Truck truck=farm.getTruck();
            Object object=farm.getObjectInWareHouse(this.object);
            for(int i=0 ; i < count ; i++)
            truck.TakeObjectFromWareHouse(object);

        }else if(vehicleName.equals("helicopter")){

           Helicopter helicopter = farm.getHelicopter();
           Object object = farm.getObjectInWareHouse(this.object);
           for(int i=0 ; i < count ; i++)
           helicopter.BuyObjectFromCityAndGetMoneyFromUser(object);
        }
    }


    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void AnalyzeRequestLine(String requestLine){
        String[] request=requestLine.split(" ");
        String vehicleName=request[0];
        String itemName=request[2];
        int Count = Integer.valueOf(request[3]);
        setCount(Count);
        setItemName(itemName);
        setVehicleName(vehicleName);
        if(itemName.equals("Egg")){
            setObject(new Egg());
        }
        else if(itemName.equals("Milk")){
            setObject(new Milk());
        }
        else if(itemName.equals("Wool")){
            setObject(new Wool());
        }
        else if(itemName.equals("Cake")){
            setObject(new Cake());
        }
        else if(itemName.equals("Cookie")){
            setObject(new Cookie());
        }
        else if(itemName.equals("Powder")){
            setObject(new Powder());
        }
        else if(itemName.equals("Cage")){
            setObject(new Cage(null));
        }
    }
}
