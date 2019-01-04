package View.ScenesAndMainGroupView;

import View.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MissionSelectionView extends View {
    private Group rootMissionSelectionView=new Group();
    private Scene sceneSelectionView=new Scene(rootMissionSelectionView,1600,900);

    public MissionSelectionView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }
}
