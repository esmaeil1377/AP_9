package FarmModel.Request;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.WorkShop;

public class StartRequest extends Request {
    private String WorkShopName;
    private WorkShop workShop;

    public void setWorkShop(WorkShop workShop) {
        this.workShop = workShop;
    }

    public WorkShop getWorkShop() {
        return workShop;
    }

    public StartRequest(String requestLine) throws MissionNotLoaded {
        AnalyzeRequestLine(requestLine);
        WorkShop workShop = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop(getWorkShopName());
        setWorkShop(workShop);
        workShop.setWorkShopActivatedToMakeProduct(true);
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    public void setWorkShopName(String workShopName) {
        WorkShopName = workShopName;
    }

    public void AnalyzeRequestLine(String requestLine){
        String workShopName = requestLine.substring(6);
        setWorkShopName(workShopName);

        //showing a appropriate notation for error that there is no workshop by this name;

    }
}
