package Model;

public class AddArmy extends Requests {
    int BlockId;

    public AddArmy(int blockId){
        this.BlockId=blockId;

    }


    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public int getBlockId() {
        return BlockId;
    }

}
