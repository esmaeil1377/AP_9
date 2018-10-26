package Model;

import static Model.Block.CalculaTedadItems;
import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;
import static View.View.*;

public class AddArmy extends Requests {
    int BlockId;

    public AddArmy(int blockId) {
        int possible = 0;
        int notpossibleuser1 = 0;
        int notpossibleuser2 = 0;
        for (Block block : user1.city1.ArrayListblocks) {
            if (block.getArmyArrayList().size() != 1) {
                notpossibleuser1 += 1;
            }
        }
        for (Block block : user2.city2.ArrayListblocks) {
            if (block.getArmyArrayList().size() != 1) {
                notpossibleuser2 += 1;
            }
        }
        if (Done.getDay() % 2 == 0) {
            for (Block block : user1.city1.ArrayListblocks) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        if (notpossibleuser1 == 0) {
                            Army army = new Army();
                            int armyid = block.NextUnitId.NextId();
                            AddtoOutPut(String.valueOf(armyid));
                            army.setId(armyid);
                            army.setId(NextId.NextId());
                            army.setNumberOf(army.getNumberOf() + 100);
                            block.AddtoArmyArray(army);
                            possible += 1;
                            user1.setGills(user1.getGills() - 15000);
                            break;
                        } else {
                            View.View.AddtoOutPut("not possible");
                        }
                    } else {
                        View.View.AddtoOutPut("not possible");
                    }
                }
            }
        } else {
            for (Block block : user2.city2.ArrayListblocks) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        if (notpossibleuser2 == 0) {
                            Army army = new Army();
                            int armyid = block.NextUnitId.NextId();
                            AddtoOutPut(String.valueOf(armyid));
                            army.setId(armyid);
                            army.setNumberOf(army.getNumberOf() + 100);
                            block.AddtoArmyArray(army);
                            possible += 1;
                            user2.setGills(user2.getGills() - 15000);
                            break;
                        } else {
                            View.View.AddtoOutPut("not possible");
                        }
                    } else {
                        View.View.AddtoOutPut("not possible");
                    }
                }
            }
        }
        if (possible == 0) {
            View.View.AddtoOutPut("not possible");
        }
    }


    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public int getBlockId() {
        return BlockId;
    }

}
