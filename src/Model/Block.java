package Model;

import java.util.ArrayList;

public class Block {
    private static int Level = 1;
    private static int Id;
    public static ArrayList<Bazar> BazarArrayList=new ArrayList<>();
    public static ArrayList<Padafand> PadafandArrayList=new ArrayList<>();
    private static ArrayList<House> HouseArrayList=new ArrayList<>();
    public static ArrayList<Army> ArmyArrayList=new ArrayList<>();
    public NextitemId NextUnitId=new NextitemId();

    public static int CalculaTedadItems(Block block){
        int out=0;
        out+=(block.getBazarArrayList(block).size());
        out+=block.getPadafandArrayList().size();
        out+=block.getHouseArrayList().size();
        out+=block.getArmyArrayList().size();
        return(out);
    }


    public void AddtoHouseArray(House house){
    HouseArrayList.add(house);}

    public void AddtoArmyArray(Army army){
        ArmyArrayList.add(army);
    }

    public void AddtoBazarArray(Bazar bazar){
        BazarArrayList.add(bazar);
    }

    public void AddtoPadafandArray(Padafand padafand){
        PadafandArrayList.add(padafand);
    }

    public void RemoveHouseArray(House house){
        HouseArrayList.remove(house);
    }

    public void RemoveBazarArray(Bazar bazar){
        BazarArrayList.remove(bazar);
    }

    public void RemoveArmyArray(Army army){
        ArmyArrayList.remove(army);
    }

    public void RemovePadafandArray(Padafand padafand){
        PadafandArrayList.remove(padafand);
    }


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

    public static ArrayList<Bazar> getBazarArrayList(Block block) {
        return BazarArrayList;
    }

    public void setPadafandArrayList(ArrayList<Padafand> padafandArrayList) {
        PadafandArrayList = padafandArrayList;
    }

    public  static ArrayList<Padafand> getPadafandArrayList() {
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

    public static int getPupulation(){
        int Pupulation =0;
        for(House house:Block.getHouseArrayList()){
            for(Floor floor:house.getArrayListFloors()){
                Pupulation +=(floor.ArrayListunits.size()) *5;
            }


        }

        return(Pupulation);
    }



    public static void setScoreForPersonsForAddingBazar(Bazar bazar ){
        for(House house:Block.getHouseArrayList()){
            for(Floor floor:house.getArrayListFloors()){
                for(Unit unit:floor.getArrayListunits()){
                    for(Person person:unit.getPersonArrayList()){
                        person.setPersonScore((float)(person.getPersonScore()*(1+(bazar.getLevel()*(0.2)))));
                    }
                }

            }
        }
    }


    public void setScoreForPersonsForRemovingBazar(Bazar bazar ){
        for(House house:Block.getHouseArrayList()){
            for(Floor floor:house.getArrayListFloors()){
                for(Unit unit:floor.getArrayListunits()){
                    for(Person person:unit.getPersonArrayList()){
                        person.setPersonScore((float)(person.getPersonScore()/(1+(bazar.getLevel()*(0.2)))));
                    }
                }

            }
        }
    }





    public static int getٍEmployedNum(Block block){
        int employedpeople=0;
        for(Bazar bazar:block.getBazarArrayList(block)){
            int lev=bazar.getLevel();
            employedpeople+=50+(lev-1)*20;
        }
        for(Army army:Block.getArmyArrayList()){
            employedpeople+=100+(army.getLevel()-1)*10;
        }
        for(Padafand padafand:Block.getPadafandArrayList()){
            employedpeople+=30;
        }
        return(employedpeople);
    }


}