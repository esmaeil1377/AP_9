package Model;

public class Padafand {
    private int Id;
    private int level = 0;

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
