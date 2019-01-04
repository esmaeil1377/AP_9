package View.ScenesAndMainGroupView;

import View.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameShopView extends View {
    private Group rootGameShopView =new Group();
    private Scene sceneGameShopView=new Scene(rootGameShopView,1600,900);

    public GameShopView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }
}
