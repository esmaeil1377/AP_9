package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class UpgradeFloorUnit extends Requests {


    public UpgradeFloorUnit(int blockId, int unitId) {
        if (User.equals(user1)) {
            for (Block block : user1.city1.getArrayListblocks()) {
                if (blockId == block.getId()) {
                    for (House house : block.getHouseArrayList()) {
                        if (house.getId() == unitId) {
                            Floor floor = new Floor();
                            int tedadUnitdarfloor = 0;
                            for (Floor floor2 : house.getArrayListFloors()) {
                                tedadUnitdarfloor = floor2.getArrayListunits().size();
                                break;
                            }
                            for (Floor floor3 : house.getArrayListFloors()) {
                                Unit unit = new Unit();
                                floor.getArrayListunits().add(unit);
                            }
                            for (int i = 0; i < tedadUnitdarfloor + 1; i++) {
                                Unit unit = new Unit();
                                floor.getArrayListunits().add(unit);
                            }
                            house.getArrayListFloors().add(floor);
                            int numberunit = 0;
                            for (Floor floor1 : house.getArrayListFloors()) {
                                numberunit = floor1.getArrayListunits().size();
                                break;
                            }
                            user1.setGills(user1.getGills() - (house.getArrayListFloors().size() + 1 + numberunit) * 50 - 300);
                        }
                    }
                }
            }
        } else {
            for (Block block : user2.city2.getArrayListblocks()) {
                if (blockId == block.getId()) {
                    for (House house : block.getHouseArrayList()) {
                        if (house.getId() == unitId) {
                            Floor floor = new Floor();
                            int tedadUnitdarfloor = 0;
                            for (Floor floor2 : house.getArrayListFloors()) {
                                tedadUnitdarfloor = floor2.getArrayListunits().size();
                                break;
                            }
                            for (Floor floor3 : house.getArrayListFloors()) {
                                Unit unit = new Unit();
                                floor.getArrayListunits().add(unit);
                            }
                            for (int i = 0; i < tedadUnitdarfloor + 1; i++) {
                                Unit unit = new Unit();
                                floor.getArrayListunits().add(unit);
                            }
                            house.getArrayListFloors().add(floor);
                            int numberunit = 0;
                            for (Floor floor1 : house.getArrayListFloors()) {
                                numberunit = floor1.getArrayListunits().size();
                                break;
                            }
                            user2.setGills(user2.getGills() - (house.getArrayListFloors().size() + 1 + numberunit) * 50 - 300);
                        }
                    }
                }
            }
        }
    }
}
