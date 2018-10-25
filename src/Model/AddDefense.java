package Model;

public class AddDefense {


    public AddDefense(int blockId){
        for(Block block:City.getArrayListblocks()){
            if(blockId==block.getId()){
                for(Padafand padanfand:block.getPadafandArrayList()){
                    padanfand.setNumofperson(padanfand.getNumofperson()+30);
                    User.setGills(User.getGills() - 10000);

                }
            }
        }
    }
}
