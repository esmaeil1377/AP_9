package View;
import View.ScenesAndMainGroupView.MissionSelectionView;
import View.ScenesAndMainGroupView.StartMenuView;


public class GameView {
    private static GameView gameView=new GameView();
    private StartMenuView startMenuView=new StartMenuView(Main.getPrimaryStage());
    private MissionSelectionView missionSelectionView=new MissionSelectionView(Main.getPrimaryStage());

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
