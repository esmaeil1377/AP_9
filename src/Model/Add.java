package Model;

public class Add extends Requests{
    String item;
    int NumberFloor;
    int NumberUnit;
    int BlockId;

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setNumberFloor(int numberFloor) {
        NumberFloor = numberFloor;
    }

    public int getNumberFloor() {
        return NumberFloor;
    }

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public int getBlockId() {
        return BlockId;
    }

    public void setNumberUnit(int numberUnit) {
        NumberUnit = numberUnit;
    }

    public int getNumberUnit() {
        return NumberUnit;
    }
}
