package View.ScenesAndMainGroupView;

import View.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductInTruckView extends View {
    private Group rootProductInTruckView=new Group();
    private Scene sceneProductInTruckView=new Scene(rootProductInTruckView,1600,900);

    public ProductInTruckView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }
}
