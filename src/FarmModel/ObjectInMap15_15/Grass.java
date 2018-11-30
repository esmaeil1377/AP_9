package FarmModel.ObjectInMap15_15;

public class Grass extends ObjectInMap15_15 {
    private int turnTODisApear;
    private int remainTurnToDisApear;
    public Grass(){
        setTurnTODisApear();
    }

    public int getRemainTurnToDisApear() {
        return remainTurnToDisApear;
    }

    public void setRemainTurnToDisApear(int remainTurnToDisApear) {
        this.remainTurnToDisApear = remainTurnToDisApear;
    }

    public int getTurnTODisApear() {
        return turnTODisApear;
    }

    public void setTurnTODisApear(int turnTODisApear) {
        this.turnTODisApear = turnTODisApear;
    }
}
