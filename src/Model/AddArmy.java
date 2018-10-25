package Model;

import static Model.Block.CalculaTedadItems;
import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class AddArmy extends Requests {
    int BlockId;

    public AddArmy(int blockId) {
        if (User.equals(user1)) {
            for (Block block : user1.city1.ArrayListblocks) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        Army army = new Army();
                        army.setId(NextId.NextId());
                        army.setNumberOf(army.getNumberOf() + 100);
                        block.AddtoArmyArray(army);
                        user1.setGills(user1.getGills() - 15000);
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }
                }
            }
        } else {
            for (Block block : user2.city2.ArrayListblocks) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        Army army = new Army();
                        army.setId(NextId.NextId());
                        army.setNumberOf(army.getNumberOf() + 100);
                        block.AddtoArmyArray(army);
                        user2.setGills(user2.getGills() - 15000);
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }
                }
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
