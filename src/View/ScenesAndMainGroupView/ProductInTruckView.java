package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
import FarmModel.Game;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WareHouse;
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
    private Group rootProductTruckViewView = new Group();
    private Scene sceneProductTruckView = new Scene(rootProductTruckViewView, (int) (xShift * 1600), (int) (yShift * 900));

    public Scene getSceneProductTruckView() {
        return sceneProductTruckView;
    }

    public ProductInTruckView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddIcons();
        AddItems();
        AddOkAndCancelButton(primaryStage);
        AddWarehouseToTruck();
    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackGround.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight((int) (yShift * 1200));
        BackGroundView.setFitWidth((int) (xShift * 2000));
        rootProductTruckViewView.getChildren().addAll(BackGroundView);
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
        rootProductTruckViewView.getChildren().addAll(rect_1, rect_2, rect_3, rect_4, rect_5, rect_6, rect_7, rect_8);
    }

    private void AddItems() {
        File truck = new File("Data\\Textures\\UI\\Truck\\01.png");
        Image truckImage = new Image(truck.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.setFitHeight((int) (yShift * 750));
        truckView.setFitWidth((int) (xShift * 600));
        truckView.relocate((int) (xShift * 1175), (int) (yShift * 300));

        File coin = new File("Data\\Shop\\Coin.png");
        Image coinImage = new Image(coin.toURI().toString());
        ImageView coinView = new ImageView(coinImage);
        coinView.setFitHeight((int) (yShift * 50));
        coinView.setFitWidth((int) (xShift * 50));
        coinView.relocate((int) (xShift * 1275), (int) (yShift * 925));

        Text coinText = new Text("0");
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

        File goodsText_1 = new File("Data\\Shop\\Goods.png");
        Image goodsTextImage_1 = new Image(goodsText_1.toURI().toString());
        ImageView goodsTextView_1 = new ImageView(goodsTextImage_1);
        goodsTextView_1.setFitHeight((int) (yShift * 40));
        goodsTextView_1.setFitWidth((int) (xShift * 75));
        goodsTextView_1.relocate((int) (xShift * 725), (int) (yShift * 150));

        File priceText_1 = new File("Data\\Shop\\Price.png");
        Image priceTextImage_1 = new Image(priceText_1.toURI().toString());
        ImageView priceTextView_1 = new ImageView(priceTextImage_1);
        priceTextView_1.setFitHeight((int) (yShift * 40));
        priceTextView_1.setFitWidth((int) (xShift * 75));
        priceTextView_1.relocate((int) (xShift * 875), (int) (yShift * 150));

        File shipText_1 = new File("Data\\Shop\\Ship.png");
        Image shipTextImage_1 = new Image(shipText_1.toURI().toString());
        ImageView shipTextView_1 = new ImageView(shipTextImage_1);
        shipTextView_1.setFitHeight((int) (yShift * 40));
        shipTextView_1.setFitWidth((int) (xShift * 75));
        shipTextView_1.relocate((int) (xShift * 1025), (int) (yShift * 150));

        File animalsText = new File("Data\\Shop\\Animals.png");
        Image animalsTextImage = new Image(animalsText.toURI().toString());
        ImageView animalsTextView = new ImageView(animalsTextImage);
        animalsTextView.setFitHeight((int) (yShift * 40));
        animalsTextView.setFitWidth((int) (xShift * 100));
        animalsTextView.relocate((int) (xShift * 1250), (int) (yShift * 150));

        File priceText_2 = new File("Data\\Price.png");
        Image priceTextImage_2 = new Image(priceText_2.toURI().toString());
        ImageView priceTextView_2 = new ImageView(priceTextImage_2);
        priceTextView_2.setFitHeight((int) (yShift * 40));
        priceTextView_2.setFitWidth((int) (xShift * 75));
        priceTextView_2.relocate((int) (xShift * 1400), (int) (yShift * 150));

        File shipText_2 = new File("Data\\Shop\\Ship.png");
        Image shipTextImage_2 = new Image(shipText_2.toURI().toString());
        ImageView shipTextView_2 = new ImageView(shipTextImage_2);
        shipTextView_2.setFitHeight((int) (yShift * 40));
        shipTextView_2.setFitWidth((int) (xShift * 75));
        shipTextView_2.relocate((int) (xShift * 1550), (int) (yShift * 150));


        rootProductTruckViewView.getChildren().addAll(truckView, coinView, coinText, shipProductTextView, shipTextView);
        rootProductTruckViewView.getChildren().addAll(goodsTextView, priceTextView, shipTextView_1, priceTextView_1, goodsTextView_1);
        rootProductTruckViewView.getChildren().addAll(animalsTextView, priceTextView_2, shipTextView_2);

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
        okTextView.setFitHeight((int) (yShift * 30));
        okTextView.setFitWidth((int) (xShift * 100));
        okTextView.relocate((int) (xShift * 775), (int) (yShift * 1025));
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
                primaryStage.setScene(GameView.getGameView().getFarmView().getSceneFarmView());
                primaryStage.setFullScreen(true);
            }
        });

        File cancelText = new File("Data\\Shop\\CancelText.png");
        Image cancelTextImage = new Image(cancelText.toURI().toString());
        ImageView cancelTextView = new ImageView(cancelTextImage);
        cancelTextView.setFitHeight((int) (yShift * 50));
        cancelTextView.setFitWidth((int) (xShift * 120));
        cancelTextView.relocate((int) (xShift * 947), (int) (yShift * 1012));
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
                primaryStage.setScene(GameView.getGameView().getFarmView().getSceneFarmView());
                primaryStage.setFullScreen(true);
            }
        });

        rootProductTruckViewView.getChildren().addAll(buttonView, okTextView, cancelButtonView, cancelTextView);
    }


    public void AddWarehouseToTruck() {
        try {
            WareHouse wareHouse = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
            ArrayList<Object> arrayList = wareHouse.getWareHouseList();
            HashMap<Object, Integer> hashMap = wareHouse.getTypeAndNumberOfProductInWAreHouse();
            int yLocationOfFirst = 170;
            InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
            for (Map.Entry<Object, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey().toString(); // getClass
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Cake")) {
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
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

                    Label labelOfNumber = new Label(value.toString());
                    labelOfNumber.relocate(208, finalYLocationOfFirst);
                    labelOfNumber.setTextFill(Color.BLACK);
                    labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                    Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                    labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                    Label labelButton1 = new Label("1");
                    labelButton1.relocate(380, finalYLocationOfFirst + 5);
                    labelButton1.setTextFill(Color.BLACK);
                    labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                    imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

                    labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });

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

                    labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

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

                    rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.equals("Cage")) {
                    WildAnimals wildAnimals = ((Cage) object).getWildAnimals();
                    if (wildAnimals.toString().equals("Lion")) {
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

                        Label labelOfNumber = new Label(value.toString());
                        labelOfNumber.relocate(208, finalYLocationOfFirst);
                        labelOfNumber.setTextFill(Color.BLACK);
                        labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                        labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                        Label labelButton1 = new Label("1");
                        labelButton1.relocate(380, finalYLocationOfFirst + 5);
                        labelButton1.setTextFill(Color.BLACK);
                        labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                            }
                        });

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

                        labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                            }
                        });

                        labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                        imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                            }
                        });

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

                        labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

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

                        rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                                , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
                        yLocationOfFirst += 50;
                    } else if (wildAnimals.toString().equals("Bear")) {
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

                        Label labelOfNumber = new Label(value.toString());
                        labelOfNumber.relocate(208, finalYLocationOfFirst);
                        labelOfNumber.setTextFill(Color.BLACK);
                        labelOfNumber.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

                        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(object))); // price of egg
                        labelOfPrice.relocate(270, finalYLocationOfFirst);
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

                        Label labelButton1 = new Label("1");
                        labelButton1.relocate(380, finalYLocationOfFirst + 5);
                        labelButton1.setTextFill(Color.BLACK);
                        labelButton1.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

                        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                            }
                        });

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

                        labelButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                            }
                        });

                        labelButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                        imageViewButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                            }
                        });

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

                        labelButtonAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

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

                        rootProductTruckViewView.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                                , imageViewMultiply, labelButton1, labelButtonAll, labelOfNumber, labelOfPrice);
                        yLocationOfFirst += 50;
                    }
                }
            }

        } catch (MissionNotLoaded | UnknownObjectException missionNotLoaded) {
            missionNotLoaded.printStackTrace();
        }
    }

}
