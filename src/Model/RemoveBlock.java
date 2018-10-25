package Model;

import static Model.Done.User;

public class RemoveBlock extends Requests {

    public RemoveBlock(int blockid){
        for(Block block:City.ArrayListblocks){
            if(block.getId()==blockid){
                City.ArrayListblocks.remove(block);
                User.setGills(User.getGills() + 10000);
            }
        }
    }
}

