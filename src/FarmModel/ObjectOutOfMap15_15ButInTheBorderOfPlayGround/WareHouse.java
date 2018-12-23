package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround;

import FarmController.Exceptions.*;
import FarmController.Interfaces.Upgradeable;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;

import java.util.ArrayList;
import java.util.HashMap;

public class WareHouse extends ObjectOutOfMap15_15ButInTheBorderOfPlayGround implements Upgradeable {
    private int Level = 0;
    private ArrayList<Object> wareHouseList = new ArrayList<>();
    private int capacityOfWareHouse = 50;
    private int remainCapacityOfWareHouse = 50;
    private HashMap<Class, Integer> recordNoteBookThatRecordEveryThingAndNumbers = new HashMap<>();

    public int getRemainCapacityOfWareHouse() {
        return remainCapacityOfWareHouse;
    }

    public void setRemainCapacityOfWareHouse(int remainCapacityOfWareHouse) {
        this.remainCapacityOfWareHouse = remainCapacityOfWareHouse;
    }

    public WareHouse() {
    }

    public int getLevel() {
        return Level;
    }

    private void setCapacityOfWareHouse(int capacityOfWareHouse) {
        this.capacityOfWareHouse = capacityOfWareHouse;
    }

    public int getCapacityOfWareHouse() {
        return capacityOfWareHouse;
    }

    public void AddWholeObjectToStore(Object object) throws FullWareHouse {
        int spaceNeededForObjectInWareHouse = InformationNeededInGame.getInformationNeededInGame().getSpaceNeededInWareHouse(object);
        // to improve this we should change Information class to methods to code clearer.
        if (getRemainCapacityOfWareHouse() > spaceNeededForObjectInWareHouse) {
            wareHouseList.add(object);
            RecordThisTransActionThatWholeObjectAddedToWareHouse(object);
            setRemainCapacityOfWareHouse(getRemainCapacityOfWareHouse() - spaceNeededForObjectInWareHouse);
        }
        throw new FullWareHouse();
    }

    public HashMap<Class, Integer> getRecordNoteBookThatRecordEveryThingAndNumbers() {
        return recordNoteBookThatRecordEveryThingAndNumbers;
    }


    //this will remove warehouse a piece of object not whole of it but
    public void RemovePieceOfObjectFromWareHouse(Object object) {
        for (Object objects : wareHouseList) {
            if (objects.toString().equals(object.toString())) {
                wareHouseList.remove(objects);
                setRemainCapacityOfWareHouse(getRemainCapacityOfWareHouse() - 1);
                return;
            }
        }
        try {
            throw new ObjectNotFoundInWareHouse();
        }catch (ObjectNotFoundInWareHouse e){
            e.printStackTrace();
        }
    }

    public void RecordThisTransActionThatWholeObjectAddedToWareHouse(Object object) {
        Class classObject = object.getClass();
        if (recordNoteBookThatRecordEveryThingAndNumbers.containsKey(classObject)) {
            recordNoteBookThatRecordEveryThingAndNumbers.put(classObject, recordNoteBookThatRecordEveryThingAndNumbers.get(classObject) + 1);
        } else {
            recordNoteBookThatRecordEveryThingAndNumbers.put(classObject, 1);
        }

    }

    public ArrayList<Object> getWareHouseList() {
        return wareHouseList;
    }

    public void Upgrade() throws NotEnoughMoney, MaxLevelExceeded, UnknownObjectException, MissionNotLoaded {
//        Level++;
//        if (Level == 1) {
//            setCapacityOfWareHouse(150);
//        } else if (Level == 2) {
//            setCapacityOfWareHouse(300);
//        } else if (Level == 3) {
//            setCapacityOfWareHouse(600);
//        }
        int maxLevel = 3;
        int priceNeed = InformationNeededInGame.getInformationNeededInGame().getPriceForUpgrade(this);
        int missionMoney = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionMoney();
        if (getLevel() < maxLevel) {
            if (priceNeed < missionMoney) {
                Level++;
                Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().setMissionMoney(missionMoney - priceNeed);
            } else {
                throw new NotEnoughMoney();
            }
        } else {
            throw new MaxLevelExceeded();
        }
        //upgrade change it's shape.don't forget it.
        //after all we have to change the price to for upgrading the warehouse in Information class.
    }

    @Override
    public String toString() {
        return "WareHouse";
    }
}

