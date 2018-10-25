package Model;

import java.util.ArrayList;

public class Block {
    private int Level;
    private static int Id;
    static Bazar [] BazarArrayList;
    private Padafand [] PadafandArrayList;
    public static House[] HouseArrayList;

    public void setBazarArrayList( Bazar [] bazarArrayList) {
        BazarArrayList = bazarArrayList;
    }

    public Bazar [] getBazarArrayList() {
        return BazarArrayList;
    }

    public void setPadafandArrayList( Padafand [] padafandArrayList) {
        PadafandArrayList = padafandArrayList;
    }

    public  Padafand [] getPadafandArrayList() {
        return PadafandArrayList;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getLevel() {
        return Level;
    }

    public static double getScore(){
        double Score=0;
        for(int i = 0;i<HouseArrayList.length;i++){
            for(int j =0; j<House.ArrayListFloors.length;j++){

                        House house=HouseArrayList[i];
                    Floor floor = House.ArrayListFloors[j];
                      Score +=(floor.ArrayListunits.length) *5;
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
