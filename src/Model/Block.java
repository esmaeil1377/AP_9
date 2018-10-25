package Model;

import java.util.ArrayList;

public class Block {
    private int Level = 1;
    private int Id;
    static ArrayList<Bazar> BazarArrayList;
    private ArrayList<Padafand> PadafandArrayList;
    private static ArrayList<House> HouseArrayList;
    private static ArrayList<Army> ArmyArrayList;


    public static void setArmyArrayList(ArrayList<Army> armyArrayList) {
        ArmyArrayList = armyArrayList;
    }

    public static ArrayList<House> getHouseArrayList() {
        return HouseArrayList;
    }

    public static void setHouseArrayList(ArrayList<House> houseArrayList) {
        HouseArrayList = houseArrayList;
    }

    public static ArrayList<Army> getArmyArrayList() {
        return ArmyArrayList;
    }

    public void setBazarArrayList(ArrayList<Bazar> bazarArrayList) {
        BazarArrayList = bazarArrayList;
    }

    public ArrayList<Bazar> getBazarArrayList() {
        return BazarArrayList;
    }

    public void setPadafandArrayList(ArrayList<Padafand> padafandArrayList) {
        PadafandArrayList = padafandArrayList;
    }

    public  ArrayList<Padafand> getPadafandArrayList() {
        return PadafandArrayList;
    }

    public static void setLevel(int level) {
        Level = level;
    }

    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }

    public static int getLevel() {
        return Level;
    }

    public static double getScore(){
        double Score=0;
        for(House house:Block.getHouseArrayList()){
            for(Floor floor:house.getArrayListFloors()){
                      Score +=(floor.ArrayListunits.size()) *5;
                }

            }
            if(Bazar.Level == 1)
                Score *=1.2;
            if(Bazar.Level == 2)
                Score *=1.4;
            if(Bazar.Level == 3)
                Score *=1.6;
        return(Score);
    }

}
