package View.ScenesAndMainGroupView;

import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
        restartImageView.relocate(1230,550);
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
        farmerImageView.relocate(1270,410);
        primaryStage.setFullScreen(true);
        farmerImageView.setFitHeight(230);
        farmerImageView.setFitWidth(90);
        rootMissionSelectionView.getChildren().addAll(farmerImageView);
        primaryStage.show();
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
                numberImageView[i].setFitWidth(35);
                numberImageView[i].setFitHeight(35);
                rootMissionSelectionView.getChildren().addAll(numberImageView[i]);
            }
            if (i >= 7) {
                numberImageView[i] = new ImageView(numberImage);
                numberImageView[i].relocate(1130 + (i - 7) * 40, 450 + 40 * 7 + 10);
                primaryStage.setFullScreen(true);
                numberImageView[i].setFitWidth(35);
                numberImageView[i].setFitHeight(35);
                rootMissionSelectionView.getChildren().addAll(numberImageView[i]);
            }
        }
        try {
            for (int i = 0; i < 15; i++) {
                final int ai = i;
                numberImageView[ai].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                    }
                });
                if (ai < 7) {
                    numberImageView[ai].setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            numberImageView[ai].relocate(1130 + 5, 450 + 40 * ai + 5);
                            numberImageView[ai].setFitWidth(30);
                            numberImageView[ai].setFitHeight(30);
                        }
                    });
                    numberImageView[ai].setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            numberImageView[ai].relocate(1130, 450 + 40 * ai);
                            numberImageView[ai].setFitWidth(35);
                            numberImageView[ai].setFitHeight(35);
                        }
                    });
                } else {
                    numberImageView[ai].setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            numberImageView[ai].relocate(1130 + (ai - 7) * 40 + 5, 450 + 40 * 7 + 10 + 5);
                            numberImageView[ai].setFitWidth(30);
                            numberImageView[ai].setFitHeight(30);
                        }
                    });
                    numberImageView[ai].setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            numberImageView[ai].relocate(1130 + (ai - 7) * 40, 450 + 40 * 7 + 10);
                            numberImageView[ai].setFitWidth(35);
                            numberImageView[ai].setFitHeight(35);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddMenuClick(Stage primaryStage) {
        File restartFile1=new File("Data\\MenuClick\\Restart.png");
        Image restartImage1=new Image(restartFile1.toURI().toString());
        ImageView restartImageView1=new ImageView(restartImage1);
        restartImageView1.relocate(266,655);
        primaryStage.setFullScreen(true);
        restartImageView1.setFitHeight(40);
        restartImageView1.setFitWidth(60);

        File continueFile=new File("Data\\MenuClick\\Continue.png");
        Image continueImage=new Image(continueFile .toURI().toString());
        ImageView continueImageView=new ImageView(continueImage);
        continueImageView.relocate(50,530);
        primaryStage.setFullScreen(true);
        continueImageView.setFitHeight(40);
        continueImageView.setFitWidth(60);

        File mapFile=new File("Data\\MenuClick\\Map.png");
        Image optionImage=new Image(mapFile.toURI().toString());
        ImageView optionImageView=new ImageView(optionImage);
        optionImageView.relocate(300,780);
        primaryStage.setFullScreen(true);
        optionImageView.setFitHeight(30);
        optionImageView.setFitWidth(50);

        File menuTextFile=new File("Data\\MenuClick\\MainMenu.png");
        Image menuTextImage=new Image(menuTextFile.toURI().toString());
        ImageView menuTextImageView=new ImageView(menuTextImage);
        menuTextImageView.relocate(175,563.495);
        primaryStage.setFullScreen(true);
        menuTextImageView.setFitHeight(40);
        menuTextImageView.setFitWidth(70);

        Circle menuCircle=new Circle(80,800,0);
        menuCircle.setOpacity(0.8);
        menuCircle.setFill(Color.rgb(216,218,34));

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
                rootMissionSelectionView.getChildren().removeAll(menuTextImageView,optionImageView,continueImageView,restartImageView1);
                KeyValue continueCircleKey=new KeyValue(continueCircle.radiusProperty(),0);
                KeyFrame continueCircleFrame=new KeyFrame(Duration.seconds(1),continueCircleKey);
                Timeline continueCircleTimeLine=new Timeline(continueCircleFrame);
                continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
                continueCircleTimeLine.play();

                KeyValue mainMenuKey=new KeyValue(mainMenuCircle.radiusProperty(),0);
                KeyFrame mainMenuFrame=new KeyFrame(Duration.seconds(1),mainMenuKey);
                Timeline mainMenuTimeLine=new Timeline(mainMenuFrame);
                mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
                mainMenuTimeLine.play();

                KeyValue restartCircleKey=new KeyValue(restartCircle.radiusProperty(),0);
                KeyFrame restartCircleFrame=new KeyFrame(Duration.seconds(1),restartCircleKey);
                Timeline restartCircleTimeLine=new Timeline(restartCircleFrame);
                restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
                restartCircleTimeLine.play();

                KeyValue mapCircleKey=new KeyValue(mapCircle.radiusProperty(),0);
                KeyFrame mapCircleFrame=new KeyFrame(Duration.seconds(1),mapCircleKey);
                Timeline mapCircleTimeLine=new Timeline(mapCircleFrame);
                mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
                mapCircleTimeLine.play();


                //PlayBubbleSound();

                KeyValue x=new KeyValue(menuCircle.radiusProperty(),0);
                KeyFrame keyFrame=new KeyFrame(Duration.millis(500),x);
                Timeline timeline=new Timeline(keyFrame);
                timeline.getKeyFrames().addAll(keyFrame);
                timeline.play();
            }
        });

        rootMissionSelectionView.getChildren().addAll(menuCircle,continueCircle,mainMenuCircle,restartCircle,mapCircle);

        File menuFile=new File("Data\\Click\\Menu.png");
        Image menuImage1=new Image(menuFile.toURI().toString());
        ImageView MenuView=new ImageView(menuImage1);
        MenuView.relocate(30,750);
        MenuView.setFitHeight(100);
        MenuView.setFitWidth(100);
        MenuView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rootMissionSelectionView.getChildren().addAll(menuTextImageView,optionImageView,continueImageView,restartImageView1);

                KeyValue continueCircleKey=new KeyValue(continueCircle.radiusProperty(),60);
                KeyFrame continueCircleFrame=new KeyFrame(Duration.millis(500),continueCircleKey);
                Timeline continueCircleTimeLine=new Timeline(continueCircleFrame);
                continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
                continueCircleTimeLine.play();

                KeyValue mainMenuKey=new KeyValue(mainMenuCircle.radiusProperty(),60);
                KeyFrame mainMenuFrame=new KeyFrame(Duration.millis(500),mainMenuKey);
                Timeline mainMenuTimeLine=new Timeline(mainMenuFrame);
                mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
                mainMenuTimeLine.play();

                KeyValue restartCircleKey=new KeyValue(restartCircle.radiusProperty(),60);
                KeyFrame restartCircleFrame=new KeyFrame(Duration.millis(500),restartCircleKey);
                Timeline restartCircleTimeLine=new Timeline(restartCircleFrame);
                restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
                restartCircleTimeLine.play();

                KeyValue mapCircleKey=new KeyValue(mapCircle.radiusProperty(),60);
                KeyFrame mapCircleFrame=new KeyFrame(Duration.millis(500),mapCircleKey);
                Timeline mapCircleTimeLine=new Timeline(mapCircleFrame);
                mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
                mapCircleTimeLine.play();


                //PlayBubbleSound();

                KeyValue x=new KeyValue(menuCircle.radiusProperty(),2000);
                KeyFrame keyFrame=new KeyFrame(Duration.millis(500),x);
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
        rootMissionSelectionView.getChildren().addAll(MenuView);

    }

    private void AddShopClick(Stage primaryStage) {
        File shopFile = new File("Data\\Mission\\Shop.png");
        Image shopImage = new Image(shopFile.toURI().toString());
        ImageView shopImageView = new ImageView(shopImage);
        shopImageView.relocate(1430 , 760);
        primaryStage.setFullScreen(true);
        shopImageView.setFitHeight(90);
        shopImageView.setFitWidth(90);

        shopImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        shopImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopImageView.relocate(1435 , 765);
                shopImageView.setFitHeight(80);
                shopImageView.setFitWidth(80);
            }
        });

        shopImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopImageView.relocate(1430 , 760);
                shopImageView.setFitHeight(90);
                shopImageView.setFitWidth(90);
            }
        });
        rootMissionSelectionView.getChildren().addAll(shopImageView);
    }

}
