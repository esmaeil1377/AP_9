package View.ScenesAndMainGroupView;//package View.ScenesAndMainGroupView;

import FarmModel.Game;
import FarmModel.Mission;
import View.View;
import javafx.application.Application;
import View.GameView;
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

    public Scene getSceneSelectionView() {
        return sceneSelectionView;
    }

    public MissionSelectionView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        BeachOfMission(primaryStage);
        NumberOfMission(primaryStage);
        FarmerOfFarm(primaryStage);
        AddItem(primaryStage);

    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\Mission\\MissionBackGround.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        rootMissionSelectionView.getChildren().addAll(BackGroundView);
        primaryStage.setScene(sceneSelectionView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddItem(Stage primaryStage) {
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
        shopButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getGameShopView().getSceneGameShopView());
                primaryStage.setFullScreen(true);
            }
        });

        File shopText = new File("Data\\Mission\\ShopText.png");
        Image shopTextImage = new Image(shopText.toURI().toString());
        ImageView shopTextView = new ImageView(shopTextImage);
        shopTextView.setFitHeight(50);
        shopTextView.setFitWidth(100);
        shopTextView.relocate(40, 772);
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
        shopTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getGameShopView().getSceneGameShopView());
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

        rootMissionSelectionView.getChildren().addAll(shopButtonView,menuButtonView,menuTextView,shopTextView);
    }

    private void BeachOfMission(Stage primaryStage) {
        File restartFile = new File("Data\\Mission\\Map.jpeg");
        Image restartImage = new Image(restartFile.toURI().toString());
        ImageView restartImageView = new ImageView(restartImage);
        restartImageView.relocate(1230, 550);
        primaryStage.setFullScreen(true);
        restartImageView.setFitHeight(120);
        restartImageView.setFitWidth(120);
        //Circle circle = new Circle(1200, 500, 150); // cast to Circle
        //circle.setFill(restartImageView);
        rootMissionSelectionView.getChildren().addAll(restartImageView);
    }

    private void FarmerOfFarm(Stage primaryStage) {
        File farmerFile = new File("Data\\Gif\\Farmer.gif");
        Image farmerImage = new Image(farmerFile.toURI().toString());
        ImageView farmerImageView = new ImageView(farmerImage);
        farmerImageView.relocate(1270, 410);
        primaryStage.setFullScreen(true);
        farmerImageView.setFitHeight(160);
        farmerImageView.setFitWidth(100);
        rootMissionSelectionView.getChildren().addAll(farmerImageView);
        primaryStage.show();
    }

    private void NumberOfMission(Stage primaryStage) {
        File numberFile = new File("Data\\Mission\\Bubble.png");
        Image numberImage = new Image(numberFile.toURI().toString());
        //ImageView numberImageView = new ImageView(numberImage);
        ImageView[] numberImageView = new ImageView[10];
        for (int i = 20; i < 30; i++) {
            ImageView bubbleImageView=new ImageView(numberImage);
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
                        Mission mission=Game.getGameInstance().getCurrentUserAccount().getMissions().get(finali-20);
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

}