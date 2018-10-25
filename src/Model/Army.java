package Model;

public class Army {
   private float Level =(float)0.2;
   private int Id;
   private int NumberOf=0;

    public void setNumberOf(int numberOf) {
        NumberOf = numberOf;
    }

    public int getNumberOf() {
        return NumberOf;
    }

    public void setLevel(float level) {
        Level = level;
    }

    public float getLevel() {
        return Level;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }
    public void Attak(int BlockId){

    }
    public void Loot(int BlockId){

    }
}
