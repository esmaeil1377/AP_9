package View.ScenesAndMainGroupView;//package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Game;
import FarmModel.Mission;
import View.GameView;
import View.View;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;

public class MissionSelectionView extends View {
    private Group rootMissionSelectionView = new Group();
    private Scene sceneSelectionView = new Scene(rootMissionSelectionView, 1600, 900);
    private String bestTimeForMissino1="99:99";
    private String bestTimeForMission2="99:99";
    private String bestTimeForMission3="99:99";
    private String bestTimeForMission4="99:99";

    public String getBestTimeForCurrnetMissionToEnd() throws MissionNotLoaded {
        Mission mission=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
        if (mission.getMissionName().equals("mission1")){
            return bestTimeForMissino1;
        }else if (mission.getMissionName().equals("mission2")){
            return bestTimeForMission2;
        }else if (mission.getMissionName().equals("mission3")){
            return bestTimeForMission3;
        }else if (mission.getMissionName().equals("mission4")){
            return bestTimeForMission4;
        }
        return "00:00";
    }

    public void setBestTimeForCurrnetMissionIfItIsBest(String newTime) throws MissionNotLoaded {
        int value=0;
        int value2=0;
        Mission mission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();;
        String lastTime = GameView.getGameView().getMissionSelectionView().getBestTimeForCurrnetMissionToEnd();
        if (newTime.length()>4) {
            value = Integer.valueOf(newTime.substring(0, 2)) * 60 + Integer.valueOf(newTime.substring(3, 5));
        }else{
            value = Integer.valueOf(newTime.substring(0, 1)) * 60 + Integer.valueOf(newTime.substring(2, 4));
        }
        if(lastTime.length()>4){
            value2 = Integer.valueOf(lastTime.substring(0, 2)) * 60 + Integer.valueOf(lastTime.substring(3, 5));
        }else{
            value2 = Integer.valueOf(lastTime.substring(0, 1)) * 60 + Integer.valueOf(lastTime.substring(2, 4));
        }
        if (value<value2) {
            if (mission.getMissionName().equals("mission1")) {
                bestTimeForMissino1 = newTime;
            } else if (mission.getMissionName().equals("mission2")) {
                bestTimeForMission2 = newTime;
            } else if (mission.getMissionName().equals("mission3")) {
                bestTimeForMission3 = newTime;
            } else if (mission.getMissionName().equals("mission4")) {
                bestTimeForMission4 = newTime;
            }
        }
    }

    public Scene getSceneSelectionView() {
        return sceneSelectionView;
    }

    public MissionSelectionView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
//        BeachOfMission(primaryStage);
        NumberOfMission(primaryStage);
        FarmerOfFarm(primaryStage);
        AddMainMenu(primaryStage);
        AddShopButton(primaryStage);


    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\Mission\\MissionBackGround.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        rootMissionSelectionView.getChildren().addAll(BackGroundView);
        AddGando();
    }


