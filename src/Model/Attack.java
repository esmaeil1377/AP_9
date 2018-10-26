package Model;


import static Model.Done.user1;
import static Model.Done.user2;

public class Attack extends Requests {

    public Attack(int BlockId) {
        float sathhamle = 0;
        if (Done.getDay()%2==0) {
            for (Block block : user1.city1.getArrayListblocks()) {
                if (block.getArmyArrayList().size() == 1) {
                    for (Army army : block.getArmyArrayList()) {
                        sathhamle = army.levelOfAttak();
                    }
                }
            }
            for (Block block : user2.city2.getArrayListblocks()) {
                for (Padafand padafand : block.getPadafandArrayList()) {
                    if (padafand.levelOfDefense(BlockId) > sathhamle) {
                        //libkjv
                    } else {
                    }
                }
            }
        } else {
            for (Block block : user2.city2.getArrayListblocks()) {
                if (block.getArmyArrayList().size() == 1) {
                    for (Army army : block.getArmyArrayList()) {
                        sathhamle = army.levelOfAttak();
                    }
                }
            }
            for (Block block : user1.city1.getArrayListblocks()) {
                for (Padafand padafand : block.getPadafandArrayList()) {
                    if (padafand.levelOfDefense(BlockId) > sathhamle) {
//khb
                    } else {

                    }
                }
            }
        }
    }
}
