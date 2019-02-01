package View.ScenesAndMainGroupView;

import FarmController.Exceptions.FullWareHouse;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.Internet.Changes;
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
import View.GameView;
import View.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static View.ScenesAndMainGroupView.HostAndGuestView.findPvViewByUserName;
import static View.View.PlayErrorSound;

public class BazaarView {
    private Group root = new Group();
    private Scene scene = new Scene(root, 1600, 900);
    private Label labelButtonFlouryCakeToOrder = new Label("0");
    private Label maxNumberOfFlouryCake = new Label("10");
    private Label labelButtonCakeToOrder = new Label("0");
    private Label maxNumberOfCake = new Label("10");
    private Label labelButton1FlourToOrder = new Label("0");
    private Label maxNumberOfFlour = new Label("10");
    private Label labelButtonPowderToOrder = new Label("0");
    private Label maxNumberOfPowder = new Label("10");
    private Label labelButtonCarnivalDressToOrder = new Label("0");
    private Label maxNumberOfCarnivalDress = new Label("10");
    private Label labelButtonDecorationToOrder = new Label("0");
    private Label maxNumberOfDecoration = new Label("10");
    private Label labelButtonFabricToOrder = new Label("0");
    private Label maxNumberOfFabric = new Label("10");
    private Label labelButtonSewingToOrder = new Label("0");
    private Label maxNumberOfSewing = new Label("10");

    private ArrayList<Node> currentOnlinePalyerNodes=new ArrayList<>();
    Rectangle onlinePlayerRectangle=new Rectangle(1150,250,300,400);

    private Text coinTextForSell = new Text("0");
    private Text coinTextForOrder = new Text("0");

