package Model;

public class AddBlock extends Requests {
    private int BlockId;

    public int getBlockId() {
        return BlockId;
    }

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public AddBlock(){
        Block block = new Block();
        block.setId(NextId.NextId());
        City.ArrayListblocks.add(block);
    }
}
