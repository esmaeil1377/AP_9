package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.Internet.ServerAndClientRunnable.SocketRunnable;
import View.GameView;
import View.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

import static View.View.PlayBubbleSound;
import static View.View.PlayErrorSound;

public class StartMenuView {
    private int gameSpeed = 10;
    private Circle circleSun;
    private TextField enterYourUser;
    private Group root = new Group();
    private Text text;
    private Scene scene = new Scene(root, 1600, 900);
    private SocketRunnable serverOrGuest;

    public SocketRunnable getServerOrGuest() {
        return serverOrGuest;
    }

    public void setServerOrGuest(SocketRunnable serverOrGuest) {
        this.serverOrGuest = serverOrGuest;
    }

    public Text getText() {
        return text;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public Group getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

    public StartMenuView(Stage primaryStage) {
        Start(primaryStage);
        System.out.println("we have new start menu view");
    }

    public void Start(Stage primaryStage) {

        AddBackGround(primaryStage);

        ShowMovingCloud(primaryStage);

        AddPlayClick(primaryStage);

        AddSettingClick(primaryStage);

        AddExitClick(primaryStage);

        AddNewUser(primaryStage);

        AddMultiPlayerIcon(primaryStage);


        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\BackGround.png");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        root.getChildren().addAll(BackGroundView);
    }

    private void AddPlayClick(Stage primaryStage) {
        File playClickFile = new File("Data\\Click\\PlayClick.png");
        Image imagePlayClick = new Image(playClickFile.toURI().toString());
        ImageView playClickView = new ImageView(imagePlayClick);
        playClickView.relocate(700, 350);
        playClickView.setFitWidth(170);
        playClickView.setFitHeight(170);
        playClickView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!enterYourUser.getText().equals("")) {
                    StartingTheUserAccount();
                    primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getScene());
                    primaryStage.setFullScreen(true);
                } else {
                    PlayErrorSound();
                    KeyValue circleSunError = new KeyValue(circleSun.fillProperty(), Color.rgb(100, 0, 0));
                    KeyFrame circleSunFarm = new KeyFrame(Duration.millis(500), circleSunError);
                    Timeline circleSunTimeline = new Timeline(circleSunFarm);
                    circleSunTimeline.setAutoReverse(true);
                    circleSunTimeline.play();
                }

