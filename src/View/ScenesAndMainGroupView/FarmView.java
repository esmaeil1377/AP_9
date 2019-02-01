package View.ScenesAndMainGroupView;

import FarmController.Exceptions.*;
import FarmModel.*;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.LiveAnimals.*;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.*;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.TransportationVehicle;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.*;
import FarmModel.Request.*;
import View.GameView;
import View.SpriteAnimation;
import View.View;
import com.gilecode.yagson.YaGson;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class FarmView extends View {
    HashMap<ArrayList<Integer>, HashMap<Node, String>> cells = new HashMap<>();
    private Text speedTextInFarmView = new Text("Speed\n   " + String.valueOf(GameView.getGameView().getStartMenuView().getGameSpeed()));
    private Circle speedCircle;
    private Group root = new Group();
    private Scene scene = new Scene(root, 1600, 900);
    private AnimationTimer animationTimer;
    private Text moneyText;
    ImageView helicopterView;
    ImageView truckView;
    Mission mission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
    private Text timerText = new Text(mission.getMinute_1() + mission.getMinute_2() + " : " + mission.getSecond_1() + mission.getSecond_2());

    public Text getSpeedTextInFarmView() {
        return speedTextInFarmView;
    }

    public AnimationTimer getAnimationTimer() {
        return animationTimer;
    }

    public FarmView(Stage primaryStage) throws Exception {
        Start(primaryStage);
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public void Start(Stage primaryStage) throws MissionNotLoaded {
        AddBackGround(primaryStage);
        AddPavement();
        InitializeTheCells();
        CheckWellBucketWater();
        AddLookingGIf();
        User user = Game.getGameInstance().getCurrentUserAccount();
        Mission mission = user.getCurrentPlayingMission();
        Farm farm = mission.getFarm();

        ShowMovingCloud();
        AddMissionWorkShopsAndVehicles(primaryStage);


        speedTextInFarmView.setText(GameView.getGameView().getStartMenuView().getText().getText());


        animationTimer = new AnimationTimer() {
            long time = -1;

            @Override
            public void handle(long now) {
                String speedText = GameView.getGameView().getStartMenuView().getText().getText();
                int speed = Integer.valueOf(speedText.substring(speedText.length() - 2));
                if (time == -1) time = now;
                if (now - time > (2000000000) - (speed * 15881818)) {
                    time = now;
                    try {
                        new TurnRequest("turn 1");
                        UpdateMoneyText();
                        System.out.println("one turn passed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    missionTime();
                }
            }
        };
        animationTimer.start();




        AddMovingWell(user.getWellLevel());

        AddMovingWareHouse(user.getWarehouseLevel());


        AddBuyItems();

        LoadMapIconTharWereBefore();


        ShowBorderOfMsp();

        AddSpeedCircleToSettingInFarm(primaryStage);
        AddMenuClick(primaryStage);

        AddTimeText();

        AddStarAndMoneyText(user.getCurrentPlayingMission().getMissionMoney());
//        ShowEndMission(primaryStage);
    }


    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\Map.png");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(870);
        BackGroundView.setFitWidth(1540);
        BackGroundView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double xPosition = event.getX();
                double yPosition = event.getY();
                if (xPosition < (649.999 + 310) && xPosition > 310 && yPosition < (210 + 375) && yPosition > 210) {
                    int[] cellPosition = getCellPositionByPosition((int) xPosition, (int) yPosition);
                    int xCell = cellPosition[0];
                    int yCell = cellPosition[1];
                    try {
                        new PlantRequest("plant " + String.valueOf(xCell) + " " + String.valueOf(yCell));
                        AddGrassByOneClick(xCell, yCell);
                    } catch (MissionNotLoaded missionNotLoaded) {
                        missionNotLoaded.printStackTrace();
                    } catch (BucketIsEmptyException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        root.getChildren().addAll(BackGroundView);
    }

    private void AddMenuClick(Stage primaryStage) {
        double viewOrder1=-0.9;
        double viewOrder2=-0.94;
        double viewOrder3=-0.98;
        File settingFile = new File("Data\\MenuClick\\Setting.png");
        Image settingImage = new Image(settingFile.toURI().toString());
        ImageView settingView = new ImageView(settingImage);
        settingView.relocate(440, 680);
        settingView.setFitHeight(30);
        settingView.setFitWidth(55);
        settingView.setViewOrder(viewOrder3);

        File saveFile = new File("Data\\MenuClick\\Save.png");
        Image saveImage = new Image(saveFile.toURI().toString());
        ImageView saveView = new ImageView(saveImage);
        saveView.relocate(168, 400);
        saveView.setFitHeight(25);
        saveView.setFitWidth(35);
        saveView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SaveGameRequest("save game UsersAccount");
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
        saveView.setViewOrder(viewOrder3);

        File restartFile = new File("Data\\MenuClick\\Restart.png");
        Image restartImage = new Image(restartFile.toURI().toString());
        ImageView restartImageView = new ImageView(restartImage);
        restartImageView.relocate(266, 655);
        restartImageView.setFitHeight(40);
        restartImageView.setFitWidth(60);
        restartImageView.setViewOrder(viewOrder3);


        File continueFile = new File("Data\\MenuClick\\Continue.png");
        Image continueImage = new Image(continueFile.toURI().toString());
        ImageView continueImageView = new ImageView(continueImage);
        continueImageView.relocate(50, 530);
        continueImageView.setFitHeight(40);
        continueImageView.setFitWidth(60);
        continueImageView.setViewOrder(viewOrder3);

        File mapFile = new File("Data\\MenuClick\\Map.png");
        Image mapImage = new Image(mapFile.toURI().toString());
        ImageView mapTextView = new ImageView(mapImage);
        mapTextView.relocate(300, 780);
        mapTextView.setFitHeight(30);
        mapTextView.setFitWidth(50);
        mapTextView.setViewOrder(viewOrder3);

        File menuTextFile = new File("Data\\MenuClick\\MainMenu.png");
        Image menuTextImage = new Image(menuTextFile.toURI().toString());
        ImageView menuTextImageView = new ImageView(menuTextImage);
        menuTextImageView.relocate(175, 563.495);
        menuTextImageView.setFitHeight(40);
        menuTextImageView.setFitWidth(70);
        menuTextImageView.setViewOrder(viewOrder3);


        Circle menuCircle = new Circle(80, 800, 0);
        menuCircle.setOpacity(0.6);
        menuCircle.setFill(Color.rgb(216, 218, 34));
        menuCircle.setViewOrder(viewOrder1);

        Circle emptyCircle = new Circle(390.84, 502.16, 0);
        emptyCircle.setOpacity(0.6);
        emptyCircle.setFill(Color.rgb(103, 85, 107));
        emptyCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                emptyCircle.setOpacity(0.8);
            }
        });
        emptyCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                emptyCircle.setOpacity(0.6);
            }
        });
        emptyCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        emptyCircle.setViewOrder(viewOrder2);

        Circle savecircle = new Circle(200, 414, 0);
        savecircle.setOpacity(0.6);
        savecircle.setFill(Color.rgb(104, 85, 107));
        savecircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                savecircle.setOpacity(0.8);
            }
        });
        savecircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                savecircle.setOpacity(0.6);
            }
        });
        savecircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                try {
                    new SaveGameRequest("save game UsersAccount");
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
                PlayBubbleSound();
            }
        });
        savecircle.setViewOrder(viewOrder2);

        Circle settingCircle = new Circle(466, 697, 0);
        settingCircle.setOpacity(0.6);
        settingCircle.setFill(Color.rgb(104, 85, 107));
        settingCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingCircle.setOpacity(0.8);
            }
        });
        settingCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingCircle.setOpacity(0.6);
            }
        });
        settingCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!root.getChildren().contains(speedTextInFarmView)) {
                    root.getChildren().addAll(speedTextInFarmView, speedCircle);
                    KeyValue xSpeed = new KeyValue(speedCircle.centerXProperty(), 630);
                    KeyValue ySpeed = new KeyValue(speedCircle.centerYProperty(), 610);
                    KeyFrame speedCircleFrame = new KeyFrame(Duration.millis(500), xSpeed, ySpeed);
                    Timeline speedCircleTimeLine = new Timeline(speedCircleFrame);
                    speedCircleTimeLine.play();
                }
            }
        });
        settingCircle.setViewOrder(viewOrder2);

        Circle mainMenuCircle = new Circle(205, 583.495, 0);
        mainMenuCircle.setOpacity(0.6);
        mainMenuCircle.setFill(Color.rgb(64, 45, 67));
        mainMenuCircle.setViewOrder(viewOrder2);
        mainMenuCircle.setOnMouseEntered(event -> mainMenuCircle.setOpacity(0.8));
        mainMenuCircle.setOnMouseExited(event -> mainMenuCircle.setOpacity(0.6));
        mainMenuCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getScene());
                primaryStage.setFullScreen(true);
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
                GameView.getGameView().setFarmView(null);
            }
        });
        menuTextImageView.setOnMouseEntered(event -> mainMenuCircle.setOpacity(0.8));
        menuTextImageView.setOnMouseExited(event -> mainMenuCircle.setOpacity(0.6));
        menuTextImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getScene());
                primaryStage.setFullScreen(true);
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
                GameView.getGameView().setFarmView(null);
            }
        });

        Circle restartCircle = new Circle(296.505, 675, 0);
        restartCircle.setOpacity(0.6);
        restartCircle.setFill(Color.rgb(64, 45, 67));
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
                try {
                    String currentMissionName = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionName();
                    animationTimer.stop();
                    FileInputStream fileInputStream;
                    fileInputStream = new FileInputStream("SaveGameFile\\" + currentMissionName + ".txt");
                    Mission mission;
                    YaGson mapper = new YaGson();
                    byte missionByte[] = fileInputStream.readAllBytes();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (byte b : missionByte) {
                        stringBuilder.append(String.valueOf((char) b));
                    }
                    String userString = stringBuilder.toString();
                    fileInputStream.close();

                    mission = mapper.fromJson(userString, Mission.class);
                    Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(mission);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        restartImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                restartCircle.setOpacity(0.8);
            }
        });
        restartImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                restartCircle.setOpacity(0.6);
            }
        });
        restartImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    animationTimer.stop();
                    String currentMissionName = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionName();
                    new LoadGameRequest("load game SaveGameFile\\" + currentMissionName + ".txt");
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }

            }
        });
        restartCircle.setViewOrder(viewOrder2);

        Circle mapCircle = new Circle(330, 800, 0);
        mapCircle.setOpacity(0.6);
        mapCircle.setFill(Color.rgb(64, 45, 67));
        mapCircle.setViewOrder(viewOrder2);
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
        mapCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getScene());
                primaryStage.setFullScreen(true);
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
                GameView.getGameView().setFarmView(null);
            }
        });
        mapTextView.setOnMouseEntered(event -> mapCircle.setOpacity(0.8));
        mapTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mapCircle.setOpacity(0.6);
            }
        });
        mapTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getScene());
                primaryStage.setFullScreen(true);
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
                GameView.getGameView().setFarmView(null);
            }
        });

        Circle continueCircle = new Circle(80, 550, 0);
        continueCircle.setOpacity(0.6);
        continueCircle.setViewOrder(viewOrder2);
        continueCircle.setFill(Color.rgb(64, 45, 67));
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
        ArrayList<Circle> menuCircles = new ArrayList<>(Arrays.asList(emptyCircle, savecircle, settingCircle, continueCircle, mainMenuCircle, restartCircle, mapCircle, menuCircle));
        continueCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().removeAll(menuTextImageView, mapTextView, continueImageView, restartImageView, saveView, settingView, speedCircle, speedTextInFarmView);
                animationTimer.start();
                ShowMenuClosing(menuCircles);
                PlayBubbleSound();


            }
        });

        root.getChildren().addAll(menuCircle, continueCircle, mainMenuCircle, restartCircle, mapCircle, settingCircle, savecircle, emptyCircle);

        File menuFile = new File("Data\\Click\\Menu.png");
        Image menuImage = new Image(menuFile.toURI().toString());
        ImageView MenuView = new ImageView(menuImage);
        MenuView.relocate(30, 750);
        MenuView.setFitHeight(100);
        MenuView.setFitWidth(100);
        MenuView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MenuView.relocate(35, 755);
                MenuView.setFitHeight(90);
                MenuView.setFitWidth(90);
            }
        });
        MenuView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MenuView.relocate(30, 750);
                MenuView.setFitHeight(100);
                MenuView.setFitWidth(100);
            }
        });
        MenuView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                try {
                    root.getChildren().addAll(menuTextImageView, mapTextView, continueImageView, restartImageView, settingView, saveView);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                ShowMenuOpening(menuCircles);
                PlayBubbleSound();
            }
        });

        root.getChildren().addAll(MenuView);
    }

    private void AddPavement() {
        File pavementFile = new File("Data\\Pavement.png");
        Image pavementImage = new Image(pavementFile.toURI().toString());
        ImageView pavementViewHelicopter = new ImageView(pavementImage);
        pavementViewHelicopter.relocate(210, 520);
        pavementViewHelicopter.setFitHeight(500);
        pavementViewHelicopter.setFitWidth(300);

        ImageView pavementViewTruck = new ImageView(pavementImage);
        pavementViewTruck.relocate(825, 520);
        pavementViewTruck.setFitHeight(500);
        pavementViewTruck.setFitWidth(300);

        root.getChildren().addAll(pavementViewHelicopter, pavementViewTruck);
    }

    private void ShowMovingCloud() {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File cloudFile = new File("Data\\Cloud.png");
        Image cloudImage = new Image(cloudFile.toURI().toString());
        ImageView cloudView = new ImageView(cloudImage);
        cloudView.relocate(1000, 40);
        cloudView.setFitWidth(40);
        cloudView.setFitHeight(40);
        KeyValue x = new KeyValue(cloudView.xProperty(), 900);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(200 * duration), x);
        Timeline timeline = new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(100000);
        timeline.setAutoReverse(true);
        timeline.play();

        root.getChildren().addAll(cloudView);
    }

    private void AddMovingWell(int level){
        File wellFile = new File("Data\\Textures\\Service\\Well\\0" + String.valueOf(level + 1) + ".png");
        Image wellImage = new Image(wellFile.toURI().toString());
        ImageView wellView = new ImageView(wellImage);
        wellView.relocate(1120, 500);
        wellView.setFitHeight(310);
        wellView.setFitWidth(315);
        wellView.setViewport(new Rectangle2D(0, 0, 150, 136));
        wellView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(1115, 495);
                wellView.setFitHeight(320);
                wellView.setFitWidth(325);
            }
        });
        wellView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(1120, 500);
                wellView.setFitHeight(310);
                wellView.setFitWidth(315);
            }
        });
        wellView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
                    if (!well.isWellActivatedToFillTheBucket()) {
                        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                        PlayBubbleSound();
                        well.setWellActivatedToFillTheBucket(true);
                        UpdateMoneyText();
                        Animation animation = new SpriteAnimation(wellView, Duration.millis(duration-level*duration/10), 12, 4, 0, 0, 150, 136);
                        animation.setCycleCount(5-level);
                        animation.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                wellView.setViewport(new Rectangle2D(0, 0, 150, 136));
                                try {
                                    new WellRequest();
                                    CheckWellBucketWater();
                                    well.setWellActivatedToFillTheBucket(false);
                                } catch (MissionNotLoaded missionNotLoaded) {
                                    missionNotLoaded.printStackTrace();
                                } catch (WellIsNotEmpty wellIsNotEmpty) {
                                    wellIsNotEmpty.printStackTrace();
                                }
                            }
                        });
                        animation.setDelay(Duration.millis(83));
                        animation.play();
                    }
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
        root.getChildren().addAll(wellView);
    }

    private void AddMovingWareHouse(int level) {
        File wareHouseFile = new File("Data\\Textures\\Service\\Depot\\0" + String.valueOf(level + 1) + ".png");
        Image wareHouseImage = new Image(wareHouseFile.toURI().toString());
        ImageView wareHouseView = new ImageView(wareHouseImage);
        wareHouseView.relocate(500, 600);
        wareHouseView.setFitHeight(300);
        wareHouseView.setFitWidth(310);
//        wellView.setViewport(new Rectangle2D(0,0 , 150, 150));
        wareHouseView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.relocate(495, 595);
                wareHouseView.setFitHeight(310);
                wareHouseView.setFitWidth(320);
            }
        });
        wareHouseView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.relocate(500, 600);
                wareHouseView.setFitHeight(300);
                wareHouseView.setFitWidth(310);
            }
        });
