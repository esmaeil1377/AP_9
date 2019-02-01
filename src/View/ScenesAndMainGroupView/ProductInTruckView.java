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
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.User;
import View.View;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
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
import javafx.scene.control.Label;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import View.GameView;


public class ProductInTruckView extends View {
    double xShift = 0.788;
    double yShift = 0.788;
    private Text coinText=new Text("0");;
    private Group root = new Group();
    private Scene scene = new Scene(root, (int) (xShift * 1600), (int) (yShift * 900));
    private Label labelEggOfNumber;
    private Label labelWoolOfNumber;
    private Label labelMilkOfNumber;
    private Label labelFlouryCakeOfNumber;
    private Label labelCakeOfNumber;
    private Label labelFlourOfNumber;
    private Label labelPowderOfNumber;
    private Label labelCarnivalDressOfNumber;
    private Label labelDecorationOfNumber;
    private Label labelFabricOfNumber;
    private Label labelSewingOfNumber;
    private Label labelCageLionOfNumber;
    private Label labelCageBrearOfNumber;
    private Label labelEggButton1 = new Label("0");
    private Label labelWoolButton1 = new Label("0");
    private Label labelMilkButton1 = new Label("0");
    private Label labelFlouryCakeButton1 = new Label("0");
    private Label labelCakeButton1 = new Label("0");
    private Label labelFlourButton1 = new Label("0");
    private Label labelPowderButton1 = new Label("0");
    private Label labelCarnivalDressButton1 = new Label("0");
    private Label labelDecorationButton1 = new Label("0");
    private Label labelFabricButton1 = new Label("0");
    private Label labelSewingButton1 = new Label("0");
    private Label labelCageLionButton1 = new Label("0");
    private Label labelCageBearButton1 = new Label("0");
    private ArrayList<Rectangle> barRectangles=new ArrayList<>();
    private User user=Game.getGameInstance().getCurrentUserAccount();

    public Scene getScene() {
        return scene;
    }

    public ProductInTruckView(Stage primaryStage) throws UnknownObjectException, MissionNotLoaded {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) throws UnknownObjectException, MissionNotLoaded {
        UpdateMoneyLabelForSellAndCapacityBar();
        AddShopBackgroundTBackground(primaryStage);
        AddIcons();
        AddItems();
        AddOkAndCancelButton(primaryStage);
        ShowWareHouseListInTruckView();
    }
    private void AddShopBackgroundTBackground(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
        root.getChildren().addAll(BackGroundView);
    }


    private void AddIcons() {
        Rectangle rect_1 = new Rectangle((int) (xShift * 500), (int) (yShift * 875));
        rect_1.setOpacity(0.6);
        rect_1.setArcHeight(70);
        rect_1.setArcWidth(70);
        rect_1.setFill(Color.rgb(64, 45, 67));
        rect_1.relocate((int) (xShift * 150), (int) (yShift * 110));

        Rectangle rect_2 = new Rectangle((int) (xShift * 500), (int) (yShift * 875));
        rect_2.setOpacity(0.6);
        rect_2.setArcHeight(70);
        rect_2.setArcWidth(70);
        rect_2.setFill(Color.rgb(64, 45, 67));
        rect_2.relocate((int) (xShift * 670), (int) (yShift * 110));

        Rectangle rect_3 = new Rectangle((int) (xShift * 500), (int) (yShift * 300));
        rect_3.setOpacity(0.6);
        rect_3.setArcHeight(70);
        rect_3.setArcWidth(70);
        rect_3.setFill(Color.rgb(64, 45, 67));
        rect_3.relocate((int) (xShift * 1190), (int) (yShift * 110));

        Rectangle rect_4 = new Rectangle((int) (xShift * 500), (int) (yShift * 100));
        rect_4.setOpacity(0.6);
        rect_4.setArcHeight(70);
        rect_4.setArcWidth(70);
        rect_4.setFill(Color.rgb(64, 45, 67));
        rect_4.relocate((int) (xShift * 1225), (int) (yShift * 900));

        Rectangle rect_5 = new Rectangle((int) (xShift * 450), (int) (yShift * 750));
        rect_5.setOpacity(0.6);
        rect_5.setArcHeight(50);
        rect_5.setArcWidth(50);
        rect_5.setFill(Color.rgb(64, 45, 67));
        rect_5.relocate((int) (xShift * 175), (int) (yShift * 200));

        Rectangle rect_6 = new Rectangle((int) (xShift * 450), (int) (yShift * 750));
        rect_6.setOpacity(0.6);
        rect_6.setArcHeight(50);
        rect_6.setArcWidth(50);
        rect_6.setFill(Color.rgb(64, 45, 67));
        rect_6.relocate((int) (xShift * 695), (int) (yShift * 200));

        Rectangle rect_7 = new Rectangle((int) (xShift * 450), (int) (yShift * 175));
        rect_7.setOpacity(0.6);
        rect_7.setArcHeight(50);
        rect_7.setArcWidth(50);
        rect_7.setFill(Color.rgb(64, 45, 67));
        rect_7.relocate((int) (xShift * 1215), (int) (yShift * 200));

        Rectangle rect_8 = new Rectangle((int) (xShift * 450), (int) (yShift * 75));
        rect_8.setOpacity(0.6);
        rect_8.setArcHeight(50);
        rect_8.setArcWidth(50);
        rect_8.setFill(Color.rgb(64, 45, 67));
        rect_8.relocate((int) (xShift * 1250), (int) (yShift * 915));
        root.getChildren().addAll(rect_1, rect_2, rect_3, rect_4, rect_5, rect_6, rect_7, rect_8);
    }

