package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class UpgradeItem extends Requests {

    public UpgradeItem(int blockId,int unitId){
        if(Done.getDay()%2==0){
            for(Block block:user1.city1.ArrayListblocks){
                for(Bazar bazar:block.getBazarArrayList(block)){
                    if(bazar.getId()==unitId && block.getId()==blockId){
                        bazar.setLevel(bazar.getLevel()+1);
                        user1.setGills(user1.getGills() - (bazar.getLevel() + 1) * 5000);
                        block.setScoreForPersonsForAddingBazar(bazar);
                    }
                }
                for(Army army:block.getArmyArrayList()){
                    if(army.getId()==unitId && block.getId()==blockId){
                        army.setLevel(army.getLevel()+1);
                        army.setNumberOf(army.getNumberOf()+10);
                        user1.setGills(user1.getGills() - 20000);
                    }
                }
                for(Padafand padafand:block.getPadafandArrayList()){
                    if(padafand.getId()==unitId && block.getId()==blockId){
                        padafand.setLevel(padafand.getLevel()+1);
                        user1.setGills(user1.getGills() - 5000);
                    }
                }
            }

    }
    else{
            for(Block block:user2.city2.ArrayListblocks){
                for(Bazar bazar:block.getBazarArrayList(block)){
                    if(bazar.getId()==unitId && block.getId()==blockId){
                        bazar.setLevel(bazar.getLevel()+1);
                        user2.setGills(user2.getGills() - (bazar.getLevel() + 1) * 5000);
                        block.setScoreForPersonsForAddingBazar(bazar);
                    }
                }
                for(Army army:block.getArmyArrayList()){
                    if(army.getId()==unitId && block.getId()==blockId){
                        army.setLevel(army.getLevel()+1);
                        army.setNumberOf(army.getNumberOf()+10);
                        user2.setGills(user2.getGills() - 20000);
                    }
                }
                for(Padafand padafand:block.getPadafandArrayList()){
                    if(padafand.getId()==unitId && block.getId()==blockId){
                        padafand.setLevel(padafand.getLevel()+1);
                        user2.setGills(user2.getGills() - 5000);
                    }
                }
            }
    }
    }
}