//        wareHouseView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    ShowTruckGoingToCityAndComingBack();
//                    ShowHelicopterToCityAndComingBack();
//                } catch (MissionNotLoaded missionNotLoaded) {
//                    missionNotLoaded.printStackTrace();
//                }
////                AddLevelBucketToWell(0);
//            }
//        });
        root.getChildren().addAll(wareHouseView);
    }

    private void AddBuyItems() {
        Text chickenPrice = new Text("100");
        chickenPrice.relocate(1430,286);
        chickenPrice.setFont(Font.font(15));
        chickenPrice.setStyle("-fx-font-weight: bold");
        File chickenFile = new File("Data\\Textures\\BuyIconNotHead\\Chicken.png");
        Image chickenImage = new Image(chickenFile.toURI().toString());
        ImageView chickenView = new ImageView(chickenImage);
        chickenView.setFitHeight(80);
        chickenView.setFitWidth(80);
        chickenView.setViewport(new Rectangle2D(0,0,55,60));
        chickenView.relocate(1405, 230);
        chickenView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenView.setOpacity(0.8);
            }
        });
        chickenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenView.setOpacity(1);
            }
        });
        chickenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                try {
                    new BuyRequest("buy Chicken");
                    UpdateMoneyText();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        Text sheepPrice = new Text("1000");
        sheepPrice.relocate(1425,376);
        sheepPrice.setFont(Font.font(15));
        sheepPrice.setStyle("-fx-font-weight: bold");
        File sheepFile = new File("Data\\Textures\\BuyIconNotHead\\Sheep.png");
        Image sheepImage = new Image(sheepFile.toURI().toString());
        ImageView sheepView = new ImageView(sheepImage);
        sheepView.relocate(1405, 320);
        sheepView.setViewport(new Rectangle2D(0,0,55,60));
        sheepView.setFitHeight(80);
        sheepView.setFitWidth(80);
        sheepView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sheepView.setOpacity(0.8);
            }
        });
        sheepView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sheepView.setOpacity(1);
            }
        });
        sheepView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                try {
                    new BuyRequest("buy Sheep");
                    UpdateMoneyText();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Text cowPrice = new Text("10000");
        cowPrice.relocate(1419,466);
        cowPrice.setFont(Font.font(15));
        cowPrice.setStyle("-fx-font-weight: bold");
        File cowFile = new File("Data\\Textures\\BuyIconNotHead\\Cow.png");
        Image cowImage = new Image(cowFile.toURI().toString());
        ImageView cowView = new ImageView(cowImage);
        cowView.relocate(1405, 410);
        cowView.setViewport(new Rectangle2D(0,0,55,60));
        cowView.setFitHeight(80);
        cowView.setFitWidth(80);

        cowView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowView.setOpacity(0.8);
            }
        });
        cowView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowView.setOpacity(1);
            }
        });
        cowView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                try {
                    new BuyRequest("buy Cow");
                    UpdateMoneyText();
                } catch (Exception e) {
                }
            }
        });
        Text catPrice = new Text("2500");
        catPrice.relocate(1425,556);
        catPrice.setFont(Font.font(15));
        catPrice.setStyle("-fx-font-weight: bold");
        File catFile = new File("Data\\Textures\\BuyIconNotHead\\Cat.png");
        Image catImage = new Image(catFile.toURI().toString());
        ImageView catView = new ImageView(catImage);
        catView.relocate(1405, 500);
        catView.setViewport(new Rectangle2D(0,0,55,60));
        catView.setFitHeight(80);
        catView.setFitWidth(80);
        catView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catView.setOpacity(0.8);
            }
        });
        catView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catView.setOpacity(1);
            }
        });
        catView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                try {
                    new BuyRequest("buy Cat");
                    UpdateMoneyText();
                } catch (Exception e) {
                }
            }
        });
        Text dogPrice = new Text("2600");
        dogPrice.relocate(1425,646);
        dogPrice.setFont(Font.font(15));
        dogPrice.setStyle("-fx-font-weight: bold");
        File dogFile = new File("Data\\Textures\\BuyIconNotHead\\Dog.png");
        Image dogImage = new Image(dogFile.toURI().toString());
        ImageView dogView = new ImageView(dogImage);
        dogView.relocate(1405, 590);
        dogView.setViewport(new Rectangle2D(0,0,55,60));
        dogView.setFitHeight(80);
        dogView.setFitWidth(80);
        dogView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogView.setOpacity(0.8);
            }
        });
        dogView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogView.setOpacity(1);
            }
        });
        dogView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                try {
                    new BuyRequest("buy Dog");
                    UpdateMoneyText();
                } catch (Exception e) {
                }
            }
        });


        root.getChildren().addAll( chickenView, sheepView, cowView, catView, dogView,chickenPrice,catPrice,cowPrice,dogPrice,sheepPrice);
    }


    private void AddSpinnery(int level) {
        File spinneryFile = new File("Data\\Textures\\Workshops\\Spinnery(Spinnery)\\0" + String.valueOf(level + 1) + ".png");
        Image spinneryImage = new Image(spinneryFile.toURI().toString());
        ImageView spinneryView = new ImageView(spinneryImage);
        spinneryView.relocate(100, 200);
        spinneryView.setFitHeight(150);
        spinneryView.setFitWidth(150);
        spinneryView.setViewport(new Rectangle2D(0, 0, 130, 106));

        File calloutFile = new File("Data\\Callout.png");
        Image calloutImage = new Image(calloutFile.toURI().toString());
        ImageView calloutView = new ImageView(calloutImage);

        File productFile = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image productImage = new Image(productFile.toURI().toString());
        ImageView productView = new ImageView(productImage);

        File productFile_2 = new File("Data\\Textures\\Products\\Sewing.png");
        Image productImage_2 = new Image(productFile_2.toURI().toString());
        ImageView productView_2 = new ImageView(productImage_2);
        Text text = new Text();

        File arrowFile = new File("Data\\Arrow.png");
        Image arrowImage = new Image(arrowFile.toURI().toString());
        ImageView arrowView = new ImageView(arrowImage);

//        File plusFile = new File("Data\\Plus.png");
//        Image plusImage = new Image(plusFile.toURI().toString());
//        ImageView plusView = new ImageView(plusImage);

        spinneryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.relocate(95, 195);
                spinneryView.setFitHeight(160);
                spinneryView.setFitWidth(160);
                calloutView.relocate(50, 95);
                calloutView.setFitHeight(150);
                calloutView.setFitWidth(225);
                text.setText("Spinnery Factory");
                text.setStyle("-fx-font-weight: bold");
                text.setFont(Font.font(20));
                text.relocate(85,135);
                productView.setFitWidth(30);
                productView.setFitHeight(30);
                productView.relocate(100,170);
                arrowView.setFitWidth(30);
                arrowView.setFitHeight(20);
                arrowView.relocate(150,175);
                productView_2.setFitWidth(30);
                productView_2.setFitHeight(30);
                productView_2.relocate(200,170);

//                plusView.setFitWidth(30);
//                plusView.setFitHeight(30);
//                plusView.relocate(100,150);
                root.getChildren().addAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        spinneryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.relocate(100, 200);
                spinneryView.setFitHeight(150);
                spinneryView.setFitWidth(150);
                root.getChildren().removeAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        spinneryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                    int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                    Spinnery spinnery = (Spinnery) Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop("Spinnery");
                    spinnery.getProductFromWareHouse();
                    PlayBubbleSound();
                    Animation animation = new SpriteAnimation(spinneryView, Duration.millis(duration / 2-level*duration/20), 16, 4, 0, 0, 130, 106);
                    animation.setCycleCount(spinnery.getTurnNeededToProduceOneProduct() / 2-level);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            spinneryView.setViewport(new Rectangle2D(0, 0, 130, 106));
                            try {
                                spinnery.MakeAProductAndPutItInMap();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    });
                    animation.setDelay(Duration.millis(83));
                    animation.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(spinneryView);
    }

    private void AddCakeBakery(int level) {
        File cakeBakeryFile = new File("Data\\Textures\\Workshops\\FlouryCake(Cake Bakery)\\0" + String.valueOf(level + 1) + ".png");
        Image cakeBakeryImage = new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw = new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(100, 350);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 184, 172));

        File calloutFile = new File("Data\\Callout.png");
        Image calloutImage = new Image(calloutFile.toURI().toString());
        ImageView calloutView = new ImageView(calloutImage);

        File productFile = new File("Data\\Textures\\Products\\Cake.png");
        Image productImage = new Image(productFile.toURI().toString());
        ImageView productView = new ImageView(productImage);

        File productFile_2 = new File("Data\\Textures\\Products\\Flour.png");
        Image productImage_2 = new Image(productFile_2.toURI().toString());
        ImageView productView_2 = new ImageView(productImage_2);

        File productFile_3 = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image productImage_3 = new Image(productFile_3.toURI().toString());
        ImageView productView_3 = new ImageView(productImage_3);

        Text text = new Text();

        File arrowFile = new File("Data\\Arrow.png");
        Image arrowImage = new Image(arrowFile.toURI().toString());
        ImageView arrowView = new ImageView(arrowImage);

        File plusFile = new File("Data\\Plus.png");
        Image plusImage = new Image(plusFile.toURI().toString());
        ImageView plusView = new ImageView(plusImage);
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(95, 345);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
                calloutView.relocate(50, 245);
                calloutView.setFitHeight(150);
                calloutView.setFitWidth(225);
                text.setText("Cake Bakery");
                text.setStyle("-fx-font-weight: bold");
                text.setFont(Font.font(20));
                text.relocate(110,285);
                productView.setFitWidth(30);
                productView.setFitHeight(30);
                productView.relocate(90,320);
                plusView.setFitWidth(20);
                plusView.setFitHeight(20);
                plusView.relocate(125,325);
                productView_2.setFitWidth(30);
                productView_2.setFitHeight(30);
                productView_2.relocate(150,320);
                arrowView.setFitWidth(30);
                arrowView.setFitHeight(20);
                arrowView.relocate(185,325);
                productView_3.setFitWidth(30);
                productView_3.setFitHeight(30);
                productView_3.relocate(220,320);
                root.getChildren().addAll(calloutView,text,productView,arrowView,productView_2,productView_3,plusView);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(100, 350);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
                root.getChildren().removeAll(calloutView,text,productView,plusView,productView_2,productView_3,arrowView);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                    int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                    CakeBakery cakeBakery = (CakeBakery) Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop("CakeBakery");
                    cakeBakery.getProductFromWareHouse();
                    PlayBubbleSound();
                    Animation animation = new SpriteAnimation(cakeBakeryVeiw, Duration.millis(duration / 2-level*duration/20), 16, 4, 0, 0, 184, 172);
                    animation.setCycleCount(cakeBakery.getTurnNeededToProduceOneProduct() / 2-level);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 184, 172));
                            try {
                                cakeBakery.MakeAProductAndPutItInMap();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    });
                    animation.setDelay(Duration.millis(83));
                    animation.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(cakeBakeryVeiw);
    }

    private void AddSewingFactory(int level) {
        File sewingFactoryFile = new File("Data\\Textures\\Workshops\\CarnivalDress(Sewing Factory)\\0" + String.valueOf(level + 1) + ".png");
        Image sewingFactoryImage = new Image(sewingFactoryFile.toURI().toString());
        ImageView sewingFactoryView = new ImageView(sewingFactoryImage);
        sewingFactoryView.relocate(100, 500);
        sewingFactoryView.setFitHeight(150);
        sewingFactoryView.setFitWidth(150);
        sewingFactoryView.setViewport(new Rectangle2D(0, 0, 170, 130));

        File calloutFile = new File("Data\\Callout.png");
        Image calloutImage = new Image(calloutFile.toURI().toString());
        ImageView calloutView = new ImageView(calloutImage);

        File productFile = new File("Data\\Textures\\Products\\Adornment.png");
        Image productImage = new Image(productFile.toURI().toString());
        ImageView productView = new ImageView(productImage);

        File productFile_2 = new File("Data\\Textures\\Products\\Fabric.png");
        Image productImage_2 = new Image(productFile_2.toURI().toString());
        ImageView productView_2 = new ImageView(productImage_2);

        File productFile_3 = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image productImage_3 = new Image(productFile_3.toURI().toString());
        ImageView productView_3 = new ImageView(productImage_3);

        Text text = new Text();

        File arrowFile = new File("Data\\Arrow.png");
        Image arrowImage = new Image(arrowFile.toURI().toString());
        ImageView arrowView = new ImageView(arrowImage);

        File plusFile = new File("Data\\Plus.png");
        Image plusImage = new Image(plusFile.toURI().toString());
        ImageView plusView = new ImageView(plusImage);
        sewingFactoryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.relocate(95, 495);
                sewingFactoryView.setFitHeight(160);
                sewingFactoryView.setFitWidth(160);
                calloutView.relocate(50, 395);
                calloutView.setFitHeight(150);
                calloutView.setFitWidth(225);
                text.setText("Sewing Factory");
                text.setStyle("-fx-font-weight: bold");
                text.setFont(Font.font(20));
                text.relocate(100,435);
                productView.setFitWidth(30);
                productView.setFitHeight(30);
                productView.relocate(90,470);
                plusView.setFitWidth(20);
                plusView.setFitHeight(20);
                plusView.relocate(125,475);
                productView_2.setFitWidth(30);
                productView_2.setFitHeight(30);
                productView_2.relocate(150,470);
                arrowView.setFitWidth(30);
                arrowView.setFitHeight(20);
                arrowView.relocate(185,475);
                productView_3.setFitWidth(30);
                productView_3.setFitHeight(30);
                productView_3.relocate(220,470);
                root.getChildren().addAll(calloutView,text,productView,arrowView,productView_2,productView_3,plusView);
            }
        });
        sewingFactoryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.relocate(100, 500);
                sewingFactoryView.setFitHeight(150);
                sewingFactoryView.setFitWidth(150);
                root.getChildren().removeAll(calloutView,text,productView,arrowView,productView_2,productView_3,plusView);
            }
        });
        sewingFactoryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                    int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                    SewingFactory sewingFactory = (SewingFactory) Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop("SewingFactory");
                    sewingFactory.getProductFromWareHouse();
                    PlayBubbleSound();
                    Animation animation = new SpriteAnimation(sewingFactoryView, Duration.millis(duration / 2-level*duration/20), 16, 4, 0, 0, 170, 130);
                    animation.setCycleCount(sewingFactory.getTurnNeededToProduceOneProduct() / 2-level);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            sewingFactoryView.setViewport(new Rectangle2D(0, 0, 170, 130));
                            try {
                                sewingFactory.MakeAProductAndPutItInMap();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    });
                    animation.setDelay(Duration.millis(83));
                    animation.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(sewingFactoryView);
    }

    private void AddWeavingFactory(int level) {
        File WeavingFile = new File("Data\\Textures\\Workshops\\Weaving(Weaving Factory)\\0" + String.valueOf(level + 1) + ".png");
        Image WeavingImage = new Image(WeavingFile.toURI().toString());
        ImageView WeavingView = new ImageView(WeavingImage);
        WeavingView.relocate(1000, 200);
        WeavingView.setFitHeight(150);
        WeavingView.setFitWidth(150);
        WeavingView.setViewport(new Rectangle2D(0, 0, 166, 116));

        File calloutFile = new File("Data\\Callout.png");
        Image calloutImage = new Image(calloutFile.toURI().toString());
        ImageView calloutView = new ImageView(calloutImage);

        File productFile = new File("Data\\Textures\\Products\\Sewing.png");
        Image productImage = new Image(productFile.toURI().toString());
        ImageView productView = new ImageView(productImage);

        File productFile_2 = new File("Data\\Textures\\Products\\Fabric.png");
        Image productImage_2 = new Image(productFile_2.toURI().toString());
        ImageView productView_2 = new ImageView(productImage_2);
        Text text = new Text();

        File arrowFile = new File("Data\\Arrow.png");
        Image arrowImage = new Image(arrowFile.toURI().toString());
        ImageView arrowView = new ImageView(arrowImage);
        WeavingView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WeavingView.relocate(995, 195);
                WeavingView.setFitHeight(160);
                WeavingView.setFitWidth(160);
                calloutView.relocate(950, 95);
                calloutView.setFitHeight(150);
                calloutView.setFitWidth(225);
                text.setText("Weaving Factory");
                text.setStyle("-fx-font-weight: bold");
                text.setFont(Font.font(20));
                text.relocate(985,135);
                productView.setFitWidth(30);
                productView.setFitHeight(30);
                productView.relocate(1000,170);
                arrowView.setFitWidth(30);
                arrowView.setFitHeight(20);
                arrowView.relocate(1050,175);
                productView_2.setFitWidth(30);
                productView_2.setFitHeight(30);
                productView_2.relocate(1100,170);

                root.getChildren().addAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        WeavingView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WeavingView.relocate(1000, 200);
                WeavingView.setFitHeight(150);
                WeavingView.setFitWidth(150);
                root.getChildren().removeAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        WeavingView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                    int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                    WeavingFactory weavingFactory = (WeavingFactory) Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop("WeavingFactory");
                    weavingFactory.getProductFromWareHouse();
                    PlayBubbleSound();
                    Animation animation = new SpriteAnimation(WeavingView, Duration.millis(duration / 2-level*duration/20), 16, 4, 0, 0, 166, 116);
                    animation.setCycleCount(weavingFactory.getTurnNeededToProduceOneProduct() / 2-level);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            WeavingView.setViewport(new Rectangle2D(0, 0, 166, 116));
                            try {
                                weavingFactory.MakeAProductAndPutItInMap();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    });
                    animation.setDelay(Duration.millis(83));
                    animation.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(WeavingView);
    }

    private void AddCookieBakery(int level) {
        File cakeBakeryFile = new File("Data\\Textures\\Workshops\\Cake(Cookie Bakery)\\0" + String.valueOf(level + 1) + ".png");
        Image cakeBakeryImage = new Image(cakeBakeryFile.toURI().toString());
        ImageView cookieBakeryView = new ImageView(cakeBakeryImage);
        cookieBakeryView.relocate(1000, 350);
        cookieBakeryView.setFitHeight(150);
        cookieBakeryView.setFitWidth(150);
        cookieBakeryView.setViewport(new Rectangle2D(0, 0, 140, 130));

        File calloutFile = new File("Data\\Callout.png");
        Image calloutImage = new Image(calloutFile.toURI().toString());
        ImageView calloutView = new ImageView(calloutImage);

        File productFile = new File("Data\\Textures\\Products\\EggPowder.png");
        Image productImage = new Image(productFile.toURI().toString());
        ImageView productView = new ImageView(productImage);

        File productFile_2 = new File("Data\\Textures\\Products\\Cake.png");
        Image productImage_2 = new Image(productFile_2.toURI().toString());
        ImageView productView_2 = new ImageView(productImage_2);

        Text text = new Text();

        File arrowFile = new File("Data\\Arrow.png");
        Image arrowImage = new Image(arrowFile.toURI().toString());
        ImageView arrowView = new ImageView(arrowImage);
        cookieBakeryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cookieBakeryView.relocate(995, 345);
                cookieBakeryView.setFitHeight(160);
                cookieBakeryView.setFitWidth(160);
                calloutView.relocate(950, 245);
                calloutView.setFitHeight(150);
                calloutView.setFitWidth(225);
                text.setText("Cookie Bakery");
                text.setStyle("-fx-font-weight: bold");
                text.setFont(Font.font(20));
                text.relocate(1000,285);
                productView.setFitWidth(30);
                productView.setFitHeight(30);
                productView.relocate(1000,320);
                productView_2.setFitWidth(30);
                productView_2.setFitHeight(30);
                productView_2.relocate(1100,320);
                arrowView.setFitWidth(30);
                arrowView.setFitHeight(20);
                arrowView.relocate(1050,325);
                root.getChildren().addAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        cookieBakeryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cookieBakeryView.relocate(1000, 350);
                cookieBakeryView.setFitHeight(150);
                cookieBakeryView.setFitWidth(150);
                root.getChildren().removeAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        cookieBakeryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                    int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                    CookieBakery cookieBakery = (CookieBakery) Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop("CookieBakery");
                    cookieBakery.getProductFromWareHouse();
                    PlayBubbleSound();
                    Animation animation = new SpriteAnimation(cookieBakeryView, Duration.millis(duration / 2-level*duration/20), 16, 4, 0, 0, 134, 142);
                    animation.setCycleCount(cookieBakery.getTurnNeededToProduceOneProduct() / 2-level);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            cookieBakeryView.setViewport(new Rectangle2D(0, 0, 134, 142));
                            try {
                                cookieBakery.MakeAProductAndPutItInMap();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    });
                    animation.setDelay(Duration.millis(83));
                    animation.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(cookieBakeryView);
    }

    private void AddEggPowderPlant(int level) {
        File cakeBakeryFile = new File("Data\\Textures\\Workshops\\DriedEggs(Egg Powder Plant)\\0" + String.valueOf(level + 1) + ".png");
        Image cakeBakeryImage = new Image(cakeBakeryFile.toURI().toString());
        ImageView eggPowderPlantView = new ImageView(cakeBakeryImage);
        eggPowderPlantView.relocate(1000, 500);
        eggPowderPlantView.setFitHeight(150);
        eggPowderPlantView.setFitWidth(150);
        eggPowderPlantView.setViewport(new Rectangle2D(0, 0, 128, 114));

        File calloutFile = new File("Data\\Callout.png");
        Image calloutImage = new Image(calloutFile.toURI().toString());
        ImageView calloutView = new ImageView(calloutImage);

        File productFile = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image productImage = new Image(productFile.toURI().toString());
        ImageView productView = new ImageView(productImage);

        File productFile_2 = new File("Data\\Textures\\Products\\EggPowder.png");
        Image productImage_2 = new Image(productFile_2.toURI().toString());
        ImageView productView_2 = new ImageView(productImage_2);

        Text text = new Text();

        File arrowFile = new File("Data\\Arrow.png");
        Image arrowImage = new Image(arrowFile.toURI().toString());
        ImageView arrowView = new ImageView(arrowImage);
        eggPowderPlantView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderPlantView.relocate(995, 495);
                eggPowderPlantView.setFitHeight(160);
                eggPowderPlantView.setFitWidth(160);
                calloutView.relocate(950, 395);
                calloutView.setFitHeight(150);
                calloutView.setFitWidth(225);
                text.setText("Egg Powder Plant");
                text.setStyle("-fx-font-weight: bold");
                text.setFont(Font.font(20));
                text.relocate(980,435);
                productView.setFitWidth(22.5);
                productView.setFitHeight(22.5);
                productView.relocate(1000,470);
                productView_2.setFitWidth(30);
                productView_2.setFitHeight(30);
                productView_2.relocate(1100,470);
                arrowView.setFitWidth(30);
                arrowView.setFitHeight(20);
                arrowView.relocate(1050,475);
                root.getChildren().addAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        eggPowderPlantView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderPlantView.relocate(1000, 500);
                eggPowderPlantView.setFitHeight(150);
                eggPowderPlantView.setFitWidth(150);
                root.getChildren().removeAll(calloutView,text,productView,arrowView,productView_2);
            }
        });
        eggPowderPlantView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                    int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                    EggPowderPlant eggPowderPlant = (EggPowderPlant) Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getSpecifiedWorkShop("EggPowderPlant");
                    eggPowderPlant.getProductFromWareHouse();
                    PlayBubbleSound();
                    Animation animation = new SpriteAnimation(eggPowderPlantView, Duration.millis(duration / 2-level*duration/20), 16, 4, 0, 0, 128, 114);
                    animation.setCycleCount(eggPowderPlant.getTurnNeededToProduceOneProduct() / 2-level);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            eggPowderPlantView.setViewport(new Rectangle2D(0, 0, 128, 114));
                            try {
                                eggPowderPlant.MakeAProductAndPutItInMap();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    });
                    animation.setDelay(Duration.millis(83));
                    animation.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(eggPowderPlantView);
    }

    private void AddCustomWorkShop() {
    }

    private void AddTruck(Stage primaryStage, int level) {
        File truckFile = new File("Data\\Textures\\Service\\Truck\\0" + String.valueOf(level + 1) + ".png");
        Image truckImage = new Image(truckFile.toURI().toString());
        truckView = new ImageView(truckImage);
        truckView.relocate(880, 620);
        truckView.setFitHeight(200);
        truckView.setFitWidth(200);
        truckView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                truckView.relocate(875, 615);
                truckView.setFitHeight(210);
                truckView.setFitWidth(210);
            }
        });
        truckView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                truckView.relocate(880, 620);
                truckView.setFitHeight(200);
                truckView.setFitWidth(200);
            }
        });
        truckView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                ProductInTruckView productInTruckView = null;
                try {
                    productInTruckView = new ProductInTruckView(primaryStage);
                } catch (UnknownObjectException e) {
                    e.printStackTrace();
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
                primaryStage.setScene(productInTruckView.getScene());
                GameView.getGameView().setProductInTruckView(productInTruckView);
                primaryStage.setFullScreen(true);
            }
        });
        root.getChildren().addAll(truckView);
    }

    public void ShowTruckGoingToCityAndComingBack() throws MissionNotLoaded {
        root.getChildren().removeAll(truckView);
        Truck truck = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        int turnToMoveObjectToCityAndComeBack = truck.getTurnToMoveObjectToCityAndComeBack();

        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File truckFile = new File("Data\\Textures\\UI\\Truck\\01_mini.png");
        Image truckImage = new Image(truckFile.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.relocate(980, 75);
        truckView.setFitHeight(80);
        truckView.setFitWidth(80);
        truckView.setViewport(new Rectangle2D(0, 0, 48, 48));
        truckView.setScaleX(-1);

        KeyValue xForGoing = new KeyValue(truckView.xProperty(), 500);

        KeyFrame going = new KeyFrame(Duration.millis(turnToMoveObjectToCityAndComeBack * duration), xForGoing);
        Timeline timeLineGoing = new Timeline(going);
        timeLineGoing.getKeyFrames().addAll(going);
        VehicleTimeLine(truck, turnToMoveObjectToCityAndComeBack, truckView, timeLineGoing);
        timeLineGoing.play();


        truckView.setViewport(new Rectangle2D(0, 0, 48, 48));

        Animation animation = new SpriteAnimation(truckView, Duration.millis(100), 2, 2, 0, 0, 48, 48);
        animation.setCycleCount(100000);
        animation.play();

        root.getChildren().addAll(truckView);
    }

    private void AddHelicopter(Stage primaryStage, int level) {
        File helicopterFile = new File("Data\\Textures\\Service\\Helicopter\\0" + String.valueOf(level + 1) + ".png");
        Image helicopterImage = new Image(helicopterFile.toURI().toString());
        helicopterView = new ImageView(helicopterImage);
        helicopterView.relocate(250, 600);
        helicopterView.setFitHeight(200);
        helicopterView.setFitWidth(200);
        helicopterView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helicopterView.relocate(245, 595);
                helicopterView.setFitHeight(210);
                helicopterView.setFitWidth(210);
            }
        });
        helicopterView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helicopterView.relocate(250, 600);
                helicopterView.setFitHeight(200);
                helicopterView.setFitWidth(200);
            }
        });
        helicopterView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                GameView.getGameView().setProductInHelicopterView(new ProductInHelicopterView(primaryStage));
                primaryStage.setScene(GameView.getGameView().getProductInHelicopterView().getScene());
                primaryStage.setFullScreen(true);
            }
        });
        root.getChildren().addAll(helicopterView);
    }

    public void ShowHelicopterToCityAndComingBack() throws MissionNotLoaded {
        root.getChildren().removeAll(helicopterView);
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        Helicopter helicopter = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getHelicopter();
        int turnToGoToCityAndComeBack = helicopter.getTurnToMoveObjectToCityAndComeBack();

        File helicopterFile = new File("Data\\Textures\\UI\\Helicopter\\01_mini.png");
        Image helicopterImage = new Image(helicopterFile.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.relocate(980, 20);
        helicopterView.setFitHeight(80);
        helicopterView.setFitWidth(80);
        helicopterView.setViewport(new Rectangle2D(0, 0, 48, 48));
        helicopterView.setScaleX(-1);

        KeyValue xForGoing = new KeyValue(helicopterView.xProperty(), 500);
        KeyFrame goingFrame = new KeyFrame(Duration.millis(turnToGoToCityAndComeBack * duration), xForGoing);
        Timeline timeLineGoing = new Timeline(goingFrame);
        timeLineGoing.getKeyFrames().addAll(goingFrame);
        VehicleTimeLine(helicopter, turnToGoToCityAndComeBack, helicopterView, timeLineGoing);
        timeLineGoing.play();

        helicopterView.setViewport(new Rectangle2D(0, 0, 48, 48));

        Animation animation = new SpriteAnimation(helicopterView, Duration.millis(100), 6, 3, 0, 0, 48, 48);
        animation.setCycleCount(100000);
        animation.play();

        root.getChildren().addAll(helicopterView);
    }

    private void VehicleTimeLine(TransportationVehicle vehicle, int turnToGoToCityAndComeBack, ImageView vehicleView, Timeline timeLineGoing) {
        timeLineGoing.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
                int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
                vehicleView.setScaleX(1);
                KeyValue xForComing = new KeyValue(vehicleView.xProperty(), 0);
                KeyFrame coming = new KeyFrame(Duration.millis(turnToGoToCityAndComeBack * duration), xForComing);
                Timeline timeLineComing = new Timeline(coming);
                timeLineComing.getKeyFrames().addAll(coming);
                timeLineComing.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        root.getChildren().removeAll(vehicleView);
                        if (vehicle instanceof Truck) {
                            try {
                                root.getChildren().addAll(truckView);
                                int money = Integer.valueOf(GameView.getGameView().getProductInTruckView().getCoinText().getText());
                                Mission mission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
                                mission.ChangeMissionMoney(money);
                                UpdateMoneyText();

                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        } else if (vehicle instanceof Helicopter) {
                            try {
                                root.getChildren().addAll(helicopterView);
                                Helicopter helicopter = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getHelicopter();
                                helicopter.PutObjectInMapRandomly();
                            } catch (MissionNotLoaded missionNotLoaded) {
                                missionNotLoaded.printStackTrace();
                            }
                        }
                    }
                });
                timeLineComing.play();
            }
        });
    }

    private void AddLookingGIf() {
        File chickenFile = new File("Data\\Gif\\LookingChicken.gif");
        Image chickenImage = new Image(chickenFile.toURI().toString());
        ImageView LookingChickenImage = new ImageView(chickenImage);
        LookingChickenImage.relocate(1150, 250);
        LookingChickenImage.setFitHeight(180);
        LookingChickenImage.setFitWidth(180);

        root.getChildren().addAll(LookingChickenImage);
    }

    private void PlantGrass(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0] - 24;
        int yPosition = position[1] - 24;

        File grassFile = new File("Data\\Textures\\Grass\\grass1.png");
        Image grassImage = new Image(grassFile.toURI().toString());
        ImageView grassView = new ImageView(grassImage);
        grassView.relocate(xPosition, yPosition);
        grassView.setFitHeight(48);
        grassView.setFitWidth(48);
        grassView.setViewport(new Rectangle2D(0, 0, 48, 48));

        Animation animation = new SpriteAnimation(grassView, Duration.millis(1000), 12, 4, 0, 0, 48, 48);
        animation.play();
        root.getChildren().addAll(grassView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(grassView,"Grass");
    }

    public void AddEgg(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File eggFile = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image eggImage = new Image(eggFile.toURI().toString());
        ImageView eggView = new ImageView(eggImage);
        eggView.relocate(xPosition, yPosition);
        eggView.setFitHeight(27);
        eggView.setFitWidth(20);
        root.getChildren().addAll(eggView);
        eggView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggView.relocate(xPosition - 2, yPosition - 2);
                eggView.setFitHeight(32);
                eggView.setFitWidth(25);
            }
        });
        eggView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggView.relocate(xPosition, yPosition);
                eggView.setFitHeight(27);
                eggView.setFitWidth(20);
            }
        });
        PickUpImageViews(xCell, yCell, eggView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(eggView,"Egg");
    }

    private void PickUpProductFromMap(int xCell, int yCell, ImageView eggView) {
        eggView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new PickUpRequest("pickup " + String.valueOf(xCell) + " " + String.valueOf(yCell));
                    root.getChildren().removeAll(eggView);
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                } catch (FullWareHouse fullWareHouse) {
                    fullWareHouse.printStackTrace();
                }
            }
        });
    }

    public void AddMilk(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];


        File milkFile = new File("Data\\Textures\\Products\\Milk.png");
        Image milkImage = new Image(milkFile.toURI().toString());
        ImageView milkView = new ImageView(milkImage);
        milkView.relocate(xPosition, yPosition);
        milkView.setFitHeight(27);
        milkView.setFitWidth(43);
        root.getChildren().addAll(milkView);
        milkView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                milkView.relocate(xPosition - 2, yPosition - 2);
                milkView.setFitHeight(32);
                milkView.setFitWidth(48);
            }
        });
        milkView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                milkView.relocate(xPosition, yPosition);
                milkView.setFitHeight(27);
                milkView.setFitWidth(43);
            }
        });
        milkView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new PickUpRequest("pickup " + String.valueOf(xCell) + " " + String.valueOf(yCell));
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                } catch (FullWareHouse fullWareHouse) {
                    fullWareHouse.printStackTrace();
                }
            }
        });
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(milkView,"Milk");
    }

    public void AddWool(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File woolFile = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image woolImage = new Image(woolFile.toURI().toString());
        ImageView woolView = new ImageView(woolImage);
        woolView.relocate(xPosition, yPosition);
        woolView.setFitHeight(27);
        woolView.setFitWidth(40);
        root.getChildren().addAll(woolView);
        woolView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                woolView.relocate(xPosition - 2, yPosition - 2);
                woolView.setFitHeight(32);
                woolView.setFitWidth(45);
            }
        });
        woolView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                woolView.relocate(xPosition, yPosition);
                woolView.setFitHeight(27);
                woolView.setFitWidth(40);
            }
        });
        woolView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new PickUpRequest("pickup " + String.valueOf(xCell) + " " + String.valueOf(yCell));
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                } catch (FullWareHouse fullWareHouse) {
                    fullWareHouse.printStackTrace();
                }
            }
        });
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(woolView,"Wool");
    }

    public void AddEggPowder(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File eggPodwerFile = new File("Data\\Textures\\Products\\EggPowder.png");
        Image eggPowderImage = new Image(eggPodwerFile.toURI().toString());
        ImageView eggPowderView = new ImageView(eggPowderImage);
        eggPowderView.relocate(xPosition, yPosition);
        eggPowderView.setFitHeight(27);
        eggPowderView.setFitWidth(40);
        root.getChildren().addAll(eggPowderView);
        eggPowderView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderView.relocate(xPosition - 2, yPosition - 2);
                eggPowderView.setFitHeight(32);
                eggPowderView.setFitWidth(45);
            }
        });
        eggPowderView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderView.relocate(xPosition, yPosition);
                eggPowderView.setFitHeight(27);
                eggPowderView.setFitWidth(40);
            }
        });
        PickUpImageViews(xCell, yCell, eggPowderView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(eggPowderView,"Powder");
    }

    private void PickUpImageViews(int xCell, int yCell, ImageView eggPowderView) {
        eggPowderView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new PickUpRequest("pickup " + String.valueOf(xCell) + " " + String.valueOf(yCell));
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                } catch (FullWareHouse fullWareHouse) {
                    fullWareHouse.printStackTrace();
                }
            }
        });
    }

    public void AddCarnivalDress(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File carnivalDressFile = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image carnivalDressImage = new Image(carnivalDressFile.toURI().toString());
        ImageView carnivalDressView = new ImageView(carnivalDressImage);
        carnivalDressView.relocate(xPosition, yPosition);
        carnivalDressView.setFitHeight(27);
        carnivalDressView.setFitWidth(40);
        root.getChildren().addAll(carnivalDressView);
        carnivalDressView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                carnivalDressView.relocate(xPosition - 2, yPosition - 2);
                carnivalDressView.setFitHeight(32);
                carnivalDressView.setFitWidth(45);
            }
        });
        carnivalDressView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                carnivalDressView.relocate(xPosition, yPosition);
                carnivalDressView.setFitHeight(27);
                carnivalDressView.setFitWidth(40);
            }
        });
        PickUpImageViews(xCell, yCell, carnivalDressView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(carnivalDressView,"CarnivalDress");
    }

    public void AddCake(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File cakeFile = new File("Data\\Textures\\Products\\Cake.png");
        Image cakeImage = new Image(cakeFile.toURI().toString());
        ImageView cakeView = new ImageView(cakeImage);
        cakeView.relocate(xPosition, yPosition);
        cakeView.setFitHeight(27);
        cakeView.setFitWidth(40);
        root.getChildren().addAll(cakeView);
        cakeView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeView.relocate(xPosition - 2, yPosition - 2);
                cakeView.setFitHeight(32);
                cakeView.setFitWidth(45);
            }
        });
        cakeView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeView.relocate(xPosition, yPosition);
                cakeView.setFitHeight(27);
                cakeView.setFitWidth(40);
            }
        });
        PickUpImageViews(xCell, yCell, cakeView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(cakeView,"Cake");
    }

    public void AddFabric(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File fabricFile = new File("Data\\Textures\\Products\\Fabric.png");
        Image fabricImage = new Image(fabricFile.toURI().toString());
        ImageView fabricView = new ImageView(fabricImage);
        fabricView.relocate(xPosition, yPosition);
        fabricView.setFitHeight(27);
        fabricView.setFitWidth(40);
        root.getChildren().addAll(fabricView);
        fabricView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fabricView.relocate(xPosition - 2, yPosition - 2);
                fabricView.setFitHeight(32);
                fabricView.setFitWidth(45);
            }
        });
        fabricView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fabricView.relocate(xPosition, yPosition);
                fabricView.setFitHeight(27);
                fabricView.setFitWidth(40);
            }
        });
        PickUpImageViews(xCell, yCell, fabricView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(fabricView,"Fabric");
    }

    public void AddFlouryCake(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File fabricFile = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image fabricImage = new Image(fabricFile.toURI().toString());
        ImageView flouryCake = new ImageView(fabricImage);
        flouryCake.relocate(xPosition, yPosition);
        flouryCake.setFitHeight(27);
        flouryCake.setFitWidth(40);
        root.getChildren().addAll(flouryCake);
        flouryCake.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                flouryCake.relocate(xPosition - 2, yPosition - 2);
                flouryCake.setFitHeight(32);
                flouryCake.setFitWidth(45);
            }
        });
        flouryCake.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                flouryCake.relocate(xPosition, yPosition);
                flouryCake.setFitHeight(27);
                flouryCake.setFitWidth(40);
            }
        });
        PickUpImageViews(xCell, yCell, flouryCake);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(flouryCake,"FlouryCake");
    }

    public void AddFlour(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File flourFile = new File("Data\\Textures\\Products\\Flour.png");
        Image flourImage = new Image(flourFile.toURI().toString());
        ImageView flourView = new ImageView(flourImage);
        flourView.relocate(xPosition, yPosition);
        flourView.setFitHeight(27);
        flourView.setFitWidth(40);
        root.getChildren().addAll(flourView);
        flourView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                flourView.relocate(xPosition - 2, yPosition - 2);
                flourView.setFitHeight(32);
                flourView.setFitWidth(45);
            }
        });
        flourView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                flourView.relocate(xPosition, yPosition);
                flourView.setFitHeight(27);
                flourView.setFitWidth(40);
            }
        });
        PickUpImageViews(xCell, yCell, flourView);
        cells.get(new ArrayList<>(Arrays.asList(xCell, yCell))).put(flourView,"Flour");
    }

    private static int[] getCellPositionByPosition(int x, int y) {
        int[] position = new int[2];
        int standardX = x - 310;
        int standardY = y - 210;
        boolean isXSet = false;
        boolean isYSet = false;
        for (int i = 0; i < 15; i++) {
            if (i * 43.33333 < standardX && standardX < (i + 1) * 43.33333) {
                position[0] = i;
                isXSet = true;
            }
            if (i * 25 < standardY && standardY < (i + 1) * 25) {
                if (i==0 || i==1){
                    System.out.println("fuck");
                }
                position[1] = i;
                isYSet = true;
            }
            if (isXSet && isYSet) {
                return position;
            }
        }
        return position;
    }

    private static int[] getPositionByCellPosition(int xCell, int yCell) {
        int[] position = new int[2];
        position[0] = (int) (310 + (xCell + 0.5) * 43.33333);
        position[1] = (int) (210 + (yCell + 0.5) * 25);
        return position;
    }

    public void ShowChickenMoving(int xcell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File chickenFile = null;
        Image chickenImage = null;
        ImageView chickenView = null;
        Animation chickenAnimation = null;
        final ImageView[] chickenArrayView = new ImageView[1];
        if (xcell1 == xCell2 & yCell1 == yCell2) {
            ShowEatingChicken(xcell1, yCell1);
        } else {
            if (xcell1 == xCell2) {
                if (yCell1 > yCell2) {
                    chickenFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\up.png");
                    chickenImage = new Image(chickenFile.toURI().toString());
                    chickenView = new ImageView(chickenImage);
                    chickenAnimation = new SpriteAnimation(chickenView, Duration.millis(duration), 24, 5, 0, 0, 64, 84);
                    chickenView.setViewport(new Rectangle2D(0, 0, 64, 84));
                } else {
                    chickenFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\down.png");
                    chickenImage = new Image(chickenFile.toURI().toString());
                    chickenView = new ImageView(chickenImage);
                    chickenAnimation = new SpriteAnimation(chickenView, Duration.millis(duration), 24, 5, 0, 0, 66, 72);
                    chickenView.setViewport(new Rectangle2D(0, 0, 66, 72));
                }
            } else if (yCell1 == yCell2) {
                chickenFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\left.png");
                chickenImage = new Image(chickenFile.toURI().toString());
                chickenView = new ImageView(chickenImage);
                chickenAnimation = new SpriteAnimation(chickenView, Duration.millis(duration), 24, 5, 0, 0, 80, 74);
                chickenView.setViewport(new Rectangle2D(0, 0, 80, 74));
                if (xcell1 < xCell2) {
                    chickenView.setScaleX(-1);
                }
            } else if (yCell2 > yCell1) {
                chickenFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\down_left.png");
                chickenImage = new Image(chickenFile.toURI().toString());
                chickenView = new ImageView(chickenImage);
                chickenAnimation = new SpriteAnimation(chickenView, Duration.millis(duration), 24, 5, 0, 0, 70, 72);
                chickenView.setViewport(new Rectangle2D(0, 0, 70, 72));
                if (xcell1 < xCell2) {
                    chickenView.setScaleX(-1);
                }
            } else if (yCell1 > yCell2) {
                chickenFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\up_left.png");
                chickenImage = new Image(chickenFile.toURI().toString());
                chickenView = new ImageView(chickenImage);
                chickenAnimation = new SpriteAnimation(chickenView, Duration.millis(duration), 24, 5, 0, 0, 68, 80);
                chickenView.setViewport(new Rectangle2D(0, 0, 68, 80));
                if (xcell1 < xCell2) {
                    chickenView.setScaleX(-1);
                }
            }
            int[] position1 = getPositionByCellPosition(xcell1, yCell1);
            int[] position2 = getPositionByCellPosition(xCell2, yCell2);
            int x1Position = position1[0] - 30;
            int y1Position = position1[1] - 30;
            int x2Position = position2[0] - 30;
            int y2Position = position2[1] - 30;
            chickenView.relocate(x1Position, y1Position);
            root.getChildren().addAll(chickenView);
            chickenArrayView[0] = chickenView;

            KeyValue xChicken = new KeyValue(chickenView.xProperty(), x2Position - x1Position);
            KeyValue yChicken = new KeyValue(chickenView.yProperty(), y2Position - y1Position);
            KeyFrame xChickenFrame = new KeyFrame(Duration.millis(duration), xChicken, yChicken);
            Timeline chickenTimeLine = new Timeline(xChickenFrame);
            chickenTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    root.getChildren().removeAll(chickenArrayView[0]);
                }
            });
            chickenAnimation.play();
            chickenTimeLine.play();
        }
    }

    public void ShowCowMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File cowFile = null;
        Image cowImage = null;
        ImageView cowView = null;
        Animation cowAnimation = null;
        final ImageView[] cowArrayView = new ImageView[1];

        if (xCell1 == xCell2 & yCell1 == yCell2) {
            ShowEatingCow(xCell1, yCell1);
        } else {
            if (xCell1 == xCell2) {
                if (yCell1 > yCell2) {
                    cowFile = new File("Data\\Textures\\Cow\\up.png");
                    cowImage = new Image(cowFile.toURI().toString());
                    cowView = new ImageView(cowImage);
                    cowAnimation = new SpriteAnimation(cowView, Duration.millis(duration), 24, 4, 0, 0, 114, 132);
                    cowView.setViewport(new Rectangle2D(0, 0, 114, 132));
                } else {
                    cowFile = new File("Data\\Textures\\Cow\\down.png");
                    cowImage = new Image(cowFile.toURI().toString());
                    cowView = new ImageView(cowImage);
                    cowAnimation = new SpriteAnimation(cowView, Duration.millis(duration), 24, 3, 0, 0, 118, 110);
                    cowView.setViewport(new Rectangle2D(0, 0, 118, 110));
                }
            } else if (yCell1 == yCell2) {
                cowFile = new File("Data\\Textures\\Cow\\left.png");
                cowImage = new Image(cowFile.toURI().toString());
                cowView = new ImageView(cowImage);
                cowAnimation = new SpriteAnimation(cowView, Duration.millis(duration), 24, 3, 0, 0, 160, 110);
                cowView.setViewport(new Rectangle2D(0, 0, 160, 110));
                if (xCell1 < xCell2) {
                    cowView.setScaleX(-1);
                }
            } else if (yCell2 > yCell1) {
                cowFile = new File("Data\\Textures\\Cow\\down_left.png");
                cowImage = new Image(cowFile.toURI().toString());
                cowView = new ImageView(cowImage);
                cowAnimation = new SpriteAnimation(cowView, Duration.millis(duration), 24, 3, 0, 0, 140, 100);
                cowView.setViewport(new Rectangle2D(0, 0, 140, 100));
                if (xCell1 < xCell2) {
                    cowView.setScaleX(-1);
                }
            } else if (yCell1 > yCell2) {
                cowFile = new File("Data\\Textures\\Cow\\up_left.png");
                cowImage = new Image(cowFile.toURI().toString());
                cowView = new ImageView(cowImage);
                cowAnimation = new SpriteAnimation(cowView, Duration.millis(duration), 24, 3, 0, 0, 138, 128);
                cowView.setViewport(new Rectangle2D(0, 0, 138, 128));
                if (xCell1 < xCell2) {
                    cowView.setScaleX(-1);
                }
            }
            int[] position1 = getPositionByCellPosition(xCell1, yCell1);
            int[] position2 = getPositionByCellPosition(xCell2, yCell2);
            int x1Position = position1[0] - 50;
            int y1Position = position1[1] - 50;
            int x2Position = position2[0] - 50;
            int y2Position = position2[1] - 50;
            cowView.relocate(x1Position, y1Position);
            root.getChildren().addAll(cowView);
            cowArrayView[0] = cowView;

            KeyValue xSheep = new KeyValue(cowView.xProperty(), x2Position - x1Position);
            KeyValue ySheep = new KeyValue(cowView.yProperty(), y2Position - y1Position);
            KeyFrame xSheepFrame = new KeyFrame(Duration.millis(duration), xSheep, ySheep);
            Timeline sheepTimeLine = new Timeline(xSheepFrame);
            sheepTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    root.getChildren().removeAll(cowArrayView[0]);
                }
            });
            cowAnimation.play();
            sheepTimeLine.play();
        }
    }

    public void ShowSheepMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File sheepFile = null;
        Image sheepImage = null;
        ImageView sheepView = null;
        Animation sheepAnimation = null;
        final ImageView[] sheepArrayView = new ImageView[1];

        if (xCell1 == xCell2 & yCell1 == yCell2) {
            ShowEatingSheep(xCell1, yCell1);
        } else {
            if (xCell1 == xCell2) {
                if (yCell1 > yCell2) {
                    sheepFile = new File("Data\\Textures\\Sheep\\up.png");
                    sheepImage = new Image(sheepFile.toURI().toString());
                    sheepView = new ImageView(sheepImage);
                    sheepAnimation = new SpriteAnimation(sheepView, Duration.millis(duration), 24, 5, 0, 0, 82, 96);
                    sheepView.setViewport(new Rectangle2D(0, 0, 82, 96));
                } else {
                    sheepFile = new File("Data\\Textures\\Sheep\\down.png");
                    sheepImage = new Image(sheepFile.toURI().toString());
                    sheepView = new ImageView(sheepImage);
                    sheepAnimation = new SpriteAnimation(sheepView, Duration.millis(duration), 24, 5, 0, 0, 84, 102);
                    sheepView.setViewport(new Rectangle2D(0, 0, 84, 102));
                }
            } else if (yCell1 == yCell2) {
                sheepFile = new File("Data\\Textures\\Sheep\\left.png");
                sheepImage = new Image(sheepFile.toURI().toString());
                sheepView = new ImageView(sheepImage);
                sheepAnimation = new SpriteAnimation(sheepView, Duration.millis(duration), 24, 4, 0, 0, 130, 78);
                sheepView.setViewport(new Rectangle2D(0, 0, 130, 78));
                if (xCell1 < xCell2) {
                    sheepView.setScaleX(-1);
                }
            } else if (yCell2 > yCell1) {
                sheepFile = new File("Data\\Textures\\Sheep\\down_left.png");
                sheepImage = new Image(sheepFile.toURI().toString());
                sheepView = new ImageView(sheepImage);
                sheepAnimation = new SpriteAnimation(sheepView, Duration.millis(duration), 24, 4, 0, 0, 104, 90);
                sheepView.setViewport(new Rectangle2D(0, 0, 104, 90));
                if (xCell1 < xCell2) {
                    sheepView.setScaleX(-1);
                }
            } else if (yCell1 > yCell2) {
                sheepFile = new File("Data\\Textures\\Sheep\\up_left.png");
                sheepImage = new Image(sheepFile.toURI().toString());
                sheepView = new ImageView(sheepImage);
                sheepAnimation = new SpriteAnimation(sheepView, Duration.millis(duration), 24, 5, 0, 0, 102, 88);
                sheepView.setViewport(new Rectangle2D(0, 0, 102, 88));
                if (xCell1 < xCell2) {
                    sheepView.setScaleX(-1);
                }
            }
            int[] position1 = getPositionByCellPosition(xCell1, yCell1);
            int[] position2 = getPositionByCellPosition(xCell2, yCell2);
            int x1Position = position1[0] - 50;
            int y1Position = position1[1] - 50;
            int x2Position = position2[0] - 50;
            int y2Position = position2[1] - 50;
            sheepView.relocate(x1Position, y1Position);
            root.getChildren().addAll(sheepView);
            sheepArrayView[0] = sheepView;

            KeyValue xSheep = new KeyValue(sheepView.xProperty(), x2Position - x1Position);
            KeyValue ySheep = new KeyValue(sheepView.yProperty(), y2Position - y1Position);
            KeyFrame xSheepFrame = new KeyFrame(Duration.millis(duration), xSheep, ySheep);
            Timeline sheepTimeLine = new Timeline(xSheepFrame);
            sheepTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    root.getChildren().removeAll(sheepArrayView[0]);
                }
            });
            sheepAnimation.play();
            sheepTimeLine.play();
        }
    }

    public void ShowDogMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File dogFile = null;
        Image dogImage = null;
        ImageView dogView = null;
        Animation dogAnimation = null;
        final ImageView[] dogArrayView = new ImageView[1];

        if (xCell1 == xCell2) {
            if (yCell1 > yCell2) {
                dogFile = new File("Data\\Textures\\Animals\\Africa\\Dog\\up.png");
                dogImage = new Image(dogFile.toURI().toString());
                dogView = new ImageView(dogImage);
                dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 66, 100);
                dogView.setViewport(new Rectangle2D(0, 0, 66, 100));
            } else {
                dogFile = new File("Data\\Textures\\Animals\\Africa\\Dog\\down.png");
                dogImage = new Image(dogFile.toURI().toString());
                dogView = new ImageView(dogImage);
                dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 66, 84);
                dogView.setViewport(new Rectangle2D(0, 0, 66, 84));
            }
        } else if (yCell1 == yCell2) {
            dogFile = new File("Data\\Textures\\Animals\\Africa\\Dog\\left.png");
            dogImage = new Image(dogFile.toURI().toString());
            dogView = new ImageView(dogImage);
            dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 108, 86);
            dogView.setViewport(new Rectangle2D(0, 0, 108, 86));
            if (xCell1 < xCell2) {
                dogView.setScaleX(-1);
            }
        } else if (yCell2 > yCell1) {
            dogFile = new File("Data\\Textures\\Animals\\Africa\\Dog\\down_left.png");
            dogImage = new Image(dogFile.toURI().toString());
            dogView = new ImageView(dogImage);
            dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 5, 0, 0, 92, 84);
            dogView.setViewport(new Rectangle2D(0, 0, 92, 84));
            if (xCell1 < xCell2) {
                dogView.setScaleX(-1);
            }
        } else if (yCell1 > yCell2) {
            dogFile = new File("Data\\Textures\\Animals\\Africa\\Dog\\up_left.png");
            dogImage = new Image(dogFile.toURI().toString());
            dogView = new ImageView(dogImage);
            dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 5, 0, 0, 92, 98);
            dogView.setViewport(new Rectangle2D(0, 0, 92, 98));
            if (xCell1 < xCell2) {
                dogView.setScaleX(-1);
            }
        }
        int[] position1 = getPositionByCellPosition(xCell1, yCell1);
        int[] position2 = getPositionByCellPosition(xCell2, yCell2);
        int x1Position = position1[0] - 40;
        int y1Position = position1[1] - 40;
        int x2Position = position2[0] - 40;
        int y2Position = position2[1] - 40;
        dogView.relocate(x1Position, y1Position);
        root.getChildren().addAll(dogView);
        dogArrayView[0] = dogView;

        KeyValue xDog = new KeyValue(dogView.xProperty(), x2Position - x1Position);
        KeyValue yDog = new KeyValue(dogView.yProperty(), y2Position - y1Position);
        KeyFrame xDogFrame = new KeyFrame(Duration.millis(duration), xDog, yDog);
        Timeline dogTimeLine = new Timeline(xDogFrame);
        dogTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(dogArrayView[0]);
            }
        });
        dogAnimation.play();
        dogTimeLine.play();
    }

    public void ShowCatMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File dogFile = null;
        Image dogImage = null;
        ImageView dogView = null;
        Animation dogAnimation = null;
        final ImageView[] dogArrayView = new ImageView[1];

        if (xCell1 == xCell2) {
            if (yCell1 > yCell2) {
                dogFile = new File("Data\\Textures\\Animals\\Africa\\Cat\\up.png");
                dogImage = new Image(dogFile.toURI().toString());
                dogView = new ImageView(dogImage);
                dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 48, 84);
                dogView.setViewport(new Rectangle2D(0, 0, 48, 84));
            } else {
                dogFile = new File("Data\\Textures\\Animals\\Africa\\Cat\\down.png");
                dogImage = new Image(dogFile.toURI().toString());
                dogView = new ImageView(dogImage);
                dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 50, 92);
                dogView.setViewport(new Rectangle2D(0, 0, 50, 92));
            }
        } else if (yCell1 == yCell2) {
            dogFile = new File("Data\\Textures\\Animals\\Africa\\Cat\\left.png");
            dogImage = new Image(dogFile.toURI().toString());
            dogView = new ImageView(dogImage);
            dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 4, 0, 0, 88, 68);
            dogView.setViewport(new Rectangle2D(0, 0, 88, 68));
            if (xCell1 < xCell2) {
                dogView.setScaleX(-1);
            }
        } else if (yCell2 > yCell1) {
            dogFile = new File("Data\\Textures\\Animals\\Africa\\Cat\\down_left.png");
            dogImage = new Image(dogFile.toURI().toString());
            dogView = new ImageView(dogImage);
            dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 72, 84);
            dogView.setViewport(new Rectangle2D(0, 0, 72, 84));
            if (xCell1 < xCell2) {
                dogView.setScaleX(-1);
            }
        } else if (yCell1 > yCell2) {
            dogFile = new File("Data\\Textures\\Animals\\Africa\\Cat\\up_left.png");
            dogImage = new Image(dogFile.toURI().toString());
            dogView = new ImageView(dogImage);
            dogAnimation = new SpriteAnimation(dogView, Duration.millis(duration), 24, 6, 0, 0, 72, 80);
            dogView.setViewport(new Rectangle2D(0, 0, 72, 80));
            if (xCell1 < xCell2) {
                dogView.setScaleX(-1);
            }
        }
        int[] position1 = getPositionByCellPosition(xCell1, yCell1);
        int[] position2 = getPositionByCellPosition(xCell2, yCell2);
        int x1Position = position1[0] - 35;
        int y1Position = position1[1] - 35;
        int x2Position = position2[0] - 35;
        int y2Position = position2[1] - 35;
        dogView.relocate(x1Position, y1Position);
        root.getChildren().addAll(dogView);
        dogArrayView[0] = dogView;

        KeyValue xDog = new KeyValue(dogView.xProperty(), x2Position - x1Position);
        KeyValue yDog = new KeyValue(dogView.yProperty(), y2Position - y1Position);
        KeyFrame xDogFrame = new KeyFrame(Duration.millis(duration), xDog, yDog);
        Timeline dogTimeLine = new Timeline(xDogFrame);
        dogTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(dogArrayView[0]);
            }
        });
        dogAnimation.play();
        dogTimeLine.play();
    }

    public void ShowLionMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File lionFile = null;
        Image lionImage = null;
        ImageView[] lionView = new ImageView[1];
        Animation lionAnimation = null;
