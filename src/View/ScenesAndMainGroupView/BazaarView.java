package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.LiveAnimals.Bear;
import FarmModel.ObjectInMap15_15.LiveAnimals.Lion;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Milk;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Wool;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.*;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.User;
import View.GameView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static View.View.PlayErrorSound;

public class BazaarView {
    private Group root = new Group();
    private Scene scene = new Scene(root, 1600, 900);
    private Label labelButtonFlouryCake = new Label("0");
    private Label labelButtonCake = new Label("0");
    private Label labelButton1Flour = new Label("0");
    private Label labelButtonPowder = new Label("0");
    private Label labelButtonCarnivalDress = new Label("0");
    private Label labelButtonDecoration = new Label("0");
    private Label labelButtonFabric = new Label("0");
    private Label labelButtonSewing = new Label("0");
    private Text coinTextForSell = new Text("0");
    private Text coinTextForOrder=new Text("0");


    private Label labelEggButton1 = new Label("10");
    private Label labelWoolButton1 = new Label("10");
    private Label labelMilkButton1 = new Label("10");
    private Label labelFlouryCakeButton1 = new Label("10");
    private Label labelCakeButton1 = new Label("10");
    private Label labelFlourButton1 = new Label("10");
    private Label labelPowderButton1 = new Label("10");
    private Label labelCarnivalDressButton1 = new Label("10");
    private Label labelDecorationButton1 = new Label("10");
    private Label labelFabricButton1 = new Label("10");
    private Label labelSewingButton1 = new Label("10");
    private Label labelCageLionButton1 = new Label("10");
    private Label labelCageBearButton1 = new Label("10");
    private User user= Game.getGameInstance().getCurrentUserAccount();
    public Scene getScene() {
        return scene;
    }

    public BazaarView(Stage primaryStage) throws UnknownObjectException, MissionNotLoaded {
        Start(primaryStage);
    }

    public Group getRoot() {
        return root;
    }

    public void Start(Stage primaryStage) throws UnknownObjectException, MissionNotLoaded {
        UpdateMoneyLabelForSell();
        AddBackground(primaryStage);
        AddItem(primaryStage);
        AddButtton(primaryStage);
        ShowWareHouseListInOnlineShopView();
        AddItemToBuyFlouryCake();
        AddItemToBuyCake();
        AddItemToBuyCarnivalDress();
        AddItemToBuyFlour();
        AddItemToBuyPowder();
        AddItemToBuyDecoration();
        AddItemToBuySewing();
        AddItemToBuyFabric();
        AddMoneyLabels();
    }

    public void AddBackground(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
        primaryStage.setFullScreen(true);
        root.getChildren().addAll(BackGroundView);
    }

