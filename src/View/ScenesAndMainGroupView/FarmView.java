package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.*;
import FarmModel.Request.BuyRequest;
import FarmModel.Request.LoadGameRequest;
import FarmModel.Request.SaveGameRequest;
import FarmModel.Request.TurnRequest;
import FarmModel.User;
import View.GameView;
import View.SpriteAnimation;
import View.View;
import com.gilecode.yagson.YaGson;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class FarmView extends View {
    private Text text = new Text("Speed\n   " + String.valueOf(GameView.getGameView().getStartMenuView().getGameSpeed()));
    private Circle speedCircle;
    private Group rootFarmView = new Group();
    private Scene sceneFarmView = new Scene(rootFarmView, 1600, 900);
    private AnimationTimer animationTimer;
    private Text moneyText;

    public Text getText() {
        return text;
    }

    public AnimationTimer getAnimationTimer() {
        return animationTimer;
    }

    public FarmView(Stage primaryStage) throws Exception {
        Start(primaryStage);
    }

    public Scene getSceneFarmView() {
        return sceneFarmView;
    }

    @Override
    public void Start(Stage primaryStage) throws MissionNotLoaded {
        User user = Game.getGameInstance().getCurrentUserAccount();
        Mission mission = user.getCurrentPlayingMission();
        Farm farm = mission.getFarm();
        CakeBakery cakeBakery = (CakeBakery) farm.getSpecifiedWorkShop("CakeBakery");
        CookieBakery cookieBakery = (CookieBakery) farm.getSpecifiedWorkShop("CookieBakery");
        EggPowderPlant eggPowderPlant = (EggPowderPlant) farm.getSpecifiedWorkShop("EggPowderPlant");
        SewingFactory sewingFactory = (SewingFactory) farm.getSpecifiedWorkShop("SewingFactory");
        Spinnery spinnery = (Spinnery) farm.getSpecifiedWorkShop("Spinnery");
        WeavingFactory weavingFactory = (WeavingFactory) farm.getSpecifiedWorkShop("WeavingFactory");

        GameView.getGameView().setProductInHelicopterView(new ProductInHelicopterView(primaryStage));
        GameView.getGameView().setProductInTruckView(new ProductInTruckView(primaryStage));
        text.setText(GameView.getGameView().getStartMenuView().getText().getText());

        AddSpeedCircleToSettingInFarm(primaryStage);

        animationTimer = new AnimationTimer() {
            long time = -1;

            @Override
            public void handle(long now) {
                String speedText = GameView.getGameView().getStartMenuView().getText().getText();
                int speed = Integer.valueOf(speedText.substring(speedText.length() - 2));
                if (time == -1) time = now;
                if (now - time > (2000000000) - (speed * 11181818)) {
                    System.out.print(speed + ":speed");
                    System.out.println(now);
                    time = now;
                    try {
                        new TurnRequest("turn 1");
                        System.out.println("one turn passed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        animationTimer.start();

        AddBackGround(primaryStage);

        ShowMovingCloud();

        AddMovingWell(farm.getWell().getLevel());

        AddMovingWareHouse(farm.getWareHouse().getLevel());

        AddPavement();

        AddBuyItems();

        AddLookingGIf();

        if (farm.getTruck() != null) AddTruck(primaryStage, farm.getTruck().getLevel());

        if (farm.getHelicopter() != null) AddHelicopter(primaryStage, farm.getHelicopter().getLevel());

        if (cakeBakery != null) AddCakeBakery(cakeBakery.getLevel());
        if (cookieBakery != null) AddCookieBakery(cookieBakery.getLevel());
        if (eggPowderPlant != null) AddEggPowderPlant(eggPowderPlant.getLevel());
        if (sewingFactory != null) AddSewingFactory(sewingFactory.getLevel());
        if (spinnery != null) AddSpinnery(spinnery.getLevel());
        if (weavingFactory != null) AddWeavingFactory(weavingFactory.getLevel());

        AddStarAndMoneyText(user.getCurrentPlayingMission().getMissionMoney());


//        AddThreePavementForWorkshop();

        AddMenuClick(primaryStage);

        primaryStage.setScene(sceneFarmView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\Map.png");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(870);
        BackGroundView.setFitWidth(1540);
        rootFarmView.getChildren().addAll(BackGroundView);
    }

    private void AddMenuClick(Stage primaryStage) {
        File settingFile = new File("Data\\MenuClick\\Setting.png");
        Image settingImage = new Image(settingFile.toURI().toString());
        ImageView settingView = new ImageView(settingImage);
        settingView.relocate(440, 680);
        settingView.setFitHeight(30);
        settingView.setFitWidth(55);

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

        File restartFile = new File("Data\\MenuClick\\Restart.png");
        Image restartImage = new Image(restartFile.toURI().toString());
        ImageView restartImageView = new ImageView(restartImage);
        restartImageView.relocate(266, 655);
        restartImageView.setFitHeight(40);
        restartImageView.setFitWidth(60);


        File continueFile = new File("Data\\MenuClick\\Continue.png");
        Image continueImage = new Image(continueFile.toURI().toString());
        ImageView continueImageView = new ImageView(continueImage);
        continueImageView.relocate(50, 530);
        continueImageView.setFitHeight(40);
        continueImageView.setFitWidth(60);

        File mapFile = new File("Data\\MenuClick\\Map.png");
        Image mapImage = new Image(mapFile.toURI().toString());
        ImageView mapTextView = new ImageView(mapImage);
        mapTextView.relocate(300, 780);
        mapTextView.setFitHeight(30);
        mapTextView.setFitWidth(50);

        File menuTextFile = new File("Data\\MenuClick\\MainMenu.png");
        Image menuTextImage = new Image(menuTextFile.toURI().toString());
        ImageView menuTextImageView = new ImageView(menuTextImage);
        menuTextImageView.relocate(175, 563.495);
        menuTextImageView.setFitHeight(40);
        menuTextImageView.setFitWidth(70);


        Circle menuCircle = new Circle(80, 800, 0);
        menuCircle.setOpacity(0.6);
        menuCircle.setFill(Color.rgb(216, 218, 34));

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
                try {
                    new SaveGameRequest("save game UsersAccount");
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });

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
                rootFarmView.getChildren().addAll(text, speedCircle);
                KeyValue xSpeed = new KeyValue(speedCircle.centerXProperty(), 630);
                KeyValue ySpeed = new KeyValue(speedCircle.centerYProperty(), 610);
                KeyFrame speedCircleFrame = new KeyFrame(Duration.millis(500), xSpeed, ySpeed);
                Timeline speedCircleTimeLine = new Timeline(speedCircleFrame);
                speedCircleTimeLine.play();
            }
        });

        Circle mainMenuCircle = new Circle(205, 583.495, 0);
        mainMenuCircle.setOpacity(0.6);
        mainMenuCircle.setFill(Color.rgb(64, 45, 67));
        mainMenuCircle.setOnMouseEntered(event -> mainMenuCircle.setOpacity(0.8));
        mainMenuCircle.setOnMouseExited(event -> mainMenuCircle.setOpacity(0.6));
        mainMenuCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getSceneStartMenuView());
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
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getSceneStartMenuView());
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

        Circle mapCircle = new Circle(330, 800, 0);
        mapCircle.setOpacity(0.6);
        mapCircle.setFill(Color.rgb(64, 45, 67));
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
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getSceneSelectionView());
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
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getSceneSelectionView());
                primaryStage.setFullScreen(true);
                Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
                GameView.getGameView().setFarmView(null);
            }
        });

        Circle continueCircle = new Circle(80, 550, 0);
        continueCircle.setOpacity(0.6);
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
                rootFarmView.getChildren().removeAll(menuTextImageView, mapTextView, continueImageView, restartImageView, saveView, settingView, speedCircle, text);
                animationTimer.start();
                ShowMenuClosing(menuCircles);
                PlayBubbleSound();


            }
        });

        rootFarmView.getChildren().addAll(menuCircle, continueCircle, mainMenuCircle, restartCircle, mapCircle, settingCircle, savecircle, emptyCircle);

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
                    rootFarmView.getChildren().addAll(menuTextImageView, mapTextView, continueImageView, restartImageView, settingView, saveView);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                ShowMenuOpening(menuCircles);
                PlayBubbleSound();
            }
        });

        rootFarmView.getChildren().addAll(MenuView);
    }

    private void AddPavement() {
        File pavementFile = new File("C:Data\\Pavement.png");
        Image pavementImage = new Image(pavementFile.toURI().toString());
        ImageView pavementViewHelicopter = new ImageView(pavementImage);
        pavementViewHelicopter.relocate(190, 520);
        pavementViewHelicopter.setFitHeight(500);
        pavementViewHelicopter.setFitWidth(300);

        ImageView pavementViewTruck = new ImageView(pavementImage);
        pavementViewTruck.relocate(825, 520);
        pavementViewTruck.setFitHeight(500);
        pavementViewTruck.setFitWidth(300);

        rootFarmView.getChildren().addAll(pavementViewHelicopter, pavementViewTruck);
    }

    private void ShowMovingCloud() {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
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

        rootFarmView.getChildren().addAll(cloudView);
    }

    private void AddMovingWell(int level) {
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
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(wellView, Duration.millis(500), 12, 4, 0, 0, 150, 136);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        wellView.setViewport(new Rectangle2D(0, 0, 150, 136));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(wellView);
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
        wareHouseView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
//                ShowChickenMoving(10,10,11,11);
                ShowCatMoving(10, 10, 11, 11);
                ShowDogMoving(5, 5, 6, 5);
            }
        });
        rootFarmView.getChildren().addAll(wareHouseView);
    }

    private void AddBuyItems() {
        Circle chickenCircle = new Circle(1450, 270, 50, Color.rgb(39, 221, 255));
        chickenCircle.setOpacity(0.6);

        Circle sheepCircle = new Circle(1450, 390, 50, Color.rgb(39, 221, 255));
        sheepCircle.setOpacity(0.6);

        Circle cowCircle = new Circle(1450, 510, 50, Color.rgb(255, 201, 0));
        cowCircle.setOpacity(0.6);

        Circle catCircle = new Circle(1450, 630, 50, Color.rgb(255, 201, 0));
        catCircle.setOpacity(0.6);

        Circle dogCircle = new Circle(1450, 750, 50, Color.rgb(255, 201, 0));
        dogCircle.setOpacity(0.6);

        File chickenFile = new File("Data\\Textures\\BuyIconNotHead\\Chicken.png");
        Image chickenImage = new Image(chickenFile.toURI().toString());
        ImageView chickenView = new ImageView(chickenImage);
        chickenView.relocate(1405, 235);
        chickenView.setFitHeight(80);
        chickenView.setFitWidth(80);
        chickenView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        chickenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.6);
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
                }

            }
        });
        chickenCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        chickenCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.6);
            }
        });
        chickenCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
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


        File sheepFile = new File("Data\\Textures\\BuyIconNotHead\\Ship.png");
        Image sheepImage = new Image(sheepFile.toURI().toString());
        ImageView sheepView = new ImageView(sheepImage);
        sheepView.relocate(1408, 353);
        sheepView.setFitHeight(80);
        sheepView.setFitWidth(80);
        sheepView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sheepCircle.setOpacity(0.95);
            }
        });
        sheepView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sheepCircle.setOpacity(0.6);
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
                }
            }
        });
        sheepCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sheepCircle.setOpacity(0.95);
            }
        });
        sheepCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sheepCircle.setOpacity(0.6);
            }
        });
        sheepCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        File cowFile = new File("Data\\Textures\\BuyIconNotHead\\Cow.png");
        Image cowImage = new Image(cowFile.toURI().toString());
        ImageView cowView = new ImageView(cowImage);
        cowView.relocate(1412, 474);
        cowView.setFitHeight(80);
        cowView.setFitWidth(80);
        cowView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowCircle.setOpacity(0.95);
            }
        });
        cowView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowCircle.setOpacity(0.6);
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
        cowCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowCircle.setOpacity(0.95);
            }
        });
        cowCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowCircle.setOpacity(0.6);
            }
        });
        cowCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        File catFile = new File("Data\\Textures\\BuyIconNotHead\\Cat.png");
        Image catImage = new Image(catFile.toURI().toString());
        ImageView catView = new ImageView(catImage);
        catView.relocate(1408, 590);
        catView.setFitHeight(80);
        catView.setFitWidth(80);
        catView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catCircle.setOpacity(0.95);
            }
        });
        catView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catCircle.setOpacity(0.6);
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
        catCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catCircle.setOpacity(0.95);
            }
        });
        catCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catCircle.setOpacity(0.6);
            }
        });
        catCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        File dogFile = new File("Data\\Textures\\BuyIconNotHead\\Dog.png");
        Image dogImage = new Image(dogFile.toURI().toString());
        ImageView dogView = new ImageView(dogImage);
        dogView.relocate(1410, 703);
        dogView.setFitHeight(90);
        dogView.setFitWidth(80);
        dogView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogCircle.setOpacity(0.95);
            }
        });
        dogView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogCircle.setOpacity(0.6);
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
        dogCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogCircle.setOpacity(0.95);
            }
        });
        dogCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogCircle.setOpacity(0.6);
            }
        });
        dogCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
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


        rootFarmView.getChildren().addAll(chickenCircle, sheepCircle, cowCircle, catCircle, dogCircle, chickenView, sheepView, cowView, catView, dogView);
    }


    private void AddSpinnery(int level) {
        File spinneryFile = new File("Data\\Textures\\Workshops\\Spinnery(Spinnery)\\0" + String.valueOf(level + 1) + ".png");
        Image spinneryImage = new Image(spinneryFile.toURI().toString());
        ImageView spinneryView = new ImageView(spinneryImage);
        spinneryView.relocate(100, 200);
        spinneryView.setFitHeight(150);
        spinneryView.setFitWidth(150);
        spinneryView.setViewport(new Rectangle2D(0, 0, 130, 106));
        spinneryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.relocate(95, 195);
                spinneryView.setFitHeight(160);
                spinneryView.setFitWidth(160);
            }
        });
        spinneryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.relocate(100, 200);
                spinneryView.setFitHeight(150);
                spinneryView.setFitWidth(150);
            }
        });
        spinneryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(spinneryView, Duration.millis(500), 12, 4, 0, 0, 130, 106);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        spinneryView.setViewport(new Rectangle2D(0, 0, 130, 106));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(spinneryView);
    }

    private void AddCakeBakery(int level) {
        File cakeBakeryFile = new File("Data\\Textures\\Workshops\\FlouryCake(Cake Bakery)\\0" + String.valueOf(level + 1) + ".png");
        Image cakeBakeryImage = new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw = new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(100, 350);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 184, 171.5));
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(95, 345);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(100, 350);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(cakeBakeryVeiw, Duration.millis(500), 12, 4, 0, 0, 184, 171);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 184, 171));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(cakeBakeryVeiw);
    }

    private void AddSewingFactory(int level) {
        File sewingFactoryFile = new File("Data\\Textures\\Workshops\\CarnivalDress(Sewing Factory)\\0" + String.valueOf(level + 1) + ".png");
        Image sewingFactoryImage = new Image(sewingFactoryFile.toURI().toString());
        ImageView sewingFactoryView = new ImageView(sewingFactoryImage);
        sewingFactoryView.relocate(100, 500);
        sewingFactoryView.setFitHeight(150);
        sewingFactoryView.setFitWidth(150);
        sewingFactoryView.setViewport(new Rectangle2D(0, 0, 170, 130));
        sewingFactoryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.relocate(95, 495);
                sewingFactoryView.setFitHeight(160);
                sewingFactoryView.setFitWidth(160);
            }
        });
        sewingFactoryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.relocate(100, 500);
                sewingFactoryView.setFitHeight(150);
                sewingFactoryView.setFitWidth(150);
            }
        });
        sewingFactoryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(sewingFactoryView, Duration.millis(500), 12, 4, 0, 0, 170, 130);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        sewingFactoryView.setViewport(new Rectangle2D(0, 0, 170, 130));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(sewingFactoryView);
    }

    private void AddWeavingFactory(int level) {
        File WeavingFile = new File("Data\\Textures\\Workshops\\Weaving(Weaving Factory)\\0" + String.valueOf(level + 1) + ".png");
        Image WeavingImage = new Image(WeavingFile.toURI().toString());
        ImageView WeavingView = new ImageView(WeavingImage);
        WeavingView.relocate(1000, 200);
        WeavingView.setFitHeight(150);
        WeavingView.setFitWidth(150);
        WeavingView.setViewport(new Rectangle2D(0, 0, 166, 116));
        WeavingView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WeavingView.relocate(995, 195);
                WeavingView.setFitHeight(160);
                WeavingView.setFitWidth(160);
            }
        });
        WeavingView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WeavingView.relocate(1000, 200);
                WeavingView.setFitHeight(150);
                WeavingView.setFitWidth(150);
            }
        });
        WeavingView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(WeavingView, Duration.millis(500), 12, 4, 0, 0, 166, 116);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        WeavingView.setViewport(new Rectangle2D(0, 0, 166, 116));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(WeavingView);
    }

    private void AddCookieBakery(int level) {
        File cakeBakeryFile = new File("Data\\Textures\\Workshops\\Cake(Cookie Bakery)\\0" + String.valueOf(level + 1) + ".png");
        Image cakeBakeryImage = new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw = new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(1000, 350);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 134, 142));
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(995, 345);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(1000, 350);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(cakeBakeryVeiw, Duration.millis(500), 12, 4, 0, 0, 134, 142);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 134, 142));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(cakeBakeryVeiw);
    }

    private void AddEggPowderPlant(int level) {
        File cakeBakeryFile = new File("Data\\Textures\\Workshops\\DriedEggs(Egg Powder Plant)\\0" + String.valueOf(level + 1) + ".png");
        Image cakeBakeryImage = new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw = new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(1000, 500);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 128, 114));
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(995, 495);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(1000, 500);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation = new SpriteAnimation(cakeBakeryVeiw, Duration.millis(500), 12, 4, 0, 0, 128, 114);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cakeBakeryVeiw.setViewport(new Rectangle2D(0, 0, 128, 114));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(cakeBakeryVeiw);
    }

    private void AddCustomWorkShop() {
    }

    private void AddTruck(Stage primaryStage, int level) {
        File truckFile = new File("Data\\Textures\\Service\\Truck\\0" + String.valueOf(level + 1) + ".png");
        Image truckImage = new Image(truckFile.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
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
                primaryStage.setScene(GameView.getGameView().getProductInTruckView().getSceneProductTruckView());
                primaryStage.setFullScreen(true);
            }
        });
        rootFarmView.getChildren().addAll(truckView);
    }
    private void ShowTruckGoingToCityAndComingBack() throws MissionNotLoaded {
        Truck truck=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        int turnToMoveObjectToCityAndComeBack=truck.getTurnToMoveObjectToCityAndComeBack();

        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
        File truckFile = new File("Data\\Textures\\UI\\Truck\\01_mini.png");
        Image truckImage = new Image(truckFile.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.relocate(980, 75);
        truckView.setFitHeight(80);
        truckView.setFitWidth(80);
        truckView.setViewport(new Rectangle2D(0, 0, 48, 48));
        truckView.setScaleX(-1);

        KeyValue xForGoing = new KeyValue(truckView.xProperty(), 500);

        KeyFrame going = new KeyFrame(Duration.millis(turnToMoveObjectToCityAndComeBack * 1000 * duration), xForGoing);
        Timeline timeLineGoing = new Timeline(going);
        timeLineGoing.getKeyFrames().addAll(going);
        timeLineGoing.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                truckView.setScaleX(1);
                KeyValue xForComing = new KeyValue(truckView.xProperty(), 0);
                KeyFrame coming = new KeyFrame(Duration.millis(turnToMoveObjectToCityAndComeBack * 1000), xForComing);
                Timeline timeLineComing = new Timeline(coming);
                timeLineComing.getKeyFrames().addAll(coming);
                timeLineComing.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        rootFarmView.getChildren().removeAll(truckView);
                    }
                });
                timeLineComing.play();
            }
        });
        timeLineGoing.play();


        truckView.setViewport(new Rectangle2D(0, 0, 48, 48));

        Animation animation = new SpriteAnimation(truckView, Duration.millis(100), 2, 2, 0, 0, 48, 48);
        animation.setCycleCount(100000);
        animation.play();

        rootFarmView.getChildren().addAll(truckView);
    }

    private void AddHelicopter(Stage primaryStage, int level) {
        File helicopterFile = new File("Data\\Textures\\Service\\Helicopter\\0" + String.valueOf(level + 1) + ".png");
        Image helicopterImage = new Image(helicopterFile.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
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
                primaryStage.setScene(GameView.getGameView().getProductInHelicopterView().getSceneProductHelicopterView());
                primaryStage.setFullScreen(true);
            }
        });
        rootFarmView.getChildren().addAll(helicopterView);
    }
    private void ShowHelicopterToCityAndComingBack() throws MissionNotLoaded {
        Helicopter helicopter=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getHelicopter();
        int timeToGoToCityAndComeBack=helicopter.getTurnToMoveObjectToCityAndComeBack();

        File helicopterFile = new File("Data\\Textures\\UI\\Helicopter\\01_mini.png");
        Image helicopterImage = new Image(helicopterFile.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.relocate(980, 20);
        helicopterView.setFitHeight(80);
        helicopterView.setFitWidth(80);
        helicopterView.setViewport(new Rectangle2D(0, 0, 48, 48));
        helicopterView.setScaleX(-1);

        KeyValue xForGoing = new KeyValue(helicopterView.xProperty(), 500);

        KeyFrame going = new KeyFrame(Duration.millis(timeToGoToCityAndComeBack * 1000), xForGoing);
        Timeline timeLineGoing = new Timeline(going);
        timeLineGoing.getKeyFrames().addAll(going);
        timeLineGoing.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                helicopterView.setScaleX(1);
                KeyValue xForComing = new KeyValue(helicopterView.xProperty(), 0);
                KeyFrame coming = new KeyFrame(Duration.millis(timeToGoToCityAndComeBack * 1000), xForComing);
                Timeline timeLineComing = new Timeline(coming);
                timeLineComing.getKeyFrames().addAll(coming);
                timeLineComing.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        rootFarmView.getChildren().removeAll(helicopterView);
                    }
                });
                timeLineComing.play();
            }
        });
        timeLineGoing.play();

        helicopterView.setViewport(new Rectangle2D(0, 0, 48, 48));

        Animation animation = new SpriteAnimation(helicopterView, Duration.millis(100), 6, 3, 0, 0, 48, 48);
        animation.setCycleCount(100000);
        animation.play();

        rootFarmView.getChildren().addAll(helicopterView);
    }

    private void AddLookingGIf() {
        File chickenFile = new File("Data\\Gif\\LookingChicken.gif");
        Image chickenImage = new Image(chickenFile.toURI().toString());
        ImageView LookingChickenImage = new ImageView(chickenImage);
        LookingChickenImage.relocate(1150, 250);
        LookingChickenImage.setFitHeight(180);
        LookingChickenImage.setFitWidth(180);

        rootFarmView.getChildren().addAll(LookingChickenImage);
    }

    private void PlantGrass(int xCell, int yCell) {
        PlayBubbleSound();
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File spinneryFile = new File("Data\\Textures\\Grass\\grass1.png");
        Image spinneryImage = new Image(spinneryFile.toURI().toString());
        ImageView spinneryView = new ImageView(spinneryImage);
        spinneryView.relocate(xPosition, yPosition);
        spinneryView.setFitHeight(48);
        spinneryView.setFitWidth(48);
        spinneryView.setViewport(new Rectangle2D(0, 0, 48, 48));

        Animation animation = new SpriteAnimation(spinneryView, Duration.millis(500), 12, 4, 0, 0, 48, 48);
        animation.play();
        rootFarmView.getChildren().addAll(spinneryView);
    }

    private void AddEgg(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File eggFile = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image eggImage = new Image(eggFile.toURI().toString());
        ImageView eggView = new ImageView(eggImage);
        eggView.relocate(xPosition, yPosition);
        eggView.setFitHeight(27);
        eggView.setFitWidth(20);
        rootFarmView.getChildren().addAll(eggView);
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
    }

    private void AddMilk(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];


        File milkFile = new File("Data\\Textures\\Products\\Milk.png");
        Image milkImage = new Image(milkFile.toURI().toString());
        ImageView milkView = new ImageView(milkImage);
        milkView.relocate(xPosition, yPosition);
        milkView.setFitHeight(27);
        milkView.setFitWidth(43);
        rootFarmView.getChildren().addAll(milkView);
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
    }

    private void AddWool(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File woolFile = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image woolImage = new Image(woolFile.toURI().toString());
        ImageView woolView = new ImageView(woolImage);
        woolView.relocate(xPosition, yPosition);
        woolView.setFitHeight(27);
        woolView.setFitWidth(40);
        rootFarmView.getChildren().addAll(woolView);
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
    }

    private void AddEggPowder(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File eggPodwerFile = new File("Data\\Textures\\Products\\EggPowder.png");
        Image eggPowderImage = new Image(eggPodwerFile.toURI().toString());
        ImageView eggPowderView = new ImageView(eggPowderImage);
        eggPowderView.relocate(xPosition, yPosition);
        eggPowderView.setFitHeight(27);
        eggPowderView.setFitWidth(40);
        rootFarmView.getChildren().addAll(eggPowderView);
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
    }

    private void AddCarnivalDress(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File carnivalDressFile = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image carnivalDressImage = new Image(carnivalDressFile.toURI().toString());
        ImageView carnivalDressView = new ImageView(carnivalDressImage);
        carnivalDressView.relocate(xPosition, yPosition);
        carnivalDressView.setFitHeight(27);
        carnivalDressView.setFitWidth(40);
        rootFarmView.getChildren().addAll(carnivalDressView);
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
    }

    private void AddCake(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File cakeFile = new File("Data\\Textures\\Products\\Cake.png");
        Image cakeImage = new Image(cakeFile.toURI().toString());
        ImageView cakeView = new ImageView(cakeImage);
        cakeView.relocate(xPosition, yPosition);
        cakeView.setFitHeight(27);
        cakeView.setFitWidth(40);
        rootFarmView.getChildren().addAll(cakeView);
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
    }

    private void AddFabric(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File fabricFile = new File("Data\\Textures\\Products\\Fabric.png");
        Image fabricImage = new Image(fabricFile.toURI().toString());
        ImageView fabricView = new ImageView(fabricImage);
        fabricView.relocate(xPosition, yPosition);
        fabricView.setFitHeight(27);
        fabricView.setFitWidth(40);
        rootFarmView.getChildren().addAll(fabricView);
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
    }

    private void AddFlouryCake(int xCell, int yCell) {
        int[] position = getPositionByCellPosition(xCell, yCell);
        int xPosition = position[0];
        int yPosition = position[1];

        File fabricFile = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image fabricImage = new Image(fabricFile.toURI().toString());
        ImageView fabricView = new ImageView(fabricImage);
        fabricView.relocate(xPosition, yPosition);
        fabricView.setFitHeight(27);
        fabricView.setFitWidth(40);
        rootFarmView.getChildren().addAll(fabricView);
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
    }

    private static int[] getCellPositionByPosition(int x, int y) {
        int[] position = new int[2];
        int standardX = x - 330;
        int standardY = y - 230;
        boolean isXSet = false;
        boolean isYSet = false;
        for (int i = 0; i < 14; i++) {
            if (i * 43.33333 < standardX && standardX < (i + 1) * 43.33333) {
                position[0] = i;
                isXSet = true;
            }
            if (i * 27.33333 < standardY && standardY < (i + 1) * 27.33333) {
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
        position[0] = (int) (320 + (xCell + 0.5) * 43.33333);
        position[1] = (int) (205 + (yCell + 0.5) * 27.33333);
        return position;
    }

    public void ShowChickenMoving(int xcell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
        File chickenFile = null;
        Image chickenImage = null;
        ImageView chickenView = null;
        Animation chickenAnimation = null;
        final ImageView[] chickenArrayView = new ImageView[1];

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
        int x1Position = position1[0];
        int y1Position = position1[1];
        int x2Position = position2[0];
        int y2Position = position2[1];
        chickenView.relocate(x1Position, y1Position);
        rootFarmView.getChildren().addAll(chickenView);
        chickenArrayView[0] = chickenView;

        KeyValue xChicken = new KeyValue(chickenView.xProperty(), x2Position - x1Position);
        KeyValue yChicken = new KeyValue(chickenView.yProperty(), y2Position - y1Position);
        KeyFrame xChickenFrame = new KeyFrame(Duration.millis(duration), xChicken, yChicken);
        Timeline chickenTimeLine = new Timeline(xChickenFrame);
        chickenTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootFarmView.getChildren().removeAll(chickenArrayView[0]);
            }
        });
        chickenAnimation.play();
        chickenTimeLine.play();
    }

    public void ShowCowMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
        File cowFile = null;
        Image cowImage = null;
        ImageView cowView = null;
        Animation cowAnimation = null;
        final ImageView[] cowArrayView = new ImageView[1];

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
        int x1Position = position1[0];
        int y1Position = position1[1];
        int x2Position = position2[0];
        int y2Position = position2[1];
        cowView.relocate(x1Position, y1Position);
        rootFarmView.getChildren().addAll(cowView);
        cowArrayView[0] = cowView;

        KeyValue xSheep = new KeyValue(cowView.xProperty(), x2Position - x1Position);
        KeyValue ySheep = new KeyValue(cowView.yProperty(), y2Position - y1Position);
        KeyFrame xSheepFrame = new KeyFrame(Duration.millis(duration), xSheep, ySheep);
        Timeline sheepTimeLine = new Timeline(xSheepFrame);
        sheepTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootFarmView.getChildren().removeAll(cowArrayView[0]);
            }
        });
        cowAnimation.play();
        sheepTimeLine.play();
    }

    public void ShowSheepMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
        File sheepFile = null;
        Image sheepImage = null;
        ImageView sheepView = null;
        Animation sheepAnimation = null;
        final ImageView[] sheepArrayView = new ImageView[1];

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
        int x1Position = position1[0];
        int y1Position = position1[1];
        int x2Position = position2[0];
        int y2Position = position2[1];
        sheepView.relocate(x1Position, y1Position);
        rootFarmView.getChildren().addAll(sheepView);
        sheepArrayView[0] = sheepView;

        KeyValue xSheep = new KeyValue(sheepView.xProperty(), x2Position - x1Position);
        KeyValue ySheep = new KeyValue(sheepView.yProperty(), y2Position - y1Position);
        KeyFrame xSheepFrame = new KeyFrame(Duration.millis(duration), xSheep, ySheep);
        Timeline sheepTimeLine = new Timeline(xSheepFrame);
        sheepTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootFarmView.getChildren().removeAll(sheepArrayView[0]);
            }
        });
        sheepAnimation.play();
        sheepTimeLine.play();
    }

    public void ShowDogMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        System.out.println("ShowDogMoving");
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
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
        int x1Position = position1[0];
        int y1Position = position1[1];
        int x2Position = position2[0];
        int y2Position = position2[1];
        dogView.relocate(x1Position, y1Position);
        rootFarmView.getChildren().addAll(dogView);
        dogArrayView[0] = dogView;

        KeyValue xDog = new KeyValue(dogView.xProperty(), x2Position - x1Position);
        KeyValue yDog = new KeyValue(dogView.yProperty(), y2Position - y1Position);
        KeyFrame xDogFrame = new KeyFrame(Duration.millis(duration), xDog, yDog);
        Timeline dogTimeLine = new Timeline(xDogFrame);
        dogTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootFarmView.getChildren().removeAll(dogArrayView[0]);
            }
        });
        dogAnimation.play();
        dogTimeLine.play();
    }

    public void ShowCatMoving(int xCell1, int yCell1, int xCell2, int yCell2) {
        int speed = GameView.getGameView().getStartMenuView().getGameSpeed();
        int duration = (int) (((2000000000) - (speed * 11181818)) / 1000000);
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
        int x1Position = position1[0];
        int y1Position = position1[1];
        int x2Position = position2[0];
        int y2Position = position2[1];
        dogView.relocate(x1Position, y1Position);
        rootFarmView.getChildren().addAll(dogView);
        dogArrayView[0] = dogView;

        KeyValue xDog = new KeyValue(dogView.xProperty(), x2Position - x1Position);
        KeyValue yDog = new KeyValue(dogView.yProperty(), y2Position - y1Position);
        KeyFrame xDogFrame = new KeyFrame(Duration.millis(duration), xDog, yDog);
        Timeline dogTimeLine = new Timeline(xDogFrame);
        dogTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootFarmView.getChildren().removeAll(dogArrayView[0]);
            }
        });
        dogAnimation.play();
        dogTimeLine.play();
    }

    private void AddSpeedCircleToSettingInFarm(Stage primaryStage) {
        speedCircle = new Circle(466, 697, 60, Color.rgb(144, 125, 147));
        speedCircle.setOpacity(0.4);
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
        text.setStyle("-fx-font-weight: bold");
        text.setFont(Font.font(20));
        text.relocate(600, 590);
        text.setFill(Color.rgb(50, 100, 120));

        speedCircle.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                int speed = Integer.valueOf(text.getText().substring(text.getText().length() - 2));
                if (speed >= 11 && speed <= 98) {
                    if (((int) (speed + event.getDeltaY() / 32)) > 9 && ((int) (speed + event.getDeltaY() / 32)) < 100) {
                        text.setText("Speed\n   " + String.valueOf((int) (speed + event.getDeltaY() / 32)));
                        GameView.getGameView().getStartMenuView().setGameSpeed((int) (speed + event.getDeltaY() / 32));
                        Text startMenuText = GameView.getGameView().getStartMenuView().getText();
                        startMenuText.setText("Speed\n   " + String.valueOf((int) (speed + event.getDeltaY() / 32)));
                    }
                } else if (speed == 10 && event.getDeltaY() > 0) {
                    text.setText("Speed\n   " + String.valueOf(speed + 1));
                    GameView.getGameView().getStartMenuView().setGameSpeed(speed + 1);
                    Text startMenuText = GameView.getGameView().getStartMenuView().getText();
                    startMenuText.setText("Speed\n   " + String.valueOf(speed + 1));
                } else if (speed == 99 && event.getDeltaY() < 0) {
                    text.setText("Speed\n   " + String.valueOf(speed - 1));
                    GameView.getGameView().getStartMenuView().setGameSpeed(speed - 1);
                    Text startMenuText = GameView.getGameView().getStartMenuView().getText();
                    startMenuText.setText("Speed\n   " + String.valueOf(speed - 1));
                }
            }
        });
    }

    private void AddStarAndMoneyText(int money) {
        File star = new File("Data\\Gif\\RotatingStar.gif");
        Image starImage = new Image(star.toURI().toString());
        ImageView starView = new ImageView(starImage);
        starView.setFitHeight(50);
        starView.setFitWidth(50);
        starView.relocate((int) (30), (int) (30));
        rootFarmView.getChildren().addAll(starView);
        moneyText = new Text(String.valueOf(money));
        moneyText.relocate((int) (100), (int) (50));
        moneyText.setFont(Font.font(30));
        moneyText.setStyle("-fx-font-weight: bold");
        rootFarmView.getChildren().addAll(moneyText);
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

    private void UpdateMoneyText() throws MissionNotLoaded {
        int currnetMissionMoney = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getMissionMoney();
        moneyText.setText(String.valueOf(currnetMissionMoney));

    }

}
