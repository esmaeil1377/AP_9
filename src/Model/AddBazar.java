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
        for(Block block:City.ArrayListblocks){
            if(blockId == block.getId()){
                Bazar bazar = new Bazar();
                Bazar.setId(NextId.NextId());

                block.getBazarArrayList().add(bazar);
                User.setGills(User.getGills() - 6000);
            }
        }
    }
}
