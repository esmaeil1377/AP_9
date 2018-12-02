package FarmModel.ObjectInMap15_15.Product;

import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public abstract class Product extends ObjectInMap15_15 {
    private int turnToDisapear;
    private int remainTurnToDisapear;

    public void setTurnToDisapear(int turnToDisapear) {
        this.turnToDisapear = turnToDisapear;
    }

    public int getTurnToDisapear() {
        return turnToDisapear;
    }

    public int getRemainTurnToDisapear() {
        return remainTurnToDisapear;
    }

    public void setRemainTurnToDisapear(int remainTurnToDisapear) {
        this.remainTurnToDisapear = remainTurnToDisapear;
    }
}
