package View.ScenesAndMainGroupView;

import View.View;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
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

import java.io.File;


public class ProductInHelicopterView extends View {
    private Group rootProductHelicopterView = new Group();
    private Scene sceneProductHelicopterView = new Scene(rootProductHelicopterView, 1600, 900);

    public void ProductInHelicopterView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddIcons();
        AddItems();
    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\GameShop.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        rootProductHelicopterView.getChildren().addAll(BackGroundView);
        primaryStage.setScene(sceneProductHelicopterView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddIcons() {
        Rectangle rect_1 = new Rectangle(500, 875);
        rect_1.setOpacity(0.6);
        rect_1.setArcHeight(70);
        rect_1.setArcWidth(70);
        rect_1.setFill(Color.rgb(64, 45, 67));
        rect_1.relocate(150, 110);
        rootProductHelicopterView.getChildren().addAll(rect_1);

        Rectangle rectangle = new Rectangle(350 , 450);
        rectangle.setOpacity(0.6);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        rectangle.setFill(Color.rgb(64, 45, 67));
        rectangle.relocate(175, 120);
        rootProductHelicopterView.getChildren().addAll(rectangle);

        Rectangle rectangle1 = new Rectangle(350 , 100);
        rectangle1.setOpacity(0.6);
        rectangle1.setArcHeight(50);
        rectangle1.setArcWidth(50);
        rectangle1.setFill(Color.rgb(64, 45, 67));
        rectangle1.relocate(175 , 580);
        rootProductHelicopterView.getChildren().addAll(rectangle1);

        Rectangle rectangle2 = new Rectangle(350 , 50);
        rectangle2.setOpacity(0.6);
        rectangle2.setArcHeight(50);
        rectangle2.setArcWidth(50);
        rectangle2.setFill(Color.rgb(64, 45, 67));
        rectangle2.relocate(175 , 690);
        rootProductHelicopterView.getChildren().addAll(rectangle2);

        File goodsFile = new File("Data\\Textures\\Service\\Goods.png");
        Image goodsImage = new Image(goodsFile.toURI().toString());
        ImageView goodsImageView = new ImageView(goodsImage);
        goodsImageView.setFitHeight(30);
        goodsImageView.setFitWidth(90);
        goodsImageView.relocate(180 , 90);
        rootProductHelicopterView.getChildren().addAll(goodsImageView);

        File priceFile = new File("Data\\Textures\\Service\\Price.png");
        Image priceImage = new Image(priceFile.toURI().toString());
        ImageView priceImageView = new ImageView(priceImage);
        priceImageView.setFitHeight(30);
        priceImageView.setFitWidth(90);
        priceImageView.relocate(300 , 90);
        rootProductHelicopterView.getChildren().addAll(priceImageView);

        File orderFile = new File("Data\\Textures\\Service\\Order.png");
        Image orderImage = new Image(orderFile.toURI().toString());
        ImageView orderImageView = new ImageView(orderImage);
        orderImageView.setFitHeight(30);
        orderImageView.setFitWidth(90);
        orderImageView.relocate(415 , 90);
        rootProductHelicopterView.getChildren().addAll(orderImageView);

        File helicopter = new File("Data\\Textures\\UI\\Helicopter\\01.png");
        Image helicopterImage = new Image(helicopter.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.setFitHeight(500);
        helicopterView.setFitWidth(750);
        helicopterView.relocate(700, 400);
        rootProductHelicopterView.getChildren().addAll(helicopterView);

        File buttonFile = new File("Data\\Textures\\Service\\OrderGoods.png");
        Image buttonImage = new Image(buttonFile.toURI().toString());
        ImageView buttonImageView = new ImageView(buttonImage);
        buttonImageView.setFitHeight(60);
        buttonImageView.setFitWidth(250);
        buttonImageView.relocate(230, 28);
        rootProductHelicopterView.getChildren().addAll(buttonImageView);

        File buttonOkFile = new File("Data\\Textures\\Service\\OkButton.png");
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

        File okText = new File("Data\\Textures\\Service\\OkText.png");
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

        File buttonCancelFile = new File("Data\\Textures\\Service\\OkButton.png");
        Image buttonCancelImage = new Image(buttonCancelFile.toURI().toString());
        ImageView buttonCancelImageView = new ImageView(buttonCancelImage);
        buttonCancelImageView.setFitHeight(60);
        buttonCancelImageView.setFitWidth(100);
        buttonCancelImageView.relocate(400, 760);
        rootProductHelicopterView.getChildren().addAll(buttonCancelImageView);

        buttonCancelImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        buttonCancelImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(70);
                buttonCancelImageView.setFitWidth(110);
                buttonCancelImageView.relocate(400 - 5, 760 - 5);
            }
        });
        buttonCancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(60);
                buttonCancelImageView.setFitWidth(100);
                buttonCancelImageView.relocate(400, 760);
            }
        });

        File cancelText = new File("Data\\Textures\\Service\\Cancel.png");
        Image cancelImage = new Image(cancelText.toURI().toString());
        ImageView cancelImageView = new ImageView(cancelImage);
        cancelImageView.setFitWidth(80);
        cancelImageView.setFitHeight(50);
        cancelImageView.relocate(410, 765);
        rootProductHelicopterView.getChildren().addAll(cancelImageView);

        cancelImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        cancelImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(70);
                buttonCancelImageView.setFitWidth(110);
                buttonCancelImageView.relocate(400 - 5, 760 - 5);
            }
        });
        cancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(60);
                buttonCancelImageView.setFitWidth(100);
                buttonCancelImageView.relocate(400, 760);
            }
        });

    }

    private void AddItems() {
        File helicopter = new File("Data\\Textures\\UI\\Helicopter\\01.png");
        Image helicopterImage = new Image(helicopter.toURI().toString());
        ImageView helicopterView = new ImageView(helicopterImage);
        helicopterView.setFitHeight(500);
        helicopterView.setFitWidth(750);
        helicopterView.relocate(1175, 500);
        rootProductHelicopterView.getChildren().addAll(helicopterView);

        File coin = new File("Data\\Textures\\Service\\Coin.png");
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
}
