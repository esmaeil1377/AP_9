package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import FarmController.Exceptions.ObjectNotFoundInWareHouse;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.LiveAnimals.Bear;
import FarmModel.ObjectInMap15_15.LiveAnimals.Lion;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.Powder;

import java.util.ArrayList;
import java.util.HashMap;

public class WareHouse extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround {
    private int Level;
    private ArrayList<Object> wareHouseList = new ArrayList<>();
    private int capacityOfWareHouse;
    private HashMap<Class, Integer> recordNoteBookThatRecoredEveryThingAndNumbers = new HashMap<>();

    public WareHouse(){
        setCapacityOfWareHouse();
    }

    private void setCapacityOfWareHouse(int capacityOfWareHouse) {
        this.capacityOfWareHouse = capacityOfWareHouse;
    }

    public int getCapacityOfWareHouse() {
        return capacityOfWareHouse;
    }

    public void AddObjectToStore(Object object) {
        wareHouseList.add(object);
        RecordThisTransActionThatAddedToWareHouse(object);


    }

    public void RemoveObjectFromWareHouse(Object object) {
        if(wareHouseList.contains(object)) {
            for(Object objects:wareHouseList){
                if(objects.getClass().equals(object.getClass())){
                    wareHouseList.remove(objects);
                }
            }
            return;
        }
        throw new ObjectNotFoundInWareHouse();
    }

    public void RecordThisTransActionThatAddedToWareHouse(Object object) {
        Class classObject=object.getClass();
        int NumberOfTheObjectThatWereInWareHouseAndThisTime = 0;
        if(recordNoteBookThatRecoredEveryThingAndNumbers.containsKey(classObject)){
            recordNoteBookThatRecoredEveryThingAndNumbers.put(classObject,recordNoteBookThatRecoredEveryThingAndNumbers.get(classObject)+1);
        }
        else{
            recordNoteBookThatRecoredEveryThingAndNumbers.put(classObject,1);
        }

    }

    public ArrayList<Object> getWareHouseList() {
        return wareHouseList;
    }

    public void UpgradadeWareHouse() {
        Level++;
        setCapacityOfWareHouse(getCapacityOfWareHouse()*);
        //upgrade change it's shape.don't forget it.
    }

    @Override
    public String toString() {
        return "WareHouse";
    }
}

