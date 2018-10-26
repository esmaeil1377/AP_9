package Model;

import static Model.Block.CalculaTedadItems;
import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;
import static View.View.AddtoOutPut;

public class AddBazar extends Requests {
    private int BlockId;

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public int getBlockId() {
        return BlockId;
    }

    public AddBazar(int blockId) {
        if (Done.getDay()%2==0) {
            for (Block block : user1.city1.ArrayListblocks) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        Bazar bazar = new Bazar();
                        int bazarid=block.NextUnitId.NextId();
                        AddtoOutPut(String.valueOf(bazarid));
                        bazar.setId(bazarid);
                        block.AddtoBazarArray(bazar);
                        user1.setGills(user1.getGills() - 6000);
                        block.setScoreForPersonsForAddingBazar(bazar);
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
                        Bazar bazar = new Bazar();
                        int bazarid=block.NextUnitId.NextId();
                        AddtoOutPut(String.valueOf(bazarid));
                        bazar.setId(bazarid);
                        block.AddtoBazarArray(bazar);
                        user2.setGills(user2.getGills() - 6000);
                        block.setScoreForPersonsForAddingBazar(bazar);
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }
                }


            }
        }
    }
}
