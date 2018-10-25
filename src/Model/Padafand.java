package Model;

public class Padafand {
    private int Id;
    private int numofperson=0;
    private int level = 1;


    public void setNumofperson(int numofperson) {
        this.numofperson = numofperson;
    }

    public int getNumofperson() {
        return numofperson;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
