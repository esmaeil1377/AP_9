package Model;

import static Model.Done.User;

public class AddDefense extends Requests{


    public AddDefense(int blockId){
        for(Block block:City.getArrayListblocks()){
            if(blockId==block.getId()){
                Padafand padafand=new Padafand();
                padafand.setNumofperson(30);
                User.setGills(User.getGills() - 10000);
                block.AddtoPadafandArray(padafand);
                break;
                }
            }
        }
    }
