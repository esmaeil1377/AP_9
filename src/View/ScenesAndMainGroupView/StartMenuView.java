package View.ScenesAndMainGroupView;

import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;

public class StartMenuView extends View {
    private Group rootStartMenuView=new Group();
    private Scene sceneStartMenuView=new Scene(rootStartMenuView,1600,900);

    public StartMenuView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {

        AddBackGround(primaryStage);

        ShowMovingCloud(primaryStage);

        AddPlayClick(primaryStage);

        AddSettingClick(primaryStage);

        AddExitClick(primaryStage);

        AddNewUser(primaryStage);


        primaryStage.setScene(sceneStartMenuView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddBackGround(Stage primaryStage){
        File backGroundFile=new File("Data\\BackGround.png");
        Image backGroundImage=new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView=new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        rootStartMenuView.getChildren().addAll(BackGroundView);
    }

    private void AddPlayClick(Stage primaryStage){
        File playClickFile=new File("Data\\Click\\PlayClick.png");
        Image imagePlayClick=new Image(playClickFile.toURI().toString());
        ImageView playClickView=new ImageView(imagePlayClick);
        playClickView.relocate(700,350);
        playClickView.setFitWidth(170);
        playClickView.setFitHeight(170);
        playClickView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String path="Data\\Voice\\Bubble.mp3";
                String path1= Paths.get(path).toUri().toString();
                Media voiceMedia = new Media(path1);
                MediaPlayer mediaPlayer = new MediaPlayer(voiceMedia);
                mediaPlayer.play();
//                primaryStage.setScene();
                primaryStage.setFullScreen(true);
            }
        });
        playClickView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.setFitWidth(160);
                playClickView.setFitHeight(160);
                playClickView.relocate(710,360);
            }
        });
        playClickView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.setFitWidth(170);
                playClickView.setFitHeight(170);
                playClickView.relocate(700,350);
            }
        });
        rootStartMenuView.getChildren().addAll(playClickView);
    }

    private void AddSettingClick(Stage primaryStage){
        File settingClick=new File("Data\\Click\\SettingClick.png");
        Image settingImage=new Image(settingClick.toURI().toString());
        ImageView settingImageView=new ImageView(settingImage);
        settingImageView.relocate(1400,700);
        settingImageView.setFitHeight(100);
        settingImageView.setFitWidth(100);
        settingImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String path="Data\\Voice\\Bubble.mp3";
                String path1= Paths.get(path).toUri().toString();
                Media voiceMedia = new Media(path1);
                MediaPlayer mediaPlayer = new MediaPlayer(voiceMedia);
                mediaPlayer.play();
                //...
            }
        });
        settingImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingImageView.relocate(1405,705);
                settingImageView.setFitHeight(90);
                settingImageView.setFitWidth(90);
            }
        });
        settingImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingImageView.relocate(1400,700);
                settingImageView.setFitHeight(100);
                settingImageView.setFitWidth(100);
            }
        });
        rootStartMenuView.getChildren().addAll(settingImageView);
    }

    private void AddExitClick(Stage primaryStage){
        File exitFile=new File("Data\\Click\\ExitClick.png");
        Image exitImage=new Image(exitFile.toURI().toString());
        ImageView exitImageView=new ImageView(exitImage);
        exitImageView.relocate(1400,50);
        exitImageView.setFitHeight(100);
        exitImageView.setFitWidth(100);
        exitImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String path="Data\\Voice\\Bubble.mp3";
                String path1= Paths.get(path).toUri().toString();
                Media voiceMedia = new Media(path1);
                MediaPlayer mediaPlayer = new MediaPlayer(voiceMedia);
                mediaPlayer.play();
                primaryStage.close();
            }
        });
        exitImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitImageView.relocate(1410,60);
                exitImageView.setFitHeight(90);
                exitImageView.setFitWidth(90);
            }
        });
        exitImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitImageView.relocate(1400,60);
                exitImageView.setFitHeight(100);
                exitImageView.setFitWidth(100);
            }
        });
        rootStartMenuView.getChildren().addAll(exitImageView);
    }

    private void ShowMovingCloud(Stage primaryStage){
        File cloudFile=new File("Data\\Cloud.png");
        Image cloudImage=new Image(cloudFile.toURI().toString());
        ImageView cloudView=new ImageView(cloudImage);
        cloudView.relocate(0,100);

        KeyValue x=new KeyValue(cloudView.xProperty(),1600);
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(90),x);
        Timeline timeline=new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(100);
        timeline.setAutoReverse(true);
        timeline.play();

        rootStartMenuView.getChildren().addAll(cloudView);
    }

    private void AddNewUser(Stage primaryStage){
        Circle circleSun=new Circle(367,364,30, Color.rgb(254,216,130));
        Circle circleUserMenu=new Circle(367,364,20,Color.rgb(255,255,255));
        TextField enterYourUser=new TextField();
        enterYourUser.relocate(290,420);


        Text text1=new Text("users");
        text1.relocate(335,356);
        text1.setFill(Color.rgb(255,15,255  ));
        text1.setStyle("-fx-font-weight: bold");
        text1.setFont(Font.font("Blackadder ITC",40));

        text1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                KeyValue radius1=new KeyValue(circleUserMenu.radiusProperty(),200);
                KeyValue color1=new KeyValue(circleUserMenu.fillProperty(),Color.rgb(240,240,255));
                KeyFrame keyFrame1=new KeyFrame(Duration.millis(500),radius1,color1);
                Timeline timeline1=new Timeline(keyFrame1);
                timeline1.getKeyFrames().addAll(keyFrame1);
                timeline1.play();
                rootStartMenuView.getChildren().addAll(enterYourUser);
            }
        });

        circleUserMenu.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                KeyValue radius1=new KeyValue(circleUserMenu.radiusProperty(),20);
                KeyValue color1=new KeyValue(circleUserMenu.fillProperty(),Color.rgb(255,255,255));
                KeyFrame keyFrame1=new KeyFrame(Duration.millis(500),radius1,color1);
                Timeline timeline1=new Timeline(keyFrame1);
                timeline1.getKeyFrames().addAll(keyFrame1);
                timeline1.play();
                rootStartMenuView.getChildren().remove(enterYourUser);
            }
        });


        KeyValue radius=new KeyValue(circleSun.radiusProperty(),50);
        KeyValue color=new KeyValue(circleSun.fillProperty(),Color.rgb(255,255,255));
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(2),radius,color);
        Timeline timeline=new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(10000);
        timeline.setAutoReverse(true);
        timeline.play();

        rootStartMenuView.getChildren().addAll(circleUserMenu,circleSun,text1);


        circleSun.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }

}
