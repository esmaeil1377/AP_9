package Model;

import static Model.Done.User;
import static Model.Done.user1;

public class UpgradeBlock extends Requests {
    private String Blockid;


    public UpgradeBlock(int blockId) {
        if (Done.getDay()%2==0) {
            for (Block block : user1.city1.ArrayListblocks) {
                if (block.getId() == blockId) {
                    block.setLevel(block.getLevel() + 1);
                    user1.setGills(user1.getGills() - (int) Math.pow((double) 500, (double) block.getLevel()));
                }
            }
        } else {
            for (Block block : user1.city1.ArrayListblocks) {
                if (block.getId() == blockId) {
                    block.setLevel(block.getLevel() + 1);
                    user1.setGills(user1.getGills() - (int) Math.pow((double) 500, (double) block.getLevel()));
                }
            }
        }
    }
}