    private Label labelEggButton1ToSell = new Label("0");
    private Label labelWoolButton1ToSell = new Label("0");
    private Label labelMilkButton1ToSell = new Label("0");
    private Label labelFlouryCakeButton1ToSell = new Label("0");
    private Label labelCakeButton1ToSell = new Label("0");
    private Label labelFlourButton1ToSell = new Label("0");
    private Label labelPowderButton1ToSell = new Label("0");
    private Label labelCarnivalDressButton1ToSell = new Label("0");
    private Label labelDecorationButton1ToSell = new Label("0");
    private Label labelFabricButton1ToSell = new Label("0");
    private Label labelSewingButton1ToSell = new Label("0");
    private Label labelCageLionButton1ToSell = new Label("0");
    private Label labelCageBearButton1ToSell = new Label("0");
    private User user = Game.getGameInstance().getCurrentUserAccount();

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
        AddButton(primaryStage);
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
        AddMaxNumberProductLabels();
        AddCagesLionIcon();
        ReloadNumberOfProductExistInOnLineShop(Changes.getDataForMaxNumberOfProductExistInOnlineShop());
    }

    public void AddBackground(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
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

    public void AddButton(Stage primaryStage) {
        File buttonOkFile = new File("Data\\Click\\OkButton.png");
        Image buttonOkImage = new Image(buttonOkFile.toURI().toString());
        ImageView buttonOkImageView = new ImageView(buttonOkImage);
        buttonOkImageView.setFitHeight(50);
        buttonOkImageView.setFitWidth(100);
        buttonOkImageView.relocate(1300, 750);
        root.getChildren().addAll(buttonOkImageView);


        buttonOkImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(60);
                buttonOkImageView.setFitWidth(110);
                buttonOkImageView.relocate(1300 - 5, 750 - 5);
            }
        });
        buttonOkImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(50);
                buttonOkImageView.setFitWidth(100);
                buttonOkImageView.relocate(1300, 750);
            }
        });

        File okText = new File("Data\\Shop\\OkText.png");
        Image okImage = new Image(okText.toURI().toString());
        ImageView okImageView = new ImageView(okImage);
        okImageView.setFitWidth(50);
        okImageView.setFitHeight(30);
        okImageView.relocate(1300 + 25, 750 + 10);
        root.getChildren().addAll(okImageView);

        okImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(60);
                buttonOkImageView.setFitWidth(110);
                buttonOkImageView.relocate(1300 - 5, 750 - 5);
            }
        });
        okImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonOkImageView.setFitHeight(50);
                buttonOkImageView.setFitWidth(100);
                buttonOkImageView.relocate(1300, 750);
            }
        });
        MakeNodeSetOnClickForOkButton(okImageView);
        MakeNodeSetOnClickForOkButton(buttonOkImageView);


        File buttonCancelFile = new File("Data\\Click\\OkButton.png");
        Image buttonCancelImage = new Image(buttonCancelFile.toURI().toString());
        ImageView buttonCancelImageView = new ImageView(buttonCancelImage);
        buttonCancelImageView.setFitHeight(50);
        buttonCancelImageView.setFitWidth(100);
        buttonCancelImageView.relocate(1150, 750);
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
                buttonCancelImageView.setFitHeight(60);
                buttonCancelImageView.setFitWidth(110);
                buttonCancelImageView.relocate(1150 - 5, 750 - 5);
            }
        });
        buttonCancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(50);
                buttonCancelImageView.setFitWidth(100);
                buttonCancelImageView.relocate(1150, 750);
            }
        });

        File cancelText = new File("Data\\Shop\\CancelText.png");
        Image cancelImage = new Image(cancelText.toURI().toString());
        ImageView cancelImageView = new ImageView(cancelImage);
        cancelImageView.setFitWidth(70);
        cancelImageView.setFitHeight(35);
        cancelImageView.relocate(1150 + 15, 750 + 10);
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
                buttonCancelImageView.setFitHeight(60);
                buttonCancelImageView.setFitWidth(110);
                buttonCancelImageView.relocate(1150 - 5, 750 - 5);
            }
        });
        cancelImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonCancelImageView.setFitHeight(50);
                buttonCancelImageView.setFitWidth(100);
                buttonCancelImageView.relocate(1150, 750);
            }
        });
    }

    private void MakeNodeSetOnClickForOkButton(Node node){
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int moneyWeGetForSellingProduct=Integer.valueOf(coinTextForSell.getText());
                int moneyWeNeedToBuy=Integer.valueOf(coinTextForOrder.getText());
                int moneyNeeded=moneyWeNeedToBuy-moneyWeGetForSellingProduct;
                int userMoney=Game.getGameInstance().getCurrentUserAccount().getMoney();
                try {
                    if(userMoney>moneyNeeded){
                        RemoveFromWareHouseProductWeSell();
                        AddObjectWeOrderedToWareHouse();
                        ExchangeTheProduct();
                        SendMaxNumberOfProDuctData(getMaxNumberOfProductData());
                        Changes.setDataForMaxNumberOfProductExistInOnlineShop(getMaxNumberOfProductData());
                        System.out.println(getMaxNumberOfProductData());
                        Game.getGameInstance().getCurrentUserAccount().setMoney(userMoney-moneyNeeded);
                        Main.getPrimaryStage().setScene(GameView.getGameView().getHostAndGuestView().getScene());
                        Main.getPrimaryStage().setFullScreen(true);
                    }else {
                        throw new NotEnoughMoney();
                    }
                }catch (Exception e){}
            }
        });
    }

    private void ExchangeTheProduct(){
        maxNumberOfFlouryCake.setText(CalculateTheRemainProductByLabel(maxNumberOfFlouryCake,labelButtonFlouryCakeToOrder,labelFlouryCakeButton1ToSell));
        maxNumberOfCake.setText(CalculateTheRemainProductByLabel(maxNumberOfCake,labelButtonCakeToOrder,labelCakeButton1ToSell));
        maxNumberOfPowder.setText(CalculateTheRemainProductByLabel(maxNumberOfPowder,labelButtonPowderToOrder,labelPowderButton1ToSell));
        maxNumberOfFlour.setText(CalculateTheRemainProductByLabel(maxNumberOfFlour,labelButton1FlourToOrder,labelFlourButton1ToSell));
        maxNumberOfDecoration.setText(CalculateTheRemainProductByLabel(maxNumberOfDecoration,labelButtonDecorationToOrder,labelDecorationButton1ToSell));
        maxNumberOfCarnivalDress.setText(CalculateTheRemainProductByLabel(maxNumberOfCarnivalDress,labelButtonCarnivalDressToOrder,labelCarnivalDressButton1ToSell));
        maxNumberOfSewing.setText(CalculateTheRemainProductByLabel(maxNumberOfSewing,labelButtonSewingToOrder,labelSewingButton1ToSell));
        maxNumberOfFabric.setText(CalculateTheRemainProductByLabel(maxNumberOfFabric,labelButtonFabricToOrder,labelFabricButton1ToSell));
    }

    private void SendMaxNumberOfProDuctData(String data){
        TextField ipText=GameView.getGameView().getHostAndGuestView().getIpTextField();
        if (GameView.getGameView().getHostAndGuestView().getRoot().getChildren().contains(ipText)){
            Changes.AddMassageToMassageThatShouldSend("B@"+data);
        }else{
            try{
                for(Map.Entry<Socket,PVView> entry:GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()){
                    entry.getValue().AddDataToMassageToSendThatWeDidntSendThem("B@"+data);
                }
            }catch (Exception e){}
        }

    }

    private String CalculateTheRemainProductByLabel(Label current,Label orderProduct,Label sellProduct){
        return String.valueOf(String.valueOf(Integer.valueOf(current.getText())-Integer.valueOf(orderProduct.getText())+Integer.valueOf(sellProduct.getText())));
    }

    private String getMaxNumberOfProductData() {
        String result="";
        result+="FlouryCake:"+maxNumberOfFlouryCake.getText()+" ";
        result+="Cake:"+maxNumberOfCake.getText()+" ";
        result+="Flour:"+maxNumberOfFlour.getText()+" ";
        result+="Powder:"+maxNumberOfPowder.getText()+" ";
        result+="CarnivalDress:"+maxNumberOfCarnivalDress.getText()+" ";
        result+="Decoration:"+maxNumberOfDecoration.getText()+" ";
        result+="Fabric:"+maxNumberOfFabric.getText()+" ";
        result+="Sewing:"+maxNumberOfSewing.getText();
        return result;


    }

    private void RemoveFromWareHouseProductWeSell() throws MissionNotLoaded {
        Truck truck=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        WareHouse wareHouse=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        for(int i = 0; i<Integer.valueOf(labelEggButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Egg());
        }
        for(int i = 0; i<Integer.valueOf(labelWoolButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Wool());
        }
        for(int i = 0; i<Integer.valueOf(labelMilkButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Milk());
        }
        for(int i = 0; i<Integer.valueOf(labelCakeButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Cake());
        }
        for(int i = 0; i<Integer.valueOf(labelFabricButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Fabric());
        }
        for(int i = 0; i<Integer.valueOf(labelDecorationButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Decoration());
        }for(int i = 0; i<Integer.valueOf(labelFlouryCakeButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new FlouryCake());
        }
        for(int i = 0; i<Integer.valueOf(labelFlourButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Flour());
        }
        for(int i = 0; i<Integer.valueOf(labelPowderButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Powder());
        }for(int i = 0; i<Integer.valueOf(labelCarnivalDressButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new CarnivalDress());
        }
        for(int i = 0; i<Integer.valueOf(labelSewingButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Sewing());
        }
        for(int i = 0; i<Integer.valueOf(labelCageLionButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Cage(new Lion()));
        }
        for(int i = 0; i<Integer.valueOf(labelCageBearButton1ToSell.getText()); i++){
            truck.TakeObjectFromWareHouse(new Cage(new Bear()));
        }
    }

    private void AddObjectWeOrderedToWareHouse() throws MissionNotLoaded, FullWareHouse {
        WareHouse wareHouse=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWareHouse();
        for(int i = 0; i<Integer.valueOf(labelButtonFlouryCakeToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new FlouryCake());
        }
        for(int i = 0; i<Integer.valueOf(labelButtonCakeToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new Cake());
        }
        for(int i = 0; i<Integer.valueOf(labelButton1FlourToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new Flour());
        }
        for(int i = 0; i<Integer.valueOf(labelButtonPowderToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new Powder());
        }
        for(int i = 0; i<Integer.valueOf(labelButtonCarnivalDressToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new CarnivalDress());
        }
        for(int i = 0; i<Integer.valueOf(labelButtonDecorationToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new Decoration());
        }for(int i = 0; i<Integer.valueOf(labelButtonFabricToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new Fabric());
        }
        for(int i = 0; i<Integer.valueOf(labelButtonSewingToOrder.getText()); i++){
            wareHouse.AddWholeObjectToStore(new Sewing());
        }

    }

    private void MakeLabelAndButtonChangable(String productName, ImageView imageViewButton1, Label labelButton) {
        int maxNumberOfProduct=Integer.valueOf(getMaxNumberOfProductLabelInOnlineShop(productName).getText());
        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < maxNumberOfProduct) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == maxNumberOfProduct) {
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
                if (nowInt < maxNumberOfProduct) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                } else if (nowInt == maxNumberOfProduct) {
                    labelButton.setText("0");
                }
                UpdateMoneyLabelNeeded();
            }
        });
    }

    private void UpdateMoneyLabelNeeded() {
        int money = MoneyToBuyNumberOfItems();
        coinTextForOrder.setText(String.valueOf(money));
    }

    private int MoneyToBuyNumberOfItems() {
        int result = 0;
        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
        result += Integer.valueOf(labelButtonFlouryCakeToOrder.getText()) * informationNeededInGame.getPriceToBuy(new FlouryCake());
        result += Integer.valueOf(labelButtonCakeToOrder.getText()) * informationNeededInGame.getPriceToBuy(new Cake());
        result += Integer.valueOf(labelButton1FlourToOrder.getText()) * informationNeededInGame.getPriceToBuy(new Flour());
        result += Integer.valueOf(labelButtonPowderToOrder.getText()) * informationNeededInGame.getPriceToBuy(new Powder());
        result += Integer.valueOf(labelButtonCarnivalDressToOrder.getText()) * informationNeededInGame.getPriceToBuy(new CarnivalDress());
        result += Integer.valueOf(labelButtonDecorationToOrder.getText()) * informationNeededInGame.getPriceToBuy(new Decoration());
        result += Integer.valueOf(labelButtonFabricToOrder.getText()) * informationNeededInGame.getPriceToBuy(new Fabric());
        result += Integer.valueOf(labelButtonSewingToOrder.getText()) * informationNeededInGame.getPriceToBuy(new Sewing());
        return result;
    }

    private int getCapacityNeeded() {
        int result = 0;
//        InformationNeededInGame informationNeededInGame=Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
//        result+=Integer.valueOf(labelEggButton1ToSell.getText());
//        result+=Integer.valueOf(labelWoolButton1ToSell.getText());
//        result+=Integer.valueOf(labelMilkButton1ToSell.getText());
//        result+=Integer.valueOf(labelCakeButton1ToSell.getText());
//        result+=Integer.valueOf(labelFabricButton1ToSell.getText());
//        result+=Integer.valueOf(labelDecorationButton1ToSell.getText());
//        result+=Integer.valueOf(labelFlouryCakeButton1ToSell.getText());
//        result+=Integer.valueOf(labelFlourButton1ToSell.getText());
//        result+=Integer.valueOf(labelPowderButton1ToSell.getText());
//        result+=Integer.valueOf(labelCarnivalDressButton1ToSell.getText());
//        result+=Integer.valueOf(labelSewingButton1ToSell.getText());
//        result+=Integer.valueOf(labelCageLionButton1ToSell.getText());
//        result+=Integer.valueOf(labelCageBearButton1ToSell.getText());
        return result;
    }

    private void UpdateMoneyLabelForSell() throws UnknownObjectException, MissionNotLoaded {
        int money = MoneyForSell();
        coinTextForSell.setText(String.valueOf(money));
    }

    private int MoneyForSell() throws UnknownObjectException {
        int result = 0;
        InformationNeededInGame informationNeededInGame = Game.getGameInstance().getCurrentUserAccount().getInformationNeededInGame();
        result += Integer.valueOf(labelEggButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Egg());
        result += Integer.valueOf(labelWoolButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Wool());
        result += Integer.valueOf(labelMilkButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Milk());
        result += Integer.valueOf(labelCakeButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Cake());
        result += Integer.valueOf(labelFabricButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Fabric());
        result += Integer.valueOf(labelDecorationButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Decoration());
        result += Integer.valueOf(labelFlouryCakeButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new FlouryCake());
        result += Integer.valueOf(labelFlourButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Flour());
        result += Integer.valueOf(labelPowderButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Powder());
        result += Integer.valueOf(labelCarnivalDressButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new CarnivalDress());
        result += Integer.valueOf(labelSewingButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Sewing());
        result += Integer.valueOf(labelCageLionButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Cage(new Lion()));
        result += Integer.valueOf(labelCageBearButton1ToSell.getText()) * informationNeededInGame.getPriceForSell(new Cage(new Bear()));
        return result;
    }

    private void MakeLabelAndButtonChangableّForSell(int maxNumber, ImageView imageViewButton1, Label labelButton, ImageView allViewButton
            , Label allLabel) throws MissionNotLoaded {
        int capacityOfOnlineShop = 100000;
        imageViewButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String nowString = labelButton.getText();
                int nowInt = Integer.valueOf(nowString);
                if (nowInt < maxNumber) {
                    labelButton.setText(String.valueOf(nowInt + 1));
                    if (getCapacityNeeded() > capacityOfOnlineShop) {
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
                    if (getCapacityNeeded() > capacityOfOnlineShop) {
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
                String currentText = labelButton.getText();
                labelButton.setText(String.valueOf(maxNumber));
                if (getCapacityNeeded() > capacityOfOnlineShop) {
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
                String currentText = labelButton.getText();
                labelButton.setText(String.valueOf(maxNumber));
                if (getCapacityNeeded() > capacityOfOnlineShop) {
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


        labelButtonFlouryCakeToOrder.relocate(455, 130 + 5);
        labelButtonFlouryCakeToOrder.setTextFill(Color.BLACK);
        labelButtonFlouryCakeToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


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

        labelButtonFlouryCakeToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5);
            }
        });
        labelButtonFlouryCakeToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130);
            }
        });

        MakeLabelAndButtonChangable("FlouryCake",imageViewButton1, labelButtonFlouryCakeToOrder);

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonFlouryCakeToOrder, labelOfPrice);

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

        labelButtonCakeToOrder.relocate(455, 130 + 5 + shift);
        labelButtonCakeToOrder.setTextFill(Color.BLACK);
        labelButtonCakeToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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
        labelButtonCakeToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });
        labelButtonCakeToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });
        MakeLabelAndButtonChangable("Cake",imageViewButton1, labelButtonCakeToOrder);

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCakeToOrder, labelOfPrice);
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

        labelButton1FlourToOrder.relocate(455, 130 + 5 + shift);
        labelButton1FlourToOrder.setTextFill(Color.BLACK);
        labelButton1FlourToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


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

        labelButton1FlourToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButton1FlourToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButton1FlourToOrder, labelOfPrice);
        MakeLabelAndButtonChangable("Flour",imageViewButton1, labelButton1FlourToOrder);
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

        labelButtonPowderToOrder.relocate(455, 130 + 5 + shift);
        labelButtonPowderToOrder.setTextFill(Color.BLACK);
        labelButtonPowderToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        MakeLabelAndButtonChangable("Powder",imageViewButton1, labelButtonPowderToOrder);

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


        labelButtonPowderToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonPowderToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonPowderToOrder, labelOfPrice);
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

        labelButtonCarnivalDressToOrder.relocate(455, 130 + 5 + shift);
        labelButtonCarnivalDressToOrder.setTextFill(Color.BLACK);
        labelButtonCarnivalDressToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


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


        labelButtonCarnivalDressToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonCarnivalDressToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        MakeLabelAndButtonChangable("CarnivalDress",imageViewButton1, labelButtonCarnivalDressToOrder);
        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonCarnivalDressToOrder, labelOfPrice);
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

        labelButtonDecorationToOrder.relocate(455, 130 + 5 + shift);
        labelButtonDecorationToOrder.setTextFill(Color.BLACK);
        labelButtonDecorationToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


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


        labelButtonDecorationToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonDecorationToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonDecorationToOrder, labelOfPrice);
        MakeLabelAndButtonChangable("Decoration",imageViewButton1, labelButtonDecorationToOrder);
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

        labelButtonFabricToOrder.relocate(455, 130 + 5 + shift);
        labelButtonFabricToOrder.setTextFill(Color.BLACK);
        labelButtonFabricToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");


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

        labelButtonFabricToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonFabricToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35);
                imageViewButton1.setFitWidth(35);
                imageViewButton1.relocate(445, 130 + shift);
            }
        });

        MakeLabelAndButtonChangable("Fabric",imageViewButton1, labelButtonFabricToOrder);
        root.getChildren().addAll(imageViewButton1, imageViewCoin, imageViewIcon, labelButtonFabricToOrder, labelOfPrice);
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


        labelButtonSewingToOrder.relocate(455, 130 + 5 + shift);
        labelButtonSewingToOrder.setTextFill(Color.BLACK);
        labelButtonSewingToOrder.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

        MakeLabelAndButtonChangable("Sewing",imageViewButton1, labelButtonSewingToOrder);

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

        labelButtonSewingToOrder.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageViewButton1.setFitHeight(35 + 5);
                imageViewButton1.setFitWidth(35 + 5);
                imageViewButton1.relocate(445 - 2.5, 130 - 2.5 + shift);
            }
        });

        labelButtonSewingToOrder.setOnMouseExited(new EventHandler<MouseEvent>() {
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
        root.getChildren().addAll(labelButtonSewingToOrder);
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


                    labelEggButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelEggButton1ToSell.setTextFill(Color.BLACK);
                    labelEggButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelEggButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });
                    labelEggButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelEggOfNumber.getText()), imageViewButton1, labelEggButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelEggButton1ToSell, labelButtonAll, labelEggOfNumber, labelOfPrice);
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


                    labelWoolButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelWoolButton1ToSell.setTextFill(Color.BLACK);
                    labelWoolButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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
                    labelWoolButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });
                    labelWoolButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelWoolOfNumber.getText()), imageViewButton1, labelWoolButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelWoolButton1ToSell, labelButtonAll, labelWoolOfNumber, labelOfPrice);
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


                    labelMilkButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelMilkButton1ToSell.setTextFill(Color.BLACK);
                    labelMilkButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelMilkButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelMilkButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelMilkOfNumber.getText()), imageViewButton1, labelMilkButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelMilkButton1ToSell, labelButtonAll, labelMilkOfNumber, labelOfPrice);
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


                    labelFlouryCakeButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelFlouryCakeButton1ToSell.setTextFill(Color.BLACK);
                    labelFlouryCakeButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelFlouryCakeButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFlouryCakeButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelFlouryCakeOfNumber.getText()), imageViewButton1, labelFlouryCakeButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelFlouryCakeButton1ToSell, labelButtonAll, labelFlouryCakeOfNumber, labelOfPrice);
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


                    labelCakeButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelCakeButton1ToSell.setTextFill(Color.BLACK);
                    labelCakeButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelCakeButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelCakeButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCakeOfNumber.getText()), imageViewButton1, labelCakeButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelCakeButton1ToSell, labelButtonAll, labelCakeOfNumber, labelOfPrice);
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


                    labelFlourButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelFlourButton1ToSell.setTextFill(Color.BLACK);
                    labelFlourButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelFlourButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFlourButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelFlourOfNumber.getText()), imageViewButton1, labelFlourButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelFlourButton1ToSell, labelButtonAll, labelFlourOfNumber, labelOfPrice);
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


                    labelPowderButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelPowderButton1ToSell.setTextFill(Color.BLACK);
                    labelPowderButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelPowderButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelPowderButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelPowderOfNumber.getText()), imageViewButton1, labelPowderButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelPowderButton1ToSell, labelButtonAll, labelPowderOfNumber, labelOfPrice);
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


                    labelCarnivalDressButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelCarnivalDressButton1ToSell.setTextFill(Color.BLACK);
                    labelCarnivalDressButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelCarnivalDressButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelCarnivalDressButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCarnivalDressOfNumber.getText()), imageViewButton1, labelCarnivalDressButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelCarnivalDressButton1ToSell, labelButtonAll, labelCarnivalDressOfNumber, labelOfPrice);
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


                    labelDecorationButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelDecorationButton1ToSell.setTextFill(Color.BLACK);
                    labelDecorationButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelDecorationButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelDecorationButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelDecorationOfNumber.getText()), imageViewButton1, labelDecorationButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelDecorationButton1ToSell, labelButtonAll, labelDecorationOfNumber, labelOfPrice);
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


                    labelFabricButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelFabricButton1ToSell.setTextFill(Color.BLACK);
                    labelFabricButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelFabricButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelFabricButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelFabricOfNumber.getText()), imageViewButton1, labelFabricButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelFabricButton1ToSell, labelButtonAll, labelFabricOfNumber, labelOfPrice);
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


                    labelSewingButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                    labelSewingButton1ToSell.setTextFill(Color.BLACK);
                    labelSewingButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                    labelSewingButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            imageViewButton1.setFitHeight(35 + 5);
                            imageViewButton1.setFitWidth(35 + 5);
                            imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                        }
                    });

                    labelSewingButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                    MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelSewingOfNumber.getText()), imageViewButton1, labelSewingButton1ToSell, imageViewButtonAll, labelButtonAll);

                    root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                            , imageViewMultiply, labelSewingButton1ToSell, labelButtonAll, labelSewingOfNumber, labelOfPrice);
                    yLocationOfFirst += 50;
                } else if (key.substring(0, 4).equals("Cage")) {
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


                        labelCageLionButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                        labelCageLionButton1ToSell.setTextFill(Color.BLACK);
                        labelCageLionButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                        labelCageLionButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelCageLionButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                        MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCageLionOfNumber.getText()), imageViewButton1, labelCageLionButton1ToSell, imageViewButtonAll, labelButtonAll);

                        root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                                , imageViewMultiply, labelCageLionButton1ToSell, labelButtonAll, labelCageLionOfNumber, labelOfPrice);
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


                        labelCageBearButton1ToSell.relocate(380 + SHIFT, finalYLocationOfFirst + 5);
                        labelCageBearButton1ToSell.setTextFill(Color.BLACK);
                        labelCageBearButton1ToSell.setStyle("-fx-font: 24 arial; -fx-base: #030202;");

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

                        labelCageBearButton1ToSell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                imageViewButton1.setFitHeight(35 + 5);
                                imageViewButton1.setFitWidth(35 + 5);
                                imageViewButton1.relocate(370 - 2.5 + SHIFT, finalYLocationOfFirst - 2.5);
                            }
                        });

                        labelCageBearButton1ToSell.setOnMouseExited(new EventHandler<MouseEvent>() {
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

                        MakeLabelAndButtonChangableّForSell(Integer.valueOf(labelCageBrearOfNumber.getText()), imageViewButton1, labelCageBearButton1ToSell, imageViewButtonAll, labelButtonAll);

                        root.getChildren().addAll(imageViewButton1, imageViewButtonAll, imageViewCoin, imageViewIcon
                                , imageViewMultiply, labelCageBearButton1ToSell, labelButtonAll, labelCageBrearOfNumber, labelOfPrice);
                        yLocationOfFirst += 50;
                    }
                }
            }

        } catch (MissionNotLoaded | UnknownObjectException missionNotLoaded) {
            missionNotLoaded.printStackTrace();
        }
    }

    private void AddMoneyLabels() {

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
        coinTextForOrder.relocate(250, 610);
        coinTextForSell.relocate(700, 610);
        root.getChildren().addAll(coinTextForSell, coinTextForOrder, imageViewCoin, coint2);
    }

    private void SetNumberOfProductExistInOnlineShop(String data) {
        //data is like Cake:2
        String product=data.split(":")[0];
        String number=data.split(":")[1];
        Label label= getMaxNumberOfProductLabelInOnlineShop(product);
        label.setText(number);
    }

    private Label getNumberOfOrderLabelProductExistInOnlineShop(String product) {
        if (product.equals("FlouryCake")) {
            return labelButtonFlouryCakeToOrder;
        } else if (product.equals("Cake")) {
            return labelButtonCakeToOrder;
        } else if (product.equals("Flour")) {
            return labelButton1FlourToOrder;
        } else if (product.equals("Powder")) {
            return labelButtonPowderToOrder;
        } else if (product.equals("CarnivalDress")) {
            return labelButtonCarnivalDressToOrder;
        } else if (product.equals("Decoration")) {
            return labelButtonDecorationToOrder;
        } else if (product.equals("Fabric")) {
            return labelButtonFabricToOrder;
        } else if (product.equals("Sewing")) {
            return labelButtonSewingToOrder;
        }
        return null;
    }

    private Label getMaxNumberOfProductLabelInOnlineShop(String product){
        if (product.equals("FlouryCake")) {
            return maxNumberOfFlouryCake;
        } else if (product.equals("Cake")) {
            return maxNumberOfCake;
        } else if (product.equals("Flour")) {
            return maxNumberOfFlour;
        } else if (product.equals("Powder")) {
            return maxNumberOfPowder;
        } else if (product.equals("CarnivalDress")) {
            return maxNumberOfCarnivalDress;
        } else if (product.equals("Decoration")) {
            return maxNumberOfDecoration;
        } else if (product.equals("Fabric")) {
            return maxNumberOfDecoration;
        } else if (product.equals("Sewing")) {
            return maxNumberOfSewing;
        }
        return null;
    }

    private void AddMaxNumberProductLabels(){
        int x=180;
        int y=80;
        int yShift=50;
        maxNumberOfFlouryCake.relocate(x,y+yShift);
        maxNumberOfFlouryCake.setFont(Font.font(20));
        maxNumberOfCake.relocate(x,y+2*yShift);
        maxNumberOfCake.setFont(Font.font(20));
        maxNumberOfFlour.relocate(x,y+3*yShift);
        maxNumberOfFlour.setFont(Font.font(20));
        maxNumberOfPowder.relocate(x,y+4*yShift);
        maxNumberOfPowder.setFont(Font.font(20));
        maxNumberOfFabric.relocate(x,y+5*yShift);
        maxNumberOfFabric.setFont(Font.font(20));
        maxNumberOfCarnivalDress.relocate(x,y+6*yShift);
        maxNumberOfCarnivalDress.setFont(Font.font(20));
        maxNumberOfDecoration.relocate(x,y+7*yShift);
        maxNumberOfDecoration.setFont(Font.font(20));
        maxNumberOfSewing.relocate(x,y+8*yShift);
        maxNumberOfSewing.setFont(Font.font(20));
        root.getChildren().addAll(maxNumberOfFlouryCake,maxNumberOfCake,maxNumberOfFlour,maxNumberOfPowder,maxNumberOfFabric,maxNumberOfCarnivalDress,maxNumberOfDecoration,maxNumberOfSewing);
    }

    public void ReloadNumberOfProductExistInOnLineShop(String data){
        String[] datas=data.split(" ");
        for(String string:datas){
            try {
                SetNumberOfProductExistInOnlineShop(string);
            }catch (Exception e){}
        }
    }

    private void AddCagesLionIcon(){
        File backGroundFile = new File("Data\\Textures\\Products\\CagedLion.png");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView wildAnimal = new ImageView(backGroundImage);
        wildAnimal.setFitHeight(70);
        wildAnimal.setFitWidth(70);
        wildAnimal.relocate(1250,650);
        wildAnimal.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wildAnimal.setFitWidth(75);
                wildAnimal.setFitHeight(75);
                wildAnimal.relocate(1248,655);
            }
        });
        wildAnimal.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wildAnimal.setFitHeight(70);
                wildAnimal.setFitWidth(70);
                wildAnimal.relocate(1250,650);
            }
        });
        root.getChildren().addAll(wildAnimal);
        MakeWildAnimalIconViewSetOnMouseClick(wildAnimal);
    }

    private void MakeWildAnimalIconViewSetOnMouseClick(Node node){

        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OnlinePlayerRectangle();
                for(Node node:currentOnlinePalyerNodes){
                    if (root.getChildren().contains(node)){
                        currentOnlinePalyerNodes.remove(node);
                    }
                }
                currentOnlinePalyerNodes=new ArrayList<>();
                int StartYForPlayername = 350;
                for (String playerName : Changes.getUserThatArePlayingMissionNow()) {
                    Label labelResultForContact;
                    labelResultForContact = new Label(playerName);
                    labelResultForContact.setTextFill(Paint.valueOf("Black"));
                    labelResultForContact.setFont(Font.font(25));
                    labelResultForContact.setStyle("-fx-background-color: rgb(84,124,154);-fx-arc-height: 30;-fx-arc-width: 30");
                    labelResultForContact.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            labelResultForContact.setStyle("-fx-background-color: rgb(84,124,154);-fx-arc-height: 30;-fx-arc-width: 30");
                        }
                    });
                    labelResultForContact.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            labelResultForContact.setStyle("-fx-background-color: rgb(114,154,184);-fx-arc-height: 30;-fx-arc-width: 30");
                        }
                    });
                    labelResultForContact.relocate(1200, StartYForPlayername);
                    labelResultForContact.setViewOrder(-0.96);
                    currentOnlinePalyerNodes.add(labelResultForContact);
                    root.getChildren().addAll(labelResultForContact);
                    StartYForPlayername += 50;
                    MakeOnlineLabelPlayerSetOnMouseClick(labelResultForContact);
                }
            }
        });
    }

    private void MakeOnlineLabelPlayerSetOnMouseClick(Label node){
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String contactName=node.getText();
                TextField ipTextField=GameView.getGameView().getHostAndGuestView().getIpTextField();
                int userMoney=Game.getGameInstance().getCurrentUserAccount().getMoney();
                int moneyNeeded=800;
                if (userMoney>moneyNeeded) {
                    if (GameView.getGameView().getHostAndGuestView().getRoot().getChildren().contains(ipTextField)) {
                        Changes.AddMassageToMassageThatShouldSend("W@" + contactName);
                    } else {
                        PVView pvView = findPvViewByUserName(contactName);
                        pvView.AddDataToMassageToSendThatWeDidntSendThem("W@");
                    }
                    Game.getGameInstance().getCurrentUserAccount().setMoney(userMoney-moneyNeeded);
                }else {
                    try {
                        throw new NotEnoughMoney();
                    } catch (NotEnoughMoney enoughMoney) {
                        enoughMoney.printStackTrace();
                    }
                }
            }
        });
    }

    private void OnlinePlayerRectangle(){
        onlinePlayerRectangle.setArcHeight(30);
        onlinePlayerRectangle.setOpacity(0);
        onlinePlayerRectangle.setArcWidth(30);
        onlinePlayerRectangle.setFill(Paint.valueOf("White"));
        onlinePlayerRectangle.setViewOrder(-0.95);
        if(root.getChildren().contains(onlinePlayerRectangle)){
            KeyValue opacity=new KeyValue(onlinePlayerRectangle.opacityProperty(),0);
            KeyFrame opacityFrame=new KeyFrame(Duration.seconds(1),opacity);
            Timeline timeline=new Timeline(opacityFrame);
            timeline.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    root.getChildren().removeAll(onlinePlayerRectangle);
                }
            });
            timeline.play();
        }else{
            root.getChildren().addAll(onlinePlayerRectangle);
            KeyValue opacity=new KeyValue(onlinePlayerRectangle.opacityProperty(),0.6);
            KeyFrame opacityFrame=new KeyFrame(Duration.seconds(1),opacity);
            Timeline timeline=new Timeline(opacityFrame);
            timeline.play();
        }
    }

}
