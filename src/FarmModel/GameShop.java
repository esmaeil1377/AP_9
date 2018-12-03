package FarmModel;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

import java.util.ArrayList;
import java.util.HashMap;

public class GameShop {
    private ArrayList<WorkShop> workshopoffeirng=new ArrayList<>();

    public class Shop {
        HashMap<Object,Integer> Shop=new HashMap<>();

        public Shop(){
            setShop();
        }

        public void setShop(HashMap<Object, Integer> shop) {
            Shop = shop;
        }

        public void showOfferings(){}
    }
}
