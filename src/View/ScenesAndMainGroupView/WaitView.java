package View.ScenesAndMainGroupView;

import View.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WaitView extends View {
    private Group rootWaitView = new Group();
    private Scene sceneWaitView = new Scene(rootWaitView, 1600, 900);

    public WaitView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }
}