    public void AddItem(Stage primaryStage) {
        File bazaarFile = new File("Data\\Bazaar\\Bazaar.png");
        Image bazaarImage = new Image(bazaarFile.toURI().toString());
        ImageView bazaarImageView = new ImageView(bazaarImage);
        bazaarImageView.setFitHeight(100);
        bazaarImageView.setFitWidth(200);
        bazaarImageView.relocate(1300, 50);
        root.getChildren().addAll(bazaarImageView);

        Rectangle rect_1 = new Rectangle(400, 750);
        rect_1.setOpacity(0.6);
        rect_1.setArcHeight(70);
        rect_1.setArcWidth(70);
        rect_1.setFill(Color.rgb(64, 45, 67));
        rect_1.relocate(150, 50);
        root.getChildren().addAll(rect_1);

        File goodsFile = new File("Data\\Shop\\GoodsText.png");
        Image goodsImage = new Image(goodsFile.toURI().toString());
        ImageView goodsImageView = new ImageView(goodsImage);
        goodsImageView.setFitHeight(30);
        goodsImageView.setFitWidth(90);
        goodsImageView.relocate(180, 90);
        root.getChildren().addAll(goodsImageView);

        File priceFile = new File("Data\\Shop\\PriceText.png");
        Image priceImage = new Image(priceFile.toURI().toString());
        ImageView priceImageView = new ImageView(priceImage);
        priceImageView.setFitHeight(30);
        priceImageView.setFitWidth(90);
        priceImageView.relocate(300, 90);
        root.getChildren().addAll(priceImageView);

        File orderFile = new File("Data\\Shop\\OrderText.png");
        Image orderImage = new Image(orderFile.toURI().toString());
        ImageView orderImageView = new ImageView(orderImage);
        orderImageView.setFitHeight(30);
        orderImageView.setFitWidth(90);
        orderImageView.relocate(415, 90);
        root.getChildren().addAll(orderImageView);

        File sellFile = new File("Data\\Bazaar\\Sell.png");
        Image sellImage = new Image(sellFile.toURI().toString());
        ImageView sellImageView = new ImageView(sellImage);
        sellImageView.setFitHeight(50);
        sellImageView.setFitWidth(140);
        sellImageView.relocate(725, 10);
        root.getChildren().addAll(sellImageView);

        File buttonFile = new File("Data\\Shop\\OrderGoodsText.png");
        Image buttonImage = new Image(buttonFile.toURI().toString());
        ImageView buttonImageView = new ImageView(buttonImage);
        buttonImageView.setFitHeight(60);
        buttonImageView.setFitWidth(250);
        buttonImageView.relocate(230, 2);
        root.getChildren().addAll(buttonImageView);

        Rectangle rectangle = new Rectangle(350, 450);
        rectangle.setOpacity(0.6);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        rectangle.setFill(Color.rgb(64, 45, 67));
        rectangle.relocate(175, 120);
        root.getChildren().addAll(rectangle);

        Rectangle rectangle1 = new Rectangle(350, 100);
        rectangle1.setOpacity(0.6);
        rectangle1.setArcHeight(50);
        rectangle1.setArcWidth(50);
        rectangle1.setFill(Color.rgb(64, 45, 67));
        rectangle1.relocate(175, 580);
        root.getChildren().addAll(rectangle1);

        Rectangle rectangle2 = new Rectangle(350, 50);
        rectangle2.setOpacity(0.6);
        rectangle2.setArcHeight(50);
        rectangle2.setArcWidth(50);
        rectangle2.setFill(Color.rgb(64, 45, 67));
        rectangle2.relocate(175, 690);
        root.getChildren().addAll(rectangle2);

        Rectangle rect_sell = new Rectangle(400, 750);
        rect_sell.setOpacity(0.6);
        rect_sell.setArcHeight(50);
        rect_sell.setArcWidth(50);
        rect_sell.setFill(Color.rgb(64, 45, 67));
        rect_sell.relocate(600, 50);
        root.getChildren().addAll(rect_sell);

        Rectangle rect_sell_1 = new Rectangle(350, 650);
        rect_sell_1.setOpacity(0.6);
        rect_sell_1.setArcHeight(50);
        rect_sell_1.setArcWidth(50);
        rect_sell_1.setFill(Color.rgb(64, 45, 67));
        rect_sell_1.relocate(625, 125);
        root.getChildren().addAll(rect_sell_1);

        File shipProductText = new File("Data\\Shop\\ShipText.png");
        Image shipProductTextImage = new Image(shipProductText.toURI().toString());
        ImageView shipProductTextView = new ImageView(shipProductTextImage);
        shipProductTextView.setFitHeight(30);
        shipProductTextView.setFitWidth(90);
        shipProductTextView.relocate(875, 90);
        root.getChildren().addAll(shipProductTextView);


        File goodsText = new File("Data\\Shop\\GoodsText.png");
        Image goodsTextImage = new Image(goodsText.toURI().toString());
        ImageView goodsTextView = new ImageView(goodsTextImage);
        goodsTextView.setFitHeight(30);
        goodsTextView.setFitWidth(90);
        goodsTextView.relocate(625, 90);
        root.getChildren().addAll(goodsTextView);

        File priceText = new File("Data\\Shop\\PriceText.png");
        Image priceTextImage = new Image(priceText.toURI().toString());
        ImageView priceTextView = new ImageView(priceTextImage);
        priceTextView.setFitHeight(30);
        priceTextView.setFitWidth(90);
        priceTextView.relocate(750, 90);
        root.getChildren().addAll(priceTextView);
    }

