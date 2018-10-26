package Model;

import static Model.Block.CalculaTedadItems;
import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;
import static View.View.AddtoOutPut;

public class AddDefense extends Requests {


    public AddDefense(int blockId) {
        int possible = 0;
        if (Done.getDay() % 2 == 0) {
            for (Block block : user1.city1.getArrayListblocks()) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < 15 + (5 * block.getLevel())) {
                        Padafand padafand = new Padafand();
                        int padafandid = block.NextUnitId.NextId();
                        AddtoOutPut(String.valueOf(padafandid));
                        padafand.setId(padafandid);
                        padafand.setNumofperson(30);
                        user1.setGills(user1.getGills() - 10000);
                        block.AddtoPadafandArray(padafand);
                        possible += 1;
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }
                }
            }
        } else {
            for (Block block : user2.city2.getArrayListblocks()) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < 15 + (5 * block.getLevel())) {
                        Padafand padafand = new Padafand();
                        int padafandid = block.NextUnitId.NextId();
                        AddtoOutPut(String.valueOf(padafandid));
                        padafand.setId(padafandid);
                        padafand.setNumofperson(30);
                        user2.setGills(user2.getGills() - 10000);
                        block.AddtoPadafandArray(padafand);
                        possible += 1;
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }
                }
            }
        }
        if (possible == 0) {
            View.View.AddtoOutPut("not possible");
        }
    }
}
