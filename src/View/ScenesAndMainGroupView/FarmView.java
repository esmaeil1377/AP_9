package View.ScenesAndMainGroupView;

import View.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FarmView extends View {
    private Group rootFarmView=new Group();
    private Scene sceneFarmView=new Scene(rootFarmView,1600,900);

    public FarmView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }
}
