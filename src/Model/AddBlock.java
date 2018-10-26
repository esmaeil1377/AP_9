package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;
import static View.View.AddtoOutPut;

public class AddBlock extends Requests {
    private int BlockId;

    public int getBlockId() {
        return BlockId;
    }

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public AddBlock() {
        System.out.println("hello");
        Block block = new Block();
        int blockid=City.NextBlockId.NextId();
        AddtoOutPut(String.valueOf(blockid));
        block.setId(blockid);
        if (Done.getDay()%2==0) {
            user1.city1.AddBlockArrayList(block);
            User.setGills(User.getScore() - 1000);
        } else {
            user2.city2.AddBlockArrayList(block);
            User.setGills(User.getScore() - 1000);
        }
    }
}
