package Model;

import static Model.Done.User;

public class UpgradeBlock extends Requests {
        private String Blockid;


        public UpgradeBlock(int blockId){
            for(Block block:City.ArrayListblocks){
                if(block.getId()==blockId){
                    block.setLevel(block.getLevel()+1);
                    User.setGills(User.getGills() - (int) Math.pow((double) 500 ,(double) block.getLevel()));
                }
            }
        }
}
