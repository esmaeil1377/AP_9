package FarmModel.Request;

public class Turn extends Request {
    private int n;

    public Turn(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void AnalyzeRequestLine(String requestLIne){}
}
