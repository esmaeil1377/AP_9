package View.ScenesAndMainGroupView;

import View.View;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

import static javafx.application.Application.launch;

public class GameShopView extends View {
    private Group rootGameShopView =new Group();
    private Scene sceneGameShopView=new Scene(rootGameShopView,1600,900);

    public GameShopView(Stage primaryStage){
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddIcons(primaryStage);
        AddItems();
    }

    private void AddIcons(Stage primaryStage) {


        Rectangle eggPowderPlantRect = new Rectangle(470, 300);
        eggPowderPlantRect.setOpacity(0.6);
        eggPowderPlantRect.setArcHeight(70);
        eggPowderPlantRect.setArcWidth(70);
        eggPowderPlantRect.setFill(Color.rgb(64, 45, 67));
        eggPowderPlantRect.relocate(20, 110);

        Rectangle cookieBakeryRect = new Rectangle(470, 300);
        cookieBakeryRect.setOpacity(0.6);
        cookieBakeryRect.setArcHeight(70);
        cookieBakeryRect.setArcWidth(70);
        cookieBakeryRect.setFill(Color.rgb(64, 45, 67));
        cookieBakeryRect.relocate(500, 110);

        Rectangle cakeBakeryRect = new Rectangle(470, 300);
        cakeBakeryRect.setOpacity(0.6);
        cakeBakeryRect.setArcHeight(70);
        cakeBakeryRect.setArcWidth(70);
        cakeBakeryRect.setFill(Color.rgb(64, 45, 67));
        cakeBakeryRect.relocate(980, 110);

        Rectangle spinneryRect = new Rectangle(440, 300);
        spinneryRect.setOpacity(0.6);
        spinneryRect.setArcHeight(70);
        spinneryRect.setArcWidth(70);
        spinneryRect.setFill(Color.rgb(64, 45, 67));
        spinneryRect.relocate(1460, 110);


        Rectangle sewingFactoryRect = new Rectangle(470, 300);
        sewingFactoryRect.setOpacity(0.6);
        sewingFactoryRect.setArcHeight(70);
        sewingFactoryRect.setArcWidth(70);
        sewingFactoryRect.setFill(Color.rgb(64, 45, 67));
        sewingFactoryRect.relocate(20, 430);

        Rectangle weavingFactoryRect = new Rectangle(470, 300);
        weavingFactoryRect.setOpacity(0.6);
        weavingFactoryRect.setArcHeight(70);
        weavingFactoryRect.setArcWidth(70);
        weavingFactoryRect.setFill(Color.rgb(64, 45, 67));
        weavingFactoryRect.relocate(500, 430);

        Rectangle wareHouseRect = new Rectangle(470, 300);
        wareHouseRect.setOpacity(0.6);
        wareHouseRect.setArcHeight(70);
        wareHouseRect.setArcWidth(70);
        wareHouseRect.setFill(Color.rgb(64, 45, 67));
        wareHouseRect.relocate(980, 430);

        Rectangle truckRect = new Rectangle(440, 300);
        truckRect.setOpacity(0.6);
        truckRect.setArcHeight(70);
        truckRect.setArcWidth(70);
        truckRect.setFill(Color.rgb(64, 45, 67));
        truckRect.relocate(1460, 430);

        Rectangle wellRect = new Rectangle(470, 300);
        wellRect.setOpacity(0.6);
        wellRect.setArcHeight(70);
        wellRect.setArcWidth(70);
        wellRect.setFill(Color.rgb(64, 45, 67));
        wellRect.relocate(20, 750);

        Rectangle helicopterRect = new Rectangle(470, 300);
        helicopterRect.setOpacity(0.6);
        helicopterRect.setArcHeight(70);
        helicopterRect.setArcWidth(70);
        helicopterRect.setFill(Color.rgb(64, 45, 67));
        helicopterRect.relocate(500, 750);

        Rectangle dogRect = new Rectangle(470, 300);
        dogRect.setOpacity(0.6);
        dogRect.setArcHeight(70);
        dogRect.setArcWidth(70);
        dogRect.setFill(Color.rgb(64, 45, 67));
        dogRect.relocate(980, 750);

        Rectangle catRect = new Rectangle(440, 300);
        catRect.setOpacity(0.6);
        catRect.setArcHeight(70);
        catRect.setArcWidth(70);
        catRect.setFill(Color.rgb(64, 45, 67));
        catRect.relocate(1460, 750);

        rootGameShopView.getChildren().addAll(eggPowderPlantRect, cookieBakeryRect, cakeBakeryRect, spinneryRect, truckRect, weavingFactoryRect, wellRect, sewingFactoryRect, wareHouseRect, dogRect, catRect, helicopterRect);

    }


    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\GameShop.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(1200);
        BackGroundView.setFitWidth(2000);
        rootGameShopView.getChildren().addAll(BackGroundView);
    }
