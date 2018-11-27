package FarmController.Request;

public class StartRequest extends Request {
    private String WorkShopName;

    public StartRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    public void setWorkShopName(String workShopName) {
        WorkShopName = workShopName;
    }

    public void AnalyzeRequestLine(String requestLine){}
}