    public void AddButtton(Stage primaryStage) {
        File buttonOkFile = new File("Data\\Click\\OkButton.png");
        Image buttonOkImage = new Image(buttonOkFile.toURI().toString());
        ImageView buttonOkImageView = new ImageView(buttonOkImage);
        buttonOkImageView.setFitHeight(100);
        buttonOkImageView.setFitWidth(200);
        buttonOkImageView.relocate(1175, 460);
        root.getChildren().addAll(buttonOkImageView);

        buttonOkImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        buttonOkImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(110);
                buttonOkImageView.setFitWidth(210);
                buttonOkImageView.relocate(1175 - 5, 460 - 5);
            }
        });
        buttonOkImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(100);
                buttonOkImageView.setFitWidth(200);
                buttonOkImageView.relocate(1175, 460);
            }
        });

        File okText = new File("Data\\Shop\\OkText.png");
        Image okImage = new Image(okText.toURI().toString());
        ImageView okImageView = new ImageView(okImage);
        okImageView.setFitWidth(140);
        okImageView.setFitHeight(80);
        okImageView.relocate(1190 + 10, 460 + 10);
        root.getChildren().addAll(okImageView);

        okImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        okImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(110);
                buttonOkImageView.setFitWidth(210);
                buttonOkImageView.relocate(1175 - 5, 460 - 5);
            }
        });
        okImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(100);
                buttonOkImageView.setFitWidth(200);
                buttonOkImageView.relocate(1175, 460);
            }
        });


        File buttonCancelFile = new File("Data\\Click\\OkButton.png");
        Image buttonCancelImage = new Image(buttonCancelFile.toURI().toString());
        ImageView buttonCancelImageView = new ImageView(buttonCancelImage);
        buttonCancelImageView.setFitHeight(100);
        buttonCancelImageView.setFitWidth(200);
        buttonCancelImageView.relocate(1175, 610);
        root.getChildren().addAll(buttonCancelImageView);

        buttonCancelImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getHostAndGuestView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        buttonCancelImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(110);
                buttonCancelImageView.setFitWidth(210);
                buttonCancelImageView.relocate(1175 - 5, 610 - 5);
            }
        });
        buttonCancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(100);
                buttonCancelImageView.setFitWidth(200);
                buttonCancelImageView.relocate(1175, 610);
            }
        });

        File cancelText = new File("Data\\Shop\\CancelText.png");
        Image cancelImage = new Image(cancelText.toURI().toString());
        ImageView cancelImageView = new ImageView(cancelImage);
        cancelImageView.setFitWidth(150);
        cancelImageView.setFitHeight(85);
        cancelImageView.relocate(1175 + 30, 610 + 10);
        root.getChildren().addAll(cancelImageView);

        cancelImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getHostAndGuestView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        cancelImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(110);
                buttonCancelImageView.setFitWidth(210);
                buttonCancelImageView.relocate(1175 - 5, 610 - 5);
            }
        });
        cancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(100);
                buttonCancelImageView.setFitWidth(200);
                buttonCancelImageView.relocate(1175, 610);
            }
        });
    }

    private void MakeLabelAndButtonChangeable(ImageView imageViewButton1, Label labelButton) {
        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButton.setText("0");
                }
                UpdateMoneyLabelNeeded();
            }
        });
        labelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButton.setText("0");
                }
                UpdateMoneyLabelNeeded();
            }
        });
    }

    private void UpdateMoneyLabelNeeded(){
        int money=MoneyToBuyNumberOfItems();
        coinTextForOrder.setText(String.valueOf(money));
    }

    private int MoneyToBuyNumberOfItems(){
        int result=0;
        InformationNeededInGame informationNeededInGame=Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
        result+=Integer.valueOf(labelButtonFlouryCake.getText())*informationNeededInGame.getPriceToBuy(new FlouryCake());
        result+=Integer.valueOf(labelButtonCake.getText())*informationNeededInGame.getPriceToBuy(new Cake());
        result+=Integer.valueOf(labelButton1Flour.getText())*informationNeededInGame.getPriceToBuy(new Flour());
        result+=Integer.valueOf(labelButtonPowder.getText())*informationNeededInGame.getPriceToBuy(new Powder());
        result+=Integer.valueOf(labelButtonCarnivalDress.getText())*informationNeededInGame.getPriceToBuy(new CarnivalDress());
        result+=Integer.valueOf(labelButtonDecoration.getText())*informationNeededInGame.getPriceToBuy(new Decoration());
        result+=Integer.valueOf(labelButtonFabric.getText())*informationNeededInGame.getPriceToBuy(new Fabric());
        result+=Integer.valueOf(labelButtonSewing.getText())*informationNeededInGame.getPriceToBuy(new Sewing());
        return result;
    }

    private int getCapacityNeeded(){
        int result=0;
//        InformationNeededInGame informationNeededInGame=Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
//        result+=Integer.valueOf(labelEggButton1.getText());
//        result+=Integer.valueOf(labelWoolButton1.getText());
//        result+=Integer.valueOf(labelMilkButton1.getText());
//        result+=Integer.valueOf(labelCakeButton1.getText());
//        result+=Integer.valueOf(labelFabricButton1.getText());
//        result+=Integer.valueOf(labelDecorationButton1.getText());
//        result+=Integer.valueOf(labelFlouryCakeButton1.getText());
//        result+=Integer.valueOf(labelFlourButton1.getText());
//        result+=Integer.valueOf(labelPowderButton1.getText());
//        result+=Integer.valueOf(labelCarnivalDressButton1.getText());
//        result+=Integer.valueOf(labelSewingButton1.getText());
//        result+=Integer.valueOf(labelCageLionButton1.getText());
//        result+=Integer.valueOf(labelCageBearButton1.getText());
        return result;
    }

    private void UpdateMoneyLabelForSell() throws UnknownObjectException, MissionNotLoaded {
        int money= MoneyForSell();
        coinTextForSell.setText(String.valueOf(money));
    }

    private int MoneyForSell() throws UnknownObjectException {
        int result=0;
        InformationNeededInGame informationNeededInGame=Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
        result+=Integer.valueOf(labelEggButton1.getText())*informationNeededInGame.getPriceForSell(new Egg());
        result+=Integer.valueOf(labelWoolButton1.getText())*informationNeededInGame.getPriceForSell(new Wool());
        result+=Integer.valueOf(labelMilkButton1.getText())*informationNeededInGame.getPriceForSell(new Milk());
        result+=Integer.valueOf(labelCakeButton1.getText())*informationNeededInGame.getPriceForSell(new Cake());
        result+=Integer.valueOf(labelFabricButton1.getText())*informationNeededInGame.getPriceForSell(new Fabric());
        result+=Integer.valueOf(labelDecorationButton1.getText())*informationNeededInGame.getPriceForSell(new Decoration());
        result+=Integer.valueOf(labelFlouryCakeButton1.getText())*informationNeededInGame.getPriceForSell(new FlouryCake());
        result+=Integer.valueOf(labelFlourButton1.getText())*informationNeededInGame.getPriceForSell(new Flour());
        result+=Integer.valueOf(labelPowderButton1.getText())*informationNeededInGame.getPriceForSell(new Powder());
        result+=Integer.valueOf(labelCarnivalDressButton1.getText())*informationNeededInGame.getPriceForSell(new CarnivalDress());
        result+=Integer.valueOf(labelSewingButton1.getText())*informationNeededInGame.getPriceForSell(new Sewing());
        result+=Integer.valueOf(labelCageLionButton1.getText())*informationNeededInGame.getPriceForSell(new Cage(new Lion()));
        result+=Integer.valueOf(labelCageBearButton1.getText())*informationNeededInGame.getPriceForSell(new Cage(new Bear()));
        return result;
    }

    private void MakeLabelAndButtonChangableّForSell(int maxNumber, ImageView imageViewButton1, Label labelButton, ImageView allViewButton
            , Label allLabel) throws MissionNotLoaded {
        int capacityOfOnlineShop=100000;
        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < maxNumber) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                    if (getCapacityNeeded()>capacityOfOnlineShop){
                        labelButton.setText(String.valueOf(0));
                        PlayErrorSound();
                    }
                } else if (nowInt == maxNumber) {
                    labelButton.setText("0");
                }
                try {
                    UpdateMoneyLabelForSell();
                } catch (UnknownObjectException e) {
                    e.printStackTrace();
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
        labelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < maxNumber) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                    if (getCapacityNeeded()>capacityOfOnlineShop){
                        labelButton.setText(String.valueOf(0));
                        PlayErrorSound();
                    }
                } else if (nowInt == maxNumber) {
                    labelButton.setText("0");
                }
                try {
                    UpdateMoneyLabelForSell();
                } catch (UnknownObjectException e) {
                    e.printStackTrace();
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
        allViewButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String currentText=labelButton.getText();
                labelButton.setText(String.valueOf(maxNumber));
                if (getCapacityNeeded()>capacityOfOnlineShop){
                    labelButton.setText(currentText);
                    PlayErrorSound();
                }
                try {
                    UpdateMoneyLabelForSell();
                } catch (UnknownObjectException e) {
                    e.printStackTrace();
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
        allLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String currentText=labelButton.getText();
                labelButton.setText(String.valueOf(maxNumber));
                if (getCapacityNeeded()>capacityOfOnlineShop){
                    labelButton.setText(currentText);
                    PlayErrorSound();
                }
                try {
                    UpdateMoneyLabelForSell();
                } catch (UnknownObjectException e) {
                    e.printStackTrace();
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
    }

    private void AddItemToBuyFlouryCake() throws UnknownObjectException {
        File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new FlouryCake()))); // price of egg
        labelOfPrice.relocate(300, 130);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130);


        labelButtonFlouryCake.relocate(455, 130 + 5);
        labelButtonFlouryCake.setTextFill(Color.BLACK);
        labelButtonFlouryCake.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130);
            }
        });

        labelButtonFlouryCake.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5);
            }
        });
        labelButtonFlouryCake.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130);
            }
        });

        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonFlouryCake);

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonFlouryCake, labelOfPrice);

    }
    private void AddItemToBuyCake() throws UnknownObjectException {
        int shift = 50;
        File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new Cake()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonCake.relocate(455, 130 + 5 + shift);
        labelButtonCake.setTextFill(Color.BLACK);
        labelButtonCake.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });
        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });
        labelButtonCake.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });
        labelButtonCake.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });
        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonCake);

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCake, labelOfPrice);
    }
    private void AddItemToBuyFlour() throws UnknownObjectException {
        int shift = 100;
        File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new Flour()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButton1Flour.relocate(455, 130 + 5 + shift);
        labelButton1Flour.setTextFill(Color.BLACK);
        labelButton1Flour.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        labelButton1Flour.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButton1Flour.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButton1Flour, labelOfPrice);
        MakeLabelAndButtonChangeable(imageViewButton1, labelButton1Flour);
    }
    private void AddItemToBuyPowder() throws UnknownObjectException {
        int shift = 150;
        File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new Powder()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonPowder.relocate(455, 130 + 5 + shift);
        labelButtonPowder.setTextFill(Color.BLACK);
        labelButtonPowder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonPowder);

        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });


        labelButtonPowder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonPowder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonPowder, labelOfPrice);
    }
    private void AddItemToBuyCarnivalDress() throws UnknownObjectException {
        int shift = 200;
        File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new CarnivalDress()))); // price of egg
        labelOfPrice.relocate(295, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonCarnivalDress.relocate(455, 130 + 5 + shift);
        labelButtonCarnivalDress.setTextFill(Color.BLACK);
        labelButtonCarnivalDress.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });


        labelButtonCarnivalDress.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonCarnivalDress.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonCarnivalDress);
        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCarnivalDress, labelOfPrice);
    }
    private void AddItemToBuyDecoration() throws UnknownObjectException {
        int shift = 250;
        File fileIcon = new File("Data\\Textures\\Products\\Adornment.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new Decoration()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonDecoration.relocate(455, 130 + 5 + shift);
        labelButtonDecoration.setTextFill(Color.BLACK);
        labelButtonDecoration.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });


        labelButtonDecoration.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonDecoration.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonDecoration, labelOfPrice);
        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonDecoration);
    }
    private void AddItemToBuyFabric() throws UnknownObjectException {
        int shift = 300;
        File fileIcon = new File("Data\\Textures\\Products\\Fabric.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new Fabric()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonFabric.relocate(455, 130 + 5 + shift);
        labelButtonFabric.setTextFill(Color.BLACK);
        labelButtonFabric.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        labelButtonFabric.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonFabric.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonFabric);
        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonFabric, labelOfPrice);
    }
    private void AddItemToBuySewing() throws UnknownObjectException {
        int shift = 350;
        File fileIcon = new File("Data\\Textures\\Products\\Sewing.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(215, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceToBuy(new Sewing()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(365, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);


        labelButtonSewing.relocate(455, 130 + 5 + shift);
        labelButtonSewing.setTextFill(Color.BLACK);
        labelButtonSewing.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        MakeLabelAndButtonChangeable(imageViewButton1, labelButtonSewing);

        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        labelButtonSewing.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonSewing.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1);
        root.getChildren().addAll(imageViewCoin);
        root.getChildren().addAll(imageViewIcon);
        root.getChildren().addAll(labelButtonSewing);
        root.getChildren().addAll(labelOfPrice);
    }

    private void ShowWareHouseListInOnlineShopView() {
        try {
            WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
            HashMap<String, Integer> hashMap = wareHouse.getTypeAndNumberOfProductInWAreHouse();
            int yLocationOfFirst = 150;
            int SHIFT = 480;
            InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey(); // getClass
                Object object = entry.getKey();
                Integer value = entry.getValue();
                if (key.equals("Egg")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Egg\\normal.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelEggOfNumber = new Label(value.toString());
                    labelEggOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelEggOfNumber.setTextFill(Color.BLACK);
                    labelEggOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelEggButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelEggButton1.setTextFill(Color.BLACK);
                    labelEggButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });
                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelEggButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });
                    labelEggButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });




                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelEggOfNumber.getText()),imageViewButton1,labelEggButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelEggButton1, labelButtonAll, labelEggOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Wool")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Wool\\normal.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelWoolOfNumber = new Label(value.toString());
                    labelWoolOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelWoolOfNumber.setTextFill(Color.BLACK);
                    labelWoolOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelWoolButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelWoolButton1.setTextFill(Color.BLACK);
                    labelWoolButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });
                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });
                    labelWoolButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });
                    labelWoolButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });



                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelWoolOfNumber.getText()),imageViewButton1,labelWoolButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelWoolButton1, labelButtonAll, labelWoolOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Milk")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Milk.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelMilkOfNumber = new Label(value.toString());
                    labelMilkOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelMilkOfNumber.setTextFill(Color.BLACK);
                    labelMilkOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelMilkButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelMilkButton1.setTextFill(Color.BLACK);
                    labelMilkButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelMilkButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelMilkButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);


                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelMilkOfNumber.getText()),imageViewButton1,labelMilkButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelMilkButton1, labelButtonAll, labelMilkOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("FlouryCake")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelFlouryCakeOfNumber = new Label(value.toString());
                    labelFlouryCakeOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelFlouryCakeOfNumber.setTextFill(Color.BLACK);
                    labelFlouryCakeOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelFlouryCakeButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelFlouryCakeButton1.setTextFill(Color.BLACK);
                    labelFlouryCakeButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelFlouryCakeButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFlouryCakeButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });



                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelFlouryCakeOfNumber.getText()),imageViewButton1,labelFlouryCakeButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelFlouryCakeButton1, labelButtonAll, labelFlouryCakeOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Cake")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelCakeOfNumber = new Label(value.toString());
                    labelCakeOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelCakeOfNumber.setTextFill(Color.BLACK);
                    labelCakeOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230+ SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelCakeButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelCakeButton1.setTextFill(Color.BLACK);
                    labelCakeButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelCakeButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelCakeButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCakeOfNumber.getText()),imageViewButton1,labelCakeButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelCakeButton1, labelButtonAll, labelCakeOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Flour")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelFlourOfNumber = new Label(value.toString());
                    labelFlourOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelFlourOfNumber.setTextFill(Color.BLACK);
                    labelFlourOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelFlourButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelFlourButton1.setTextFill(Color.BLACK);
                    labelFlourButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelFlourButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFlourButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelFlourOfNumber.getText()),imageViewButton1,labelFlourButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelFlourButton1, labelButtonAll, labelFlourOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Powder")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png"); // not image
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelPowderOfNumber = new Label(value.toString());
                    labelPowderOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelPowderOfNumber.setTextFill(Color.BLACK);
                    labelPowderOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelPowderButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelPowderButton1.setTextFill(Color.BLACK);
                    labelPowderButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelPowderButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelPowderButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelPowderOfNumber.getText()),imageViewButton1, labelPowderButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelPowderButton1, labelButtonAll, labelPowderOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("CarnivalDress")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelCarnivalDressOfNumber = new Label(value.toString());
                    labelCarnivalDressOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelCarnivalDressOfNumber.setTextFill(Color.BLACK);
                    labelCarnivalDressOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelCarnivalDressButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelCarnivalDressButton1.setTextFill(Color.BLACK);
                    labelCarnivalDressButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelCarnivalDressButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelCarnivalDressButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCarnivalDressOfNumber.getText()),imageViewButton1,labelCarnivalDressButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelCarnivalDressButton1, labelButtonAll, labelCarnivalDressOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Decoration")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Decoration.png"); // todo
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelDecorationOfNumber = new Label(value.toString());
                    labelDecorationOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelDecorationOfNumber.setTextFill(Color.BLACK);
                    labelDecorationOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelDecorationButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelDecorationButton1.setTextFill(Color.BLACK);
                    labelDecorationButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelDecorationButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelDecorationButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelDecorationOfNumber.getText()),imageViewButton1,labelDecorationButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelDecorationButton1, labelButtonAll, labelDecorationOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Fabric")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Fabric.png"); // not image
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelFabricOfNumber = new Label(value.toString());
                    labelFabricOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelFabricOfNumber.setTextFill(Color.BLACK);
                    labelFabricOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelFabricButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelFabricButton1.setTextFill(Color.BLACK);
                    labelFabricButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelFabricButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFabricButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelFabricOfNumber.getText()),imageViewButton1,labelFabricButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelFabricButton1, labelButtonAll, labelFabricOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Sewing")) {
                    final int finalYLocationOfFirst = yLocationOfFirst;
                    File fileIcon = new File("Data\\Textures\\Products\\Sewing.png"); // not image
                    Image imageIcon = new Image(fileIcon.toURI().toString());
                    ImageView imageViewIcon = new ImageView(imageIcon);
                    imageViewIcon.setFitHeight(30);
                    imageViewIcon.setFitWidth(30);
                    imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                    Label labelSewingOfNumber = new Label(value.toString());
                    labelSewingOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                    labelSewingOfNumber.setTextFill(Color.BLACK);
                    labelSewingOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                    labelSewingButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelSewingButton1.setTextFill(Color.BLACK);
                    labelSewingButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelSewingButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelSewingButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelSewingOfNumber.getText()),imageViewButton1,labelSewingButton1,imageViewButtonAll,labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelSewingButton1, labelButtonAll, labelSewingOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.substring(0,4).equals("Cage")) {
                    if (key.equals("CageLion")) {
                        final int finalYLocationOfFirst = yLocationOfFirst;
                        File fileIcon = new File("Data\\Textures\\Products\\CagedLion.png"); // not image
                        Image imageIcon = new Image(fileIcon.toURI().toString());
                        ImageView imageViewIcon = new ImageView(imageIcon);
                        imageViewIcon.setFitHeight(30);
                        imageViewIcon.setFitWidth(30);
                        imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                        File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                        Image imageMultiply = new Image(fileMultiply.toURI().toString());
                        ImageView imageViewMultiply = new ImageView(imageMultiply);
                        imageViewMultiply.setFitWidth(30);
                        imageViewMultiply.setFitHeight(30);
                        imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                        Label labelCageLionOfNumber = new Label(value.toString());
                        labelCageLionOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                        labelCageLionOfNumber.setTextFill(Color.BLACK);
                        labelCageLionOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Cage(new Lion())))); // price of egg
                        labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                        labelOfPrice.setTextFill(Color.BLACK);
                        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        File fileOfCoin = new File("Data\\Shop\\Coin.png");
                        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                        ImageView imageViewCoin = new ImageView(imageOfCoin);
                        imageViewCoin.setFitWidth(30);
                        imageViewCoin.setFitHeight(30);
                        imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                        File fileButton1 = new File("Data\\Click\\OkButton.png");
                        Image imageButton1 = new Image(fileButton1.toURI().toString());
                        ImageView imageViewButton1 = new ImageView(imageButton1);
                        imageViewButton1.setFitHeight(35);
                        imageViewButton1.setFitWidth(35);
                        imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                        labelCageLionButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                        labelCageLionButton1.setTextFill(Color.BLACK);
                        labelCageLionButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                            }
                        });

                        labelCageLionButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelCageLionButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                            }
                        });


                        File fileButtonAll = new File("Data\\Click\\OkButton.png");
                        Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                        ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                        imageViewButtonAll.setFitHeight(35);
                        imageViewButtonAll.setFitWidth(45);
                        imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                        Label labelButtonAll = new Label("All");
                        labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                        labelButtonAll.setTextFill(Color.BLACK);
                        labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                            }
                        });

                        labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                            }
                        });

                        MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCageLionOfNumber.getText()),imageViewButton1,labelCageLionButton1,imageViewButtonAll,labelButtonAll);

                        root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                                , imageViewMultiply, labelCageLionButton1, labelButtonAll, labelCageLionOfNumber, labelOfPrice);
                        yLocationOfFirst += 50;
                    } else if (key.equals("CageBear")) {
                        final int finalYLocationOfFirst = yLocationOfFirst;
                        File fileIcon = new File("Data\\Textures\\Products\\CagedBrownBear.png"); // not image
                        Image imageIcon = new Image(fileIcon.toURI().toString());
                        ImageView imageViewIcon = new ImageView(imageIcon);
                        imageViewIcon.setFitHeight(30);
                        imageViewIcon.setFitWidth(30);
                        imageViewIcon.relocate(150 + SHIFT, finalYLocationOfFirst);

                        File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                        Image imageMultiply = new Image(fileMultiply.toURI().toString());
                        ImageView imageViewMultiply = new ImageView(imageMultiply);
                        imageViewMultiply.setFitWidth(30);
                        imageViewMultiply.setFitHeight(30);
                        imageViewMultiply.relocate(185 + SHIFT, finalYLocationOfFirst);

                        Label labelCageBrearOfNumber = new Label(value.toString());
                        labelCageBrearOfNumber.relocate(190 + SHIFT, finalYLocationOfFirst);
                        labelCageBrearOfNumber.setTextFill(Color.BLACK);
                        labelCageBrearOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Cage(new Bear())))); // price of egg
                        labelOfPrice.relocate(230 + SHIFT, finalYLocationOfFirst);
                        labelOfPrice.setTextFill(Color.BLACK);
                        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        File fileOfCoin = new File("Data\\Shop\\Coin.png");
                        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                        ImageView imageViewCoin = new ImageView(imageOfCoin);
                        imageViewCoin.setFitWidth(30);
                        imageViewCoin.setFitHeight(30);
                        imageViewCoin.relocate(310 + SHIFT, finalYLocationOfFirst);

                        File fileButton1 = new File("Data\\Click\\OkButton.png");
                        Image imageButton1 = new Image(fileButton1.toURI().toString());
                        ImageView imageViewButton1 = new ImageView(imageButton1);
                        imageViewButton1.setFitHeight(35);
                        imageViewButton1.setFitWidth(35);
                        imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);


                        labelCageBearButton1.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                        labelCageBearButton1.setTextFill(Color.BLACK);
                        labelCageBearButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                            }
                        });

                        labelCageBearButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelCageBearButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370 + SHIFT, finalYLocationOfFirst);
                            }
                        });


                        File fileButtonAll = new File("Data\\Click\\OkButton.png");
                        Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                        ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                        imageViewButtonAll.setFitHeight(35);
                        imageViewButtonAll.setFitWidth(45);
                        imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);

                        Label labelButtonAll = new Label("All");
                        labelButtonAll.relocate(443 + SHIFT, finalYLocationOfFirst + 5);
                        labelButtonAll.setTextFill(Color.BLACK);
                        labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                            }
                        });

                        labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435 + SHIFT, finalYLocationOfFirst);
                            }
                        });

                        MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCageBrearOfNumber.getText()),imageViewButton1,labelCageBearButton1,imageViewButtonAll,labelButtonAll);

                        root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                                , imageViewMultiply, labelCageBearButton1, labelButtonAll, labelCageBrearOfNumber, labelOfPrice);
                        yLocationOfFirst += 50;
                    }
                }
            }

        } catch (MissionNotLoaded | UnknownObjectException missionNotLoaded) {
            missionNotLoaded.printStackTrace();
        }
    }

    private void AddMoneyLabels(){

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(200, 615);

        ImageView coint2 = new ImageView(imageOfCoin);
        coint2.setFitWidth(30);
        coint2.setFitHeight(30);
        coint2.relocate(650, 615);

        coinTextForSell.setFont(Font.font(25));
        coinTextForOrder.setFont(Font.font(25));
        coinTextForOrder.relocate(250,610);
        coinTextForSell.relocate(700,610);
        root.getChildren().addAll(coinTextForSell,coinTextForOrder,imageViewCoin,coint2);
    }

}
