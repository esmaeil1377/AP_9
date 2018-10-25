package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class RemoveBlock extends Requests {

    public RemoveBlock(int blockid){
        if(User.equals(user1)) {
            for (Block block : user1.city1.ArrayListblocks) {
                if (block.getId() == blockid) {
                    user1.city1.ArrayListblocks.remove(block);
                    user1.setGills(user1.getGills() + 10000);
                }
            }
        }
        else{
            for (Block block : user2.city2.ArrayListblocks) {
                if (block.getId() == blockid) {
                    user2.city2.ArrayListblocks.remove(block);
                    user2.setGills(user2.getGills() + 10000);
                }
            }
        }
    }
}

