package Model;

public class UpgradeFloorUnit extends Requests {


    public UpgradeFloorUnit(int blockId,int unitId){
        for(Block block:City.getArrayListblocks()){
            if(blockId==block.getId()){
                for(House house:block.getHouseArrayList()){
                    if(house.getId()==unitId){
                        Floor floor=new Floor();
                        int tedadUnitdarfloor=0;
                        for(Floor floor2:house.getArrayListFloors()){
                            tedadUnitdarfloor=floor2.getArrayListunits().size();
                        break;}
                        for(Floor floor3:house.getArrayListFloors()){
                            Unit unit=new Unit();
                            floor.getArrayListunits().add(unit);
                        }
                        for(int i=0;i<tedadUnitdarfloor+1;i++){
                            Unit unit=new Unit();
                            floor.getArrayListunits().add(unit);
                        }
                        house.getArrayListFloors().add(floor);

                        }
                    }
                }
            }
        }
    }

