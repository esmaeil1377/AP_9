package Model;

public class AddHome extends Requests {
    private int BlockId;
    private int NumberFloor;
    private int NumberUnit;

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public void setNumberFloor(int numberFloor) {
        NumberFloor = numberFloor;
    }

    public void setNumberUnit(int numberUnit) {
        NumberUnit = numberUnit;
    }

    public AddHome(int blockid,int numberFloor,int numberUnit){
        for(Block block:City.ArrayListblocks){
            if(blockid==block.getId()){
                House house=new House();
                house.setId(NextId());
                for()
                block.getHouseArrayList().add(house);
            }
        }
    }
}
