package View.ScenesAndMainGroupView;

import View.View;
import javafx.event.EventHandler;
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
    private Group rootMissionSelectionView = new Group();
    private Scene sceneSelectionView = new Scene(rootMissionSelectionView, 1600, 900);

    public MissionSelectionView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\Mission\\mapofmission.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(870);
        BackGroundView.setFitWidth(1540);
        rootMissionSelectionView.getChildren().addAll(BackGroundView);
    }

    private void BeachOfMission(Stage primaryStage) {
        File restartFile = new File("Data\\Mission\\Map.jpeg");
        Image restartImage = new Image(restartFile.toURI().toString());
        ImageView restartImageView = new ImageView(restartImage);
        restartImageView.relocate(1200,500);
        primaryStage.setFullScreen(true);
        restartImageView.setFitHeight(200);
        restartImageView.setFitWidth(200);
        Circle circle = new Circle(1200, 500, 150); // cast to Circle
        //circle.setFill(restartImageView);
        rootMissionSelectionView.getChildren().addAll(restartImageView);
    }

    private void NumberOfMission(Stage primaryStage) {
        File numberFile = new File("Data\\Mission\\hob.png");
        Image numberImage = new Image(numberFile.toURI().toString());
        //ImageView numberImageView = new ImageView(numberImage);
        ImageView[] numberImageView = new ImageView[15];
        for (int i = 0; i < 15; i++) {
            if (i < 7) {
                numberImageView[i] = new ImageView(numberImage);
                numberImageView[i].relocate(1130, 450 + 40 * i);
                primaryStage.setFullScreen(true);
                numberImageView[i].setFitWidth(30);
                numberImageView[i].setFitHeight(30);
                rootMissionSelectionView.getChildren().addAll(numberImageView[i]);
            }
            if (i > 7) {
                numberImageView[i] = new ImageView(numberImage);
                numberImageView[i].relocate(1130 + (i - 7) * 40, 450 + 40 * 7 + 10);
                primaryStage.setFullScreen(true);
                numberImageView[i].setFitWidth(30);
                numberImageView[i].setFitHeight(30);
                rootMissionSelectionView.getChildren().addAll(numberImageView[i]);
            }
        }
        for (int i = 0; i < 15; i++) {
            numberImageView[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        }
    }
}
