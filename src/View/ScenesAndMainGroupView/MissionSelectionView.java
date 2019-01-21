package View.ScenesAndMainGroupView;//package View.ScenesAndMainGroupView;
//
//import View.View;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import java.io.File;
//
//public class MissionSelectionView extends View {
//    private Group rootMissionSelectionView = new Group();
//    private Scene sceneSelectionView = new Scene(rootMissionSelectionView, 1600, 900);
//
//    public MissionSelectionView(Stage primaryStage) {
//        Start(primaryStage);
//    }
//
//    @Override
//    public void Start(Stage primaryStage) {
//
//    }
//
//    private void AddBackGround(Stage primaryStage) {
//        File backGroundFile = new File("Data\\Mission\\mapofmission.jpg");
//        Image backGroundImage = new Image(backGroundFile.toURI().toString());
//        ImageView BackGroundView = new ImageView(backGroundImage);
//        primaryStage.setFullScreen(true);
//        BackGroundView.setFitHeight(870);
//        BackGroundView.setFitWidth(1540);
//        rootMissionSelectionView.getChildren().addAll(BackGroundView);
//    }
//

//
//    private void AddMenuClick(Stage primaryStage) {
//        File restartFile1=new File("Data\\MenuClick\\Restart.png");
//        Image restartImage1=new Image(restartFile1.toURI().toString());
//        ImageView restartImageView1=new ImageView(restartImage1);
//        restartImageView1.relocate(266,655);
//        primaryStage.setFullScreen(true);
//        restartImageView1.setFitHeight(40);
//        restartImageView1.setFitWidth(60);
//
//        File continueFile=new File("Data\\MenuClick\\Continue.png");
//        Image continueImage=new Image(continueFile .toURI().toString());
//        ImageView continueImageView=new ImageView(continueImage);
//        continueImageView.relocate(50,530);
//        primaryStage.setFullScreen(true);
//        continueImageView.setFitHeight(40);
//        continueImageView.setFitWidth(60);
//
//        File mapFile=new File("Data\\MenuClick\\Map.png");
//        Image optionImage=new Image(mapFile.toURI().toString());
//        ImageView optionImageView=new ImageView(optionImage);
//        optionImageView.relocate(300,780);
//        primaryStage.setFullScreen(true);
//        optionImageView.setFitHeight(30);
//        optionImageView.setFitWidth(50);
//
//        File menuTextFile=new File("Data\\MenuClick\\MainMenu.png");
//        Image menuTextImage=new Image(menuTextFile.toURI().toString());
//        ImageView menuTextImageView=new ImageView(menuTextImage);
//        menuTextImageView.relocate(175,563.495);
//        primaryStage.setFullScreen(true);
//        menuTextImageView.setFitHeight(40);
//        menuTextImageView.setFitWidth(70);
//
//        Circle menuCircle=new Circle(80,800,0);
//        menuCircle.setOpacity(0.8);
//        menuCircle.setFill(Color.rgb(216,218,34));
//
//        Circle mainMenuCircle=new Circle(205,583.495,0);
//        mainMenuCircle.setOpacity(0.6);
//        mainMenuCircle.setFill(Color.rgb(64,45,67));
//        mainMenuCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                mainMenuCircle.setOpacity(0.8);
//            }
//        });
//        mainMenuCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                mainMenuCircle.setOpacity(0.6);
//            }
//        });
//        mainMenuCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//            }
//        });
//
//        Circle restartCircle =new Circle(296.505,675,0);
//        restartCircle.setOpacity(0.6);
//        restartCircle.setFill(Color.rgb(64,45,67));
//        restartCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                restartCircle.setOpacity(0.8);
//            }
//        });
//        restartCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                restartCircle.setOpacity(0.6);
//            }
//        });
//        restartCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//            }
//        });
//
//        Circle mapCircle =new Circle(330,800,0);
//        mapCircle.setOpacity(0.6);
//        mapCircle.setFill(Color.rgb(64,45,67));
//        mapCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                mapCircle.setOpacity(0.8);
//            }
//        });
//        mapCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                mapCircle.setOpacity(0.6);
//            }
//        });
//        restartCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//            }
//        });
//
//        Circle continueCircle=new Circle(80,550,0);
//        continueCircle.setOpacity(0.6);
//        continueCircle.setFill(Color.rgb(64,45,67));
//        continueCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                continueCircle.setOpacity(0.8);
//            }
//        });
//        continueCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                continueCircle.setOpacity(0.6);
//            }
//        });
//        continueCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                rootMissionSelectionView.getChildren().removeAll(menuTextImageView,optionImageView,continueImageView,restartImageView1);
//                KeyValue continueCircleKey=new KeyValue(continueCircle.radiusProperty(),0);
//                KeyFrame continueCircleFrame=new KeyFrame(Duration.seconds(1),continueCircleKey);
//                Timeline continueCircleTimeLine=new Timeline(continueCircleFrame);
//                continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
//                continueCircleTimeLine.play();
//
//                KeyValue mainMenuKey=new KeyValue(mainMenuCircle.radiusProperty(),0);
//                KeyFrame mainMenuFrame=new KeyFrame(Duration.seconds(1),mainMenuKey);
//                Timeline mainMenuTimeLine=new Timeline(mainMenuFrame);
//                mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
//                mainMenuTimeLine.play();
//
//                KeyValue restartCircleKey=new KeyValue(restartCircle.radiusProperty(),0);
//                KeyFrame restartCircleFrame=new KeyFrame(Duration.seconds(1),restartCircleKey);
//                Timeline restartCircleTimeLine=new Timeline(restartCircleFrame);
//                restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
//                restartCircleTimeLine.play();
//
//                KeyValue mapCircleKey=new KeyValue(mapCircle.radiusProperty(),0);
//                KeyFrame mapCircleFrame=new KeyFrame(Duration.seconds(1),mapCircleKey);
//                Timeline mapCircleTimeLine=new Timeline(mapCircleFrame);
//                mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
//                mapCircleTimeLine.play();
//
//
//                //PlayBubbleSound();
//
//                KeyValue x=new KeyValue(menuCircle.radiusProperty(),0);
//                KeyFrame keyFrame=new KeyFrame(Duration.millis(500),x);
//                Timeline timeline=new Timeline(keyFrame);
//                timeline.getKeyFrames().addAll(keyFrame);
//                timeline.play();
//            }
//        });
//
//        rootMissionSelectionView.getChildren().addAll(menuCircle,continueCircle,mainMenuCircle,restartCircle,mapCircle);
//
//        File menuFile=new File("Data\\Click\\Menu.png");
//        Image menuImage1=new Image(menuFile.toURI().toString());
//        ImageView MenuView=new ImageView(menuImage1);
//        MenuView.relocate(30,750);
//        MenuView.setFitHeight(100);
//        MenuView.setFitWidth(100);
//        MenuView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                rootMissionSelectionView.getChildren().addAll(menuTextImageView,optionImageView,continueImageView,restartImageView1);
//
//                KeyValue continueCircleKey=new KeyValue(continueCircle.radiusProperty(),60);
//                KeyFrame continueCircleFrame=new KeyFrame(Duration.millis(500),continueCircleKey);
//                Timeline continueCircleTimeLine=new Timeline(continueCircleFrame);
//                continueCircleTimeLine.getKeyFrames().addAll(continueCircleFrame);
//                continueCircleTimeLine.play();
//
//                KeyValue mainMenuKey=new KeyValue(mainMenuCircle.radiusProperty(),60);
//                KeyFrame mainMenuFrame=new KeyFrame(Duration.millis(500),mainMenuKey);
//                Timeline mainMenuTimeLine=new Timeline(mainMenuFrame);
//                mainMenuTimeLine.getKeyFrames().addAll(mainMenuFrame);
//                mainMenuTimeLine.play();
//
//                KeyValue restartCircleKey=new KeyValue(restartCircle.radiusProperty(),60);
//                KeyFrame restartCircleFrame=new KeyFrame(Duration.millis(500),restartCircleKey);
//                Timeline restartCircleTimeLine=new Timeline(restartCircleFrame);
//                restartCircleTimeLine.getKeyFrames().addAll(restartCircleFrame);
//                restartCircleTimeLine.play();
//
//                KeyValue mapCircleKey=new KeyValue(mapCircle.radiusProperty(),60);
//                KeyFrame mapCircleFrame=new KeyFrame(Duration.millis(500),mapCircleKey);
//                Timeline mapCircleTimeLine=new Timeline(mapCircleFrame);
//                mapCircleTimeLine.getKeyFrames().addAll(mapCircleFrame);
//                mapCircleTimeLine.play();
//
//
//                //PlayBubbleSound();
//
//                KeyValue x=new KeyValue(menuCircle.radiusProperty(),2000);
//                KeyFrame keyFrame=new KeyFrame(Duration.millis(500),x);
//                Timeline timeline=new Timeline(keyFrame);
//                timeline.getKeyFrames().addAll(keyFrame);
//                timeline.play();
//
//            }
//        });
//        MenuView.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                MenuView.relocate(35,755);
//                MenuView.setFitHeight(90);
//                MenuView.setFitWidth(90);
//            }
//        });
//        MenuView.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                MenuView.relocate(30,750);
//                MenuView.setFitHeight(100);
//                MenuView.setFitWidth(100);
//            }
//        });
//        rootMissionSelectionView.getChildren().addAll(MenuView);
//
//    }
//
//    private void AddShopClick(Stage primaryStage) {
//        File shopFile = new File("Data\\Mission\\Shop.png");
//        Image shopImage = new Image(shopFile.toURI().toString());
//        ImageView shopImageView = new ImageView(shopImage);
//        shopImageView.relocate(1430 , 760);
//        primaryStage.setFullScreen(true);
//        shopImageView.setFitHeight(90);
//        shopImageView.setFitWidth(90);
//
//        shopImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//            }
//        });
//
//        shopImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                shopImageView.relocate(1435 , 765);
//                shopImageView.setFitHeight(80);
//                shopImageView.setFitWidth(80);
//            }
//        });
//
//        shopImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                shopImageView.relocate(1430 , 760);
//                shopImageView.setFitHeight(90);
//                shopImageView.setFitWidth(90);
//            }
//        });
//        rootMissionSelectionView.getChildren().addAll(shopImageView);
//    }
//
//}

