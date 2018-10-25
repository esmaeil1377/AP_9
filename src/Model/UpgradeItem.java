package Model;

public class UpgradeItem extends Requests {

    public UpgradeItem(int blockId,int unitId){
        for(Block block:City.ArrayListblocks){
            for(Bazar bazar:block.getBazarArrayList()){
                if(bazar.getId()==unitId && block.getId()==blockId){
                    bazar.setLevel(bazar.getLevel()+1);
                    User.setGills(User.getGills() - (bazar.getLevel() + 1) * 5000);
                }
            }
            for(Army army:block.getArmyArrayList()){
                if(army.getId()==unitId && block.getId()==blockId){
                    army.setLevel(army.getLevel()+1);
                    User.setGills(User.getGills() - 20000);
                }
            }
            for(Padafand padafand:block.getPadafandArrayList()){
                if(padafand.getId()==unitId && block.getId()==blockId){
                    padafand.setLevel(padafand.getLevel()+1);
                    User.setGills(User.getGills() - 5000);
                }
            }
            for(House house:block.getHouseArrayList()){
                if(house.getId()==unitId && block.getId()==blockId){
                    block.getHouseArrayList().remove(house);
                }
            }
        }

    }
}
