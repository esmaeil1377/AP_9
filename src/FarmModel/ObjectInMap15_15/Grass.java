package FarmModel.ObjectInMap15_15;

public class Grass extends ObjectInMap15_15 {
    private int turnToDisapear;
    private int remainTurnToDisApear;
    public Grass(){
        setTurnTODisapear();
    }

    public int getRemainTurnToDisApear() {
        return remainTurnToDisApear;
    }

    public void setRemainTurnToDisApear(int remainTurnToDisApear) {
        this.remainTurnToDisApear = remainTurnToDisApear;
    }

    public int getTurnToDisapear() {
        return turnToDisapear;
    }

    public void setTurnTODisapear(int turnTODisApear) {
        this.turnToDisapear = turnTODisApear;
    }
}
