package FarmController.Request;

public class TurnRequest extends Request {
    private int n;

    public TurnRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void AnalyzeRequestLine(String requestLIne){}

    public void AddWildAnimalsToMapAfterOneMinute(){}
}
