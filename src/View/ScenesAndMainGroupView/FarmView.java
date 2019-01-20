package View.ScenesAndMainGroupView;

import View.View;
import View.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;

public class FarmView extends View {
    private Group rootFarmView=new Group();
    private Scene sceneFarmView=new Scene(rootFarmView,1600,900);

    public FarmView(Stage primaryStage) throws Exception {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {


        AddBackGround(primaryStage);

        ShowMovingCloud();

        AddMovingWell();

        AddMovingWareHouse();

        AddPavement();

        AddBuyItems();

//        AddThreePavementForWorkshop();

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
        menuCircle.setOpacity(0.6);
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

        rootFarmView.getChildren().addAll(MenuView);
    }
    private void AddPavement(){
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
    private void ShowMovingCloud(){
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

    private void AddMovingWell(){
        File wellFile=new File("Data\\Textures\\Service\\Well\\01.png");
        Image wellImage=new Image(wellFile.toURI().toString());
        ImageView wellView=new ImageView(wellImage);
        wellView.relocate(1120,500);
        wellView.setFitHeight(310);
        wellView.setFitWidth(315);
        wellView.setViewport(new Rectangle2D(0,0 , 150, 136));
        wellView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(1115,495);
                wellView.setFitHeight(320);
                wellView.setFitWidth(325);
            }
        });
        wellView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.relocate(1120,500);
                wellView.setFitHeight(310);
                wellView.setFitWidth(315);
            }
        });
        wellView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(wellView,Duration.seconds(1),12,4,0,0,150,136);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        wellView.setViewport(new Rectangle2D(0,0 , 150, 136));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(wellView);
    }
    private void AddMovingWareHouse(){
        File wareHouseFile=new File("Data\\Textures\\Service\\Depot\\01.png");
        Image wareHouseImage=new Image(wareHouseFile.toURI().toString());
        ImageView wareHouseView=new ImageView(wareHouseImage);
        wareHouseView.relocate(500,600);
        wareHouseView.setFitHeight(300);
        wareHouseView.setFitWidth(310);
//        wellView.setViewport(new Rectangle2D(0,0 , 150, 150));
        wareHouseView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.relocate(495,595);
                wareHouseView.setFitHeight(310);
                wareHouseView.setFitWidth(320);
            }
        });
        wareHouseView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.relocate(500,600);
                wareHouseView.setFitHeight(300);
                wareHouseView.setFitWidth(310);
            }
        });
        wareHouseView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
