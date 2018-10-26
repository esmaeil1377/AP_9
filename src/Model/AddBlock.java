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
        if (Done.getDay()%2==0) {
            Block block = new Block();
            int blockid=user1.city1.NextBlockId.NextId();
            AddtoOutPut(String.valueOf(blockid));
            block.setId(blockid);
            user1.city1.AddBlockArrayList(block);
            user1.setGills(user1.getScore() - 1000);
        }
        else {
            Block block = new Block();
            int blockid=user2.city2.NextBlockId.NextId();
            AddtoOutPut(String.valueOf(blockid));
            block.setId(blockid);
            user2.city2.AddBlockArrayList(block);
            user2.setGills(user2.getScore() - 1000);
        }
    }
}
