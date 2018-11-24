package FarmModel.Request;

public class Turn extends Request {
    private int n;

    public Turn(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
