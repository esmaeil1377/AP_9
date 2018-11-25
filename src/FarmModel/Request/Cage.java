package FarmModel.Request;

public class Cage extends Request {
    private int x;
    private int y;

    public Cage(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void AnalyzeRequestLine(String requestLine){
    }
}
