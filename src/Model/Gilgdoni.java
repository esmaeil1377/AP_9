package Model;

import java.util.ArrayList;

public class Gilgdoni {
    public static ArrayList<House> HouseArrayList;
//    public int GetScore(){
//        int score = 0;
//        return score;
//    }
    public void AddHouseArrayList(House house){
        HouseArrayList.add(house);
    }

    public void RemoveHouseArrayList(House house){
        HouseArrayList.remove(house);
    }



}
