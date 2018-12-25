package FarmModel.ObjectInMap30_30.Product;

import FarmModel.ObjectInMap30_30.ObjectInMap30_30;

public abstract class Product extends ObjectInMap30_30 {
    private int remainTurnToDisapear=20;


    public int getRemainTurnToDisapear() {
        return remainTurnToDisapear;
    }

    public void setRemainTurnToDisapear(int remainTurnToDisapear) {
        this.remainTurnToDisapear = remainTurnToDisapear;
    }
}
