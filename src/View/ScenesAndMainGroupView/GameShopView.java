package View.ScenesAndMainGroupView;

import FarmController.Exceptions.NotEnoughMoney;
import FarmModel.Game;
import FarmModel.Request.UpgradeRequest;
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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

import static javafx.application.Application.launch;
import View.GameView;
import javafx.util.Duration;

public class GameShopView extends View {
    double xShift = 0.788;
    double yShift = 0.788;
    private Text moneyText=new Text();
    private Group rootGameShopView = new Group();
    private Scene sceneGameShopView = new Scene(rootGameShopView, (int) (1500 * xShift), (int) (700 * yShift));

    public Scene getSceneGameShopView() {
        return sceneGameShopView;
    }

    public GameShopView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        UpdateMoneyText();
        AddBackGround(primaryStage);
        AddIcons(primaryStage);
        AddItems();
        AddShopText();
        AddStarAndMoneyText();
        AddOkText(primaryStage);

    }

    private void AddIcons(Stage primaryStage) {

        Rectangle eggPowderPlantRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        eggPowderPlantRect.setOpacity(0.6);
        eggPowderPlantRect.setArcHeight((int) (70 * yShift));
        eggPowderPlantRect.setArcWidth((int) (70 * xShift));
        eggPowderPlantRect.setFill(Color.rgb(64, 45, 67));
        eggPowderPlantRect.relocate((int) (20 * xShift), (int) (110 * yShift));

        Rectangle cookieBakeryRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        cookieBakeryRect.setOpacity(0.6);
        cookieBakeryRect.setArcHeight((int) (70 * yShift));
        cookieBakeryRect.setArcWidth((int) (70 * xShift));
        cookieBakeryRect.setFill(Color.rgb(64, 45, 67));
        cookieBakeryRect.relocate((int) (500 * xShift), (int) (110 * yShift));

        Rectangle cakeBakeryRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        cakeBakeryRect.setOpacity(0.6);
        cakeBakeryRect.setArcHeight((int) (70 * yShift));
        cakeBakeryRect.setArcWidth((int) (70 * xShift));
        cakeBakeryRect.setFill(Color.rgb(64, 45, 67));
        cakeBakeryRect.relocate((int) (980 * xShift), (int) (110 * yShift));

        Rectangle spinneryRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        spinneryRect.setOpacity(0.6);
        spinneryRect.setArcHeight((int) (70 * yShift));
        spinneryRect.setArcWidth((int) (70 * xShift));
        spinneryRect.setFill(Color.rgb(64, 45, 67));
        spinneryRect.relocate((int) (1460 * xShift), (int) (110 * yShift));


        Rectangle sewingFactoryRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        sewingFactoryRect.setOpacity(0.6);
        sewingFactoryRect.setArcHeight((int) (70 * yShift));
        sewingFactoryRect.setArcWidth((int) (70 * xShift));
        sewingFactoryRect.setFill(Color.rgb(64, 45, 67));
        sewingFactoryRect.relocate((int) (20 * xShift), (int) (430 * yShift));

        Rectangle weavingFactoryRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        weavingFactoryRect.setOpacity(0.6);
        weavingFactoryRect.setArcHeight((int) (70 * yShift));
        weavingFactoryRect.setArcWidth((int) (70 * xShift));
        weavingFactoryRect.setFill(Color.rgb(64, 45, 67));
        weavingFactoryRect.relocate((int) (500 * xShift), (int) (430 * yShift));

        Rectangle wareHouseRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        wareHouseRect.setOpacity(0.6);
        wareHouseRect.setArcHeight((int) (70 * yShift));
        wareHouseRect.setArcWidth((int) (70 * xShift));
        wareHouseRect.setFill(Color.rgb(64, 45, 67));
        wareHouseRect.relocate((int) (980 * xShift), (int) (430 * yShift));

        Rectangle truckRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        truckRect.setOpacity(0.6);
        truckRect.setArcHeight((int) (70 * yShift));
        truckRect.setArcWidth((int) (70 * xShift));
        truckRect.setFill(Color.rgb(64, 45, 67));
        truckRect.relocate((int) (1460 * xShift), (int) (430 * yShift));

        Rectangle wellRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        wellRect.setOpacity(0.6);
        wellRect.setArcHeight((int) (70 * yShift));
        wellRect.setArcWidth((int) (70 * xShift));
        wellRect.setFill(Color.rgb(64, 45, 67));
        wellRect.relocate((int) (20 * xShift), (int) (750 * yShift));

        Rectangle helicopterRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        helicopterRect.setOpacity(0.6);
        helicopterRect.setArcHeight((int) (70 * yShift));
        helicopterRect.setArcWidth((int) (70 * xShift));
        helicopterRect.setFill(Color.rgb(64, 45, 67));
        helicopterRect.relocate((int) (500 * xShift), (int) (750 * yShift));

        Rectangle dogRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        dogRect.setOpacity(0.6);
        dogRect.setArcHeight((int) (70 * yShift));
        dogRect.setArcWidth((int) (70 * xShift));
        dogRect.setFill(Color.rgb(64, 45, 67));
        dogRect.relocate((int) (980 * xShift), (int) (750 * yShift));

        Rectangle catRect = new Rectangle((int) (470 * xShift), (int) (300 * yShift));
        catRect.setOpacity(0.6);
        catRect.setArcHeight((int) (70 * yShift));
        catRect.setArcWidth((int) (70 * xShift));
        catRect.setFill(Color.rgb(64, 45, 67));
        catRect.relocate((int) (1460 * xShift), (int) (750 * yShift));

        rootGameShopView.getChildren().addAll(eggPowderPlantRect, cookieBakeryRect, cakeBakeryRect, spinneryRect, truckRect, weavingFactoryRect, wellRect, sewingFactoryRect, wareHouseRect, dogRect, catRect, helicopterRect);

    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(primaryStage.getHeight());
        BackGroundView.setFitWidth(primaryStage.getWidth());
        rootGameShopView.getChildren().addAll(BackGroundView);
    }

    private void AddItems() {
        File eggPowderPlant = new File("Data\\Textures\\Workshops\\DriedEggs(Egg Powder Plant)\\01.png");
        Image eggPowderPlantImage = new Image(eggPowderPlant.toURI().toString());
        ImageView eggPowderPlantView = new ImageView(eggPowderPlantImage);
        eggPowderPlantView.setFitHeight((int) (175 * yShift));
        eggPowderPlantView.setFitWidth((int) (250 * xShift));
        eggPowderPlantView.setViewport(new Rectangle2D(0, 0, 130, 110));
        eggPowderPlantView.relocate((int) (23 * xShift), (int) (210 * yShift));
        rootGameShopView.getChildren().addAll(eggPowderPlantView);
        eggPowderPlantView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderPlantView.setFitHeight((int) (175 * yShift) + 10);
                eggPowderPlantView.setFitWidth((int) (250 * xShift) + 10);
                eggPowderPlantView.relocate((int) (23 * xShift) - 5, (int) (210 * yShift) - 5);
            }
        });
        eggPowderPlantView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eggPowderPlantView.setFitHeight((int) (175 * yShift));
                eggPowderPlantView.setFitWidth((int) (250 * xShift));
                eggPowderPlantView.relocate((int) (23 * xShift), (int) (210 * yShift));
            }
        });
        eggPowderPlantView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade EggPowderPlant");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e2){
                  ShowNotEnoughMoneyError();
                }catch (Exception e3){
                    e3.printStackTrace();
                }
            }
        });

        File cookieBakery = new File("Data\\Textures\\Workshops\\Cake(Cookie Bakery)\\01.png");
        Image cookieBakeryImage = new Image(cookieBakery.toURI().toString());
        ImageView cookieBakeryView = new ImageView(cookieBakeryImage);
        cookieBakeryView.setFitHeight((int) (175 * yShift));
        cookieBakeryView.setFitWidth((int) (250 * xShift));
        cookieBakeryView.setViewport(new Rectangle2D(0, 0, 130, 130));
        cookieBakeryView.relocate((int) (525 * xShift), (int) (200 * yShift));
        rootGameShopView.getChildren().addAll(cookieBakeryView);
        cookieBakeryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cookieBakeryView.setFitHeight((int) (175 * yShift) + 10);
                cookieBakeryView.setFitWidth((int) (250 * xShift) + 10);
                cookieBakeryView.relocate((int) (525 * xShift) - 5, (int) (200 * yShift) - 5);
            }
        });
        cookieBakeryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cookieBakeryView.setFitHeight((int) (175 * yShift));
                cookieBakeryView.setFitWidth((int) (250 * xShift));
                cookieBakeryView.relocate((int) (525 * xShift), (int) (200 * yShift));
            }
        });
        cookieBakeryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade CookieBakery");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                   ShowNotEnoughMoneyError();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        File cakeBakery = new File("Data\\Textures\\Workshops\\FlouryCake(Cake Bakery)\\01.png");
        Image cakeBakeryImage = new Image(cakeBakery.toURI().toString());
        ImageView cakeBakeryView = new ImageView(cakeBakeryImage);
        cakeBakeryView.setFitHeight((int) (210 * yShift));
        cakeBakeryView.setFitWidth((int) (300 * xShift));
        cakeBakeryView.setViewport(new Rectangle2D(0, 0, 190, 170));
        cakeBakeryView.relocate((int) (970 * xShift), (int) (185 * yShift));
        rootGameShopView.getChildren().addAll(cakeBakeryView);
        cakeBakeryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                cakeBakeryView.setFitHeight((int) (210 * yShift) + 10);
                cakeBakeryView.setFitWidth((int) (300 * xShift) + 10);
                cakeBakeryView.relocate((int) (970 * xShift) - 5, (int) (185 * yShift) - 5);
            }
        });
        cakeBakeryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cakeBakeryView.setFitHeight((int) (210 * yShift));
                cakeBakeryView.setFitWidth((int) (300 * xShift));
                cakeBakeryView.relocate((int) (970 * xShift), (int) (185 * yShift));
            }
        });
        cakeBakeryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade CakeBakery");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    e.printStackTrace();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        File spinnery = new File("Data\\Textures\\Workshops\\Spinnery(Spinnery)\\01.png");
        Image spinneryImage = new Image(spinnery.toURI().toString());
        ImageView spinneryView = new ImageView(spinneryImage);
        spinneryView.setFitHeight((int) (160 * yShift));
        spinneryView.setFitWidth((int) (230 * xShift));
        spinneryView.setViewport(new Rectangle2D(0, 0, 140, 100));
        spinneryView.relocate((int) (1480 * xShift), (int) (218 * yShift));
        rootGameShopView.getChildren().addAll(spinneryView);
        spinneryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.setFitHeight((int) (160 * yShift) + 10);
                spinneryView.setFitWidth((int) (230 * xShift) + 10);
                spinneryView.relocate((int) (1480 * xShift) - 5, (int) (218 * yShift) - 5);
            }
        });
        spinneryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spinneryView.setFitHeight((int) (160 * yShift));
                spinneryView.setFitWidth((int) (230 * xShift));
                spinneryView.relocate((int) (1480 * xShift), (int) (218 * yShift));
            }
        });
        spinneryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Spinnery");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File sewingFactory = new File("Data\\Textures\\Workshops\\CarnivalDress(Sewing Factory)\\01.png");
        Image sewingFactoryImage = new Image(sewingFactory.toURI().toString());
        ImageView sewingFactoryView = new ImageView(sewingFactoryImage);
        sewingFactoryView.setFitHeight((int) (160 * yShift));
        sewingFactoryView.setFitWidth((int) (230 * xShift));
        sewingFactoryView.setViewport(new Rectangle2D(0, 0, 150, 130));
        sewingFactoryView.relocate((int) (23 * xShift), (int) (540 * yShift));
        rootGameShopView.getChildren().addAll(sewingFactoryView);
        sewingFactoryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.setFitHeight((int) (160 * yShift) + 10);
                sewingFactoryView.setFitWidth((int) (230 * xShift) + 10);
                sewingFactoryView.relocate((int) (23 * xShift) - 5, (int) (540 * yShift) - 5);
            }
        });
        sewingFactoryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sewingFactoryView.setFitHeight((int) (160 * yShift));
                sewingFactoryView.setFitWidth((int) (230 * xShift));
                sewingFactoryView.relocate((int) (23 * xShift), (int) (540 * yShift));
            }
        });
        sewingFactoryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade SewingFactory");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File weavingFactory = new File("Data\\Textures\\Workshops\\Weaving(Weaving Factory)\\01.png");
        Image weavingFactoryImage = new Image(weavingFactory.toURI().toString());
        ImageView weavingFactoryView = new ImageView(weavingFactoryImage);
        weavingFactoryView.setFitHeight((int) (175 * yShift));
        weavingFactoryView.setFitWidth((int) (250 * xShift));
        weavingFactoryView.setViewport(new Rectangle2D(0, 0, 150, 110));
        weavingFactoryView.relocate((int) (525 * xShift), (int) (530 * yShift));
        rootGameShopView.getChildren().addAll(weavingFactoryView);
        weavingFactoryView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                weavingFactoryView.setFitHeight((int) (175 * yShift) + 10);
                weavingFactoryView.setFitWidth((int) (250 * xShift) + 10);
                weavingFactoryView.relocate((int) (525 * xShift) - 5, (int) (530 * yShift) - 5);
            }
        });
        weavingFactoryView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                weavingFactoryView.setFitHeight((int) (175 * yShift));
                weavingFactoryView.setFitWidth((int) (250 * xShift));
                weavingFactoryView.relocate((int) (525 * xShift), (int) (530 * yShift));
            }
        });
        weavingFactoryView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade WeavingFactory");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File wareHouse = new File("Data\\Textures\\Service\\Depot\\01.png");
        Image wareHouseImage = new Image(wareHouse.toURI().toString());
        ImageView wareHouseView = new ImageView(wareHouseImage);
        wareHouseView.setFitHeight((int) (175 * yShift));
        wareHouseView.setFitWidth((int) (250 * xShift));
        wareHouseView.setViewport(new Rectangle2D(0, 0, 190, 170));
        wareHouseView.relocate((int) (1000 * xShift), (int) (540 * yShift));
        rootGameShopView.getChildren().addAll(wareHouseView);
        wareHouseView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.setFitHeight((int) (175 * yShift) + 10);
                wareHouseView.setFitWidth((int) (250 * xShift) + 10);
                wareHouseView.relocate((int) (1000 * xShift) - 5, (int) (540 * yShift) - 5);
            }
        });
        wareHouseView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wareHouseView.setFitHeight((int) (175 * yShift));
                wareHouseView.setFitWidth((int) (250 * xShift));
                wareHouseView.relocate((int) (1000 * xShift), (int) (540 * yShift));
            }
        });
        wareHouseView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Warehouse");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File truck = new File("Data\\Textures\\Service\\Truck\\01.png");
        Image truckImage = new Image(truck.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.setFitHeight((int) (220 * yShift));
        truckView.setFitWidth((int) (300 * xShift));
        truckView.setViewport(new Rectangle2D(0, 0, 170, 130));
        truckView.relocate((int) (1480 * xShift), (int) (495 * yShift));
        rootGameShopView.getChildren().addAll(truckView);
        truckView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                truckView.setFitHeight((int) (220 * yShift) + 10);
                truckView.setFitWidth((int) (300 * xShift) + 10);
                truckView.relocate((int) (1480 * xShift) - 5, (int) (495 * yShift) - 5);
            }
        });
        truckView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                truckView.setFitHeight((int) (220 * yShift));
                truckView.setFitWidth((int) (300 * xShift));
                truckView.relocate((int) (1480 * xShift), (int) (495 * yShift));
            }
        });
        truckView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Truck");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File well = new File("Data\\Textures\\Service\\Well\\01.png");
        Image wellImage = new Image(well.toURI().toString());
        ImageView wellView = new ImageView(wellImage);
        wellView.setFitHeight((int) (220 * yShift));
        wellView.setFitWidth((int) (260 * xShift));
        wellView.setViewport(new Rectangle2D(0, 0, 150, 130));
        wellView.relocate((int) (23 * xShift), (int) (800 * yShift));
        rootGameShopView.getChildren().addAll(wellView);
        wellView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.setFitHeight((int) (220 * yShift) + 10);
                wellView.setFitWidth((int) (260 * xShift) + 10);
                wellView.relocate((int) (23 * xShift) - 5, (int) (800 * yShift) - 5);
            }
        });
        wellView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wellView.setFitHeight((int) (220 * yShift));
                wellView.setFitWidth((int) (260 * xShift));
                wellView.relocate((int) (23 * xShift), (int) (800 * yShift));
            }
        });
        wellView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Well");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File helicopter = new File("Data\\Textures\\Service\\Helicopter\\01.png");
        Image helicopterImage = new Image(helicopter.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.setFitHeight((int) (230 * yShift));
        helicopterView.setFitWidth((int) (270 * xShift));
        helicopterView.setViewport(new Rectangle2D(0, 0, 150, 160));
        helicopterView.relocate((int) (500 * xShift), (int) (805 * yShift));
        rootGameShopView.getChildren().addAll(helicopterView);
        helicopterView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helicopterView.setFitHeight((int) (230 * yShift) + 10);
                helicopterView.setFitWidth((int) (270 * xShift) + 10);
                helicopterView.relocate((int) (500 * xShift) - 5, (int) (805 * yShift) -5);
            }
        });
        helicopterView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helicopterView.setFitHeight((int) (230 * yShift));
                helicopterView.setFitWidth((int) (270 * xShift));
                helicopterView.relocate((int) (500 * xShift), (int) (805 * yShift));
            }
        });
        helicopterView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Helicopter");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File dog = new File("Data\\Textures\\Service\\Dog.png");
        Image dogImage = new Image(dog.toURI().toString());
        ImageView dogView = new ImageView(dogImage);
        dogView.setFitHeight((int) (200 * yShift));
        dogView.setFitWidth((int) (250 * xShift));
        dogView.relocate((int) (980 * xShift), (int) (840 * yShift));
        rootGameShopView.getChildren().addAll(dogView);
        dogView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogView.setFitHeight((int) (200 * yShift) + 10);
                dogView.setFitWidth((int) (250 * xShift) + 10);
                dogView.relocate((int) (980 * xShift) - 5, (int) (840 * yShift) - 5);
            }
        });
        dogView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dogView.setFitHeight((int) (200 * yShift));
                dogView.setFitWidth((int) (250 * xShift));
                dogView.relocate((int) (980 * xShift), (int) (840 * yShift));
            }
        });
        dogView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Dog");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        File cat = new File("Data\\Textures\\Service\\Cat.png");
        Image catImage = new Image(cat.toURI().toString());
        ImageView catView = new ImageView(catImage);
        catView.setFitHeight((int) (160 * yShift));
        catView.setFitWidth((int) (200 * xShift));
        catView.relocate((int) (1480 * xShift), (int) (860 * yShift));
        rootGameShopView.getChildren().addAll(catView);
        catView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catView.setFitHeight((int) (160 * yShift) + 10);
                catView.setFitWidth((int) (200 * xShift) + 10);
                catView.relocate((int) (1480 * xShift) - 5, (int) (860 * yShift) - 5);
            }
        });
        catView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                catView.setFitHeight((int) (160 * yShift));
                catView.setFitWidth((int) (200 * xShift));
                catView.relocate((int) (1480 * xShift), (int) (860 * yShift));
            }
        });
        catView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new UpgradeRequest("upgrade Cat");
                    UpdateMoneyText();
                } catch (NotEnoughMoney e) {
                    ShowNotEnoughMoneyError();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });
    }

    public void AddEggPowerPlantLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(270 , 190 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddCookieBakeryLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(650 , 190 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddCakeBakeryLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(1030 , 190 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddSpinneryLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(1410 , 190 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddSewingFactoryLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(270 , 440 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddWeavingFactoryLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(650 , 440 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddWareHouseLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(1030 , 440 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddTruckLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(1410 , 440 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddWellLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(270 , 690 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddHelicopterLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(650 , 690 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddDogLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(1030 , 690 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }

    public void AddCatLevel(int level) {
        File UpgradeArrow = new File("Data\\Textures\\Service\\UpgradeArrow.png");
        Image UpgradeArrowImage = new Image(UpgradeArrow.toURI().toString());
        ImageView[] UpgradeArrowImageView = new ImageView[level];

        for (int i = 0; i < level; i++) {
            UpgradeArrowImageView[i] = new ImageView(UpgradeArrowImage);
            UpgradeArrowImageView[i].setFitWidth(70);
            UpgradeArrowImageView[i].setFitHeight(50);
            UpgradeArrowImageView[i].relocate(1410 , 690 + i * 20);
            rootGameShopView.getChildren().addAll(UpgradeArrowImageView[i]);
        }
    }



    private void AddShopText(){
        File shopText = new File("Data\\MenuClick\\ShopText.png");
        Image shopTextImage = new Image(shopText.toURI().toString());
        ImageView shopTextView = new ImageView(shopTextImage);
        shopTextView.setFitHeight((int) (100 * yShift));
        shopTextView.setFitWidth((int) (200 * xShift));
        shopTextView.relocate((int) (890 * xShift), (int) (0 * yShift));
        rootGameShopView.getChildren().addAll(shopTextView);
    }

    private void AddStarAndMoneyText(){
        File star = new File("Data\\Gif\\RotatingStar.gif");
        Image starImage = new Image(star.toURI().toString());
        ImageView starView = new ImageView(starImage);
        starView.setFitHeight((int) (50 * yShift));
        starView.setFitWidth((int) (50 * xShift));
        starView.relocate((int) (30 * xShift), (int) (30 * yShift));
        rootGameShopView.getChildren().addAll(starView);
        moneyText.relocate((int) (100 * xShift), (int) (50 * yShift));
        moneyText.setFont(Font.font(30));
        moneyText.setStyle("-fx-font-weight: bold");
        rootGameShopView.getChildren().addAll(moneyText);
    }

    private void AddOkText(Stage primaryStage){
        File okButton = new File("Data\\Click\\OkButton.png");
        Image okButtonImage = new Image(okButton.toURI().toString());
        ImageView okButtonView = new ImageView(okButtonImage);
        okButtonView.setFitHeight((int) (75 * yShift));
        okButtonView.setFitWidth((int) (150 * xShift));
        okButtonView.relocate((int) (1700 * xShift), (int) (20 * yShift));
        okButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate((int) (1698 * xShift), (int) (18 * yShift));
                okButtonView.setFitHeight((int) (80 * yShift));
                okButtonView.setFitWidth((int) (150 * xShift));
            }
        });
        okButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.setFitHeight((int) (75 * yShift));
                okButtonView.setFitWidth((int) (150 * xShift));
                okButtonView.relocate((int) (1700 * xShift), (int) (20 * yShift));
            }
        });
        okButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getSceneSelectionView());
                primaryStage.setFullScreen(true);
            }
        });
        rootGameShopView.getChildren().addAll(okButtonView);
        File okText = new File("Data\\MenuClick\\OkText.png");
        Image okTextImage = new Image(okText.toURI().toString());
        ImageView okTextView = new ImageView(okTextImage);
        okTextView.setFitHeight((int) (30 * yShift));
        okTextView.setFitWidth((int) (100 * xShift));
        okTextView.relocate((int) (1720 * xShift), (int) (40 * yShift));
        okTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate((int) (1698 * xShift), (int) (18 * yShift));
                okButtonView.setFitHeight((int) (80 * yShift));
                okButtonView.setFitWidth((int) (155 * xShift));
            }
        });
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.setFitHeight((int) (75 * yShift));
                okButtonView.setFitWidth((int) (150 * xShift));
                okButtonView.relocate((int) (1700 * xShift), (int) (20 * yShift));
            }
        });
        okTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getSceneSelectionView());
                primaryStage.setFullScreen(true);
            }
        });
        rootGameShopView.getChildren().addAll(okTextView);
    }

    private void ShowNotEnoughMoneyError(){
        Circle circle=new Circle(35,35,0, Paint.valueOf("Red"));
        circle.setOpacity(0.5);
        rootGameShopView.getChildren().addAll(circle);
        KeyValue radiusValue=new KeyValue(circle.radiusProperty(),30);
        KeyValue opacityValue=new KeyValue(circle.opacityProperty(),0);
        KeyFrame circleFrame=new KeyFrame(Duration.seconds(1),opacityValue,radiusValue);
        Timeline circleTimeLine=new Timeline(circleFrame);
        circleTimeLine.play();
    }
    private void UpdateMoneyText(){
        int userMoney= Game.getGameInstance().getCurrentUserAccount().getMoney();
        moneyText.setText(String.valueOf(userMoney));

    }
}
