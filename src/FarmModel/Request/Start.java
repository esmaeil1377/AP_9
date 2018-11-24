package FarmModel.Request;

public class Start extends Request {
    private String WorkShopName;

    public Start(String workShopName) {
        WorkShopName = workShopName;
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    public void setWorkShopName(String workShopName) {
        WorkShopName = workShopName;
    }
}
