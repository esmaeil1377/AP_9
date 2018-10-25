package Model;

import java.util.ArrayList;

public class RemoveUnit extends Requests {

    public RemoveUnit(int blockid,int unitId){
        for(Block block:City.ArrayListblocks){
            for(Bazar bazar:block.getBazarArrayList()){
                if(bazar.getId()==unitId && block.getId()==blockid){
                    block.getBazarArrayList().remove(bazar);
                }
            }
            for(Army army:block.getArmyArrayList()){
                if(army.getId()==unitId && block.getId()==blockid){
                    block.getArmyArrayList().remove(army);
                }
            }
            for(Padafand padafand:block.getPadafandArrayList()){
                if(padafand.getId()==unitId && block.getId()==blockid){
                    block.getPadafandArrayList().remove(padafand);
                }
            }
            for(House house:block.getHouseArrayList()){
                if(house.getId()==unitId && block.getId()==blockid){
                    block.getHouseArrayList().remove(house);
                }
            }
        }
    }
}
