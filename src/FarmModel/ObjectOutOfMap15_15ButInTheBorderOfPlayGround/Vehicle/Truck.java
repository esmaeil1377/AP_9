package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import java.util.ArrayList;

public class Truck extends TransportationVehicle {
    private ArrayList<Object> goodsThatCarry=new ArrayList<>();

    public ArrayList<Object> getGoodsThatCarry() {
        return goodsThatCarry;
    }

    public void setGoodsThatCarry(ArrayList<Object> goodsThatCarry) {
        this.goodsThatCarry = goodsThatCarry;
    }

    public Truck(){
        setActivationPrice();
        setTurnToMoveObjectToCity();
        setCapacity();
    }
    public void SellObjectToCity(ArrayList<Object> goods){
        setGoodsThatCarry(null);
        //delete onject from warehouse and increase money;
    }

    public void TransportGoodsToCity(){

    }
    public void TakeObjectFromWareHouse(ArrayList<Object> goods){
        setGoodsThatCarry(goods);

    }
}
