package View.ScenesAndMainGroupView;

import View.View;
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

import java.io.File;


public class ProductInTruckView extends View {
    private Group rootProductTruckViewView = new Group();
    private Scene sceneProductTruckView = new Scene(rootProductTruckViewView, 1600, 900);

    public void ProductInTruckView(Stage primaryStage) {
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
        BackGroundView.setFitHeight(1200);
        BackGroundView.setFitWidth(2000);
        rootProductTruckViewView.getChildren().addAll(BackGroundView);
        primaryStage.setScene(sceneProductTruckView);
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

        Rectangle rect_2 = new Rectangle(500, 875);
        rect_2.setOpacity(0.6);
        rect_2.setArcHeight(70);
        rect_2.setArcWidth(70);
        rect_2.setFill(Color.rgb(64, 45, 67));
        rect_2.relocate(670, 110);

        Rectangle rect_3 = new Rectangle(500, 300);
        rect_3.setOpacity(0.6);
        rect_3.setArcHeight(70);
        rect_3.setArcWidth(70);
        rect_3.setFill(Color.rgb(64, 45, 67));
        rect_3.relocate(1190, 110);

        Rectangle rect_4 = new Rectangle(500, 100);
        rect_4.setOpacity(0.6);
        rect_4.setArcHeight(70);
        rect_4.setArcWidth(70);
        rect_4.setFill(Color.rgb(64, 45, 67));
        rect_4.relocate(1225, 900);
        rootProductTruckViewView.getChildren().addAll(rect_1, rect_2, rect_3, rect_4);
    }