//                PlantGrass(0,0);
//                AddEgg(1,0);
//                AddMilk(2,0);
//                AddWool(3,0);
//                AddEgg(4,0);
//                AddCake(5,0);
//                AddCarnivalDress(6,0);
//                AddFabric(7,0);
//                AddEggPowder(8,0);
//                AddFlouryCake(9,0);
                for(int j=0;j<15;j++) {
                    for (int i = 0; i < 15; i++) {
                        AddEgg(i, j);
                    }
                }

                ShowTruckGoingToCityAndComingBack(5);
                ShowHelicopterToCityAndComingBack(5);


            }
        });
        rootFarmView.getChildren().addAll(wareHouseView);
    }
    private void AddBuyItems(){
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

    private void AddThreePavementForWorkshop(){
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

    private void AddSpinnery(){
        File spinneryFile =new File("Data\\Textures\\Workshops\\Spinnery(Spinnery)\\01.png");
        Image spinneryImage=new Image(spinneryFile.toURI().toString());
        ImageView spinneryView=new ImageView(spinneryImage);
        spinneryView.relocate(100,200);
        spinneryView.setFitHeight(150);
        spinneryView.setFitWidth(150);
        spinneryView.setViewport(new Rectangle2D(0,0 , 130, 106));
        spinneryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.relocate(95,195);
                spinneryView.setFitHeight(160);
                spinneryView.setFitWidth(160);
            }
        });
        spinneryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.relocate(100,200);
                spinneryView.setFitHeight(150);
                spinneryView.setFitWidth(150);
            }
        });
        spinneryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(spinneryView,Duration.seconds(1),12,4,0,0,130,106);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        spinneryView.setViewport(new Rectangle2D(0,0 , 130, 106));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(spinneryView);
    }
    private void AddCakeBakery(){
        File cakeBakeryFile=new File("Data\\Textures\\Workshops\\FlouryCake(Cake Bakery)\\01.png");
        Image cakeBakeryImage=new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw=new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(100,350);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0,0 , 184, 171.5));
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(95,345);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(100,350);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(cakeBakeryVeiw,Duration.seconds(1),12,4,0,0,184,171);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cakeBakeryVeiw.setViewport(new Rectangle2D(0,0 , 184, 171));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(cakeBakeryVeiw);
    }
    private void AddSewingFactory(){
        File sewingFactoryFile =new File("Data\\Textures\\Workshops\\CarnivalDress(Sewing Factory)\\01.png");
        Image sewingFactoryImage=new Image(sewingFactoryFile.toURI().toString());
        ImageView sewingFactoryView=new ImageView(sewingFactoryImage);
        sewingFactoryView.relocate(100,500);
        sewingFactoryView.setFitHeight(150);
        sewingFactoryView.setFitWidth(150);
        sewingFactoryView.setViewport(new Rectangle2D(0,0 , 170, 130));
        sewingFactoryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.relocate(95,495);
                sewingFactoryView.setFitHeight(160);
                sewingFactoryView.setFitWidth(160);
            }
        });
        sewingFactoryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.relocate(100,500);
                sewingFactoryView.setFitHeight(150);
                sewingFactoryView.setFitWidth(150);
            }
        });
        sewingFactoryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(sewingFactoryView,Duration.seconds(1),12,4,0,0,170,130);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        sewingFactoryView.setViewport(new Rectangle2D(0,0 , 170, 130));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(sewingFactoryView);
    }

    private void AddWeavingFactory(){
        File WeavingFile =new File("Data\\Textures\\Workshops\\Weaving(Weaving Factory)\\01.png");
        Image WeavingImage=new Image(WeavingFile.toURI().toString());
        ImageView WeavingView=new ImageView(WeavingImage);
        WeavingView.relocate(1000,200);
        WeavingView.setFitHeight(150);
        WeavingView.setFitWidth(150);
        WeavingView.setViewport(new Rectangle2D(0,0 , 166, 116));
        WeavingView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WeavingView.relocate(995,195);
                WeavingView.setFitHeight(160);
                WeavingView.setFitWidth(160);
            }
        });
        WeavingView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WeavingView.relocate(1000,200);
                WeavingView.setFitHeight(150);
                WeavingView.setFitWidth(150);
            }
        });
        WeavingView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(WeavingView,Duration.seconds(1),12,4,0,0,166,116);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        WeavingView.setViewport(new Rectangle2D(0,0 , 166, 116));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(WeavingView);
    }
    private void AddCookieBakery(){
        File cakeBakeryFile=new File("Data\\Textures\\Workshops\\Cake(Cookie Bakery)\\01.png");
        Image cakeBakeryImage=new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw=new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(1000,350);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0,0 , 134, 142));
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(995,345);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(1000,350);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(cakeBakeryVeiw,Duration.seconds(1),12,4,0,0,134,142);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cakeBakeryVeiw.setViewport(new Rectangle2D(0,0 , 134, 142));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(cakeBakeryVeiw);
    }
    private void AddEggPowderPlant(){
        File cakeBakeryFile=new File("Data\\Textures\\Workshops\\DriedEggs(Egg Powder Plant)\\01.png");
        Image cakeBakeryImage=new Image(cakeBakeryFile.toURI().toString());
        ImageView cakeBakeryVeiw=new ImageView(cakeBakeryImage);
        cakeBakeryVeiw.relocate(1000,500);
        cakeBakeryVeiw.setFitHeight(150);
        cakeBakeryVeiw.setFitWidth(150);
        cakeBakeryVeiw.setViewport(new Rectangle2D(0,0 , 128, 114));
        cakeBakeryVeiw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(995,495);
                cakeBakeryVeiw.setFitHeight(160);
                cakeBakeryVeiw.setFitWidth(160);
            }
        });
        cakeBakeryVeiw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryVeiw.relocate(1000,500);
                cakeBakeryVeiw.setFitHeight(150);
                cakeBakeryVeiw.setFitWidth(150);
            }
        });
        cakeBakeryVeiw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayBubbleSound();
                //we have ifs here
                Animation animation=new SpriteAnimation(cakeBakeryVeiw,Duration.seconds(1),12,4,0,0,128,114);
                animation.setCycleCount(3);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cakeBakeryVeiw.setViewport(new Rectangle2D(0,0 , 128, 114));
                    }
                });
                animation.setDelay(Duration.millis(83));
                animation.play();
            }
        });
        rootFarmView.getChildren().addAll(cakeBakeryVeiw);
    }

    private void AddCustomWorkShop(){}

    private void AddTruck(){
        File truckFile=new File("Data\\Textures\\Service\\Truck\\01.png");
        Image truckImage=new Image(truckFile.toURI().toString());
        ImageView truckView=new ImageView(truckImage);
        truckView.relocate(880,620);
        truckView.setFitHeight(200);
        truckView.setFitWidth(200);
        truckView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                truckView.relocate(875,615);
                truckView.setFitHeight(210);
                truckView.setFitWidth(210);
            }
        });
        truckView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                truckView.relocate(880,620);
                truckView.setFitHeight(200);
                truckView.setFitWidth(200);
            }
        });
        rootFarmView.getChildren().addAll(truckView);
    }
    private void ShowTruckGoingToCityAndComingBack(int sec){
        File truckFile =new File("Data\\Textures\\UI\\Truck\\01_mini.png");
        Image truckImage=new Image(truckFile.toURI().toString());
        ImageView truckView=new ImageView(truckImage);
        truckView.relocate(980,75);
        truckView.setFitHeight(80);
        truckView.setFitWidth(80);
        truckView.setViewport(new Rectangle2D(0,0 , 48, 48));
        truckView.setScaleX(-1);

        KeyValue xForGoing=new KeyValue(truckView.xProperty(),500);

        KeyFrame going=new KeyFrame(Duration.millis(sec*1000),xForGoing);
        Timeline timeLineGoing=new Timeline(going);
        timeLineGoing.getKeyFrames().addAll(going);
        timeLineGoing.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                truckView.setScaleX(1);
                KeyValue xForComing=new KeyValue(truckView.xProperty(),0);
                KeyFrame coming=new KeyFrame(Duration.millis(sec*1000),xForComing);
                Timeline timeLineComing=new Timeline(coming);
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


        truckView.setViewport(new Rectangle2D(0,0 , 48, 48));

        Animation animation=new SpriteAnimation(truckView,Duration.millis(100),2,2,0,0,48,48);
        animation.setCycleCount(100000);
        animation.play();

        rootFarmView.getChildren().addAll(truckView);
    }
    private void AddHelicopter(){
        File helicopterFile=new File("Data\\Textures\\Service\\Helicopter\\01.png");
        Image helicopterImage=new Image(helicopterFile.toURI().toString());
        ImageView helicopterView=new ImageView(helicopterImage);
        helicopterView.relocate(250,600);
        helicopterView.setFitHeight(200);
        helicopterView.setFitWidth(200);
        helicopterView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helicopterView.relocate(245,595);
                helicopterView.setFitHeight(210);
                helicopterView.setFitWidth(210);
            }
        });
        helicopterView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helicopterView.relocate(250,600);
                helicopterView.setFitHeight(200);
                helicopterView.setFitWidth(200);
            }
        });
        rootFarmView.getChildren().addAll(helicopterView);
    }
    private void ShowHelicopterToCityAndComingBack(int sec){
        File helicopterFile =new File("Data\\Textures\\UI\\Helicopter\\01_mini.png");
        Image helicopterImage=new Image(helicopterFile.toURI().toString());
        ImageView helicopterView=new ImageView(helicopterImage);
        helicopterView.relocate(980,20);
        helicopterView.setFitHeight(80);
        helicopterView.setFitWidth(80);
        helicopterView.setViewport(new Rectangle2D(0,0 , 48, 48));
        helicopterView.setScaleX(-1);

        KeyValue xForGoing=new KeyValue(helicopterView.xProperty(),500);

        KeyFrame going=new KeyFrame(Duration.millis(sec*1000),xForGoing);
        Timeline timeLineGoing=new Timeline(going);
        timeLineGoing.getKeyFrames().addAll(going);
        timeLineGoing.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                helicopterView.setScaleX(1);
                KeyValue xForComing=new KeyValue(helicopterView.xProperty(),0);
                KeyFrame coming=new KeyFrame(Duration.millis(sec*1000),xForComing);
                Timeline timeLineComing=new Timeline(coming);
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

        helicopterView.setViewport(new Rectangle2D(0,0 , 48, 48));

        Animation animation=new SpriteAnimation(helicopterView,Duration.millis(100),6,3,0,0,48,48);
        animation.setCycleCount(100000);
        animation.play();

        rootFarmView.getChildren().addAll(helicopterView);
    }

    private void AddLookingGIf(){
        File chickenFile=new File("Data\\Gif\\LookingChicken.gif");
        Image chickenImage=new Image(chickenFile.toURI().toString());
        ImageView LookingChickenImage=new ImageView(chickenImage);
        LookingChickenImage.relocate(1150,250);
        LookingChickenImage.setFitHeight(180);
        LookingChickenImage.setFitWidth(180);

        rootFarmView.getChildren().addAll(LookingChickenImage);
    }
    private void AddRectangleForPosition(){
        Rectangle rectangle=new Rectangle(650,410);
        rectangle.relocate(320 ,205);
        rootFarmView.getChildren().addAll(rectangle);
    }

    private void PlantGrass(int xCell,int yCell){
        PlayBubbleSound();
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File spinneryFile =new File("Data\\Textures\\Grass\\grass1.png");
        Image spinneryImage=new Image(spinneryFile.toURI().toString());
        ImageView spinneryView=new ImageView(spinneryImage);
        spinneryView.relocate(xPosition,yPosition);
        spinneryView.setFitHeight(48);
        spinneryView.setFitWidth(48);
        spinneryView.setViewport(new Rectangle2D(0,0 , 48, 48));

        Animation animation=new SpriteAnimation(spinneryView,Duration.millis(500),12,4,0,0,48,48);
        animation.play();
        rootFarmView.getChildren().addAll(spinneryView);
    }
    private void AddEgg(int xCell, int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File eggFile =new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image eggImage=new Image(eggFile.toURI().toString());
        ImageView eggView=new ImageView(eggImage);
        eggView.relocate(xPosition,yPosition);
        eggView.setFitHeight(27);
        eggView.setFitWidth(20);
        rootFarmView.getChildren().addAll(eggView);
        eggView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggView.relocate(xPosition-2,yPosition-2);
                eggView.setFitHeight(32);
                eggView.setFitWidth(25);
            }
        });

        eggView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggView.relocate(xPosition,yPosition);
                eggView.setFitHeight(27);
                eggView.setFitWidth(20);
            }
        });
    }
    private void AddMilk(int xCell,int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];


        File milkFile =new File("Data\\Textures\\Products\\Milk.png");
        Image milkImage=new Image(milkFile.toURI().toString());
        ImageView milkView=new ImageView(milkImage);
        milkView.relocate(xPosition,yPosition);
        milkView.setFitHeight(27);
        milkView.setFitWidth(43);
        rootFarmView.getChildren().addAll(milkView);
        milkView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                milkView.relocate(xPosition-2,yPosition-2);
                milkView.setFitHeight(32);
                milkView.setFitWidth(48);
            }
        });

        milkView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                milkView.relocate(xPosition,yPosition);
                milkView.setFitHeight(27);
                milkView.setFitWidth(43);
            }
        });
    }
    private void AddWool(int xCell,int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File woolFile =new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image woolImage=new Image(woolFile.toURI().toString());
        ImageView woolView=new ImageView(woolImage);
        woolView.relocate(xPosition,yPosition);
        woolView.setFitHeight(27);
        woolView.setFitWidth(40);
        rootFarmView.getChildren().addAll(woolView);
        woolView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                woolView.relocate(xPosition-2,yPosition-2);
                woolView.setFitHeight(32);
                woolView.setFitWidth(45);
            }
        });

        woolView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                woolView.relocate(xPosition,yPosition);
                woolView.setFitHeight(27);
                woolView.setFitWidth(40);
            }
        });
    }

    private void AddEggPowder(int xCell, int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File eggPodwerFile =new File("Data\\Textures\\Products\\EggPowder.png");
        Image eggPowderImage=new Image(eggPodwerFile.toURI().toString());
        ImageView eggPowderView=new ImageView(eggPowderImage);
        eggPowderView.relocate(xPosition,yPosition);
        eggPowderView.setFitHeight(27);
        eggPowderView.setFitWidth(40);
        rootFarmView.getChildren().addAll(eggPowderView);
        eggPowderView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderView.relocate(xPosition-2,yPosition-2);
                eggPowderView.setFitHeight(32);
                eggPowderView.setFitWidth(45);
            }
        });

        eggPowderView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderView.relocate(xPosition,yPosition);
                eggPowderView.setFitHeight(27);
                eggPowderView.setFitWidth(40);
            }
        });
    }
    private void AddCarnivalDress(int xCell,int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File carnivalDressFile =new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image carnivalDressImage=new Image(carnivalDressFile.toURI().toString());
        ImageView carnivalDressView=new ImageView(carnivalDressImage);
        carnivalDressView.relocate(xPosition,yPosition);
        carnivalDressView.setFitHeight(27);
        carnivalDressView.setFitWidth(40);
        rootFarmView.getChildren().addAll(carnivalDressView);
        carnivalDressView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                carnivalDressView.relocate(xPosition-2,yPosition-2);
                carnivalDressView.setFitHeight(32);
                carnivalDressView.setFitWidth(45);
            }
        });

        carnivalDressView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                carnivalDressView.relocate(xPosition,yPosition);
                carnivalDressView.setFitHeight(27);
                carnivalDressView.setFitWidth(40);
            }
        });
    }
    private void AddCake(int xCell,int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File cakeFile =new File("Data\\Textures\\Products\\Cake.png");
        Image cakeImage=new Image(cakeFile.toURI().toString());
        ImageView cakeView=new ImageView(cakeImage);
        cakeView.relocate(xPosition,yPosition);
        cakeView.setFitHeight(27);
        cakeView.setFitWidth(40);
        rootFarmView.getChildren().addAll(cakeView);
        cakeView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeView.relocate(xPosition-2,yPosition-2);
                cakeView.setFitHeight(32);
                cakeView.setFitWidth(45);
            }
        });

        cakeView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeView.relocate(xPosition,yPosition);
                cakeView.setFitHeight(27);
                cakeView.setFitWidth(40);
            }
        });
    }
    private void AddFabric(int xCell,int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File fabricFile =new File("Data\\Textures\\Products\\Fabric.png");
        Image fabricImage=new Image(fabricFile.toURI().toString());
        ImageView fabricView=new ImageView(fabricImage);
        fabricView.relocate(xPosition,yPosition);
        fabricView.setFitHeight(27);
        fabricView.setFitWidth(40);
        rootFarmView.getChildren().addAll(fabricView);
        fabricView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fabricView.relocate(xPosition-2,yPosition-2);
                fabricView.setFitHeight(32);
                fabricView.setFitWidth(45);
            }
        });

        fabricView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fabricView.relocate(xPosition,yPosition);
                fabricView.setFitHeight(27);
                fabricView.setFitWidth(40);
            }
        });
    }
    private void AddFlouryCake(int xCell,int yCell){
        int[] position=getPositionByCellPosition(xCell,yCell);
        int xPosition=position[0];
        int yPosition=position[1];

        File fabricFile =new File("Data\\Textures\\Products\\FlouryCake.png");
        Image fabricImage=new Image(fabricFile.toURI().toString());
        ImageView fabricView=new ImageView(fabricImage);
        fabricView.relocate(xPosition,yPosition);
        fabricView.setFitHeight(27);
        fabricView.setFitWidth(40);
        rootFarmView.getChildren().addAll(fabricView);
        fabricView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fabricView.relocate(xPosition-2,yPosition-2);
                fabricView.setFitHeight(32);
                fabricView.setFitWidth(45);
            }
        });

        fabricView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fabricView.relocate(xPosition,yPosition);
                fabricView.setFitHeight(27);
                fabricView.setFitWidth(40);
            }
        });
    }

    private void AnimationForChicken(int x1,int xy1,int x2,int y2){}

    private static int[] getCellPositionByPosition(int x,int y){
        int[] position=new int[2];
        int standardX=x-330;
        int standardY=y-230;
        boolean isXSet=false;
        boolean isYSet=false;
        for(int i=0;i<14;i++){
            if(i*43.33333<standardX && standardX<(i+1)*43.33333){
                position[0]=i;
                isXSet=true;
            }
            if(i*27.33333<standardY && standardY<(i+1)*27.33333){
                position[1]=i;
                isYSet=true;
            }
            if(isXSet && isYSet){
                return position;
            }
        }
        return position;
    }

    private static int[] getPositionByCellPosition(int xCell,int yCell){
        int[] position=new int[2];
        position[0]=(int)(320+(xCell+0.5)*43.33333);
        position[1]=(int)(205+(yCell+0.5)*27.33333);
        return position;
    }

}