                primaryStage.setFullScreen(true);
            }
        });
        playClickView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.relocate(705, 355);
                playClickView.setFitWidth(160);
                playClickView.setFitHeight(160);
            }
        });
        playClickView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.relocate(700, 350);
                playClickView.setFitWidth(170);
                playClickView.setFitHeight(170);
            }
        });
        root.getChildren().addAll(playClickView);
    }

    private void AddSettingClick(Stage primaryStage) {
        Circle speedCircle = new Circle(1450, 750, 45, Paint.valueOf("White"));
        speedCircle.setOpacity(0.15);
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
        speedCircle.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                int speed = Integer.valueOf(text.getText().substring(text.getText().length() - 2));
                if (speed >= 11 && speed <= 98) {
                    if ((speed + event.getDeltaY() / 32) > 9 && (speed + event.getDeltaY() / 32) < 100)
                        text.setText("Speed\n   " + String.valueOf((int) (speed + event.getDeltaY() / 32)));
                    setGameSpeed((int) (speed + event.getDeltaY() / 32));
                } else if (speed == 10 && event.getDeltaY() > 0) {
                    text.setText("Speed\n   " + String.valueOf(speed + 1));
                    setGameSpeed(speed + 1);
                } else if (speed == 99 && event.getDeltaY() < 0) {
                    text.setText("Speed\n   " + String.valueOf(speed - 1));
                    setGameSpeed(speed - 1);
                }
            }
        });
        text = new Text("Speed\n   10");
        text.setStyle("-fx-font-weight: bold");
        text.setFont(Font.font(20));
        text.relocate(1420, 720);
        text.setFill(Color.rgb(50, 100, 120));


        File settingClick = new File("Data\\Click\\SettingClick.png");
        Image settingImage = new Image(settingClick.toURI().toString());
        ImageView settingImageView = new ImageView(settingImage);
        settingImageView.relocate(1400, 700);
        settingImageView.setFitHeight(100);
        settingImageView.setFitWidth(100);

        settingImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();

                if (root.getChildren().contains(speedCircle)) {
                    KeyValue yText = new KeyValue(text.yProperty(), 0);
                    KeyValue y = new KeyValue(speedCircle.centerYProperty(), 750);
                    KeyFrame speedCircleKeyFrame = new KeyFrame(Duration.millis(500), yText, y);
                    Timeline speedCircleTimeLine = new Timeline(speedCircleKeyFrame);
                    speedCircleTimeLine.getKeyFrames().addAll(speedCircleKeyFrame);
                    speedCircleTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            root.getChildren().removeAll(text, speedCircle);
                        }
                    });
                    speedCircleTimeLine.play();

                } else {
                    root.getChildren().addAll(text);
                    root.getChildren().addAll(speedCircle);

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
                settingImageView.relocate(1405, 705);
                settingImageView.setFitHeight(90);
                settingImageView.setFitWidth(90);
            }
        });
        settingImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingImageView.relocate(1400, 700);
                settingImageView.setFitHeight(100);
                settingImageView.setFitWidth(100);
            }
        });
        root.getChildren().addAll(settingImageView);
    }

    private void AddExitClick(Stage primaryStage) {
        File exitFile = new File("Data\\Click\\ExitClick.png");
        Image exitImage = new Image(exitFile.toURI().toString());
        ImageView exitImageView = new ImageView(exitImage);
        exitImageView.relocate(1400, 50);
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
                exitImageView.relocate(1405, 55);
                exitImageView.setFitHeight(90);
                exitImageView.setFitWidth(90);
            }
        });
        exitImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitImageView.relocate(1400, 50);
                exitImageView.setFitHeight(100);
                exitImageView.setFitWidth(100);
            }
        });
        root.getChildren().addAll(exitImageView);
    }

    private void ShowMovingCloud(Stage primaryStage) {
        File cloudFile = new File("Data\\Cloud.png");
        Image cloudImage = new Image(cloudFile.toURI().toString());
        ImageView cloudView = new ImageView(cloudImage);
        cloudView.relocate(0, 100);

        KeyValue x = new KeyValue(cloudView.xProperty(), 1600);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(90), x);
        Timeline timeline = new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(100);
        timeline.setAutoReverse(true);
        timeline.play();

        root.getChildren().addAll(cloudView);
    }

    private void AddNewUser(Stage primaryStage) {
        circleSun = new Circle(367, 364, 30, Color.rgb(254, 216, 130));
        Circle circleUserMenu = new Circle(367, 364, 20, Color.rgb(240, 240, 255));
        circleUserMenu.setOpacity(0.5);

        enterYourUser = new TextField();
        enterYourUser.relocate(290, 420);


        Text text1 = new Text("users");
        text1.relocate(335, 356);
        text1.setFill(Color.rgb(255, 15, 255));
        text1.setStyle("-fx-font-weight: bold");
        text1.setFont(Font.font(25));

        text1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                KeyValue radius1 = new KeyValue(circleUserMenu.radiusProperty(), 200);
                KeyValue color1 = new KeyValue(circleUserMenu.fillProperty(), Color.rgb(255, 120, 120));
                KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), radius1, color1);
                Timeline timeline1 = new Timeline(keyFrame1);
                timeline1.getKeyFrames().addAll(keyFrame1);
                timeline1.play();
                if (!root.getChildren().contains(enterYourUser)) {
                    root.getChildren().addAll(enterYourUser);
                }
            }
        });

        circleUserMenu.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                KeyValue radius1 = new KeyValue(circleUserMenu.radiusProperty(), 20);
                KeyValue color1 = new KeyValue(circleUserMenu.fillProperty(), Color.rgb(255, 255, 255));
                KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), radius1, color1);
                Timeline timeline1 = new Timeline(keyFrame1);
                timeline1.getKeyFrames().addAll(keyFrame1);
                timeline1.play();
                root.getChildren().remove(enterYourUser);
            }
        });


        KeyValue radius = new KeyValue(circleSun.radiusProperty(), 50);
        KeyValue color = new KeyValue(circleSun.fillProperty(), Color.rgb(255, 255, 255));
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), radius, color);
        Timeline timeline = new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(10000);
        timeline.setAutoReverse(true);
        timeline.play();

        root.getChildren().addAll(circleUserMenu, circleSun, text1);


        circleSun.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }

    private void AddMultiPlayerIcon(Stage primaryStage) {
        File multiPlayerFile = new File("Data\\Click\\MultiPlayerClick.png");
        Image imagePlayClick = new Image(multiPlayerFile.toURI().toString());
        ImageView playClickView = new ImageView(imagePlayClick);
        playClickView.relocate(1390, 380);
        playClickView.setFitWidth(110);
        playClickView.setFitHeight(110);
        playClickView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.relocate(1395, 385);
                playClickView.setFitWidth(100);
                playClickView.setFitHeight(100);
            }
        });
        playClickView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playClickView.relocate(1390, 380);
                playClickView.setFitWidth(110);
                playClickView.setFitHeight(110);
            }
        });
        root.getChildren().addAll(playClickView);

        File cloudServerFile = new File("Data\\Click\\CloudServer.png");
        Image cloudServerImage = new Image(cloudServerFile.toURI().toString());
        ImageView cloudServerView = new ImageView(cloudServerImage);
        cloudServerView.relocate(1200, 350);
        cloudServerView.setFitWidth(140);
        cloudServerView.setFitHeight(140);
        cloudServerView.setOpacity(0);


        Rectangle serverRec = new Rectangle(1200, 350, 140, 70);
        serverRec.setOpacity(0);
        MakeRectangleChangeOpacityWhenMouseIsOnThem(serverRec, "Server");
        Rectangle guestRec = new Rectangle(1200, 420, 140, 70);
        guestRec.setOpacity(0);
        MakeRectangleChangeOpacityWhenMouseIsOnThem(guestRec, "Guest");
        playClickView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!enterYourUser.getText().equals("")) {
                    if (root.getChildren().contains(cloudServerView)) {
                        KeyValue serverGuestOpacity = new KeyValue(cloudServerView.opacityProperty(), 0);
                        KeyFrame serverGuestFrame = new KeyFrame(Duration.millis(1000), serverGuestOpacity);
                        Timeline serverTimeLine = new Timeline(serverGuestFrame);
                        serverTimeLine.play();
                        serverTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                root.getChildren().removeAll(cloudServerView, guestRec, serverRec);
                            }
                        });
                    } else {
                        root.getChildren().addAll(cloudServerView, guestRec, serverRec);
                        KeyValue serverGuestOpacity = new KeyValue(cloudServerView.opacityProperty(), 1);
                        KeyFrame serverGuestFrame = new KeyFrame(Duration.millis(1000), serverGuestOpacity);
                        Timeline serverTimeLine = new Timeline(serverGuestFrame);
                        serverTimeLine.play();
                    }
                } else {
                    PlayErrorSound();
                    KeyValue circleSunError = new KeyValue(circleSun.fillProperty(), Color.rgb(100, 0, 0));
                    KeyFrame circleSunFarm = new KeyFrame(Duration.millis(500), circleSunError);
                    Timeline circleSunTimeline = new Timeline(circleSunFarm);
                    circleSunTimeline.setAutoReverse(true);
                    circleSunTimeline.play();
                }
                primaryStage.setFullScreen(true);
            }
        });
    }

    private void MakeRectangleChangeOpacityWhenMouseIsOnThem(Node node, String serverOrClient) {
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                node.setOpacity(0.3);
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                node.setOpacity(0);
            }
        });
        if (serverOrClient.equals("Server")) {
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    StartingTheUserAccount();
                    HostAndGuestView hostAndGuestView = null;
                    try {
                        hostAndGuestView = new HostAndGuestView(Main.getPrimaryStage());
                    } catch (UnknownObjectException e) {
                        e.printStackTrace();
                    } catch (MissionNotLoaded missionNotLoaded) {
                        missionNotLoaded.printStackTrace();
                    }
                    GameView.getGameView().setHostAndGuestView(hostAndGuestView);
                    Main.getPrimaryStage().setScene(GameView.getGameView().getHostAndGuestView().getScene());
                    Main.getPrimaryStage().setFullScreen(true);
                }
            });
        } else {
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    StartingTheUserAccount();
                    HostAndGuestView hostAndGuestView = null;
                    try {
                        hostAndGuestView = new HostAndGuestView(Main.getPrimaryStage());
                    } catch (UnknownObjectException e) {
                        e.printStackTrace();
                    } catch (MissionNotLoaded missionNotLoaded) {
                        missionNotLoaded.printStackTrace();
                    }
                    hostAndGuestView.AddServerIP();
                    hostAndGuestView.AddTextFieldToGetServerIPAndServerPort();
                    GameView.getGameView().setHostAndGuestView(hostAndGuestView);
                    Main.getPrimaryStage().setScene(hostAndGuestView.getScene());
                    Main.getPrimaryStage().setFullScreen(true);
                }
            });
        }
    }

    private void StartingTheUserAccount() {
        try {
            PlayBubbleSound();
            Game.getGameInstance().NewUserStringWantToStartTheGame(enterYourUser.getText());
        } catch (UnknownObjectException e) {
            e.printStackTrace();
        } catch (NotEnoughMoney notEnoughMoney) {
            notEnoughMoney.printStackTrace();
        } catch (MissionNotLoaded missionNotLoaded) {
            missionNotLoaded.printStackTrace();
        } catch (MaxLevelExceeded maxLevelExceeded) {
            maxLevelExceeded.printStackTrace();
        }
    }
}