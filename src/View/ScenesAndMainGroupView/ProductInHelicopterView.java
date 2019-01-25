package View.ScenesAndMainGroupView;

import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.Product.WorkShopProduct.*;
import View.View;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import View.GameView;

import java.io.File;


public class ProductInHelicopterView extends View {
    private Group rootProductHelicopterView = new Group();
    private Scene sceneProductHelicopterView = new Scene(rootProductHelicopterView, 1600, 900);
    private Label labelButtonCake = new Label("0");
    private Label labelButtonCookie = new Label("0");
    private Label labelButton1Flour = new Label("0");
    private Label labelButtonPowder = new Label("0");
    private Label labelButtonCarnivalDress = new Label("0");
    private Label labelButtonDecoration = new Label("0");
    private Label labelButtonFabric = new Label("0");
    private Label labelButtonSewing = new Label("0");


    public Scene getSceneProductHelicopterView() {
        return sceneProductHelicopterView;
    }

    public ProductInHelicopterView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        try {
            AddBackGround();
            AddItemToBackGround(primaryStage);
            AddItemToBuyCake();
            AddItemToBuyCookie();
            AddItemToBuyCarnivalDress();
            AddItemToBuyFlour();
            AddItemToBuyPowder();
            AddItemToBuyDecoration();
            AddItemToBuySewing();
            AddItemToBuyFabric();
        } catch (UnknownObjectException e) {
            e.printStackTrace();
        }
    }

    private void AddBackGround() {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        rootProductHelicopterView.getChildren().addAll(BackGroundView);
    }

    private void AddItemToBackGround(Stage primaryStage) {
        Rectangle rect_1 = new Rectangle(400, 800);
        rect_1.setOpacity(0.6);
        rect_1.setArcHeight(70);
        rect_1.setArcWidth(70);
        rect_1.setFill(Color.rgb(64, 45, 67));
        rect_1.relocate(150, 50);
        rootProductHelicopterView.getChildren().addAll(rect_1);

        File goodsFile = new File("Data\\Shop\\GoodsText.png");
        Image goodsImage = new Image(goodsFile.toURI().toString());
        ImageView goodsImageView = new ImageView(goodsImage);
        goodsImageView.setFitHeight(30);
        goodsImageView.setFitWidth(90);
        goodsImageView.relocate(180, 90);
        rootProductHelicopterView.getChildren().addAll(goodsImageView);

        File priceFile = new File("Data\\Shop\\PriceText.png");
        Image priceImage = new Image(priceFile.toURI().toString());
        ImageView priceImageView = new ImageView(priceImage);
        priceImageView.setFitHeight(30);
        priceImageView.setFitWidth(90);
        priceImageView.relocate(300, 90);
        rootProductHelicopterView.getChildren().addAll(priceImageView);

        File orderFile = new File("Data\\Shop\\OrderText.png");
        Image orderImage = new Image(orderFile.toURI().toString());
        ImageView orderImageView = new ImageView(orderImage);
        orderImageView.setFitHeight(30);
        orderImageView.setFitWidth(90);
        orderImageView.relocate(415, 90);
        rootProductHelicopterView.getChildren().addAll(orderImageView);

        File helicopter = new File("Data\\Textures\\UI\\Helicopter\\01.png");
        Image helicopterImage = new Image(helicopter.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.setFitHeight(500);
        helicopterView.setFitWidth(750);
        helicopterView.relocate(700, 400);
        rootProductHelicopterView.getChildren().addAll(helicopterView);

        File buttonFile = new File("Data\\Shop\\OrderGoodsText.png");
        Image buttonImage = new Image(buttonFile.toURI().toString());
        ImageView buttonImageView = new ImageView(buttonImage);
        buttonImageView.setFitHeight(60);
        buttonImageView.setFitWidth(250);
        buttonImageView.relocate(230, 28);
        rootProductHelicopterView.getChildren().addAll(buttonImageView);

        File buttonOkFile = new File("Data\\Click\\OkButton.png");
        Image buttonOkImage = new Image(buttonOkFile.toURI().toString());
        ImageView buttonOkImageView = new ImageView(buttonOkImage);
        buttonOkImageView.setFitHeight(60);
        buttonOkImageView.setFitWidth(100);
        buttonOkImageView.relocate(190, 760);
        rootProductHelicopterView.getChildren().addAll(buttonOkImageView);

        buttonOkImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        buttonOkImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(70);
                buttonOkImageView.setFitWidth(110);
                buttonOkImageView.relocate(190 - 5, 760 - 5);
            }
        });
        buttonOkImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(60);
                buttonOkImageView.setFitWidth(100);
                buttonOkImageView.relocate(190, 760);
            }
        });

        File okText = new File("Data\\Shop\\OkText.png");
        Image okImage = new Image(okText.toURI().toString());
        ImageView okImageView = new ImageView(okImage);
        okImageView.setFitWidth(80);
        okImageView.setFitHeight(40);
        okImageView.relocate(200, 770);
        rootProductHelicopterView.getChildren().addAll(okImageView);

        okImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        okImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(70);
                buttonOkImageView.setFitWidth(110);
                buttonOkImageView.relocate(190 - 5, 760 - 5);
            }
        });
        okImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(60);
                buttonOkImageView.setFitWidth(100);
                buttonOkImageView.relocate(190, 760);
            }
        });

        File buttonCancelFile = new File("Data\\Click\\OkButton.png");
        Image buttonCancelImage = new Image(buttonCancelFile.toURI().toString());
        ImageView cancelButtonView = new ImageView(buttonCancelImage);
        cancelButtonView.setFitHeight(60);
        cancelButtonView.setFitWidth(100);
        cancelButtonView.relocate(400, 760);
        rootProductHelicopterView.getChildren().addAll(cancelButtonView);
        cancelButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight(70);
                cancelButtonView.setFitWidth(110);
                cancelButtonView.relocate(400 - 5, 760 - 5);
            }
        });
        cancelButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight(60);
                cancelButtonView.setFitWidth(100);
                cancelButtonView.relocate(400, 760);
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
        Image cancelImage = new Image(cancelText.toURI().toString());
        ImageView cancelImageView = new ImageView(cancelImage);
        cancelImageView.setFitWidth(80);
        cancelImageView.setFitHeight(50);
        cancelImageView.relocate(410, 765);
        rootProductHelicopterView.getChildren().addAll(cancelImageView);

        cancelImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                AnimationTimer animationTimer = GameView.getGameView().getFarmView().getAnimationTimer();
                animationTimer.start();
                primaryStage.setScene(GameView.getGameView().getFarmView().getSceneFarmView());
                primaryStage.setFullScreen(true);
            }
        });
        cancelImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight(70);
                cancelButtonView.setFitWidth(110);
                cancelButtonView.relocate(400 - 5, 760 - 5);
            }
        });
        cancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight(60);
                cancelButtonView.setFitWidth(100);
                cancelButtonView.relocate(400, 760);
            }
        });

        Rectangle rectangle = new Rectangle(350, 450);
        rectangle.setOpacity(0.6);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        rectangle.setFill(Color.rgb(64, 45, 67));
        rectangle.relocate(175, 120);
        rootProductHelicopterView.getChildren().addAll(rectangle);

        Rectangle rectangle1 = new Rectangle(350, 100);
        rectangle1.setOpacity(0.6);
        rectangle1.setArcHeight(50);
        rectangle1.setArcWidth(50);
        rectangle1.setFill(Color.rgb(64, 45, 67));
        rectangle1.relocate(175, 580);
        rootProductHelicopterView.getChildren().addAll(rectangle1);

        Rectangle rectangle2 = new Rectangle(350, 50);
        rectangle2.setOpacity(0.6);
        rectangle2.setArcHeight(50);
        rectangle2.setArcWidth(50);
        rectangle2.setFill(Color.rgb(64, 45, 67));
        rectangle2.relocate(175, 690);
        rootProductHelicopterView.getChildren().addAll(rectangle2);

        File coin = new File("Data\\Shop\\Coin.png");
        Image coinImage = new Image(coin.toURI().toString());
        ImageView coinView = new ImageView(coinImage);
        coinView.setFitHeight(50);
        coinView.setFitWidth(50);
        coinView.relocate(180, 690);
        rootProductHelicopterView.getChildren().addAll(coinView);

        Text coinText = new Text("0");
        coinText.relocate(375, 715);
        coinText.setFont(Font.font(30));
        coinText.setStyle("-fx-font-weight: bold");
        coinText.setFill(Color.rgb(244, 240, 16));
        rootProductHelicopterView.getChildren().addAll(coinText);
    }

    private void AddItemToBuyCake() throws UnknownObjectException {
        File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Cake()))); // price of egg
        labelOfPrice.relocate(300, 130);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130);


        labelButtonCake.relocate(455, 130 + 5);
        labelButtonCake.setTextFill(Color.BLACK);
        labelButtonCake.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonCake.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonCake.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonCake.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

        labelButtonCake.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5);
            }
        });

        labelButtonCake.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130);
            }
        });

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCake, labelOfPrice);

    }

    private void AddItemToBuyCookie() throws UnknownObjectException {
        int shift = 50;
        File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Cookie()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonCookie.relocate(455, 130 + 5 + shift);
        labelButtonCookie.setTextFill(Color.BLACK);
        labelButtonCookie.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonCookie.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonCookie.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonCookie.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

        labelButtonCookie.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonCookie.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCookie, labelOfPrice);
    }

    private void AddItemToBuyFlour() throws UnknownObjectException {
        int shift = 100;
        File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Flour()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButton1Flour.relocate(455, 130 + 5 + shift);
        labelButton1Flour.setTextFill(Color.BLACK);
        labelButton1Flour.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton1Flour.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButton1Flour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton1Flour.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
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

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButton1Flour, labelOfPrice);
    }

    private void AddItemToBuyPowder() throws UnknownObjectException {
        int shift = 150;
        File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Powder()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonPowder.relocate(455, 130 + 5 + shift);
        labelButtonPowder.setTextFill(Color.BLACK);
        labelButtonPowder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonPowder.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonPowder.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonPowder.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
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

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonPowder, labelOfPrice);
    }

    private void AddItemToBuyCarnivalDress() throws UnknownObjectException {
        int shift = 200;
        File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new CarnivalDress()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonCarnivalDress.relocate(455, 130 + 5 + shift);
        labelButtonCarnivalDress.setTextFill(Color.BLACK);
        labelButtonCarnivalDress.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonCarnivalDress.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonCarnivalDress.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonCarnivalDress.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
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

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCarnivalDress, labelOfPrice);
    }

    private void AddItemToBuyDecoration() throws UnknownObjectException {
        int shift = 250;
        File fileIcon = new File("Data\\Textures\\Products\\Decoration.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Decoration()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonDecoration.relocate(455, 130 + 5 + shift);
        labelButtonDecoration.setTextFill(Color.BLACK);
        labelButtonDecoration.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonDecoration.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonDecoration.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonDecoration.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
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

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonDecoration, labelOfPrice);
    }

    private void AddItemToBuyFabric() throws UnknownObjectException {
        int shift = 300;
        File fileIcon = new File("Data\\Textures\\Products\\Fabric.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Fabric()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);

        labelButtonFabric.relocate(455, 130 + 5 + shift);
        labelButtonFabric.setTextFill(Color.BLACK);
        labelButtonFabric.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonFabric.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonFabric.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonFabric.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
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

        rootProductHelicopterView.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonFabric, labelOfPrice);
    }

    private void AddItemToBuySewing() throws UnknownObjectException {
        int shift = 350;
        File fileIcon = new File("Data\\Textures\\Products\\Sewing.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(30);
        imageViewIcon.setFitWidth(30);
        imageViewIcon.relocate(200, 130 + shift);

        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();

        Label labelOfPrice = new Label(String.valueOf(informationNeededInGame.getPriceForSell(new Sewing()))); // price of egg
        labelOfPrice.relocate(300, 130 + shift);
        labelOfPrice.setTextFill(Color.BLACK);
        labelOfPrice.setStyle("-fx-font: 28 arial; -fx-base: #030202;");

        File fileOfCoin = new File("Data\\Shop\\Coin.png");
        Image imageOfCoin = new Image(fileOfCoin.toURI().toString());
        ImageView imageViewCoin = new ImageView(imageOfCoin);
        imageViewCoin.setFitWidth(30);
        imageViewCoin.setFitHeight(30);
        imageViewCoin.relocate(355, 130 + shift);

        File fileButton1 = new File("Data\\Click\\OkButton.png");
        Image imageButton1 = new Image(fileButton1.toURI().toString());
        ImageView imageViewButton1 = new ImageView(imageButton1);
        imageViewButton1.setFitHeight(35);
        imageViewButton1.setFitWidth(35);
        imageViewButton1.relocate(445, 130 + shift);


        labelButtonSewing.relocate(455, 130 + 5 + shift);
        labelButtonSewing.setTextFill(Color.BLACK);
        labelButtonSewing.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonSewing.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
            }
        });

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

        labelButtonSewing.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButtonSewing.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < 9) {
                    labelButtonCake.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == 9) {
                    labelButtonCake.setText("0");
                }
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

        rootProductHelicopterView.getChildren().addAll(imageViewButton1);
        rootProductHelicopterView.getChildren().addAll(imageViewCoin);
        rootProductHelicopterView.getChildren().addAll(imageViewIcon);
        rootProductHelicopterView.getChildren().addAll(labelButtonSewing);
        rootProductHelicopterView.getChildren().addAll(labelOfPrice);
    }

}