//    private void BeachOfMission(Stage primaryStage) {
//        File restartFile = new File("Data\\Mission\\Map.jpeg");
//        Image restartImage = new Image(restartFile.toURI().toString());
//        ImageView restartImageView = new ImageView(restartImage);
//        restartImageView.relocate(1230, 550);
//        primaryStage.setFullScreen(true);
//        restartImageView.setFitHeight(120);
//        restartImageView.setFitWidth(120);
//        //Circle circle = new Circle(1200, 500, 150); // cast to Circle
//        //circle.setFill(restartImageView);
//        rootMissionSelectionView.getChildren().addAll(restartImageView);
//    }

    private void FarmerOfFarm(Stage primaryStage) {
        File farmerFile = new File("Data\\Gif\\SeaAnimal.gif");
        Image farmerImage = new Image(farmerFile.toURI().toString());
        ImageView farmerImageView = new ImageView(farmerImage);
        farmerImageView.relocate(1200, 410);
        primaryStage.setFullScreen(true);
        farmerImageView.setFitHeight(200);
        farmerImageView.setFitWidth(200);
        rootMissionSelectionView.getChildren().addAll(farmerImageView);
        primaryStage.show();
    }

    private void NumberOfMission(Stage primaryStage) {
        File numberFile = new File("Data\\Mission\\Bubble.png");
        Image numberImage = new Image(numberFile.toURI().toString());
        //ImageView numberImageView = new ImageView(numberImage);
        ImageView[] numberImageView = new ImageView[10];
        for (int i = 20; i < 30; i++) {
            ImageView bubbleImageView = new ImageView(numberImage);
            numberImageView[i - 20] = bubbleImageView;
            bubbleImageView.relocate(1300 - 300 * Math.cos(i * 3.14 / 11), 550 - 300 * Math.sin(i * 3.14 / 11));
            bubbleImageView.setFitWidth(50);
            bubbleImageView.setFitHeight(50);
            rootMissionSelectionView.getChildren().addAll(bubbleImageView);
        }
        try {
            for (int i = 20; i < 30; i++) {
                final int finali = i;
                numberImageView[finali - 20].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Mission mission = Game.getGameInstance().getCurrentUserAccount().getMissions().get(finali - 20);
                        Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(mission);
                        try {
                            GameView.getGameView().setFarmView(new FarmView(primaryStage));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        primaryStage.setScene(GameView.getGameView().getFarmView().getSceneFarmView());
                        primaryStage.setFullScreen(true);
                    }
                });

                numberImageView[finali - 20].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        numberImageView[finali - 20].relocate(1300 - 300 * Math.cos(finali * 3.14 / 11) + 5, 550 - 300 * Math.sin(finali * 3.14 / 11) + 5);
                        numberImageView[finali - 20].setFitWidth(40);
                        numberImageView[finali - 20].setFitHeight(40);
                    }
                });
                numberImageView[finali - 20].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        numberImageView[finali - 20].relocate(1300 - 300 * Math.cos(finali * 3.14 / 11), 550 - 300 * Math.sin(finali * 3.14 / 11));
                        numberImageView[finali - 20].setFitWidth(50);
                        numberImageView[finali - 20].setFitHeight(50);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddGando() {
        File restartFile = new File("Data\\Gif\\Gando.gif");
        Image restartImage = new Image(restartFile.toURI().toString());
        ImageView restartImageView = new ImageView(restartImage);
        restartImageView.relocate(450, 250);
        restartImageView.setFitHeight(200);
        restartImageView.setFitWidth(200);
        rootMissionSelectionView.getChildren().addAll(restartImageView);
    }

    private void AddMainMenu(Stage primaryStage) {
        File menuButton = new File("Data\\Mission\\OkButton.png");
        Image menuButtonImage = new Image(menuButton.toURI().toString());
        ImageView menuButtonView = new ImageView(menuButtonImage);
        menuButtonView.setFitHeight(75);
        menuButtonView.setFitWidth(150);
        menuButtonView.relocate(1350, 760);
        menuButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.relocate(1345, 755);
                menuButtonView.setFitHeight(85);
                menuButtonView.setFitWidth(160);
            }
        });
        menuButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.setFitHeight(75);
                menuButtonView.setFitWidth(150);
                menuButtonView.relocate(1350, 760);
            }
        });
        menuButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getSceneStartMenuView());
                primaryStage.setFullScreen(true);
            }
        });
        File menuText = new File("Data\\Mission\\MenuText.png");
        Image menuTextImage = new Image(menuText.toURI().toString());
        ImageView menuTextView = new ImageView(menuTextImage);
        menuTextView.setFitHeight(50);
        menuTextView.setFitWidth(100);
        menuTextView.relocate(1378, 770);
        menuTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.relocate(1345, 755);
                menuButtonView.setFitHeight(85);
                menuButtonView.setFitWidth(160);
            }
        });
        menuTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.setFitHeight(75);
                menuButtonView.setFitWidth(150);
                menuButtonView.relocate(1350, 760);
            }
        });
        menuTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getSceneStartMenuView());
                primaryStage.setFullScreen(true);
            }
        });
        rootMissionSelectionView.getChildren().addAll(menuButtonView, menuTextView);
    }

    private void AddShopButton(Stage primaryStage) {
        File menuButton = new File("Data\\Mission\\OkButton.png");
        Image menuButtonImage = new Image(menuButton.toURI().toString());
        ImageView shopButtonView = new ImageView(menuButtonImage);
        shopButtonView.setFitHeight(75);
        shopButtonView.setFitWidth(150);
        shopButtonView.relocate(15, 760);
        shopButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.relocate(10, 755);
                shopButtonView.setFitHeight(85);
                shopButtonView.setFitWidth(160);
            }
        });
        shopButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.setFitHeight(75);
                shopButtonView.setFitWidth(150);
                shopButtonView.relocate(15, 760);
            }
        });
        ShowShopScene(primaryStage, shopButtonView);

        File shopText = new File("Data\\Mission\\ShopText.png");
        Image shopTextImage = new Image(shopText.toURI().toString());
        ImageView shopTextView = new ImageView(shopTextImage);
        shopTextView.setFitHeight(60);
        shopTextView.setFitWidth(110);
        shopTextView.relocate(35, 772);
        shopTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.relocate(10, 755);
                shopButtonView.setFitHeight(85);
                shopButtonView.setFitWidth(160);
            }
        });
        shopTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.setFitHeight(75);
                shopButtonView.setFitWidth(150);
                shopButtonView.relocate(15, 760);
            }
        });
        ShowShopScene(primaryStage, shopTextView);
        rootMissionSelectionView.getChildren().addAll(shopButtonView, shopTextView);
    }

    private void ShowShopScene(Stage primaryStage, ImageView shopTextView) {
        shopTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameShopView gameShopView = new GameShopView(primaryStage);
                GameView.getGameView().setGameShopView(gameShopView);
                primaryStage.setScene(gameShopView.getSceneGameShopView());
                primaryStage.setFullScreen(true);
            }
        });
    }

}