//        final ImageView[] dogArrayView = new ImageView[1];

        if (xCell1 == xCell2) {
            if (yCell1 > yCell2) {
                lionFile = new File("Data\\Textures\\Animals\\Africa\\Lion\\up.png");
                lionImage = new Image(lionFile.toURI().toString());
                lionView[0] = new ImageView(lionImage);
                lionAnimation = new SpriteAnimation(lionView[0], Duration.millis(duration), 24, 6, 0, 0, 94, 116);
                lionView[0].setViewport(new Rectangle2D(0, 0, 94, 116));
            } else {
                lionFile = new File("Data\\Textures\\Animals\\Africa\\Lion\\down.png");
                lionImage = new Image(lionFile.toURI().toString());
                lionView[0] = new ImageView(lionImage);
                lionAnimation = new SpriteAnimation(lionView[0], Duration.millis(duration), 24, 5, 0, 0, 96, 92);
                lionView[0].setViewport(new Rectangle2D(0, 0, 96, 92));
            }
        } else if (yCell1 == yCell2) {
            lionFile = new File("Data\\Textures\\Animals\\Africa\\Lion\\left.png");
            lionImage = new Image(lionFile.toURI().toString());
            lionView[0] = new ImageView(lionImage);
            lionAnimation = new SpriteAnimation(lionView[0], Duration.millis(duration), 24, 3, 0, 0, 138, 92);
            lionView[0].setViewport(new Rectangle2D(0, 0, 138, 92));
            if (xCell1 < xCell2) {
                lionView[0].setScaleX(-1);
            }
        } else if (yCell2 > yCell1) {
            lionFile = new File("Data\\Textures\\Animals\\Africa\\Lion\\down_left.png");
            lionImage = new Image(lionFile.toURI().toString());
            lionView[0] = new ImageView(lionImage);
            lionAnimation = new SpriteAnimation(lionView[0], Duration.millis(duration), 24, 4, 0, 0, 118, 90);
            lionView[0].setViewport(new Rectangle2D(0, 0, 118, 90));
            if (xCell1 < xCell2) {
                lionView[0].setScaleX(-1);
            }
        } else if (yCell1 > yCell2) {
            lionFile = new File("Data\\Textures\\Animals\\Africa\\Lion\\up_left.png");
            lionImage = new Image(lionFile.toURI().toString());
            lionView[0] = new ImageView(lionImage);
            lionAnimation = new SpriteAnimation(lionView[0], Duration.millis(duration), 24, 6, 0, 0, 120, 106);
            lionView[0].setViewport(new Rectangle2D(0, 0, 120, 106));
            if (xCell1 < xCell2) {
                lionView[0].setScaleX(-1);
            }
        }
        int[] position1 = getPositionByCellPosition(xCell1, yCell1);
        int[] position2 = getPositionByCellPosition(xCell2, yCell2);
        int x1Position = position1[0] - 50;
        int y1Position = position1[1] - 50;
        int x2Position = position2[0] - 50;
        int y2Position = position2[1] - 50;
        lionView[0].relocate(x1Position, y1Position);
        root.getChildren().addAll(lionView);
