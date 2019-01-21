package FarmModel.ObjectInMap15_15;

public class Grass extends ObjectInMap15_15 {
    private int turnToDisappear;
    private int remainTurnToDisAppear;

    public Grass() {
        setTurnToDisappear(30);
        setRemainTurnToDisAppear(30);
    }

    public int getRemainTurnToDisAppear() {
        return remainTurnToDisAppear;
    }

    public void setRemainTurnToDisAppear(int remainTurnToDisAppear) {
        this.remainTurnToDisAppear = remainTurnToDisAppear;
    }

    public int getTurnToDisappear() {
        return turnToDisappear;
    }

    public void setTurnToDisappear(int turnTODisApear) {
        this.turnToDisappear = turnTODisApear;
    }

    @Override
    public String toString() {
        return "Grass";
    }
}
