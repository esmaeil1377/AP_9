package Model;
import java.lang.*;
import java.util.ArrayList;

public class Block {
    private int Level;
    private int Id;
    static Bazar [] BazarArrayList;
    private Padafand [] PadafandArrayList;
    private static Gilgdoni Gigldini;

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

    public static void setGigldini(Gilgdoni gigldini) {
        Gigldini = gigldini;
    }

    public static int getPopulation(){
        for(int i = 0;i<Gilgdoni.HouseArrayList.length;i++){

        }
        return()
    }
}
