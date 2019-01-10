package View.ScenesAndMainGroupView;

import View.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class MissionSelectionView extends View {
    private Group rootMissionSelectionView=new Group();
    private Scene sceneSelectionView=new Scene(rootMissionSelectionView,1600,900);

    public MissionSelectionView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }

    private void AddBackGround (Stage primaryStage) {
        File backGroundFile = new File("Data\\Mission\\mapofmission.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(870);
        BackGroundView.setFitWidth(1540);
        rootMissionSelectionView.getChildren().addAll(BackGroundView);
    }
}