    private void AddItems() {
        File truck = new File("Data\\Textures\\UI\\Truck\\0" + String.valueOf(user.getTruckLevel() + 1) + ".png");
        Image truckImage = new Image(truck.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.setFitHeight((int) (yShift * 750));
        truckView.setFitWidth((int) (xShift * 600));
        truckView.relocate((int) (xShift * 1175), (int) (yShift * 320));

        File coin = new File("Data\\Shop\\Coin.png");
        Image coinImage = new Image(coin.toURI().toString());
        ImageView coinView = new ImageView(coinImage);
        coinView.setFitHeight((int) (yShift * 50));
        coinView.setFitWidth((int) (xShift * 50));
        coinView.relocate((int) (xShift * 1275), (int) (yShift * 925));

        coinText.relocate((int) (xShift * 1475), (int) (yShift * 945));
        coinText.setFont(Font.font(30));
        coinText.setStyle("-fx-font-weight: bold");
        coinText.setFill(Color.rgb(244, 240, 16));

        File shipProductText = new File("Data\\Shop\\ShipProductsText.png");
        Image shipProductTextImage = new Image(shipProductText.toURI().toString());
        ImageView shipProductTextView = new ImageView(shipProductTextImage);
        shipProductTextView.setFitHeight((int) yShift * 125);
        shipProductTextView.setFitWidth((int) xShift * 400);
        shipProductTextView.relocate((int) xShift * 700, (int) yShift * (-10));


        File goodsText = new File("Data\\Shop\\GoodsText.png");
        Image goodsTextImage = new Image(goodsText.toURI().toString());
        ImageView goodsTextView = new ImageView(goodsTextImage);
        goodsTextView.setFitHeight((int) (yShift * 40));
        goodsTextView.setFitWidth((int) (xShift * 75));
        goodsTextView.relocate((int) (xShift * 200), (int) (yShift * 150));

        File priceText = new File("Data\\Shop\\PriceText.png");
        Image priceTextImage = new Image(priceText.toURI().toString());
        ImageView priceTextView = new ImageView(priceTextImage);
        priceTextView.setFitHeight((int) (yShift * 40));
        priceTextView.setFitWidth((int) (xShift * 75));
        priceTextView.relocate((int) (xShift * 350), (int) (yShift * 150));

        File shipText = new File("Data\\Shop\\ShipText.png");
        Image shipTextImage = new Image(shipText.toURI().toString());
        ImageView shipTextView = new ImageView(shipTextImage);
        shipTextView.setFitHeight((int) (yShift * 40));
        shipTextView.setFitWidth((int) (xShift * 75));
        shipTextView.relocate((int) (xShift * 500), (int) (yShift * 150));

        File goodsText_1 = new File("Data\\Shop\\GoodsText.png");
        Image goodsTextImage_1 = new Image(goodsText_1.toURI().toString());
        ImageView goodsTextView_1 = new ImageView(goodsTextImage_1);
        goodsTextView_1.setFitHeight((int) (yShift * 40));
        goodsTextView_1.setFitWidth((int) (xShift * 75));
        goodsTextView_1.relocate((int) (xShift * 725), (int) (yShift * 150));

        File priceText_1 = new File("Data\\Shop\\PriceText.png");
        Image priceTextImage_1 = new Image(priceText_1.toURI().toString());
        ImageView priceTextView_1 = new ImageView(priceTextImage_1);
        priceTextView_1.setFitHeight((int) (yShift * 40));
        priceTextView_1.setFitWidth((int) (xShift * 75));
        priceTextView_1.relocate((int) (xShift * 875), (int) (yShift * 150));

        File shipText_1 = new File("Data\\Shop\\ShipText.png");
        Image shipTextImage_1 = new Image(shipText_1.toURI().toString());
        ImageView shipTextView_1 = new ImageView(shipTextImage_1);
        shipTextView_1.setFitHeight((int) (yShift * 40));
        shipTextView_1.setFitWidth((int) (xShift * 75));
        shipTextView_1.relocate((int) (xShift * 1025), (int) (yShift * 150));

        File animalsText = new File("Data\\Shop\\AnimalsText.png");
        Image animalsTextImage = new Image(animalsText.toURI().toString());
        ImageView animalsTextView = new ImageView(animalsTextImage);
        animalsTextView.setFitHeight((int) (yShift * 40));
        animalsTextView.setFitWidth((int) (xShift * 100));
        animalsTextView.relocate((int) (xShift * 1250), (int) (yShift * 150));

        File priceText_2 = new File("Data\\Shop\\PriceText.png");
        Image priceTextImage_2 = new Image(priceText_2.toURI().toString());
        ImageView priceTextView_2 = new ImageView(priceTextImage_2);
        priceTextView_2.setFitHeight((int) (yShift * 40));
        priceTextView_2.setFitWidth((int) (xShift * 75));
        priceTextView_2.relocate((int) (xShift * 1400), (int) (yShift * 150));

        File shipText_2 = new File("Data\\Shop\\ShipText.png");
        Image shipTextImage_2 = new Image(shipText_2.toURI().toString());
        ImageView shipTextView_2 = new ImageView(shipTextImage_2);
        shipTextView_2.setFitHeight((int) (yShift * 40));
        shipTextView_2.setFitWidth((int) (xShift * 75));
        shipTextView_2.relocate((int) (xShift * 1550), (int) (yShift * 150));


        root.getChildren().addAll(truckView, coinView, coinText, shipProductTextView, shipTextView);
        root.getChildren().addAll(goodsTextView, priceTextView, shipTextView_1, priceTextView_1, goodsTextView_1);
        root.getChildren().addAll(animalsTextView, priceTextView_2, shipTextView_2);

    }

    public Text getCoinText() {
        return coinText;
    }

    private void AddOkAndCancelButton(Stage primaryStage) {
        File button = new File("Data\\Click\\OkButton.png");
        Image buttonImage = new Image(button.toURI().toString());
        ImageView buttonView = new ImageView(buttonImage);
        buttonView.setFitHeight((int) (yShift * 75));
        buttonView.setFitWidth((int) (xShift * 160));
        buttonView.relocate((int) (xShift * 750), (int) (yShift * 1000));
        buttonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonView.relocate((int) (xShift * 745), (int) (yShift * 995));
                buttonView.setFitHeight((int) (yShift * 85));
                buttonView.setFitWidth((int) (xShift * 170));
            }
        });
        buttonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonView.setFitHeight((int) (yShift * 75));
                buttonView.setFitWidth((int) (xShift * 160));
                buttonView.relocate((int) (xShift * 750), (int) (yShift * 1000));
            }
        });
        File okText = new File("Data\\Shop\\OkText.png");

        Image okTextImage = new Image(okText.toURI().toString());
        ImageView okTextView = new ImageView(okTextImage);
        okTextView.setFitHeight((int) (yShift * 50));
        okTextView.setFitWidth((int) (xShift * 100));
        okTextView.relocate((int) (xShift * 775), (int) (yShift * 1014));
        okTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonView.relocate((int) (xShift * 745), (int) (yShift * 995));
                buttonView.setFitHeight((int) (yShift * 85));
                buttonView.setFitWidth((int) (xShift * 170));
            }
        });
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonView.setFitHeight((int) (yShift * 75));
                buttonView.setFitWidth((int) (xShift * 150));
                buttonView.relocate((int) (xShift * 750), (int) (yShift * 1000));
            }
        });

        MakeOkButton(primaryStage,buttonView,okTextView);


        ImageView cancelButtonView = new ImageView(buttonImage);
        cancelButtonView.setFitHeight((int) (yShift * 75));
        cancelButtonView.setFitWidth((int) (xShift * 160));
        cancelButtonView.relocate((int) (xShift * 925), (int) (yShift * 1000));
        cancelButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.relocate((int) (xShift * 920), (int) (yShift * 995));
                cancelButtonView.setFitHeight((int) (yShift * 85));
                cancelButtonView.setFitWidth((int) (xShift * 170));
            }
        });
        cancelButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight((int) (yShift * 75));
                cancelButtonView.setFitWidth((int) (xShift * 160));
                cancelButtonView.relocate((int) (xShift * 925), (int) (yShift * 1000));
            }
        });
        cancelButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                AnimationTimer animationTimer = GameView.getGameView().getFarmView().getAnimationTimer();
                animationTimer.start();
                primaryStage.setScene(GameView.getGameView().getFarmView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        File cancelText = new File("Data\\Shop\\CancelText.png");
        Image cancelTextImage = new Image(cancelText.toURI().toString());
        ImageView cancelTextView = new ImageView(cancelTextImage);
        cancelTextView.setFitHeight((int) (yShift * 60));
        cancelTextView.setFitWidth((int) (xShift * 120));
        cancelTextView.relocate((int) (xShift * 947), (int) (yShift * 1007));
        cancelTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.relocate((int) (xShift * 920), (int) (yShift * 995));
                cancelButtonView.setFitHeight((int) (yShift * 85));
                cancelButtonView.setFitWidth((int) (xShift * 170));
            }
        });
        cancelTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                AnimationTimer animationTimer = GameView.getGameView().getFarmView().getAnimationTimer();
                animationTimer.start();
                primaryStage.setScene(GameView.getGameView().getFarmView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        root.getChildren().addAll(buttonView, okTextView, cancelButtonView, cancelTextView);
    }


    private void ShowWareHouseListInTruckView() {
        try {
            WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
            ArrayList<Object> arrayList = wareHouse.getWareHouseList();
            HashMap<String, Integer> hashMap = wareHouse.getTypeAndNumberOfProductInWAreHouse();
            int yLocationOfFirst = 170;
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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelEggOfNumber = new Label(value.toString());
                    labelEggOfNumber.relocate(190, finalYLocationOfFirst);
                    labelEggOfNumber.setTextFill(Color.BLACK);
                    labelEggOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelEggButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelEggButton1.setTextFill(Color.BLACK);
                    labelEggButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });
                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelEggButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });
                    labelEggButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });




                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelEggOfNumber.getText()),imageViewButton1,labelEggButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelWoolOfNumber = new Label(value.toString());
                    labelWoolOfNumber.relocate(190, finalYLocationOfFirst);
                    labelWoolOfNumber.setTextFill(Color.BLACK);
                    labelWoolOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelWoolButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelWoolButton1.setTextFill(Color.BLACK);
                    labelWoolButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });
                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });
                    labelWoolButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });
                    labelWoolButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });



                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelWoolOfNumber.getText()),imageViewButton1,labelWoolButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelMilkOfNumber = new Label(value.toString());
                    labelMilkOfNumber.relocate(190, finalYLocationOfFirst);
                    labelMilkOfNumber.setTextFill(Color.BLACK);
                    labelMilkOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelMilkButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelMilkButton1.setTextFill(Color.BLACK);
                    labelMilkButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelMilkButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelMilkButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);


                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelMilkOfNumber.getText()),imageViewButton1,labelMilkButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelFlouryCakeOfNumber = new Label(value.toString());
                    labelFlouryCakeOfNumber.relocate(190, finalYLocationOfFirst);
                    labelFlouryCakeOfNumber.setTextFill(Color.BLACK);
                    labelFlouryCakeOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelFlouryCakeButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelFlouryCakeButton1.setTextFill(Color.BLACK);
                    labelFlouryCakeButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelFlouryCakeButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFlouryCakeButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });



                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelFlouryCakeOfNumber.getText()),imageViewButton1,labelFlouryCakeButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelCakeOfNumber = new Label(value.toString());
                    labelCakeOfNumber.relocate(190, finalYLocationOfFirst);
                    labelCakeOfNumber.setTextFill(Color.BLACK);
                    labelCakeOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelCakeButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelCakeButton1.setTextFill(Color.BLACK);
                    labelCakeButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelCakeButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelCakeButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelCakeOfNumber.getText()),imageViewButton1,labelCakeButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelFlourOfNumber = new Label(value.toString());
                    labelFlourOfNumber.relocate(190, finalYLocationOfFirst);
                    labelFlourOfNumber.setTextFill(Color.BLACK);
                    labelFlourOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelFlourButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelFlourButton1.setTextFill(Color.BLACK);
                    labelFlourButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelFlourButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFlourButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelFlourOfNumber.getText()),imageViewButton1,labelFlourButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelPowderOfNumber = new Label(value.toString());
                    labelPowderOfNumber.relocate(190, finalYLocationOfFirst);
                    labelPowderOfNumber.setTextFill(Color.BLACK);
                    labelPowderOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelPowderButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelPowderButton1.setTextFill(Color.BLACK);
                    labelPowderButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelPowderButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelPowderButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelPowderOfNumber.getText()),imageViewButton1, labelPowderButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelCarnivalDressOfNumber = new Label(value.toString());
                    labelCarnivalDressOfNumber.relocate(190, finalYLocationOfFirst);
                    labelCarnivalDressOfNumber.setTextFill(Color.BLACK);
                    labelCarnivalDressOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelCarnivalDressButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelCarnivalDressButton1.setTextFill(Color.BLACK);
                    labelCarnivalDressButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelCarnivalDressButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelCarnivalDressButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelCarnivalDressOfNumber.getText()),imageViewButton1,labelCarnivalDressButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelDecorationOfNumber = new Label(value.toString());
                    labelDecorationOfNumber.relocate(190, finalYLocationOfFirst);
                    labelDecorationOfNumber.setTextFill(Color.BLACK);
                    labelDecorationOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelDecorationButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelDecorationButton1.setTextFill(Color.BLACK);
                    labelDecorationButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelDecorationButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelDecorationButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelDecorationOfNumber.getText()),imageViewButton1,labelDecorationButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelFabricOfNumber = new Label(value.toString());
                    labelFabricOfNumber.relocate(190, finalYLocationOfFirst);
                    labelFabricOfNumber.setTextFill(Color.BLACK);
                    labelFabricOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelFabricButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelFabricButton1.setTextFill(Color.BLACK);
                    labelFabricButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelFabricButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFabricButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelFabricOfNumber.getText()),imageViewButton1,labelFabricButton1,imageViewButtonAll,labelButtonAll);

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
                    imageViewIcon.relocate(150, finalYLocationOfFirst);

                    File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                    Image imageMultiply = new Image(fileMultiply.toURI().toString());
                    ImageView imageViewMultiply = new ImageView(imageMultiply);
                    imageViewMultiply.setFitWidth(30);
                    imageViewMultiply.setFitHeight(30);
                    imageViewMultiply.relocate(185, finalYLocationOfFirst);

                    labelSewingOfNumber = new Label(value.toString());
                    labelSewingOfNumber.relocate(190, finalYLocationOfFirst);
                    labelSewingOfNumber.setTextFill(Color.BLACK);
                    labelSewingOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(230, finalYLocationOfFirst);
                    labelOfPrice.setTextFill(Color.BLACK);
                    labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    File fileOfCoin = new File("Data\\Shop\\Coin.png");
                    Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                    ImageView imageViewCoin = new ImageView(imageOfCoin);
                    imageViewCoin.setFitWidth(30);
                    imageViewCoin.setFitHeight(30);
                    imageViewCoin.relocate(310, finalYLocationOfFirst);

                    File fileButton1 = new File("Data\\Click\\OkButton.png");
                    Image imageButton1 = new Image(fileButton1.toURI().toString());
                    ImageView imageViewButton1 = new ImageView(imageButton1);
                    imageViewButton1.setFitHeight(35);
                    imageViewButton1.setFitWidth(35);
                    imageViewButton1.relocate(370, finalYLocationOfFirst);


                    labelSewingButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelSewingButton1.setTextFill(Color.BLACK);
                    labelSewingButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });

                    labelSewingButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelSewingButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35);
                            imageViewButton1.setFitWidth(35);
                            imageViewButton1.relocate(370, finalYLocationOfFirst);
                        }
                    });


                    File fileButtonAll = new File("Data\\Click\\OkButton.png");
                    Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                    ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                    imageViewButtonAll.setFitHeight(35);
                    imageViewButtonAll.setFitWidth(45);
                    imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                    Label labelButtonAll = new Label("All");
                    labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                    labelButtonAll.setTextFill(Color.BLACK);
                    labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35 + 5);
                            imageViewButtonAll.setFitWidth(45 + 5);
                            imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButtonAll.setFitHeight(35);
                            imageViewButtonAll.setFitWidth(45);
                            imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                        }
                    });

                    MakeLabelAndButtonChangeable(Integer.valueOf(labelSewingOfNumber.getText()),imageViewButton1,labelSewingButton1,imageViewButtonAll,labelButtonAll);

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
                        imageViewIcon.relocate(150, finalYLocationOfFirst);

                        File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                        Image imageMultiply = new Image(fileMultiply.toURI().toString());
                        ImageView imageViewMultiply = new ImageView(imageMultiply);
                        imageViewMultiply.setFitWidth(30);
                        imageViewMultiply.setFitHeight(30);
                        imageViewMultiply.relocate(185, finalYLocationOfFirst);

                        labelCageLionOfNumber = new Label(value.toString());
                        labelCageLionOfNumber.relocate(190, finalYLocationOfFirst);
                        labelCageLionOfNumber.setTextFill(Color.BLACK);
                        labelCageLionOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Cage(new Lion())))); // price of egg
                        labelOfPrice.relocate(230, finalYLocationOfFirst);
                        labelOfPrice.setTextFill(Color.BLACK);
                        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        File fileOfCoin = new File("Data\\Shop\\Coin.png");
                        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                        ImageView imageViewCoin = new ImageView(imageOfCoin);
                        imageViewCoin.setFitWidth(30);
                        imageViewCoin.setFitHeight(30);
                        imageViewCoin.relocate(310, finalYLocationOfFirst);

                        File fileButton1 = new File("Data\\Click\\OkButton.png");
                        Image imageButton1 = new Image(fileButton1.toURI().toString());
                        ImageView imageViewButton1 = new ImageView(imageButton1);
                        imageViewButton1.setFitHeight(35);
                        imageViewButton1.setFitWidth(35);
                        imageViewButton1.relocate(370, finalYLocationOfFirst);


                        labelCageLionButton1.relocate(380, finalYLocationOfFirst + 5);
                        labelCageLionButton1.setTextFill(Color.BLACK);
                        labelCageLionButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370, finalYLocationOfFirst);
                            }
                        });

                        labelCageLionButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelCageLionButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370, finalYLocationOfFirst);
                            }
                        });


                        File fileButtonAll = new File("Data\\Click\\OkButton.png");
                        Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                        ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                        imageViewButtonAll.setFitHeight(35);
                        imageViewButtonAll.setFitWidth(45);
                        imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                        Label labelButtonAll = new Label("All");
                        labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                        labelButtonAll.setTextFill(Color.BLACK);
                        labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                            }
                        });

                        labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                            }
                        });

                        MakeLabelAndButtonChangeable(Integer.valueOf(labelCageLionOfNumber.getText()),imageViewButton1,labelCageLionButton1,imageViewButtonAll,labelButtonAll);

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
                        imageViewIcon.relocate(150, finalYLocationOfFirst);

                        File fileMultiply = new File("Data\\Textures\\Service\\multiply.png");
                        Image imageMultiply = new Image(fileMultiply.toURI().toString());
                        ImageView imageViewMultiply = new ImageView(imageMultiply);
                        imageViewMultiply.setFitWidth(30);
                        imageViewMultiply.setFitHeight(30);
                        imageViewMultiply.relocate(185, finalYLocationOfFirst);

                        labelCageBrearOfNumber = new Label(value.toString());
                        labelCageBrearOfNumber.relocate(190, finalYLocationOfFirst);
                        labelCageBrearOfNumber.setTextFill(Color.BLACK);
                        labelCageBrearOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Cage(new Bear())))); // price of egg
                        labelOfPrice.relocate(230, finalYLocationOfFirst);
                        labelOfPrice.setTextFill(Color.BLACK);
                        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        File fileOfCoin = new File("Data\\Shop\\Coin.png");
                        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
                        ImageView imageViewCoin = new ImageView(imageOfCoin);
                        imageViewCoin.setFitWidth(30);
                        imageViewCoin.setFitHeight(30);
                        imageViewCoin.relocate(310, finalYLocationOfFirst);

                        File fileButton1 = new File("Data\\Click\\OkButton.png");
                        Image imageButton1 = new Image(fileButton1.toURI().toString());
                        ImageView imageViewButton1 = new ImageView(imageButton1);
                        imageViewButton1.setFitHeight(35);
                        imageViewButton1.setFitWidth(35);
                        imageViewButton1.relocate(370, finalYLocationOfFirst);


                        labelCageBearButton1.relocate(380, finalYLocationOfFirst + 5);
                        labelCageBearButton1.setTextFill(Color.BLACK);
                        labelCageBearButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370, finalYLocationOfFirst);
                            }
                        });

                        labelCageBearButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelCageBearButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35);
                                imageViewButton1.setFitWidth(35);
                                imageViewButton1.relocate(370, finalYLocationOfFirst);
                            }
                        });


                        File fileButtonAll = new File("Data\\Click\\OkButton.png");
                        Image imageButtonAll = new Image(fileButtonAll.toURI().toString());
                        ImageView imageViewButtonAll = new ImageView(imageButtonAll);
                        imageViewButtonAll.setFitHeight(35);
                        imageViewButtonAll.setFitWidth(45);
                        imageViewButtonAll.relocate(435, finalYLocationOfFirst);

                        Label labelButtonAll = new Label("All");
                        labelButtonAll.relocate(443, finalYLocationOfFirst + 5);
                        labelButtonAll.setTextFill(Color.BLACK);
                        labelButtonAll.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        imageViewButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                            }
                        });

                        labelButtonAll.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35 + 5);
                                imageViewButtonAll.setFitWidth(45 + 5);
                                imageViewButtonAll.relocate(435 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelButtonAll.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButtonAll.setFitHeight(35);
                                imageViewButtonAll.setFitWidth(45);
                                imageViewButtonAll.relocate(435, finalYLocationOfFirst);
                            }
                        });

                        MakeLabelAndButtonChangeable(Integer.valueOf(labelCageBrearOfNumber.getText()),imageViewButton1,labelCageBearButton1,imageViewButtonAll,labelButtonAll);

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

    private void UpdateMoneyLabelForSellAndCapacityBar() throws UnknownObjectException, MissionNotLoaded {
        int money= MoneyForSell();
        coinText.setText(String.valueOf(money));
        Truck truck=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        int capacityOfTruck=truck.getCapacity();
        LoadDegreeForCapcity((int)(((float)getCapacityNeeded()/(float)capacityOfTruck)*10));

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

    private void MakeLabelAndButtonChangeable(int maxNumber,ImageView imageViewButton1, Label labelButton,ImageView allViewButton,Label allLabel) throws MissionNotLoaded {
        Truck truck=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        int capacityOfTruck=truck.getCapacity();
        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < maxNumber) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                    if (getCapacityNeeded()>capacityOfTruck){
                        labelButton.setText(String.valueOf(0));
                        View.PlayErrorSound();
                    }
                } else if (nowInt == maxNumber) {
                    labelButton.setText("0");
                }
                try {
                    UpdateMoneyLabelForSellAndCapacityBar();
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
                    if (getCapacityNeeded()>capacityOfTruck){
                        labelButton.setText(String.valueOf(0));
                        View.PlayErrorSound();
                    }
                } else if (nowInt == maxNumber) {
                    labelButton.setText("0");
                }
                try {
                    UpdateMoneyLabelForSellAndCapacityBar();
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
                if (getCapacityNeeded()>capacityOfTruck){
                    labelButton.setText(currentText);
                    PlayErrorSound();
                }
                try {
                    UpdateMoneyLabelForSellAndCapacityBar();
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
                if (getCapacityNeeded()>capacityOfTruck){
                    labelButton.setText(currentText);
                    PlayErrorSound();
                }
                try {
                    UpdateMoneyLabelForSellAndCapacityBar();
                } catch (UnknownObjectException e) {
                    e.printStackTrace();
                } catch (MissionNotLoaded missionNotLoaded) {
                    missionNotLoaded.printStackTrace();
                }
            }
        });
    }

    private void LoadDegreeForCapcity(int num){
        for (Rectangle rectangle:barRectangles){
            root.getChildren().removeAll(rectangle);
        }
        barRectangles=new ArrayList<>();
        for(int i=0;i<num;i++){
            Rectangle bar=new Rectangle(1105+55*(i/5),548-(i%5)*10,30,6);
            bar.setArcHeight(5);
            bar.setArcWidth(5);
            bar.setFill(Color.rgb(87,0,5));
            root.getChildren().addAll(bar);
            barRectangles.add(bar);

        }
    }

    private void MakeOkButton(Stage primaryStage,ImageView okButton,ImageView okText){
        okButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(getCapacityNeeded()!=0){
                    FarmView farmView= GameView.getGameView().getFarmView();
                    primaryStage.setScene(farmView.getScene());
                    primaryStage.setFullScreen(true);
                    farmView.getAnimationTimer().start();
                    try {
                        RemoveFromWareHouseThe();
                        farmView.ShowTruckGoingToCityAndComingBack();
                    } catch (MissionNotLoaded missionNotLoaded) {
                        missionNotLoaded.printStackTrace();
                    }

                }else{
                    AnimationTimer animationTimer = GameView.getGameView().getFarmView().getAnimationTimer();
                    animationTimer.start();
                    primaryStage.setScene(GameView.getGameView().getFarmView().getScene());
                    primaryStage.setFullScreen(true);
                }
            }
        });
        okText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(getCapacityNeeded()!=0){
                    FarmView farmView= GameView.getGameView().getFarmView();
                    primaryStage.setScene(farmView.getScene());
                    primaryStage.setFullScreen(true);
                    farmView.getAnimationTimer().start();
                    try {
                        farmView.ShowTruckGoingToCityAndComingBack();
                    } catch (MissionNotLoaded missionNotLoaded) {
                        missionNotLoaded.printStackTrace();
                    }

                }else{
                    AnimationTimer animationTimer = GameView.getGameView().getFarmView().getAnimationTimer();
                    animationTimer.start();
                    primaryStage.setScene(GameView.getGameView().getFarmView().getScene());
                    primaryStage.setFullScreen(true);
                }
            }
        });
    }

    private int getCapacityNeeded(){
        int result=0;
        InformationNeededInGame informationNeededInGame=Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
        result+=Integer.valueOf(labelEggButton1.getText());
        result+=Integer.valueOf(labelWoolButton1.getText());
        result+=Integer.valueOf(labelMilkButton1.getText());
        result+=Integer.valueOf(labelCakeButton1.getText());
        result+=Integer.valueOf(labelFabricButton1.getText());
        result+=Integer.valueOf(labelDecorationButton1.getText());
        result+=Integer.valueOf(labelFlouryCakeButton1.getText());
        result+=Integer.valueOf(labelFlourButton1.getText());
        result+=Integer.valueOf(labelPowderButton1.getText());
        result+=Integer.valueOf(labelCarnivalDressButton1.getText());
        result+=Integer.valueOf(labelSewingButton1.getText());
        result+=Integer.valueOf(labelCageLionButton1.getText());
        result+=Integer.valueOf(labelCageBearButton1.getText());
        return result;
    }

    private void RemoveFromWareHouseThe() throws MissionNotLoaded {
        Truck truck=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        WareHouse wareHouse=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        for(int i = 0; i<Integer.valueOf(labelEggButton1.getText()); i++){
            truck.TakeObjectFromWareHouse(new Egg());
        }
        for(int i = 0; i<Integer.valueOf(labelWoolButton1.getText()); i++){
            truck.TakeObjectFromWareHouse(new Wool());
        }
        for(int i=0;i<Integer.valueOf(labelMilkButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Milk());
        }
        for(int i=0;i<Integer.valueOf(labelCakeButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Cake());
        }
        for(int i=0;i<Integer.valueOf(labelFabricButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Fabric());
        }
        for(int i=0;i<Integer.valueOf(labelDecorationButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Decoration());
        }for(int i=0;i<Integer.valueOf(labelFlouryCakeButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new FlouryCake());
        }
        for(int i=0;i<Integer.valueOf(labelFlourButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Flour());
        }
        for(int i=0;i<Integer.valueOf(labelPowderButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Powder());
        }for(int i=0;i<Integer.valueOf(labelCarnivalDressButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new CarnivalDress());
        }
        for(int i=0;i<Integer.valueOf(labelSewingButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Sewing());
        }
        for(int i=0;i<Integer.valueOf(labelCageLionButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Cage(new Lion()));
        }
        for(int i=0;i<Integer.valueOf(labelCageBearButton1.getText());i++){
            truck.TakeObjectFromWareHouse(new Cage(new Bear()));
        }
    }

}
