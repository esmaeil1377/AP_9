package View;
import View.ScenesAndMainGroupView.FarmView;
import View.ScenesAndMainGroupView.GameShopView;
import View.ScenesAndMainGroupView.MissionSelectionView;
import View.ScenesAndMainGroupView.StartMenuView;


public class GameView {
    private static GameView gameView=new GameView();
    private StartMenuView startMenuView=new StartMenuView(Main.getPrimaryStage());
    private MissionSelectionView missionSelectionView=new MissionSelectionView(Main.getPrimaryStage());
    private GameShopView gameShopView=new GameShopView(Main.getPrimaryStage());
    private FarmView farmView;

    public void setFarmView(FarmView farmView) {
        this.farmView = farmView;
    }
    public FarmView getFarmView() {
        return farmView;
    }
    public GameShopView getGameShopView() {
        return gameShopView;
    }
    public void setGameShopView(GameShopView gameShopView) {
        this.gameShopView = gameShopView;
    }
    public StartMenuView getStartMenuView() {
        return startMenuView;
    }
    public void setStartMenuView(StartMenuView startMenuView) {
        this.startMenuView = startMenuView;
    }
    public MissionSelectionView getMissionSelectionView() {
        return missionSelectionView;
    }
    public void setMissionSelectionView(MissionSelectionView missionSelectionView) {
        this.missionSelectionView = missionSelectionView;
    }

    private GameView(){}
    public static GameView getGameView() {
        return gameView;
    }

}
