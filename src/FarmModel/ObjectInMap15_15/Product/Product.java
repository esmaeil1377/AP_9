package FarmModel.ObjectInMap15_15.Product;

import FarmModel.ObjectInMap15_15.ObjectInMap30_30;

public abstract class Product extends ObjectInMap30_30 {
    private int remainTurnToDisapear=20;


    public int getRemainTurnToDisapear() {
        return remainTurnToDisapear;
    }

    public void setRemainTurnToDisapear(int remainTurnToDisapear) {
        this.remainTurnToDisapear = remainTurnToDisapear;
    }
}
