package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle;

import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import java.util.ArrayList;

public abstract class TransportationVehicle extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level = 0;
    private int turnToMoveObjectToCityAndComeBack;
    private int capacity;
    private int remainTurnToMoveObjectToCityAndComeBack;
    private ArrayList<Object> goodsThatCarry = new ArrayList<>();
    private boolean isVehicleActivated = false;

    public void setVehicleActivated(boolean vehicleActivated) {
        isVehicleActivated = vehicleActivated;
    }

    public boolean IsVehicleActivated() {
        return isVehicleActivated;
    }

    void setGoodsThatHaveToCarry(ArrayList<Object> goodsThatCarry) {
        this.goodsThatCarry = goodsThatCarry;
    }

    public ArrayList<Object> getGoodsThatHaveToCarry() {
        return goodsThatCarry;
    }

    public void setRemainTurnToMoveObjectToCityAndComeBack(int remainTurnToMoveObjectToCity) {
        this.remainTurnToMoveObjectToCityAndComeBack = remainTurnToMoveObjectToCity;
    }

    public int getRemainTurnToMoveObjectToCityAndComeBack() {
        return remainTurnToMoveObjectToCityAndComeBack;
    }

    public int getLevel() {
        return Level;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    void setTurnToMoveObjectToCityAndComeBack(int turnToMoveObjectToCityAndComeBack) {
        this.turnToMoveObjectToCityAndComeBack = turnToMoveObjectToCityAndComeBack;
    }

    public int getTurnToMoveObjectToCityAndComeBack() {
        return turnToMoveObjectToCityAndComeBack;
    }

    public static int CalculatePriceToBuy(ArrayList<Object> goods) {
        int price;
        for (Object object : goods) {
            if (object.toString().equals("Egg")) {
            } else if (object.toString().equals("Milk")) {
            }

        }
    }

    public static int CalculatePriceForSell(ArrayList<Object> goods) {
        int price = 0;
        for (Object object : goods) {
            if (object.toString().equals("Egg")) {
                price += InformationNeededInGame.GetData("PriceForSellEgg");
            } else if (object.toString().equals("Milk")) {
                price += InformationNeededInGame.GetData("PriceForSellMilk");
            } else if (object.toString().equals("Wool")) {
                price += InformationNeededInGame.GetData("PriceForSellWool");
            } else if (object.toString().equals("Cage")) {
                Cage cage = (Cage) object;
                if (cage.getWildAnimals().toString().equals("Lion")) {
                    price += InformationNeededInGame.GetData("PriceForSellCageLion");
                } else if (cage.getWildAnimals().toString().equals("Bear")) {
                    price += InformationNeededInGame.GetData("PriceForSellCageBear");
                }
            } else if (object.toString().equals("Cake")) {
                price += InformationNeededInGame.GetData("PriceForSellCake");
            } else if (object.toString().equals("Cookie")) {
                price += InformationNeededInGame.GetData("PriceForSellCookie");
            } else if (object.toString().equals("Power")) {
                price += InformationNeededInGame.GetData("PriceForSellPowder");
            } // add new if for other workshop product
        }
        return price;
    }
}
