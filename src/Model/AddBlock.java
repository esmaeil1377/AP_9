package Model;

public class AddBlock extends Requests {
    private int BlockId;

    public int getBlockId() {
        return BlockId;
    }

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public AddBlock(int blockId){
        Block block = new Block();
        block.setId(blockId);
        City.ArrayListblocks.add(block);
    }
}
