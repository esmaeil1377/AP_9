package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class AddBlock extends Requests {
    private int BlockId;

    public int getBlockId() {
        return BlockId;
    }

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public AddBlock() {
        Block block = new Block();
        block.setId(NextId.NextId());
        if (User.equals(user1)) {
            user1.city1.AddBlockArrayList(block);
            User.setGills(User.getScore() - 1000);
        } else {
            user2.city2.AddBlockArrayList(block);
            User.setGills(User.getScore() - 1000);
        }
    }
}
