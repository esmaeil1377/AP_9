package Model;

public class RemoveBlock extends Requests {

    public RemoveBlock(int blockid){
        for(Block block:City.ArrayListblocks){
            if(block.getId()==blockid){
                City.ArrayListblocks.remove(block);
            }
        }
        }
    }

