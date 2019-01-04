package View.ScenesAndMainGroupView;

import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;

public class FarmView extends View {
    private Group rootFarmView=new Group();
    private Scene sceneFarmView=new Scene(rootFarmView,1600,900);

    public FarmView(Stage primaryStage) throws Exception {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {


        AddBackGround(primaryStage);

        ShowMovingCloud(primaryStage);

        AddMenuClick(primaryStage);

        MakeWellMoving(primaryStage);



        primaryStage.setScene(sceneFarmView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }



    private void AddBackGround(Stage primaryStage){
        File backGroundFile=new File("Data\\Map.png");
        Image backGroundImage=new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView=new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(870);
        BackGroundView.setFitWidth(1540);
        rootFarmView.getChildren().addAll(BackGroundView);
    }

    private void AddMenuClick(Stage primaryStage){
        Circle menuCircle=new Circle(80,800,10);
        menuCircle.setOpacity(0.8);
        menuCircle.setFill(Color.rgb(216,218,34));



        Circle continueCircle=new Circle(80,550,0);
        continueCircle.setOpacity(0.6);
        continueCircle.setFill(Color.rgb(64,45,67));
        continueCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                continueCircle.setOpacity(0.8);
            }
        });
        continueCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                continueCircle.setOpacity(0.6);
            }
        });
        continueCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        Circle mainMenuCircle=new Circle(205,583.495,0);
        mainMenuCircle.setOpacity(0.6);
        mainMenuCircle.setFill(Color.rgb(64,45,67));
        mainMenuCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainMenuCircle.setOpacity(0.8);
            }
        });
        mainMenuCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainMenuCircle.setOpacity(0.6);
            }
        });
        mainMenuCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        Circle restartCircle =new Circle(296.505,675,0);
        restartCircle.setOpacity(0.6);
        restartCircle.setFill(Color.rgb(64,45,67));
        restartCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                restartCircle.setOpacity(0.8);
            }
        });
        restartCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                restartCircle.setOpacity(0.6);
            }
        });
        restartCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        Circle mapCircle =new Circle(330,800,0);
        mapCircle.setOpacity(0.6);
        mapCircle.setFill(Color.rgb(64,45,67));
        mapCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mapCircle.setOpacity(0.8);
            }
        });
        mapCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mapCircle.setOpacity(0.6);
            }
        });
        restartCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });




        File menuFile=new File("Data\\Click\\Menu.png");
        Image menuImage=new Image(menuFile.toURI().toString());
        ImageView MenuView=new ImageView(menuImage);
        MenuView.relocate(30,750);
        MenuView.setFitHeight(100);
        MenuView.setFitWidth(100);
        MenuView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rootFarmView.getChildren().addAll(menuCircle,continueCircle,mainMenuCircle,restartCircle,mapCircle);

                KeyValue continueCircleKey=new KeyValue(continueCircle.radiusProperty(),60);
                KeyFrame continueCircleFrame=new KeyFrame(Duration.seconds(1),continueCircleKey);
                Timeline continueCircleTimeLine=new Timeline(continueCircleFrame);
                continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
                continueCircleTimeLine.play();

                KeyValue mainMenuKey=new KeyValue(mainMenuCircle.radiusProperty(),60);
                KeyFrame mainMenuFrame=new KeyFrame(Duration.seconds(1),mainMenuKey);
                Timeline mainMenuTimeLine=new Timeline(mainMenuFrame);
                mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
                mainMenuTimeLine.play();

                KeyValue restartCircleKey=new KeyValue(restartCircle.radiusProperty(),60);
                KeyFrame restartCircleFrame=new KeyFrame(Duration.seconds(1),restartCircleKey);
                Timeline restartCircleTimeLine=new Timeline(restartCircleFrame);
                restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
                restartCircleTimeLine.play();

                KeyValue mapCircleKey=new KeyValue(mapCircle.radiusProperty(),60);
                KeyFrame mapCircleFrame=new KeyFrame(Duration.seconds(1),mapCircleKey);
                Timeline mapCircleTimeLine=new Timeline(mapCircleFrame);
                mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
                mapCircleTimeLine.play();


                String path="Data\\Voice\\Bubble.mp3";
                String path1= Paths.get(path).toUri().toString();
                Media voiceMedia = new Media(path1);
                MediaPlayer mediaPlayer = new MediaPlayer(voiceMedia);
                mediaPlayer.play();

                KeyValue x=new KeyValue(menuCircle.radiusProperty(),350);
                KeyFrame keyFrame=new KeyFrame(Duration.seconds(1),x);
                Timeline timeline=new Timeline(keyFrame);
                timeline.getKeyFrames().addAll(keyFrame);
                timeline.play();

            }
        });
        MenuView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MenuView.relocate(35,755);
                MenuView.setFitHeight(90);
                MenuView.setFitWidth(90);
            }
        });
        MenuView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MenuView.relocate(30,750);
                MenuView.setFitHeight(100);
                MenuView.setFitWidth(100);
            }
        });
        rootFarmView.getChildren().addAll(MenuView);
    }

    private void ShowMovingCloud(Stage primaryStage){
        File cloudFile=new File("Data\\Cloud.png");
        Image cloudImage=new Image(cloudFile.toURI().toString());
        ImageView cloudView=new ImageView(cloudImage);
        cloudView.relocate(1000,40);
        cloudView.setFitWidth(40);
        cloudView.setFitHeight(40);
        KeyValue x=new KeyValue(cloudView.xProperty(),900);
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(200),x);
        Timeline timeline=new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(100000);
        timeline.setAutoReverse(true);
        timeline.play();

        rootFarmView.getChildren().addAll(cloudView);
    }

    private void MakeWellMoving(Stage primaryStage){
        File wellFile=new File("Data\\Well.png");
        Image wellImage=new Image(wellFile.toURI().toString());
        ImageView wellView=new ImageView(wellImage);
        wellView.relocate(-38,64);
        wellView.setFitHeight(310);
        wellView.setFitWidth(315);
        wellView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(-34,69);
                wellView.setFitHeight(298);
                wellView.setFitWidth(308);
            }
        });
        wellView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(-38,64);
                wellView.setFitHeight(310);
                wellView.setFitWidth(315);
            }
        });
        wellView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });


        rootFarmView.getChildren().addAll(wellView);
    }

}