//    public static void main(String[] arg){
//        launch(arg);
//    }


    private void AddItems() {
        File eggPowderPlant = new File("Data\\Textures\\Workshops\\DriedEggs (Egg Powder Plant)\\01.png");
        Image eggPowderPlantImage = new Image(eggPowderPlant.toURI().toString());
        ImageView eggPowderPlantView = new ImageView(eggPowderPlantImage);
        eggPowderPlantView.setFitHeight(175);
        eggPowderPlantView.setFitWidth(250);
        eggPowderPlantView.setViewport(new Rectangle2D(0, 0, 130, 110));
        eggPowderPlantView.relocate(23, 210);
        rootGameShopView.getChildren().addAll(eggPowderPlantView);

        File cookieBakery = new File("Data\\Textures\\Workshops\\Cake (Cookie Bakery)\\01.png");
        Image cookieBakeryImage = new Image(cookieBakery.toURI().toString());
        ImageView cookieBakeryView = new ImageView(cookieBakeryImage);
        cookieBakeryView.setFitHeight(175);
        cookieBakeryView.setFitWidth(250);
        cookieBakeryView.setViewport(new Rectangle2D(0, 0, 130, 130));
        cookieBakeryView.relocate(525, 200);
        rootGameShopView.getChildren().addAll(cookieBakeryView);

        File cakeBakery = new File("Data\\Textures\\Workshops\\FlouryCake (Cake Bakery)\\01.png");
        Image cakeBakeryImage = new Image(cakeBakery.toURI().toString());
        ImageView cakeBakeryView = new ImageView(cakeBakeryImage);
        cakeBakeryView.setFitHeight(210);
        cakeBakeryView.setFitWidth(300);
        cakeBakeryView.setViewport(new Rectangle2D(0, 0, 190, 170));
        cakeBakeryView.relocate(970, 185);
        rootGameShopView.getChildren().addAll(cakeBakeryView);

        File spinnery = new File("Data\\Textures\\Workshops\\Spinnery (Spinnery)\\01.png");
        Image spinneryImage = new Image(spinnery.toURI().toString());
        ImageView spinneryView = new ImageView(spinneryImage);
        spinneryView.setFitHeight(160);
        spinneryView.setFitWidth(230);
        spinneryView.setViewport(new Rectangle2D(0, 0, 140, 100));
        spinneryView.relocate(1480, 218);
        rootGameShopView.getChildren().addAll(spinneryView);


        File sewingFactory = new File("Data\\Textures\\Workshops\\CarnivalDress (Sewing Factory)\\01.png");
        Image sewingFactoryImage = new Image(sewingFactory.toURI().toString());
        ImageView sewingFactoryView = new ImageView(sewingFactoryImage);
        sewingFactoryView.setFitHeight(160);
        sewingFactoryView.setFitWidth(230);
        sewingFactoryView.setViewport(new Rectangle2D(0, 0, 150, 130));
        sewingFactoryView.relocate(23, 540);
        rootGameShopView.getChildren().addAll(sewingFactoryView);

        File weavingFavtory = new File("Data\\Textures\\Workshops\\Weaving (Weaving Factory)\\01.png");
        Image weavingFactoryImage = new Image(weavingFavtory.toURI().toString());
        ImageView weavingFactoryView = new ImageView(weavingFactoryImage);
        weavingFactoryView.setFitHeight(175);
        weavingFactoryView.setFitWidth(250);
        weavingFactoryView.setViewport(new Rectangle2D(0, 0, 150, 110));
        weavingFactoryView.relocate(525, 530);
        rootGameShopView.getChildren().addAll(weavingFactoryView);

        File wareHouse = new File("Data\\Textures\\Service\\Depot\\01.png");
        Image wareHouseImage = new Image(wareHouse.toURI().toString());
        ImageView wareHouseView = new ImageView(wareHouseImage);
        wareHouseView.setFitHeight(210);
        wareHouseView.setFitWidth(250);
        wareHouseView.setViewport(new Rectangle2D(0, 0, 190, 170));
        wareHouseView.relocate(1000, 540);
        rootGameShopView.getChildren().addAll(wareHouseView);

        File truck = new File("Data\\Textures\\Service\\Truck\\01.png");
        Image truckImage = new Image(truck.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.setFitHeight(220);
        truckView.setFitWidth(300);
        truckView.setViewport(new Rectangle2D(0, 0, 170, 130));
        truckView.relocate(1480, 495);
        rootGameShopView.getChildren().addAll(truckView);


        File well = new File("Data\\Textures\\Service\\Well\\01.png");
        Image wellImage = new Image(well.toURI().toString());
        ImageView wellView = new ImageView(wellImage);
        wellView.setFitHeight(220);
        wellView.setFitWidth(260);
        wellView.setViewport(new Rectangle2D(0, 0, 150, 130));
        wellView.relocate(23, 800);
        rootGameShopView.getChildren().addAll(wellView);

        File helicopter = new File("Data\\Textures\\Service\\Helicopter\\01.png");
        Image helicopterImage = new Image(helicopter.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.setFitHeight(230);
        helicopterView.setFitWidth(270);
        helicopterView.setViewport(new Rectangle2D(0, 0, 150, 160));
        helicopterView.relocate(500, 805);
        rootGameShopView.getChildren().addAll(helicopterView);

        File dog = new File("Data\\Textures\\Service\\Dog.png");
        Image dogImage = new Image(dog.toURI().toString());
        ImageView dogView = new ImageView(dogImage);
        dogView.setFitHeight(200);
        dogView.setFitWidth(250);
        dogView.relocate(980, 840);
        rootGameShopView.getChildren().addAll(dogView);

        File cat = new File("Data\\Textures\\Service\\BuyIconNotHead\\Cat.png");
        Image catImage = new Image(cat.toURI().toString());
        ImageView catView = new ImageView(catImage);
        catView.setFitHeight(160);
        catView.setFitWidth(200);
        catView.relocate(1480, 860);
        rootGameShopView.getChildren().addAll(catView);


        File shopText = new File("Data\\Textures\\Service\\ShopText.png");
        Image shopTextImage = new Image(shopText.toURI().toString());
        ImageView shopTextView = new ImageView(shopTextImage);
        shopTextView.setFitHeight(100);
        shopTextView.setFitWidth(200);
        //shopTextView.setViewport(new Rectangle2D(0,0,130,110));
        shopTextView.relocate(890, 0);
        rootGameShopView.getChildren().addAll(shopTextView);

        File okButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image okButtonImage = new Image(okButton.toURI().toString());
        ImageView okButtonView = new ImageView(okButtonImage);
        okButtonView.setFitHeight(75);
        okButtonView.setFitWidth(150);
        okButtonView.relocate(1700, 20);
        okButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate(1698, 18);
                okButtonView.setFitHeight(80);
                okButtonView.setFitWidth(155);
                okButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        okButtonView.setFitHeight(75);
                        okButtonView.setFitWidth(150);
                        okButtonView.relocate(1700, 20);
                    }
                });

            }
        });
        rootGameShopView.getChildren().addAll(okButtonView);

        File okText = new File("Data\\Textures\\Service\\OkText.png");
        Image okTextImage = new Image(okText.toURI().toString());
        ImageView okTextView = new ImageView(okTextImage);
        okTextView.setFitHeight(30);
        okTextView.setFitWidth(100);
        okTextView.relocate(1720, 40);
        okTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate(1698,18);
                okButtonView.setFitHeight(80);
                okButtonView.setFitWidth(155);
            }
        });
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.setFitHeight(75);
                okButtonView.setFitWidth(150);
                okButtonView.relocate(1700, 20);
            }
        });
        rootGameShopView.getChildren().addAll(okTextView);

        File star = new File("Data\\Textures\\Service\\Star.gif");
        Image starImage = new Image(star.toURI().toString());
        ImageView starView = new ImageView(starImage);
        starView.setFitHeight(50);
        starView.setFitWidth(50);
        starView.relocate(30, 30);
        rootGameShopView.getChildren().addAll(starView);
        Text starText = new Text("0");
        starText.relocate(100,50);
        starText.setFont(Font.font(30));
        starText.setStyle("-fx-font-weight: bold");
        rootGameShopView.getChildren().addAll(starText);

    }
}
