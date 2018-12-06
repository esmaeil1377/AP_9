package FarmModel.Request;

import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WeavinFactory;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

public class StartRequest extends Request {
    private String WorkShopName;
    private WorkShop workShop;

    public void setWorkShop(WorkShop workShop) {
        this.workShop = workShop;
    }

    public WorkShop getWorkShop() {
        return workShop;
    }

    public StartRequest(String requestLine) {
        AnalyzeRequestLine(requestLine);
        workShop.setWorkShopActivatedToMakeProduct(true);
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    public void setWorkShopName(String workShopName) {
        WorkShopName = workShopName;
    }

    public void AnalyzeRequestLine(String requestLine){
        String workShopName=requestLine.substring(6);
        WorkShop workShop=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getspecifiedWorkShop(workShopName);
        setWorkShop(workShop);
        //showing a appropriate notation for error that there is no workshop by this name;

    }
}
