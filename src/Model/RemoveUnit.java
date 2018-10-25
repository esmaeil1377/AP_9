package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class RemoveUnit extends Requests {

    public RemoveUnit(int blockid,int unitId){
        if(User.equals(user1)){
            for(Block block:user1.city1.ArrayListblocks){
                for(Bazar bazar:block.getBazarArrayList()){
                    if(bazar.getId()==unitId && block.getId()==blockid){
                        block.RemoveBazarArray(bazar);
                        user1.setGills(user1.getGills() + 500);
                    }
                }
                for(Army army:block.getArmyArrayList()){
                    if(army.getId()==unitId && block.getId()==blockid){
                        block.RemoveArmyArray(army);
                        user1.setGills(user1.getGills() + 10000);
                    }
                }
                for(Padafand padafand:block.getPadafandArrayList()){
                    if(padafand.getId()==unitId && block.getId()==blockid){
                        block.RemovePadafandArray(padafand);
                        user1.setGills(user1.getGills() + 10000);
                    }
                }
                for(House house:block.getHouseArrayList()){
                    if(house.getId()==unitId && block.getId()==blockid){
                        block.RemoveHouseArray(house);
                    }
                }
            }
    }
    else{
            for(Block block:user2.city2.ArrayListblocks){
                for(Bazar bazar:block.getBazarArrayList()){
                    if(bazar.getId()==unitId && block.getId()==blockid){
                        block.RemoveBazarArray(bazar);
                        user2.setGills(user2.getGills() + 500);
                        block.setScoreForPersonsForRemovingBazar(bazar);
                    }
                }
                for(Army army:block.getArmyArrayList()){
                    if(army.getId()==unitId && block.getId()==blockid){
                        block.RemoveArmyArray(army);
                        user2.setGills(user2.getGills() + 10000);
                    }
                }
                for(Padafand padafand:block.getPadafandArrayList()){
                    if(padafand.getId()==unitId && block.getId()==blockid){
                        block.RemovePadafandArray(padafand);
                        user2.setGills(user2.getGills() + 10000);
                    }
                }
                for(House house:block.getHouseArrayList()){
                    if(house.getId()==unitId && block.getId()==blockid){
                        block.RemoveHouseArray(house);
                    }
                }
            }
    }
    }
}
