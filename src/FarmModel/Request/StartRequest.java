package FarmModel.Request;

import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WeavinFactory;

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

    public void AnalyzeRequestLine(String requestLine){
        String workShopName=requestLine.substring(6);
        if(workShopName.equals("CakeBakery")){
            Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWorkShops()
        }else if(workShopName.equals("CookieBakery")){}
        else if(workShopName.equals("EggPowderPlant")){}
        else if(workShopName.equals("SewingFactory")){}
        else if(workShopName.equals("Spinnery")){}
        else if(workShopName.equals("WeavinFactory")){}
        else {


            return;
        }
        //showing a appropriate notation for error that there is no workshop by this name;

    }
}
