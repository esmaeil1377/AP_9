package Model;

import static Model.City.ArrayListblocks;
import static Model.Done.*;

public class Loot extends Requests {

    public Loot(int Blockid){
        if(Done.getDay()%2==0){
        for(Block block:user2.city2.ArrayListblocks){
            if(block.getId()==Blockid){
                int itemofblock=0;
                itemofblock+=block.getBazarArrayList().size();
                itemofblock+=block.getArmyArrayList().size();
                itemofblock+=block.getHouseArrayList().size();
                user1.setGills(User.getGills()+500*itemofblock);
            }
        }
    }
    else{
        for(Block block:user1.city1.ArrayListblocks){
            if(block.getId()==Blockid){
                int itemofblock=0;
                itemofblock+=block.getBazarArrayList().size();
                itemofblock+=block.getArmyArrayList().size();
                itemofblock+=block.getHouseArrayList().size();
                user2.setGills(User.getGills()+500*itemofblock);
            }
        }
    }
    }
}
