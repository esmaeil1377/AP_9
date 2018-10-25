package Model;

public class UpgradeBlock extends Requests {
        private String Blockid;


        public UpgradeBlock(int blockId){
            for(Block block:City.ArrayListblocks){
                if(block.getId()==blockId){
                    block.setLevel(block.getLevel()+1);
                }
            }
        }
}