//        dogArrayView[0] = lionView[0];

        lionView[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    ShowCageWhenIsUsingForWildAnimal("Lion", xCell2, yCell2);
                    new CageRequest("cage " + String.valueOf(xCell2) + " " + String.valueOf(yCell2));
                    root.getChildren().removeAll(lionView[0]);
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });

        KeyValue xLion = new KeyValue(lionView[0].xProperty(), x2Position - x1Position);
        KeyValue yLion = new KeyValue(lionView[0].yProperty(), y2Position - y1Position);
        KeyFrame xLionFrame = new KeyFrame(Duration.millis(duration), xLion, yLion);
        Timeline lionTimeLine = new Timeline(xLionFrame);
        lionTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(lionView[0]);
            }
        });
        lionAnimation.play();
        lionTimeLine.play();
    }

    public void ShowBearMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File bearFile = null;
        Image bearImage = null;
        ImageView bearView = null;
        Animation bearAnimation = null;
        final ImageView[] dogArrayView = new ImageView[1];

        if (xCell1 == xCell2) {
            if (yCell1 > yCell2) {
                bearFile = new File("Data\\Textures\\Grizzly\\up.png");
                bearImage = new Image(bearFile.toURI().toString());
                bearView = new ImageView(bearImage);
                bearAnimation = new SpriteAnimation(bearView, Duration.millis(duration), 24, 4, 0, 0, 120, 116);
                bearView.setViewport(new Rectangle2D(0, 0, 120, 116));
            } else {
                bearFile = new File("Data\\Textures\\Grizzly\\down.png");
                bearImage = new Image(bearFile.toURI().toString());
                bearView = new ImageView(bearImage);
                bearAnimation = new SpriteAnimation(bearView, Duration.millis(duration), 24, 4, 0, 0, 120, 108);
                bearView.setViewport(new Rectangle2D(0, 0, 120, 108));
            }
        } else if (yCell1 == yCell2) {
            bearFile = new File("Data\\Textures\\Grizzly\\left.png");
            bearImage = new Image(bearFile.toURI().toString());
            bearView = new ImageView(bearImage);
            bearAnimation = new SpriteAnimation(bearView, Duration.millis(duration), 24, 4, 0, 0, 110, 116);
            bearView.setViewport(new Rectangle2D(0, 0, 110, 116));
            if (xCell1 < xCell2) {
                bearView.setScaleX(-1);
            }
        } else if (yCell2 > yCell1) {
            bearFile = new File("Data\\Textures\\Grizzly\\down_left.png");
            bearImage = new Image(bearFile.toURI().toString());
            bearView = new ImageView(bearImage);
            bearAnimation = new SpriteAnimation(bearView, Duration.millis(duration), 24, 4, 0, 0, 112, 106);
            bearView.setViewport(new Rectangle2D(0, 0, 112, 106));
            if (xCell1 < xCell2) {
                bearView.setScaleX(-1);
            }
        } else if (yCell1 > yCell2) {
            bearFile = new File("Data\\Textures\\Grizzly\\up_left.png");
            bearImage = new Image(bearFile.toURI().toString());
            bearView = new ImageView(bearImage);
            bearAnimation = new SpriteAnimation(bearView, Duration.millis(duration), 24, 4, 0, 0, 112, 120);
            bearView.setViewport(new Rectangle2D(0, 0, 112, 120));
            if (xCell1 < xCell2) {
                bearView.setScaleX(-1);
            }
        }
        int[] position1 = getPositionByCellPosition(xCell1, yCell1);
        int[] position2 = getPositionByCellPosition(xCell2, yCell2);
        int x1Position = position1[0] - 55;
        int y1Position = position1[1] - 55;
        int x2Position = position2[0] - 55;
        int y2Position = position2[1] - 55;
        bearView.relocate(x1Position, y1Position);
        root.getChildren().addAll(bearView);
        dogArrayView[0] = bearView;

        KeyValue xBear = new KeyValue(bearView.xProperty(), x2Position - x1Position);
        KeyValue yBear = new KeyValue(bearView.yProperty(), y2Position - y1Position);
        KeyFrame positionBearFrame = new KeyFrame(Duration.millis(duration), xBear, yBear);
        Timeline bearTimeLine = new Timeline(positionBearFrame);
        bearTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(dogArrayView[0]);
            }
        });
        bearAnimation.play();
        bearTimeLine.play();
    }

    public void ShowFightBetweenDogAndWildAnimal(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File fightFile = new File("Data\\Textures\\Animals\\battle_1.png");
        Image fightImage = new Image(fightFile.toURI().toString());
        ImageView fightView = new ImageView(fightImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 125;
        int yPosition = position1[1] - 125;
        fightView.relocate(xPosition - 50, yPosition - 50);
        root.getChildren().addAll(fightView);
        Animation fightAnimation = new SpriteAnimation(fightView, Duration.millis(duration + 500), 20, 5, 0, 0, 250, 250);
        fightView.setViewport(new Rectangle2D(0, 0, 250, 250));
        fightAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(fightView);
            }
        });
        fightAnimation.setCycleCount(3);
        fightAnimation.play();
    }

    private void ShowDingChicken(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File fightFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\death.png");
        Image fightImage = new Image(fightFile.toURI().toString());
        ImageView fightView = new ImageView(fightImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 35;
        int yPosition = position1[1] - 35;
        fightView.relocate(xPosition, yPosition);
        root.getChildren().addAll(fightView);
        Animation fightAnimation = new SpriteAnimation(fightView, Duration.millis(duration + 500), 24, 5, 0, 0, 78, 70);
        fightView.setViewport(new Rectangle2D(0, 0, 78, 70));
        fightAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(fightView);
            }
        });
        fightAnimation.play();
    }

    private void ShowDingSheep(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File fightFile = new File("Data\\Textures\\Sheep\\death.png");
        Image fightImage = new Image(fightFile.toURI().toString());
        ImageView fightView = new ImageView(fightImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 50;
        int yPosition = position1[1] - 50;
        fightView.relocate(xPosition, yPosition);
        root.getChildren().addAll(fightView);
        Animation fightAnimation = new SpriteAnimation(fightView, Duration.millis(duration + 500), 24, 4, 0, 0, 122, 88);
        fightView.setViewport(new Rectangle2D(0, 0, 122, 88));
        fightAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(fightView);
            }
        });
        fightAnimation.play();
    }

    private void ShowDingCow(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File fightFile = new File("Data\\Textures\\Cow\\death.png");
        Image fightImage = new Image(fightFile.toURI().toString());
        ImageView fightView = new ImageView(fightImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 60;
        int yPosition = position1[1] - 60;
        fightView.relocate(xPosition, yPosition);
        root.getChildren().addAll(fightView);
        Animation fightAnimation = new SpriteAnimation(fightView, Duration.millis(duration + 500), 24, 3, 0, 0, 156, 112);
        fightView.setViewport(new Rectangle2D(0, 0, 156, 112));
        fightAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(fightView);
            }
        });
        fightAnimation.play();
    }

    private void ShowEatingChicken(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File eatFile = new File("Data\\Textures\\Animals\\Africa\\GuineaFowl\\eat.png");
        Image eatImage = new Image(eatFile.toURI().toString());
        ImageView eatView = new ImageView(eatImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 35;
        int yPosition = position1[1] - 35;
        eatView.relocate(xPosition, yPosition);
        root.getChildren().addAll(eatView);
        Animation eatAnimation = new SpriteAnimation(eatView, Duration.millis(duration), 24, 5, 0, 0, 74, 64);
        eatView.setViewport(new Rectangle2D(0, 0, 74, 64));
        eatAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(eatView);
            }
        });
        eatAnimation.play();
    }

    private void ShowEatingCow(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File eatFile = new File("Data\\Textures\\Cow\\eat.png");
        Image eatImage = new Image(eatFile.toURI().toString());
        ImageView eatView = new ImageView(eatImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 65;
        int yPosition = position1[1] - 65;
        eatView.relocate(xPosition, yPosition);
        root.getChildren().addAll(eatView);
        Animation eatAnimation = new SpriteAnimation(eatView, Duration.millis(duration), 24, 4, 0, 0, 134, 144);
        eatView.setViewport(new Rectangle2D(0, 0, 134, 144));
        eatAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(eatView);
            }
        });
        eatAnimation.play();
    }

    private void ShowEatingSheep(int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File eatFile = new File("Data\\Textures\\Sheep\\eat.png");
        Image eatImage = new Image(eatFile.toURI().toString());
        ImageView eatView = new ImageView(eatImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 55;
        int yPosition = position1[1] - 55;
        eatView.relocate(xPosition, yPosition);
        root.getChildren().addAll(eatView);
        Animation eatAnimation = new SpriteAnimation(eatView, Duration.millis(duration), 24, 4, 0, 0, 110, 78);
        eatView.setViewport(new Rectangle2D(0, 0, 110, 78));
        eatAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(eatView);
            }
        });

        eatAnimation.play();
    }

    private void ShowCageWhenIsUsingForWildAnimal(String bearOrLionCage, int xCell, int yCell) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 15881818)) / 1000000);
        File cageFile = new File("Data\\Textures\\Cages\\build01.png");
        Image cageImage = new Image(cageFile.toURI().toString());
        ImageView cageView = new ImageView(cageImage);
        int[] position1 = getPositionByCellPosition(xCell, yCell);
        int xPosition = position1[0] - 130;
        int yPosition = position1[1] - 130;
        cageView.relocate(xPosition, yPosition);
        Animation cageAnimation = new SpriteAnimation(cageView, Duration.millis(duration), 8, 3, 0, 0, 260, 260);
        cageView.setViewport(new Rectangle2D(0, 0, 260, 260));
        cageAnimation.play();

        File wildAnimalFile;
        Image wildImage;
        final ImageView[] wildView = new ImageView[1];
        Animation wildCagedAnimation = null;
        if (bearOrLionCage.equals("Lion")) {
            wildAnimalFile = new File("Data\\Textures\\Animals\\Africa\\Lion\\caged.png");
            wildImage = new Image(wildAnimalFile.toURI().toString());
            wildView[0] = new ImageView(wildImage);
//            cageView.setViewport(new Rectangle2D(0, 0, 132, 142));
            wildCagedAnimation = new SpriteAnimation(wildView[0], Duration.millis(duration), 24, 6, 0, 0, 132, 142);
            wildView[0].setViewport(new Rectangle2D(0, 0, 132, 142));
            wildCagedAnimation.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    wildView[0].setViewport(new Rectangle2D(0, 0, 132, 142));
                }
            });
        } else if (bearOrLionCage.equals("Bear")) {
            wildAnimalFile = new File("Data\\Textures\\Grizzly\\caged.png");
            wildImage = new Image(wildAnimalFile.toURI().toString());
            wildView[0] = new ImageView(wildImage);
            wildCagedAnimation = new SpriteAnimation(wildView[0], Duration.millis(duration), 24, 6, 0, 0, 142, 126);
            wildCagedAnimation.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    wildView[0].setViewport(new Rectangle2D(0, 0, 142, 126));
                }
            });
            wildView[0].setViewport(new Rectangle2D(0, 0, 142, 126));
        }
        wildCagedAnimation.setCycleCount(Timeline.INDEFINITE);
        wildView[0].relocate(xPosition + 50, yPosition + 50);
        wildCagedAnimation.play();
        root.getChildren().addAll(wildView[0]);
        root.getChildren().addAll(cageView);
        wildView[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new PickUpRequest("pickup " + String.valueOf(xCell) + " " + String.valueOf(yCell));
                    root.getChildren().removeAll(wildView[0], cageView);
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                } catch (FullWareHouse fullWareHouse) {
                    fullWareHouse.printStackTrace();
                }
            }
        });
    }

    public void ShowDingAnimal(Animals animals, int xCell, int yCell) {
        if (animals instanceof Chicken) {
            ShowDingChicken(xCell, yCell);
        } else if (animals instanceof Cow) {
            ShowDingCow(xCell, yCell);
        } else if (animals instanceof Sheep) {
            ShowDingSheep(xCell, yCell);
        }

    }

    private void AddSpeedCircleToSettingInFarm(Stage primaryStage) {
        speedCircle = new Circle(466, 697, 60, Color.rgb(144, 125, 147));
        speedCircle.setOpacity(0.4);
        speedCircle.setViewOrder(-0.98);
        speedCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                speedCircle.setOpacity(0.8);
            }
        });
        speedCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                speedCircle.setOpacity(0.4);
            }
        });
        speedTextInFarmView.setStyle("-fx-font-weight: bold");
        speedTextInFarmView.setFont(Font.font(20));
        speedTextInFarmView.relocate(600, 590);
        speedTextInFarmView.setFill(Color.rgb(50, 100, 120));

        speedCircle.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                int speed = Integer.valueOf(speedTextInFarmView.getText().substring(speedTextInFarmView.getText().length() - 2));
                if (speed >= 11 && speed <= 98) {
                    if (((int) (speed + event.getDeltaY() / 32)) > 9 && ((int) (speed + event.getDeltaY() / 32)) < 100) {
                        speedTextInFarmView.setText("Speed\n   " + String.valueOf((int) (speed + event.getDeltaY() / 32)));
                        GameView.getGameView().getStartMenuView().setGameSpeed((int) (speed + event.getDeltaY() / 32));
                        Text startMenuText = GameView.getGameView().getStartMenuView().getText();
                        startMenuText.setText("Speed\n   " + String.valueOf((int) (speed + event.getDeltaY() / 32)));
                    }
                } else if (speed == 10 && event.getDeltaY() > 0) {
                    speedTextInFarmView.setText("Speed\n   " + String.valueOf(speed + 1));
                    GameView.getGameView().getStartMenuView().setGameSpeed(speed + 1);
                    Text startMenuText = GameView.getGameView().getStartMenuView().getText();
                    startMenuText.setText("Speed\n   " + String.valueOf(speed + 1));
                } else if (speed == 99 && event.getDeltaY() < 0) {
                    speedTextInFarmView.setText("Speed\n   " + String.valueOf(speed - 1));
                    GameView.getGameView().getStartMenuView().setGameSpeed(speed - 1);
                    Text startMenuText = GameView.getGameView().getStartMenuView().getText();
                    startMenuText.setText("Speed\n   " + String.valueOf(speed - 1));
                }
            }
        });
    }

    private void AddStarAndMoneyText(int money) {
        File star = new File("Data\\Gif\\Coin.gif");
        Image starImage = new Image(star.toURI().toString());
        ImageView starView = new ImageView(starImage);
        starView.setFitHeight(75);
        starView.setFitWidth(75);
        starView.relocate((int) (20), (int) (17));
        moneyText = new Text(String.valueOf(money));
        moneyText.relocate(100,50);
        moneyText.setFont(Font.font(25));
        moneyText.setStyle("-fx-font-weight: bold");
        root.getChildren().addAll(moneyText,starView);
    }

    private void ShowMenuClosing(ArrayList<Circle> circles) {
        KeyValue emptyValue = new KeyValue(circles.get(0).radiusProperty(), 0);
        KeyFrame emptyFrame = new KeyFrame(Duration.millis(1000), emptyValue);
        Timeline emptyTimeLine = new Timeline(emptyFrame);
        emptyTimeLine.getKeyFrames().addAll(emptyFrame);
        emptyTimeLine.play();

        KeyValue saveCircleKey = new KeyValue(circles.get(1).radiusProperty(), 0);
        KeyFrame saveCircleFrame = new KeyFrame(Duration.millis(1000), saveCircleKey);
        Timeline saveCircleTimeLine = new Timeline(saveCircleFrame);
        saveCircleTimeLine.getKeyFrames().addAll(saveCircleFrame);
        saveCircleTimeLine.play();

        KeyValue settingCircleValue = new KeyValue(circles.get(2).radiusProperty(), 0);
        KeyFrame settingFrame = new KeyFrame(Duration.millis(1000), settingCircleValue);
        Timeline settingTimeLine = new Timeline(settingFrame);
        settingTimeLine.getKeyFrames().addAll(settingFrame);
        settingTimeLine.play();

        KeyValue continueCircleKey = new KeyValue(circles.get(3).radiusProperty(), 0);
        KeyFrame continueCircleFrame = new KeyFrame(Duration.seconds(1), continueCircleKey);
        Timeline continueCircleTimeLine = new Timeline(continueCircleFrame);
        continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
        continueCircleTimeLine.play();

        KeyValue mainMenuKey = new KeyValue(circles.get(4).radiusProperty(), 0);
        KeyFrame mainMenuFrame = new KeyFrame(Duration.seconds(1), mainMenuKey);
        Timeline mainMenuTimeLine = new Timeline(mainMenuFrame);
        mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
        mainMenuTimeLine.play();

        KeyValue restartCircleKey = new KeyValue(circles.get(5).radiusProperty(), 0);
        KeyFrame restartCircleFrame = new KeyFrame(Duration.seconds(1), restartCircleKey);
        Timeline restartCircleTimeLine = new Timeline(restartCircleFrame);
        restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
        restartCircleTimeLine.play();

        KeyValue mapCircleKey = new KeyValue(circles.get(6).radiusProperty(), 0);
        KeyFrame mapCircleFrame = new KeyFrame(Duration.seconds(1), mapCircleKey);
        Timeline mapCircleTimeLine = new Timeline(mapCircleFrame);
        mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
        mapCircleTimeLine.play();

        KeyValue x = new KeyValue(circles.get(7).radiusProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), x);
        Timeline timeline = new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
    }

    private void ShowMenuOpening(ArrayList<Circle> circles) {
        KeyValue emptyValue = new KeyValue(circles.get(0).radiusProperty(), 90);
        KeyFrame emptyFrame = new KeyFrame(Duration.millis(1000), emptyValue);
        Timeline emptyTimeLine = new Timeline(emptyFrame);
        emptyTimeLine.getKeyFrames().addAll(emptyFrame);
        emptyTimeLine.play();

        KeyValue saveCircleKey = new KeyValue(circles.get(1).radiusProperty(), 60);
        KeyFrame saveCircleFrame = new KeyFrame(Duration.millis(1000), saveCircleKey);
        Timeline saveCircleTimeLine = new Timeline(saveCircleFrame);
        saveCircleTimeLine.getKeyFrames().addAll(saveCircleFrame);
        saveCircleTimeLine.play();

        KeyValue settingCircleValue = new KeyValue(circles.get(2).radiusProperty(), 60);
        KeyFrame settingFrame = new KeyFrame(Duration.millis(1000), settingCircleValue);
        Timeline settingTimeLine = new Timeline(settingFrame);
        settingTimeLine.getKeyFrames().addAll(settingFrame);
        settingTimeLine.play();

        KeyValue continueCircleKey = new KeyValue(circles.get(3).radiusProperty(), 60);
        KeyFrame continueCircleFrame = new KeyFrame(Duration.millis(1000), continueCircleKey);
        Timeline continueCircleTimeLine = new Timeline(continueCircleFrame);
        continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
        continueCircleTimeLine.play();

        KeyValue mainMenuKey = new KeyValue(circles.get(4).radiusProperty(), 60);
        KeyFrame mainMenuFrame = new KeyFrame(Duration.millis(1000), mainMenuKey);
        Timeline mainMenuTimeLine = new Timeline(mainMenuFrame);
        mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
        mainMenuTimeLine.play();

        KeyValue restartCircleKey = new KeyValue(circles.get(5).radiusProperty(), 60);
        KeyFrame restartCircleFrame = new KeyFrame(Duration.millis(1000), restartCircleKey);
        Timeline restartCircleTimeLine = new Timeline(restartCircleFrame);
        restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
        restartCircleTimeLine.play();

        KeyValue mapCircleKey = new KeyValue(circles.get(6).radiusProperty(), 60);
        KeyFrame mapCircleFrame = new KeyFrame(Duration.millis(1000), mapCircleKey);
        Timeline mapCircleTimeLine = new Timeline(mapCircleFrame);
        mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
        mapCircleTimeLine.play();

        KeyValue x = new KeyValue(circles.get(7).radiusProperty(), 2000);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), x);
        Timeline timeline = new Timeline(keyFrame);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
    }

    public void UpdateMoneyText() throws MissionNotLoaded {
        int currnetMissionMoney = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionMoney();
        moneyText.setText(String.valueOf(currnetMissionMoney));

    }

    private void AddGrassByOneClick(int xCell, int yCell) throws MissionNotLoaded {
        PlayBubbleSound();
        int startX = Collections.max(new ArrayList<>(Arrays.asList(xCell - 1, 0)));
        int startY = Collections.max(new ArrayList<>(Arrays.asList(yCell - 1, 0)));
        int endX = Collections.min(new ArrayList<>(Arrays.asList(xCell + 1, 14)));
        int endY = Collections.min(new ArrayList<>(Arrays.asList(yCell + 1, 14)));

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                PlantGrass(i, j);
            }
        }
        CheckWellBucketWater();
    }

    public void AddNumberOfIconsInWarehouse(String iconName) throws MissionNotLoaded {
        File file = null;
        int numberOfIconWeNeedToAdd = 0;
        User user = Game.getGameInstance().getCurrentUserAccount();
        WareHouse wareHouse = user.getCurrentPlayingMission().getFarm().getWareHouse();
        InformationNeededInGame informationNeededInGame = user.getInformationNeededInGame();
        int occupiedSpace = wareHouse.getCapacityOfWareHouse() - wareHouse.getRemainCapacityOfWareHouse();
        if (iconName.equals("CageBear")) {
            file = new File("Data\\Textures\\Products\\CagedBrownBear.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Cage(new Bear()));
        } else if (iconName.equals("CageLion")) {
            file = new File("Data\\Textures\\Products\\CagedLion.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Cage(new Lion()));
        } else if (iconName.equals("Egg")) {
            file = new File("Data\\Textures\\Products\\Egg\\normal_1.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Egg());
        } else if (iconName.equals("Milk")) {
            file = new File("Data\\Textures\\Products\\Milk.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Milk());
        } else if (iconName.equals("Wool")) {
            file = new File("Data\\Textures\\Products\\Wool\\normal.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Wool());
        } else if (iconName.equals("FlouryCake")) {
            file = new File("Data\\Textures\\Products\\FlouryCake.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new FlouryCake());
        } else if (iconName.equals("Cake")) {
            file = new File("Data\\Textures\\Products\\Cake.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Cake());
        } else if (iconName.equals("Fabric")) {
            file = new File("Data\\Textures\\Products\\Fabric.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Fabric());
        } else if (iconName.equals("CarnivalDress")) {
            file = new File("Data\\Textures\\Products\\CarnivalDress.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new CarnivalDress());
        } else if (iconName.equals("Powder")) {
            file = new File("Data\\Textures\\Products\\EggPowder.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new CarnivalDress());
        } else if (iconName.equals("Flour")) {
            file = new File("Data\\Textures\\Products\\Flour.png");
            numberOfIconWeNeedToAdd = informationNeededInGame.getSpaceNeededInWareHouse(new Flour());
        }
//        else if(iconName.equals("EggPowder")){
//            file=new File("Data\\Textures\\Products\\EggPowder.png");
//            numberOfIconWeNeedToAdd=informationNeededInGame.getSpaceNeededInWareHouse(new EggPow());
//        }else if(iconName.equals("Flour")){
//            file=new File("Data\\Textures\\Products\\Flour.png");
//        }
        try {
            Image iconImage = new Image(file.toURI().toString());
            for (int icon = 0; icon < numberOfIconWeNeedToAdd; icon++) {
                ImageView iconView = new ImageView(iconImage);
                iconView.setFitWidth(19);
                iconView.setFitHeight(19);
                int row = occupiedSpace % 7;
                int column = (int) (((float) occupiedSpace) / 10.0);
                occupiedSpace++;
                iconView.relocate(column * 19 + 560, 825 - row * 19);
                root.getChildren().addAll(iconView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void InitializeTheCells() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                cells.put(new ArrayList<>(Arrays.asList(i, j)), new HashMap<>());
            }
        }
    }

    public void RemoveGrassAndProductFromMap(String nodeName, int xCell, int yCell) {
        HashMap<Node, String> cellNodes = cells.get(new ArrayList<>(Arrays.asList(xCell, yCell)));
        Node node=null;
        loop:for(Node nodes:cellNodes.keySet()){
            if(cellNodes.get(nodes).equals(nodeName)){
                node=nodes;
                break loop;
            }
        }
        root.getChildren().removeAll(node);
        cellNodes.remove(node,nodeName);

    }

    public void AddMapObjectIcon(Object object, int xCell, int yCell) {
        if (object instanceof Cake) {
            AddCake(xCell, yCell);
        } else if (object instanceof CarnivalDress) {
            AddCarnivalDress(xCell, yCell);
        } else if (object instanceof Fabric) {
            AddFabric(xCell, yCell);
        } else if (object instanceof Flour) {
            AddFlour(xCell, yCell);
        } else if (object instanceof FlouryCake) {
            AddFlouryCake(xCell, yCell);
        }
    }

    private void LoadMapIconTharWereBefore() throws MissionNotLoaded {
        Cell[][] map = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap();
        for (int xCell = 0; xCell < 15; xCell++) {
            for (int yCell = 0; yCell < 15; yCell++) {
                Cell cell = map[xCell][yCell];
                for (Object object : cell.getCellObjectInMap15_15()) {
                    AddMapObjectIcon(object, xCell, yCell);
                }
            }
        }

    }

    private void ShowBorderOfMsp() {
        Line line = new Line(310, 210, 310, 375 + 210);
        Line line1 = new Line(649.999 + 310, 210, 649.999 + 310, 210 + 375);
        Line line2 = new Line(310, 375 + 210, 310 + 649.999, 375 + 210);
        Line line3 = new Line(310, 210, 310 + 649.999, 210);
        root.getChildren().addAll(line, line1, line2, line3);

    }

    private void AddMissionWorkShopsAndVehicles(Stage primaryStage) throws MissionNotLoaded {
        User user = Game.getGameInstance().getCurrentUserAccount();
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        CakeBakery cakeBakery = (CakeBakery) farm.getSpecifiedWorkShop("CakeBakery");
        CookieBakery cookieBakery = (CookieBakery) farm.getSpecifiedWorkShop("CookieBakery");
        EggPowderPlant eggPowderPlant = (EggPowderPlant) farm.getSpecifiedWorkShop("EggPowderPlant");
        SewingFactory sewingFactory = (SewingFactory) farm.getSpecifiedWorkShop("SewingFactory");
        Spinnery spinnery = (Spinnery) farm.getSpecifiedWorkShop("Spinnery");
        WeavingFactory weavingFactory = (WeavingFactory) farm.getSpecifiedWorkShop("WeavingFactory");
        if (cakeBakery != null) AddCakeBakery(user.getCakeBakeryLevel());
        if (cookieBakery != null) AddCookieBakery(user.getCookieBakeryLevel());
        if (eggPowderPlant != null) AddEggPowderPlant(user.getEggPowderPlantLevel());
        if (sewingFactory != null) AddSewingFactory(user.getSewingFactoryLevel());
        if (spinnery != null) AddSpinnery(user.getSpinneryLevel());
        if (weavingFactory != null) AddWeavingFactory(user.getWeavingFactoryLevel());

        if (farm.getTruck() != null) AddTruck(primaryStage, user.getTruckLevel());
        if (farm.getHelicopter() != null) AddHelicopter(primaryStage, user.getHelicopterLevel());
    }

    private void CheckWellBucketWater() throws MissionNotLoaded {
        Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
        int waterOfBucket = well.getWaterOfTheBucket();
        AddLevelBucketToWell(waterOfBucket);
    }

    private void AddLevelBucketToWell(int num) {
        int x = 1160;
        int y = 630;
        Rectangle rectangle = new Rectangle(18, 112);
        rectangle.relocate(x, y);
        rectangle.setFill(Color.rgb(231, 137, 0));
        rectangle.setArcHeight(8);
        rectangle.setArcWidth(8);
        root.getChildren().addAll(rectangle);
        for (int i = 0; i < num; i++) {
            Rectangle rectangle1 = new Rectangle(14, 18);
            rectangle1.relocate(x + 2, y + 93 - i * 23);
            rectangle1.setFill(Color.rgb(29, 85, 132));
            rectangle1.setArcWidth(8);
            rectangle1.setArcHeight(8);
            root.getChildren().addAll(rectangle1);
        }
    }

    private void missionTime() {
        mission.setSecond_2(mission.getSecond_2() + 1);
        if (mission.getSecond_2() == 10) {
            mission.setSecond_1(mission.getSecond_1() + 1);
            mission.setSecond_2(0);
        }
        if (mission.getSecond_1() == 6) {
            mission.setMinute_2(mission.getMinute_2() + 1);
            mission.setSecond_1(0);
        }
        if (mission.getMinute_2() == 10) {
            mission.setMinute_1(mission.getMinute_1() + 1);
            mission.setMinute_2(0);
        }
        timerText.setText(mission.getMinute_1() + mission.getMinute_2() + ":" + mission.getSecond_1() + mission.getSecond_2());
    }

    private void AddTimeText() {
        timerText.setText(mission.getMinute_1() + mission.getMinute_2() + ":" + mission.getSecond_1() + mission.getSecond_2());
        timerText.relocate(720, 40);
        timerText.setFont(Font.font(25));

        File backGroundFile = new File("Data\\Click\\time_gold.png");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView backgroundForTime = new ImageView(backGroundImage);
        backgroundForTime.relocate(680, 20);
        backgroundForTime.setFitHeight(60);
        backgroundForTime.setFitWidth(120);


        root.getChildren().addAll(backgroundForTime, timerText);
    }

    public void ShowMissionResultInTheEnd(Stage primaryStage) throws MissionNotLoaded {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView backgroundView = new ImageView(backGroundImage);
        Rectangle rectangleClip=new Rectangle(0,0,400,450);
        rectangleClip.setArcHeight(30);
        rectangleClip.setArcWidth(30);
        backgroundView.setClip(rectangleClip);
        backgroundView.setFitHeight(450);
        backgroundView.setFitWidth(400);
        backgroundView.relocate(600 , 200);
        backgroundView.setOpacity(0.8);
        root.getChildren().addAll(backgroundView);

        int shiftX = 600;
        int shiftY = 200;

        Rectangle rectangle = new Rectangle(150 , 35);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        rectangle.relocate(130 + shiftX , 5 + shiftY);
        rectangle.setFill(Color.rgb(0,114,150));
        root.getChildren().addAll(rectangle);

        Label label = new Label("Level result");
        label.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        label.relocate(150 + shiftX, 7 + shiftY);
        label.setTextFill(Color.WHITE);
        root.getChildren().addAll(label);

        File coin = new File("Data\\Shop\\Coin.png");
        Image coinImage = new Image(coin.toURI().toString());
        ImageView coinView = new ImageView(coinImage);
        coinView.setFitHeight(40);
        coinView.setFitWidth(40);
        coinView.relocate(30 + shiftX, 50 + shiftY);
        root.getChildren().addAll(coinView);

        Label labelCoin = new Label("Coin:");
        labelCoin.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelCoin.relocate(85 + shiftX , 60 + shiftY);
        labelCoin.setTextFill(Color.WHITE);
        root.getChildren().addAll(labelCoin);

        Label labelCoinLevel = new Label(moneyText.getText()); // todo
        labelCoinLevel.setTextFill(Color.WHITE);
        labelCoinLevel.relocate(200 + shiftX , 60 + shiftY);
        labelCoinLevel.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        root.getChildren().addAll(labelCoinLevel);

        File clock = new File("Data\\Shop\\Clock.png");
        Image clockImage = new Image(clock.toURI().toString());
        ImageView clockView = new ImageView(clockImage);
        clockView.setFitHeight(40);
        clockView.setFitWidth(40);
        clockView.relocate(30 + shiftX, 110 + shiftY);
        root.getChildren().addAll(clockView);

        Label labelClock = new Label("Time:");
        labelClock.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelClock.relocate(85 + shiftX , 120 + shiftY);
        labelClock.setTextFill(Color.WHITE);
        root.getChildren().addAll(labelClock);

        Label labelClockLevel = new Label(timerText.getText());
        labelClockLevel.setTextFill(Color.WHITE);
        labelClockLevel.relocate(200 + shiftX, 120 + shiftY);
        labelClockLevel.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        root.getChildren().addAll(labelClockLevel);
        GameView.getGameView().getMissionSelectionView().setBestTimeForCurrnetMissionIfItIsBest(timerText.getText());

        Label labelBonus = new Label("Bonus:");
        labelBonus.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelBonus.setTextFill(Color.WHITE);
        labelBonus.relocate(85 + shiftX, 180 + shiftY);
        root.getChildren().addAll(labelBonus);

        String time=timerText.getText();
        Label[] labelBonusLevel=new Label[1];
        if (time.substring(0,2).equals("0:")){
            labelBonusLevel[0]=new Label("200");
        }else if(time.substring(0,2).equals("1:")){
            labelBonusLevel[0]=new Label("100");
        }else if(time.substring(0,2).equals("2:")){
            labelBonusLevel[0]=new Label("50");
        }else {
            labelBonusLevel[0]=new Label("25");
        }
        labelBonusLevel[0].setTextFill(Color.WHITE);
        labelBonusLevel[0].setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelBonusLevel[0].relocate(200 + shiftX,  180 + shiftY);
        root.getChildren().addAll(labelBonusLevel[0]);

        File star = new File("Data\\Shop\\Star.png");
        Image starImage = new Image(star.toURI().toString());
        ImageView starView = new ImageView(starImage);
        starView.setFitHeight(40);
        starView.setFitWidth(40);
        starView.relocate(30 + shiftX, 170 + shiftY);
        root.getChildren().addAll(starView);

        File coinBank1 = new File("Data\\Shop\\Coin.png");
        Image coinBankImage1 = new Image(coinBank1.toURI().toString());
        ImageView coinBankView1 = new ImageView(coinBankImage1);
        coinBankView1.setFitHeight(20);
        coinBankView1.setFitWidth(20);
        coinBankView1.relocate(30 + shiftX, 240 + shiftY);
        root.getChildren().addAll(coinBankView1);

        File coinBank2 = new File("Data\\Shop\\Coin.png");
        Image coinBankImage2 = new Image(coinBank2.toURI().toString());
        ImageView coinBankView2 = new ImageView(coinBankImage2);
        coinBankView2.setFitHeight(20);
        coinBankView2.setFitWidth(20);
        coinBankView2.relocate(50 + shiftX, 240 + shiftY);
        root.getChildren().addAll(coinBankView2);

        File coinBank3 = new File("Data\\Shop\\Coin.png");
        Image coinBankImage3 = new Image(coinBank3.toURI().toString());
        ImageView coinBankView3 = new ImageView(coinBankImage3);
        coinBankView3.setFitHeight(20);
        coinBankView3.setFitWidth(20);
        coinBankView3.relocate(40 + shiftX, 260 + shiftY);
        root.getChildren().addAll(coinBankView3);

        Label labelBank = new Label("Bank:");
        labelBank.relocate(85 + shiftX , 245 + shiftY);
        labelBank.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelBank.setTextFill(Color.WHITE);
        root.getChildren().addAll(labelBank);

        Label labelBankLevel = new Label("25"); // todo
        labelBankLevel.setTextFill(Color.WHITE);
        labelBankLevel.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelBankLevel.relocate(200 + shiftX, 245 + shiftY);
        root.getChildren().addAll(labelBankLevel);

        Line line = new Line(60  + shiftX, 300 + shiftY, 330 + shiftX, 300 + shiftY);
        root.getChildren().addAll(line);

        Label labelBestTime = new Label("Best time:");
        labelBestTime.setTextFill(Color.WHITE);
        labelBestTime.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelBestTime.relocate(120 + shiftX , 305 + shiftY);
        root.getChildren().addAll(labelBestTime);

        Label labelBestTimeLevel = new Label(GameView.getGameView().getMissionSelectionView().getBestTimeForCurrnetMissionToEnd());
        labelBestTimeLevel.setTextFill(Color.WHITE);
        labelBestTimeLevel.setStyle("-fx-font: 23 Georgia; -fx-base: #4258ee;");
        labelBestTimeLevel.relocate(250 + shiftX , 305 + shiftY);
        root.getChildren().addAll(labelBestTimeLevel);

        File buttonOkFile = new File("Data\\Click\\OkButton.png");
        Image buttonOkImage = new Image(buttonOkFile.toURI().toString());
        ImageView buttonOkImageView = new ImageView(buttonOkImage);
        buttonOkImageView.setFitHeight(50);
        buttonOkImageView.setFitWidth(120);
        buttonOkImageView.relocate(150 + shiftX, 360 + shiftY);
        root.getChildren().addAll(buttonOkImageView);

        MakeEndMissionOkViewForClick(primaryStage, labelBonusLevel, labelBankLevel, buttonOkImageView);
        buttonOkImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(50 + 10);
                buttonOkImageView.setFitWidth(120 + 10);
                buttonOkImageView.relocate(150 - 5 + shiftX, 360 - 5 + shiftY);
            }
        });
        buttonOkImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(50);
                buttonOkImageView.setFitWidth(120);
                buttonOkImageView.relocate(150 + shiftX, 360 + shiftY);
            }
        });

        File okText = new File("Data\\Shop\\OkText.png");
        Image okImage = new Image(okText.toURI().toString());
        ImageView okImageView = new ImageView(okImage);
        okImageView.setFitWidth(50);
        okImageView.setFitHeight(40);
        okImageView.relocate(185 + shiftX, 365 + shiftY);
        root.getChildren().addAll(okImageView);

        MakeEndMissionOkViewForClick(primaryStage, labelBonusLevel, labelBankLevel, okImageView);
        okImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(50 + 10);
                buttonOkImageView.setFitWidth(120 + 10);
                buttonOkImageView.relocate(150 - 5 + shiftX, 360 - 5 + shiftY);
            }
        });
        okImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(50);
                buttonOkImageView.setFitWidth(120);
                buttonOkImageView.relocate(150 + shiftX, 360 + shiftY);
            }
        });
    }

    private void MakeEndMissionOkViewForClick(Stage primaryStage, Label[] labelBonusLevel, Label labelBankLevel, ImageView buttonOkImageView) {
        buttonOkImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                User user= Game.getGameInstance().getCurrentUserAccount();
                int addMoney=Integer.valueOf(moneyText.getText())+Integer.valueOf(labelBonusLevel[0].getText())+Integer.valueOf(labelBankLevel.getText());
                user.setMoney(user.getMoney()+addMoney);
                try {
                    user.RenewMissions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getScene());
                GameView.getGameView().setFarmView(null);
                primaryStage.setFullScreen(true);
            }
        });
    }

}