import View.View;
import javafx.application.Application;
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

    public MissionSelectionView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddItem(primaryStage);
//        AddBubble(1025, 820);
//        AddBubble(1075, 650);
//        AddBubble(1200, 500);
        BeachOfMission(primaryStage);
        NumberOfMission(primaryStage);
        FarmerOfFarm(primaryStage);

    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\MissionBackGround.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(1100);
        BackGroundView.setFitWidth(2000);
        rootMissionSelectionView.getChildren().addAll(BackGroundView);
        primaryStage.setScene(sceneSelectionView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddItem(Stage primaryStage) {
        File menuButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image menuButtonImage = new Image(menuButton.toURI().toString());
        ImageView menuButtonView = new ImageView(menuButtonImage);
        menuButtonView.setFitHeight(75);
        menuButtonView.setFitWidth(150);
        menuButtonView.relocate(1760, 990);
        menuButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.relocate(1755, 985);
                menuButtonView.setFitHeight(85);
                menuButtonView.setFitWidth(160);
            }
        });
        menuButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.setFitHeight(75);
                menuButtonView.setFitWidth(150);
                menuButtonView.relocate(1760, 990);
            }
        });
        rootMissionSelectionView.getChildren().addAll(menuButtonView);


        File shopButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image shopButtonImage = new Image(shopButton.toURI().toString());
        ImageView shopButtonView = new ImageView(shopButtonImage);
        shopButtonView.setFitHeight(75);
        shopButtonView.setFitWidth(150);
        shopButtonView.relocate(15, 990);
        shopButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.relocate(10, 985);
                shopButtonView.setFitHeight(85);
                shopButtonView.setFitWidth(160);
            }
        });
        shopButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.setFitHeight(75);
                shopButtonView.setFitWidth(150);
                shopButtonView.relocate(15, 990);
            }
        });
        rootMissionSelectionView.getChildren().addAll(shopButtonView);

        File shopText = new File("Data\\Textures\\Service\\ShopText.png");
        Image shopTextImage = new Image(shopText.toURI().toString());
        ImageView shopTextView = new ImageView(shopTextImage);
        shopTextView.setFitHeight(50);
        shopTextView.setFitWidth(100);
        shopTextView.relocate(40, 1005);
        shopTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.relocate(10, 985);
                shopButtonView.setFitHeight(85);
                shopButtonView.setFitWidth(160);
            }
        });
        shopTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.setFitHeight(75);
                shopButtonView.setFitWidth(150);
                shopButtonView.relocate(15, 990);
            }
        });
        rootMissionSelectionView.getChildren().addAll(shopTextView);

        File menuText = new File("Data\\Textures\\Service\\MenuText.png");
        Image menuTextImage = new Image(menuText.toURI().toString());
        ImageView menuTextView = new ImageView(menuTextImage);
        menuTextView.setFitHeight(50);
        menuTextView.setFitWidth(100);
        menuTextView.relocate(1785, 1005);
        menuTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.relocate(1755, 985);
                menuButtonView.setFitHeight(85);
                menuButtonView.setFitWidth(160);
            }
        });
        menuTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.setFitHeight(75);
                menuButtonView.setFitWidth(150);
                menuButtonView.relocate(1760, 990);
            }
        });
        rootMissionSelectionView.getChildren().addAll(menuTextView);
    }

    private void AddBubble(int x, int y) {

//        File bubble = new File("Data\\Bubble.png");
//        Image bubbleImage = new Image(bubble.toURI().toString());
//        ImageView bubbleView = new ImageView(bubbleImage);
//        bubbleView.setFitHeight(80);
//        bubbleView.setFitWidth(80);
//        bubbleView.relocate(x, y);
//        bubbleView.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                bubbleView.relocate(x - 5, y - 5);
//                bubbleView.setFitHeight(90);
//                bubbleView.setFitWidth(90);
//            }
//        });
//        bubbleView.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                bubbleView.setFitHeight(80);
//                bubbleView.setFitWidth(80);
//                bubbleView.relocate(x, y);
//            }
//        });
//        rootMissionSelectionView.getChildren().addAll(bubbleView);


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
        farmerImageView.setFitHeight(230);
        farmerImageView.setFitWidth(90);
        rootMissionSelectionView.getChildren().addAll(farmerImageView);
        primaryStage.show();
    }

    private void NumberOfMission(Stage primaryStage) {
        File numberFile = new File("Data\\Mission\\hob.png");
        Image numberImage = new Image(numberFile.toURI().toString());
        //ImageView numberImageView = new ImageView(numberImage);
        ImageView[] numberImageView = new ImageView[10];
        for (int i = 20; i < 30; i++) {
            numberImageView[i - 20] = new ImageView(numberImage);
            numberImageView[i - 20].relocate(1300 - 300 * Math.cos(i * 3.14 / 11), 550 - 300 * Math.sin(i * 3.14 / 11));
            primaryStage.setFullScreen(true);
            numberImageView[i - 20].setFitWidth(50);
            numberImageView[i - 20].setFitHeight(50);
            rootMissionSelectionView.getChildren().addAll(numberImageView[i - 20]);
        }
        try {
            for (int i = 20; i < 30; i++) {
                final int ai = i;
                numberImageView[ai - 20].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                    }
                });

                numberImageView[ai - 20].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        numberImageView[ai - 20].relocate(1300 - 300 * Math.cos(ai * 3.14 / 11) + 5, 550 - 300 * Math.sin(ai * 3.14 / 11) + 5);
                        numberImageView[ai - 20].setFitWidth(40);
                        numberImageView[ai - 20].setFitHeight(40);
                    }
                });
                numberImageView[ai - 20].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        numberImageView[ai - 20].relocate(1300 - 300 * Math.cos(ai * 3.14 / 11), 550 - 300 * Math.sin(ai * 3.14 / 11));
                        numberImageView[ai - 20].setFitWidth(50);
                        numberImageView[ai - 20].setFitHeight(50);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}