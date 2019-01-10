package View.ScenesAndMainGroupView;

import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

        AddMovingWell(primaryStage);

        AddMovingWareHouse(primaryStage);

        AddPavement(primaryStage);

        AddBuyItems(primaryStage);

        AddThreePavementForWorkshop(primaryStage);

        AddMenuClick(primaryStage);

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
        File restartFile=new File("Data\\MenuClick\\Restart.png");
        Image restartImage=new Image(restartFile.toURI().toString());
        ImageView restartImageView=new ImageView(restartImage);
        restartImageView.relocate(266,655);
        primaryStage.setFullScreen(true);
        restartImageView.setFitHeight(40);
        restartImageView.setFitWidth(60);

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
                rootFarmView.getChildren().removeAll(menuTextImageView,optionImageView,continueImageView,restartImageView);
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


                PlayBubbleSound();

                KeyValue x=new KeyValue(menuCircle.radiusProperty(),0);
                KeyFrame keyFrame=new KeyFrame(Duration.millis(500),x);
                Timeline timeline=new Timeline(keyFrame);
                timeline.getKeyFrames().addAll(keyFrame);
                timeline.play();
            }
        });

        rootFarmView.getChildren().addAll(menuCircle,continueCircle,mainMenuCircle,restartCircle,mapCircle);

        File menuFile=new File("Data\\Click\\Menu.png");
        Image menuImage=new Image(menuFile.toURI().toString());
        ImageView MenuView=new ImageView(menuImage);
        MenuView.relocate(30,750);
        MenuView.setFitHeight(100);
        MenuView.setFitWidth(100);
        MenuView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rootFarmView.getChildren().addAll(menuTextImageView,optionImageView,continueImageView,restartImageView);

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


                PlayBubbleSound();

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

    private void AddMovingWell(Stage primaryStage){
        File wellFile=new File("Data\\Textures\\Service\\Well\\01.png");
        Image wellImage=new Image(wellFile.toURI().toString());
        ImageView wellView=new ImageView(wellImage);
        wellView.relocate(-38,68);
        wellView.setFitHeight(310);
        wellView.setFitWidth(315);
        wellView.setViewport(new Rectangle2D(0,0 , 150, 150));
        wellView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(-34,76);
                wellView.setFitHeight(298);
                wellView.setFitWidth(308);
            }
        });
        wellView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(-38,68);
                wellView.setFitHeight(310);
                wellView.setFitWidth(315);
            }
        });
        wellView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //ifs
//                SpriteAnimation spriteAnimation=new SpriteAnimation(wellView,Duration.seconds(10),1,2,100,100,150,150);
//                spriteAnimation.interpolate(2);

            }
        });
        rootFarmView.getChildren().addAll(wellView);
    }

    private void AddMovingWareHouse(Stage primaryStage){
        File wareHouseFile=new File("Data\\Textures\\Service\\Depot\\01.png");
        Image wareHouseImage=new Image(wareHouseFile.toURI().toString());
        ImageView wareHouseView=new ImageView(wareHouseImage);
        wareHouseView.relocate(500,580);
        wareHouseView.setFitHeight(310);
        wareHouseView.setFitWidth(315);
//        wellView.setViewport(new Rectangle2D(0,0 , 150, 150));
        wareHouseView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.relocate(504,588);
                wareHouseView.setFitHeight(298);
                wareHouseView.setFitWidth(308);
            }
        });
        wareHouseView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.relocate(500,580);
                wareHouseView.setFitHeight(310);
                wareHouseView.setFitWidth(315);
            }
        });
        wareHouseView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //ifs
