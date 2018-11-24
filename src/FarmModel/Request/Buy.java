package FarmModel.Request;

public class Buy extends Request {
    private String animalName;

    public Buy(String requestLine) {
        AnalyzeRequestLine(animalName);
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void Buy(String request){}

    public void AnalyzeRequestLine(String requestLine){
    }
}
