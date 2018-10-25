package Model;

public class UpgradeFloorUnit extends Requests{


    public UpgradeFloorUnit(int blockId,int unitId){
        for(Block block:City.getArrayListblocks()){
            if(blockId==block.getId()){
                for(House house:block.getHouseArrayList()){
                    if(house.getId()==unitId){
                        Floor floor=new Floor();
                        for(int i=0;i< ;i++){
                            Unit unit=new Unit();
                            floor.getArrayListunits().add(unit);
                        }
                        for(Floor floor1:house.getArrayListFloors()){

                        }
                    }
                }
            }
        }
    }
}
