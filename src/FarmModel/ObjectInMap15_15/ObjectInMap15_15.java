package FarmModel.ObjectInMap15_15;

public abstract class ObjectInMap15_15 {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void AddToFarmMap(){}

    public void RemoveFromMap(){}

    public abstract String toString();
}
