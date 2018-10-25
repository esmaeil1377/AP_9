package Model;

public class AddBazar extends Requests {
    private int BlockId;

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public int getBlockId() {
        return BlockId;
    }

    public AddBazar(int blockId){
        this.BlockId=blockId;
    }
}
