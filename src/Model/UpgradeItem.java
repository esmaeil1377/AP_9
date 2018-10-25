package Model;

public class UpgradeItem extends Requests {

    public UpgradeItem(int blockId,int unitid){
        for(Block block:City.ArrayListblocks){
            if(block.getId()==blockId){
                block.setLevel(block.getLevel()+1);
            }
        }

    }
}
