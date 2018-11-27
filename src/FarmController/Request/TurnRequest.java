package FarmController.Request;

public class TurnRequest extends Request {
    private int n;

    public TurnRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        DoWorkByPassingTime();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void AnalyzeRequestLine(String requestLIne){}

    public void DoWorkByPassingTime(){
        AddWildAnimalsToMapAfterOneMinute();
        MoveObject();
        KillAnimals();
        MakeProducerAnimalHungry();
        MakeProductDisapear();
        //and so on
    }

    public void AddWildAnimalsToMapAfterOneMinute(){}

    public void MoveObject(){}

    public void KillAnimals(){}

    public void MakeProducerAnimalHungry(){}

    public void MakeProductDisapear(){}
}
