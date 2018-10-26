package Model;

import static Model.Block.CalculaTedadItems;
import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;
import static View.View.AddtoOutPut;

public class AddHome extends Requests {
    private int BlockId;
    private int NumberFloor;
    private int NumberUnit;

    public void setBlockId(int blockId) {
        BlockId = blockId;
    }

    public void setNumberFloor(int numberFloor) {
        NumberFloor = numberFloor;
    }

    public void setNumberUnit(int numberUnit) {
        NumberUnit = numberUnit;
    }

    public AddHome(int blockid, int numberFloor, int numberUnit) {
        if (User.equals(user1)) {
            for (Block block : user1.city1.ArrayListblocks) {
                if (blockid == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        House house = new House();
                        int houseid=block.NextUnitId.NextId();
                        AddtoOutPut(String.valueOf(houseid));
                        house.setId(houseid);
                        for (int i = 0; i < numberFloor; i++) {
                            Floor floor = new Floor();
                            for (int j = 0; j < numberUnit; j++) {
                                Unit unit = new Unit();
                                floor.AddUnitArrayList(unit);
                            }
                            house.AddFloorArrayList(floor);
                        }
                        block.AddtoHouseArray(house);
                        user1.setGills(user1.getGills() - 700 - 300 * numberFloor - numberFloor * numberUnit * 100);
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }

                }
            }
        } else {
            for (Block block : user2.city2.ArrayListblocks) {
                if (blockid == block.getId()) {
                    if (CalculaTedadItems(block) < block.getLevel()) {
                        House house = new House();
                        int houseid=block.NextUnitId.NextId();
                        AddtoOutPut(String.valueOf(houseid));
                        house.setId(houseid);
                        for (int i = 0; i < numberFloor; i++) {
                            Floor floor = new Floor();
                            for (int j = 0; j < numberUnit; j++) {
                                Unit unit = new Unit();
                                floor.AddUnitArrayList(unit);
                            }
                            house.AddFloorArrayList(floor);
                        }
                        block.AddtoHouseArray(house);
                        user2.setGills(user2.getGills() - 700 - 300 * numberFloor - numberFloor * numberUnit * 100);
                        break;
                    } else {
                        NotPossible notPossible = new NotPossible();
                    }

                }
            }
        }
    }
}
