package Model;

import java.util.ArrayList;

public class Block {
    private int Level;
    private int Id;
    private ArrayList<Bazar> BazarArrayList;
    private ArrayList<Padafand> PadafandArrayList;

    public void setBazarArrayList(ArrayList<Bazar> bazarArrayList) {
        BazarArrayList = bazarArrayList;
    }

    public ArrayList<Bazar> getBazarArrayList() {
        return BazarArrayList;
    }

    public void setPadafandArrayList(ArrayList<Padafand> padafandArrayList) {
        PadafandArrayList = padafandArrayList;
    }

    public ArrayList<Padafand> getPadafandArrayList() {
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

}
