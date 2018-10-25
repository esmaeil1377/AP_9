package Model;

import static Model.Block.CalculaTedadItems;
import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class AddDefense extends Requests {


    public AddDefense(int blockId) {
        if (User.equals(user1)) {
            for (Block block : user1.city1.getArrayListblocks()) {
                if (blockId == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        Padafand padafand = new Padafand();
                        padafand.setNumofperson(30);
                        user1.setGills(user1.getGills() - 10000);
                        block.AddtoPadafandArray(padafand);
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }
                }
            }
        }
        else{
            for (Block block : user2.city2.getArrayListblocks()) {
                if (blockId == block.getId() && CalculaTedadItems(block) < block.getLevel()) {
                    Padafand padafand = new Padafand();
                    padafand.setNumofperson(30);
                    user2.setGills(user2.getGills() - 10000);
                    block.AddtoPadafandArray(padafand);
                    break;
                } else {
                    NotPossible notPossible = new NotPossible();
                }
            }
        }
    }
}
