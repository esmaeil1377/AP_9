package FarmModel.Request;

public class BuyRequest extends Request {
    private String animalName;

    public BuyRequest(String requestLine) {
        AnalyzeRequestLine(animalName);

    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void Buy(String request) {
    }

    public void AnalyzeRequestLine(String requestLine) {
    }
}