    private void AddItems() {
        File truck = new File("Data\\Textures\\UI\\Truck\\01.png");
        Image truckImage = new Image(truck.toURI().toString());
        ImageView truckView = new ImageView(truckImage);
        truckView.setFitHeight(750);
        truckView.setFitWidth(600);
        truckView.relocate(1175, 300);

        File coin = new File("Data\\Coin.png");
        Image coinImage = new Image(coin.toURI().toString());
        ImageView coinView = new ImageView(coinImage);
        coinView.setFitHeight(50);
        coinView.setFitWidth(50);
        coinView.relocate(1275, 925);

        Text coinText = new Text("0");
        coinText.relocate(1475, 945);
        coinText.setFont(Font.font(30));
        coinText.setStyle("-fx-font-weight: bold");
        coinText.setFill(Color.rgb(244, 240, 16));

        File shipProductText = new File("Data\\ShipProductsText.png");
        Image shipProductTextImage = new Image(shipProductText.toURI().toString());
        ImageView shipProductTextView = new ImageView(shipProductTextImage);
        shipProductTextView.setFitHeight(125);
        shipProductTextView.setFitWidth(400);
        shipProductTextView.relocate(700, -10);


        File goodsText = new File("Data\\Goods.png");
        Image goodsTextImage = new Image(goodsText.toURI().toString());
        ImageView goodsTextView = new ImageView(goodsTextImage);
        goodsTextView.setFitHeight(40);
        goodsTextView.setFitWidth(75);
        goodsTextView.relocate(200, 150);

        File priceText = new File("Data\\Price.png");
        Image priceTextImage = new Image(priceText.toURI().toString());
        ImageView priceTextView = new ImageView(priceTextImage);
        priceTextView.setFitHeight(40);
        priceTextView.setFitWidth(75);
        priceTextView.relocate(350, 150);

        File shipText = new File("Data\\Ship.png");
        Image shipTextImage = new Image(shipText.toURI().toString());
        ImageView shipTextView = new ImageView(shipTextImage);
        shipTextView.setFitHeight(40);
        shipTextView.setFitWidth(75);
        shipTextView.relocate(500, 150);

        File goodsText_1 = new File("Data\\Goods.png");
        Image goodsTextImage_1 = new Image(goodsText_1.toURI().toString());
        ImageView goodsTextView_1 = new ImageView(goodsTextImage_1);
        goodsTextView_1.setFitHeight(40);
        goodsTextView_1.setFitWidth(75);
        goodsTextView_1.relocate(725, 150);

        File priceText_1 = new File("Data\\Price.png");
        Image priceTextImage_1 = new Image(priceText_1.toURI().toString());
        ImageView priceTextView_1 = new ImageView(priceTextImage_1);
        priceTextView_1.setFitHeight(40);
        priceTextView_1.setFitWidth(75);
        priceTextView_1.relocate(875, 150);

        File shipText_1 = new File("Data\\Ship.png");
        Image shipTextImage_1 = new Image(shipText_1.toURI().toString());
        ImageView shipTextView_1 = new ImageView(shipTextImage_1);
        shipTextView_1.setFitHeight(40);
        shipTextView_1.setFitWidth(75);
        shipTextView_1.relocate(1025, 150);

        File animalsText = new File("Data\\Animals.png");
        Image animalsTextImage = new Image(animalsText.toURI().toString());
        ImageView animalsTextView = new ImageView(animalsTextImage);
        animalsTextView.setFitHeight(40);
        animalsTextView.setFitWidth(100);
        animalsTextView.relocate(1250, 150);

        File priceText_2 = new File("Data\\Price.png");
        Image priceTextImage_2 = new Image(priceText_2.toURI().toString());
        ImageView priceTextView_2 = new ImageView(priceTextImage_2);
        priceTextView_2.setFitHeight(40);
        priceTextView_2.setFitWidth(75);
        priceTextView_2.relocate(1400, 150);

        File shipText_2 = new File("Data\\Ship.png");
        Image shipTextImage_2 = new Image(shipText_2.toURI().toString());
        ImageView shipTextView_2 = new ImageView(shipTextImage_2);
        shipTextView_2.setFitHeight(40);
        shipTextView_2.setFitWidth(75);
        shipTextView_2.relocate(1550, 150);

        File okButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image okButtonImage = new Image(okButton.toURI().toString());
        ImageView okButtonView = new ImageView(okButtonImage);
        okButtonView.setFitHeight(75);
        okButtonView.setFitWidth(160);
        okButtonView.relocate(750, 1000);
        okButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate(745, 995);
                okButtonView.setFitHeight(85);
                okButtonView.setFitWidth(170);
                okButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        okButtonView.setFitHeight(75);
                        okButtonView.setFitWidth(160);
                        okButtonView.relocate(750, 1000);
                    }
                });

            }
        });

        File okText = new File("Data\\Textures\\Service\\OkText.png");
        Image okTextImage = new Image(okText.toURI().toString());
        ImageView okTextView = new ImageView(okTextImage);
        okTextView.setFitHeight(30);
        okTextView.setFitWidth(100);
        okTextView.relocate(775, 1025);
        okTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate(745, 995);
                okButtonView.setFitHeight(85);
                okButtonView.setFitWidth(170);
            }
        });
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.setFitHeight(75);
                okButtonView.setFitWidth(150);
                okButtonView.relocate(750, 1000);
            }
        });

        File cancelButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image cancelButtonImage = new Image(cancelButton.toURI().toString());
        ImageView cancelButtonView = new ImageView(cancelButtonImage);
        cancelButtonView.setFitHeight(75);
        cancelButtonView.setFitWidth(160);
        cancelButtonView.relocate(925, 1000);
        cancelButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.relocate(920, 995);
                cancelButtonView.setFitHeight(85);
                cancelButtonView.setFitWidth(170);
                cancelButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        cancelButtonView.setFitHeight(75);
                        cancelButtonView.setFitWidth(160);
                        cancelButtonView.relocate(925, 1000);
                    }
                });

            }
        });

        File cancelText = new File("Data\\Cancel.png");
        Image cancelTextImage = new Image(cancelText.toURI().toString());
        ImageView cancelTextView = new ImageView(cancelTextImage);
        cancelTextView.setFitHeight(50);
        cancelTextView.setFitWidth(120);
        cancelTextView.relocate(947, 1012);
        cancelTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.relocate(920, 995);
                cancelButtonView.setFitHeight(85);
                cancelButtonView.setFitWidth(170);
            }
        });
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight(75);
                cancelButtonView.setFitWidth(160);
                cancelButtonView.relocate(925, 1000);
            }
        });
        rootProductTruckViewView.getChildren().addAll(truckView, coinView, coinText, shipProductTextView, shipTextView);
        rootProductTruckViewView.getChildren().addAll(goodsTextView, priceTextView, shipTextView_1, priceTextView_1, goodsTextView_1);
        rootProductTruckViewView.getChildren().addAll(animalsTextView, priceTextView_2, shipTextView_2, okButtonView, okTextView);
        rootProductTruckViewView.getChildren().addAll(cancelButtonView, cancelTextView);

    }
}