//                SpriteAnimation spriteAnimation=new SpriteAnimation(wellView,Duration.seconds(10),1,2,100,100,150,150);
//                spriteAnimation.interpolate(2);

            }
        });
        rootFarmView.getChildren().addAll(wareHouseView);
    }

    private void AddPavement(Stage primaryStage){
        File pavementFile=new File("C:Data\\Pavement.png");
        Image pavementImage=new Image(pavementFile.toURI().toString());
        ImageView pavementViewHelicopter=new ImageView(pavementImage);
        pavementViewHelicopter.relocate(190,520);
        pavementViewHelicopter.setFitHeight(500);
        pavementViewHelicopter.setFitWidth(300);

        ImageView pavementViewTruck=new ImageView(pavementImage);
        pavementViewTruck.relocate(825,520);
        pavementViewTruck.setFitHeight(500);
        pavementViewTruck.setFitWidth(300);

        rootFarmView.getChildren().addAll(pavementViewHelicopter,pavementViewTruck);
    }

    private void AddBuyItems(Stage primaryStage){
        Circle chickenCircle=new Circle(1450,270,50,Color.rgb(255,201,0));
        chickenCircle.setOpacity(0.85);
        chickenCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        chickenCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.85);
            }
        });
        chickenCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //some thing ti buy
            }
        });

        Circle shipCircle=new Circle(1450,390,50,Color.rgb(255,201,0));
        shipCircle.setOpacity(0.85);
        shipCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shipCircle.setOpacity(0.95);
            }
        });
        shipCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shipCircle.setOpacity(0.85);
            }
        });
        shipCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //something to by
            }
        });

        Circle cowCircle=new Circle(1450,510,50,Color.rgb(255,201,0));
        cowCircle.setOpacity(0.85);
        cowCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowCircle.setOpacity(0.95);
            }
        });
        cowCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cowCircle.setOpacity(0.85);
            }
        });
        cowCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //something to buy
            }
        });

        Circle catCircle=new Circle(1450,630,50,Color.rgb(255,201,0));
        catCircle.setOpacity(0.85);
        catCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catCircle.setOpacity(0.95);
            }
        });
        catCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catCircle.setOpacity(0.85);
            }
        });
        catCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //something to buy
            }
        });

        Circle dogCircle=new Circle(1450,750,50,Color.rgb(255,201,0));
        dogCircle.setOpacity(0.85);
        dogCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogCircle.setOpacity(0.95);
            }
        });
        dogCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogCircle.setOpacity(0.85);
            }
        });
        dogCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //something to buy
            }
        });

        File chickenFile=new File("Data\\Textures\\BuyIconNotHead\\Chicken.png");
        Image chickenImage=new Image(chickenFile.toURI().toString());
        ImageView chickenView=new ImageView(chickenImage);
        chickenView.relocate(1405,235);
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
                chickenCircle.setOpacity(0.85);
            }
        });
        chickenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //something to buy

            }
        });


        File shipFile=new File("Data\\Textures\\BuyIconNotHead\\Ship.png");
        Image shipImage=new Image(shipFile.toURI().toString());
        ImageView shipView=new ImageView(shipImage);
        shipView.relocate(1408,353);
        shipView.setFitHeight(80);
        shipView.setFitWidth(80);
        shipView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        shipView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.85);
            }
        });
        shipView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        File cowFile=new File("Data\\Textures\\BuyIconNotHead\\Cow.png");
        Image cowImage=new Image(cowFile.toURI().toString());
        ImageView cowView=new ImageView(cowImage);
        cowView.relocate(1412,474);
        cowView.setFitHeight(80);
        cowView.setFitWidth(80);
        cowView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        cowView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.85);
            }
        });
        cowView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        File catFile=new File("Data\\Textures\\BuyIconNotHead\\Cat.png");
        Image catImage=new Image(catFile.toURI().toString());
        ImageView catView=new ImageView(catImage);
        catView.relocate(1408,590);
        catView.setFitHeight(80);
        catView.setFitWidth(80);
        catView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        catView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.85);
            }
        });
        catView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        File dogFile=new File("Data\\Textures\\BuyIconNotHead\\Dog.png");
        Image dogImage=new Image(dogFile.toURI().toString());
        ImageView dogView=new ImageView(dogImage);
        dogView.relocate(1410,703);
        dogView.setFitHeight(90);
        dogView.setFitWidth(80);
        dogView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.95);
            }
        });
        dogView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                chickenCircle.setOpacity(0.85);
            }
        });
        dogView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });


        rootFarmView.getChildren().addAll(chickenCircle,shipCircle,cowCircle,catCircle,dogCircle,chickenView,shipView,cowView,catView,dogView);
    }

    private void AddThreePavementForWorkshop(Stage primaryStage){
        File pavementFile=new File("Data\\WorkShopPavement.png");
        Image pavementImage=new Image(pavementFile.toURI().toString());

        int xDelta=950;
        int yDelta=150;
        int baseX=50;
        int baseY=220;

        ImageView pavementView1=new ImageView(pavementImage);
        pavementView1.relocate(baseX+40,baseY);
        pavementView1.setFitHeight(100);
        pavementView1.setFitWidth(220);

        ImageView pavementView2=new ImageView(pavementImage);
        pavementView2.relocate(baseX+20,baseY+yDelta*1);
        pavementView2.setFitHeight(110);
        pavementView2.setFitWidth(230);

        ImageView pavementView3=new ImageView(pavementImage);
        pavementView3.relocate(baseX,baseY+yDelta*2);
        pavementView3.setFitHeight(120);
        pavementView3.setFitWidth(240);

        ImageView pavementView4=new ImageView(pavementImage);
        pavementView4.relocate(baseX+xDelta-20,baseY);
        pavementView4.setFitHeight(100);
        pavementView4.setFitWidth(220);

        ImageView pavementView5=new ImageView(pavementImage);
        pavementView5.relocate(baseX+xDelta-10,baseY+yDelta);
        pavementView5.setFitHeight(110);
        pavementView5.setFitWidth(230);

        ImageView pavementView6=new ImageView(pavementImage);
        pavementView6.relocate(baseX+xDelta,baseY+yDelta*2);
        pavementView6.setFitHeight(120);
        pavementView6.setFitWidth(240);

        rootFarmView.getChildren().addAll(pavementView1,pavementView2,pavementView3,pavementView4,pavementView5,pavementView6);
    }

}
