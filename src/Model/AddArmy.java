package Model;

import static Model.Done.User;

public class AddArmy extends Requests {
    int BlockId;

    public AddArmy(int blockId){
        for(Block block:City.ArrayListblocks){
            if(blockId == block.getId()){
                Army army = new Army();
                army.setId(NextId.NextId());
                army.setNumberOf(army.getNumberOf()+100);
                block.AddtoArmyArray(army);
                User.setGills(User.getGills() - 15000);
                break;
            }
        }
    }


    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public int getBlockId() {
        return BlockId;
    }

}
