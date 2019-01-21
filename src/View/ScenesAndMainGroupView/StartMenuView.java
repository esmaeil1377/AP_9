package View.ScenesAndMainGroupView;

import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class StartMenuView extends View {
    private int gameSpeed=10;
    private Group rootStartMenuView=new Group();
    private Scene sceneStartMenuView=new Scene(rootStartMenuView,1600,900);

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public Group getRootStartMenuView() {
        return rootStartMenuView;
    }

    public Scene getSceneStartMenuView() {
        return sceneStartMenuView;
    }

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

//        AddJumpingRabbit(primaryStage);


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
                PlayBubbleSound();
//                primaryStage.setScene();
                primaryStage.setFullScreen(true);
            }
        });
        playClickView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.relocate(705,355);
                playClickView.setFitWidth(160);
                playClickView.setFitHeight(160);
            }
        });
        playClickView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.relocate(700,350);
                playClickView.setFitWidth(170);
                playClickView.setFitHeight(170);
            }
        });
        rootStartMenuView.getChildren().addAll(playClickView);
    }

    private void AddSettingClick(Stage primaryStage){
        Circle speedCircle=new Circle(1450,750,45, Paint.valueOf("White"));
        speedCircle.setOpacity(0.15);
        speedCircle.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
            }
        });
        speedCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                speedCircle.setOpacity(0.4);
            }
        });
        speedCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                speedCircle.setOpacity(0.1);
            }
        });

        Text text=new Text("Speed\n   10");
        text.setStyle("-fx-font-weight: bold");
        text.setFont(Font.font(20));
        text.relocate(1420,720);
        text.setFill(Color.rgb(50,100,120));

        speedCircle.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
               int speed=Integer.valueOf(text.getText().substring(text.getText().length()-2));
                if(speed>=11 && speed<=98) {
                    text.setText("Speed\n   " + String.valueOf((int)(speed + event.getDeltaY()/32)));
                    setGameSpeed((int)(speed + event.getDeltaY()/32));
                }else if(speed==10 && event.getDeltaY()>0){
                    text.setText("Speed\n   " + String.valueOf(speed + 1));
                    setGameSpeed(speed+1);
                }
                else if(speed==99 && event.getDeltaY()<0){
                    text.setText("Speed\n   " + String.valueOf(speed - 1));
                    setGameSpeed(speed-1);
                }
            }
        });

        File settingClick=new File("Data\\Click\\SettingClick.png");
        Image settingImage=new Image(settingClick.toURI().toString());
        ImageView settingImageView=new ImageView(settingImage);
        settingImageView.relocate(1400,700);
        settingImageView.setFitHeight(100);
        settingImageView.setFitWidth(100);

        settingImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();

                if(rootStartMenuView.getChildren().contains(speedCircle)){
                    KeyValue yText = new KeyValue(text.yProperty(), 0);
                    KeyValue y = new KeyValue(speedCircle.centerYProperty(), 750);
                    KeyFrame speedCircleKeyFrame = new KeyFrame(Duration.millis(500), yText, y);
                    Timeline speedCircleTimeLine = new Timeline(speedCircleKeyFrame);
                    speedCircleTimeLine.getKeyFrames().addAll(speedCircleKeyFrame);
                    speedCircleTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            rootStartMenuView.getChildren().removeAll(text,speedCircle);
                        }
                    });
                    speedCircleTimeLine.play();

                }else {
                    rootStartMenuView.getChildren().addAll(text);
                    rootStartMenuView.getChildren().addAll(speedCircle);

                    KeyValue yTextForStarting = new KeyValue(text.yProperty(), -118);
                    KeyValue yForStarting = new KeyValue(speedCircle.centerYProperty(), 630);
                    KeyFrame speedCircleKeyFrame = new KeyFrame(Duration.millis(500), yTextForStarting, yForStarting);
                    Timeline continueCircleTimeLine = new Timeline(speedCircleKeyFrame);
                    continueCircleTimeLine.getKeyFrames().addAll(speedCircleKeyFrame);
                    continueCircleTimeLine.play();
                }

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
        File exitFile=new File("Data\\Click\\Exit.png");
        Image exitImage=new Image(exitFile.toURI().toString());
        ImageView exitImageView=new ImageView(exitImage);
        exitImageView.relocate(1400,50);
        exitImageView.setFitHeight(100);
        exitImageView.setFitWidth(100);
        exitImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                primaryStage.close();
            }
        });
        exitImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitImageView.relocate(1405,55);
                exitImageView.setFitHeight(90);
                exitImageView.setFitWidth(90);
            }
        });
        exitImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitImageView.relocate(1400,50);
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
        Circle circleUserMenu=new Circle(367,364,20,Color.rgb(240,240,255));
        circleUserMenu.setOpacity(0.5);
        TextField enterYourUser=new TextField();
        enterYourUser.relocate(290,420);


        Text text1=new Text("users");
        text1.relocate(335,356);
        text1.setFill(Color.rgb(255,15,255  ));
        text1.setStyle("-fx-font-weight: bold");
        text1.setFont(Font.font(25));

        text1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                KeyValue radius1=new KeyValue(circleUserMenu.radiusProperty(),200);
                KeyValue color1=new KeyValue(circleUserMenu.fillProperty(),Color.rgb(255,120,120));
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
