package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.Internet.Changes;
import FarmModel.Internet.ServerAndClientRunnable.GuestSocketRunnable;
import FarmModel.Internet.ServerAndClientRunnable.ServerSocketRunnable;
import FarmModel.User;
import View.GameView;
import View.Main;
import javafx.animation.AnimationTimer;
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
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HostAndGuestView extends View.View {
    private Group root = new Group();
    private Scene scene = new Scene(root, 1500, 700);
    private TextField userPort = new TextField("8050");
    private TextField ipTextField = new TextField("serverip");
    private TextField portTextField = new TextField("8050");
    private int endHeightOfTheMassages = 120;
    private int endHeightOfTheContacts = 120;
    Label clientIp=new Label("Client Ip: ");
    Rectangle scoreboardRectangle = new Rectangle(475, 900, 500, 600);
    Rectangle returnToMainMenu = new Rectangle(20, 20, 105, 45);
    private ArrayList<String> massagedidntshowedInInGroup = new ArrayList<>();
    private ArrayList<String> historyMassage = new ArrayList<>();
    private ArrayList<Node> massageHistoryNodes = new ArrayList<>();
    private ArrayList<Node> currentContactsNode = new ArrayList<>();
    private ArrayList<String> currentPlayerNameSortbyMoney = new ArrayList<>();
    private ArrayList<Node> currentPlayerNodeSortbyMoney = new ArrayList<>();
    private BazaarView bazaarView;
    public BazaarView getBazaarView() {
        return bazaarView;
    }

    public void setBazaarView(BazaarView bazaarView) {
        this.bazaarView = bazaarView;
    }

    public void setClientIp(int clientIpNumber) {
        clientIp.setText("Client Ip: "+String.valueOf(clientIpNumber));
    }

    public Group getRoot() {
        return root;
    }

    public TextField getIpTextField() {
        return ipTextField;
    }

    public ArrayList<Node> getCurrentContactsNode() {
        return currentContactsNode;
    }

    public void setCurrentContactsNode(ArrayList<Node> currentContactsNode) {
        this.currentContactsNode = currentContactsNode;
    }
    //    public ArrayList<String> getMassagedidntsent() {
//        return massagedidntsent;
//    }

//    public void setMassagedidntsent(ArrayList<String> massagedidntsent) {
//        this.massagedidntsent = massagedidntsent;
//    }

    public HostAndGuestView(Stage primaryStage) throws UnknownObjectException, MissionNotLoaded {
        Start(primaryStage);
    }

    public ArrayList<String> getHistoryMassage() {
        return historyMassage;
    }

    public Scene getScene() {
        return scene;
    }


    @Override
    public void Start(Stage primaryStage) {
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastTime = 0;
            double time = 0;
            private long second = 1000000000;

            @Override
            public void handle(long now) {
                if (lastTime == 0)
                    lastTime = now;
                if (now - lastTime > (second / 4)) {
                    //this check every 0.5 sec to upload every thing like PVView and IsNewMassage.
                    lastTime = now;
                    time += 1;
                    ReloadStateOfUsersAndServer();
                    if (Changes.isThereAnyNewContact()) {
                        ReloadPVContacts(primaryStage);
                        ReloadCurrentPLayerSortedByMoneyAndViewWhenScoreBoardIsShowing();
                        Changes.ContactViewReloaded();
                    }
                    if (Changes.DoWeHaveUserNameError()) {
                        GameView.getGameView().getHostAndGuestView().ShowThereIsAUserWithThisNameError();
                        Changes.setWeHaveUserNameErrorfalse();
                    }
                    if (Changes.isThereAnyNewMassage()) {
                        try {
                            Changes.MassagesAdded();
                            AddNewMassagesToAllocatedPvAndGroup();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if (GameView.getGameView().getStartMenuView().getServerOrGuest() != null) {
                        GameView.getGameView().getHostAndGuestView().getBazaarView().ReloadNumberOfProductExistInOnLineShop(Changes.getDataForMaxNumberOfProductExistInOnlineShop());
                        try {
                            Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
                            TextField ipTextField = GameView.getGameView().getHostAndGuestView().getIpTextField();
                            if (GameView.getGameView().getHostAndGuestView().getRoot().getChildren().contains(ipTextField)) {
                                Changes.AddMassageToMassageThatShouldSend("P@" + Game.getGameInstance().getCurrentUserAccount().getAccountName() + "@Playing");
                            } else {
                                for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
                                    entry.getValue().AddDataToMassageToSendThatWeDidntSendThem("P@Playing");
                                }
                            }
                        } catch (MissionNotLoaded missionNotLoaded) {
                            //it means that user is not playing a mission now so you can't release a wild animal in his map.
                            try {
                                TextField ipTextField = GameView.getGameView().getHostAndGuestView().getIpTextField();
                                if (GameView.getGameView().getHostAndGuestView().getRoot().getChildren().contains(ipTextField)) {
                                    Changes.AddMassageToMassageThatShouldSend("P@" + Game.getGameInstance().getCurrentUserAccount().getAccountName() + "@NotPlaying");
                                } else {
                                    for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
                                        entry.getValue().AddDataToMassageToSendThatWeDidntSendThem("P@NotPlaying");
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        animationTimer.start();
        AddShopBackground(primaryStage);
        AddBackgroundBlackRectangle();
        AddGroupRectangleAndContactRectangle();
        AddTextFieldToGetPort();
        AddTextFieldTOSendInGroup();
        AddOkToStartConnecting();
        AddGoToMissionselectionView(primaryStage);
        AddScoreBoardButton();
        AddBazarClick(primaryStage);
    }

    private void AddOkToStartConnecting() {
        Rectangle rectangle = new Rectangle(1430, 55, 50, 45);
        rectangle.setArcWidth(8);
        rectangle.setArcHeight(8);
        rectangle.setOpacity(0.2);
        rectangle.setFill(Color.rgb(255, 255, 255));
        Label okLabel = new Label("OK");
        okLabel.setTextFill(Color.rgb(255, 255, 255));
        okLabel.setFont(Font.font(35));
        okLabel.relocate(1430, 53);
        rectangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.setOpacity(0.5);
            }
        });
        rectangle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.setOpacity(0.2);
            }
        });
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (root.getChildren().contains(ipTextField)) {
                    if (!portTextField.getText().equals("") && !ipTextField.getText().equals("") && !userPort.getText().equals("")) {
                        GameView.getGameView().getStartMenuView().setServerOrGuest(new GuestSocketRunnable(portTextField.getText(), ipTextField.getText()));
                        Thread thread = new Thread(GameView.getGameView().getStartMenuView().getServerOrGuest());
                        thread.start();
                    }
                } else {
                    if (!userPort.getText().equals("")) {
                        GameView.getGameView().getStartMenuView().setServerOrGuest(new ServerSocketRunnable(userPort.getText()));
                        Thread thread = new Thread(GameView.getGameView().getStartMenuView().getServerOrGuest());
                        thread.start();
                    }
                }
            }
        });
        root.getChildren().addAll(okLabel, rectangle);
    }


    private void AddNewContactWhenItConnectToOurPort(Socket socket, Stage primaryStage, String contactName) {
        Label contactLabel = new Label(" " + contactName + " ");
        contactLabel.relocate(850, endHeightOfTheContacts + 5);
        endHeightOfTheContacts += 50;
        contactLabel.setFont(Font.font(30));
        contactLabel.setStyle("-fx-background-color: rgb(114,144,174);-fx-arc-height: 30;-fx-arc-width: 30");
        currentContactsNode.add(contactLabel);
        MakeContactsViewScrolling(contactLabel);
        contactLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                contactLabel.setStyle("-fx-background-color: rgb(154,194,224);-fx-arc-height: 30;-fx-arc-width: 30");
            }
        });
        contactLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                contactLabel.setStyle("-fx-background-color: rgb(114,144,174);-fx-arc-height: 30;-fx-arc-width: 30");
            }
        });
        contactLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).getScene());
                primaryStage.setFullScreen(true);
            }
        });
        root.getChildren().addAll(contactLabel);
    }

    public void AddServerIP() {
        clientIp.relocate(800,60);
        clientIp.setFont(Font.font(25));
        root.getChildren().addAll(clientIp);
    }


    public void ShowDataInPV(String str, int xForLocationToDetermineTheOwner) {
        if (str.length() < 6) {
            int x;
            if (xForLocationToDetermineTheOwner > 100) {
                x = xForLocationToDetermineTheOwner + 100;
            } else {
                x = xForLocationToDetermineTheOwner;
            }
            Label labelMassage = new Label(str);
            labelMassage.setTextFill(Color.rgb(15, 15, 45));
            labelMassage.setFont(Font.font(20));
            labelMassage.relocate(x, endHeightOfTheMassages);
            endHeightOfTheMassages = endHeightOfTheMassages + 20 + 10;
            if (endHeightOfTheMassages > 750) {
                endHeightOfTheMassages = 750;
                makeNodesChangeTheY(-30, massageHistoryNodes);
            }
            root.getChildren().addAll(labelMassage);
            massageHistoryNodes.add(labelMassage);
        } else {
            if (str.substring(0, 4).equals("Gif ")) {
                int x;
                if (xForLocationToDetermineTheOwner > 100) {
                    x = xForLocationToDetermineTheOwner + 100;
                } else {
                    x = xForLocationToDetermineTheOwner;
                }
                String path = str.split(" ")[1];
                AddDataImageOrGifsOrEmojiToPv(path, 100, 100, x);

            } else if (str.substring(0, 6).equals("Image ")) {
                String path = str.split(" ")[1];
                AddDataImageOrGifsOrEmojiToPv(path, 200, 200, xForLocationToDetermineTheOwner);

            } else if (str.substring(0, 6).equals("Emoji ")) {
                int x;
                if (xForLocationToDetermineTheOwner > 100) {
                    x = xForLocationToDetermineTheOwner + 100;
                } else {
                    x = xForLocationToDetermineTheOwner;
                }
                String path = str.split(" ")[1];
                AddDataImageOrGifsOrEmojiToPv(path, 20, 20, x);
            } else {
                int x;
                if (xForLocationToDetermineTheOwner > 100) {
                    x = xForLocationToDetermineTheOwner + 100;
                } else {
                    x = xForLocationToDetermineTheOwner;
                }
                Label labelMassage = new Label(str);
                labelMassage.setFont(Font.font(20));
                labelMassage.relocate(x, endHeightOfTheMassages);
                labelMassage.setTextFill(Color.rgb(15, 15, 45));
                endHeightOfTheMassages = endHeightOfTheMassages + 20 + 10;
                if (endHeightOfTheMassages > 750) {
                    endHeightOfTheMassages = 750;
                    makeNodesChangeTheY(-30, massageHistoryNodes);
                }
                root.getChildren().addAll(labelMassage);
                massageHistoryNodes.add(labelMassage);
            }
        }
    }

    public void ReloadPVContacts(Stage primaryStage) {
        SendConnectedClientDataToOther();
        endHeightOfTheContacts = 120;
        for (Node node : currentContactsNode) {
            if (root.getChildren().contains(node)) {
                root.getChildren().removeAll(node);
            }
        }
        currentContactsNode = new ArrayList<>();
        try {
            for (Map.Entry<Socket, PVView> socketPVViewEntry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
                AddNewContactWhenItConnectToOurPort(socketPVViewEntry.getKey(), primaryStage, socketPVViewEntry.getValue().getContactName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddNewMassagesToAllocatedPvAndGroup() throws IOException {
        try {
            for (PVView pvView : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().values()) {
                if (pvView.getMassagesNotWrittenInPVView().size() != 0) {
                    for (Map.Entry<String, Integer> stringIntegerEntry : pvView.getMassagesNotWrittenInPVView().entrySet()) {
                        pvView.ShowDataInPV(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                    }
                    pvView.setDatasNotWrittenInPVViewAndTheXPosition(new HashMap<>());
                }
            }
        } catch (Exception e) {
        }
        try {
            for (String string : massagedidntshowedInInGroup) {
                ShowDataInPV(string, 100);
            }
            massagedidntshowedInInGroup = new ArrayList<>();
        } catch (Exception e) {
        }
    }

    private void AddDataImageOrGifsOrEmojiToPv(String path, int height, int width, int x) {
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.relocate(x, endHeightOfTheMassages);
        endHeightOfTheMassages += height + 10;
        root.getChildren().addAll(imageView);
    }

    public void AddMassageToHistoryAndMassageNotWrittenInGroup(String massage) {
        massagedidntshowedInInGroup.add(massage);
        historyMassage.add(massage);
    }

    private void AddGroupRectangleAndContactRectangle() {
        Rectangle rectangle = new Rectangle(75, 120, 600, 700);
        rectangle.setFill(Color.rgb(0, 64, 158));
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);
        rectangle.setOpacity(0.4);
        rectangle.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                makeNodesChangeTheY((int) (event.getDeltaY() / 8), massageHistoryNodes);
            }
        });

        root.getChildren().addAll(rectangle);

        Rectangle rectangle2 = new Rectangle(775, 120, 700, 700);
        rectangle2.setFill(Color.rgb(0, 158, 130));
        rectangle2.setArcWidth(30);
        rectangle2.setArcHeight(30);
        rectangle2.setOpacity(0.4);
        MakeContactsViewScrolling(rectangle2);

        root.getChildren().addAll(rectangle2);
    }

    public void AddShopBackground(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
        root.getChildren().addAll(BackGroundView);
    }

    public void AddBackgroundBlackRectangle() {
        Rectangle rectangle = new Rectangle(50, 100, 1450, 760);
        rectangle.setFill(Color.rgb(0, 0, 0));
        rectangle.setOpacity(0.5);
        rectangle.setArcWidth(50);
        rectangle.setArcHeight(50);
        root.getChildren().addAll(rectangle);
    }

    private void AddTextFieldToGetPort() {
        Rectangle userPortRec = new Rectangle(2, 2, 200, 40);
        userPortRec.setArcWidth(15);
        userPortRec.setArcHeight(15);

        userPort.relocate(1150, 56);
        userPort.setFont(Font.font(20));
        userPort.setClip(userPortRec);
        root.getChildren().addAll(userPort);

    }

    private void AddTextFieldTOSendInGroup() {
        TextField textField = new TextField();
        textField.relocate(75, 825);
        textField.setFont(Font.font(15));

        Label sendLabel = new Label("Send");
        sendLabel.setFont(Font.font(20));
        sendLabel.setTextFill(Color.rgb(255, 255, 255));
        sendLabel.relocate(308, 825);

        Rectangle clipRectangle = new Rectangle(300, 825, 60, 30);
        clipRectangle.setFill(Color.rgb(255, 255, 255));
        clipRectangle.setArcHeight(8);
        clipRectangle.setArcWidth(8);
        clipRectangle.setOpacity(0.1);

        clipRectangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clipRectangle.setOpacity(0.2);
            }
        });
        clipRectangle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clipRectangle.setOpacity(0.1);
            }
        });
        clipRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (root.getChildren().contains(ipTextField)) {
                    String massage = textField.getText();
                    Changes.AddMassageToMassageThatShouldSend("@" + massage);
                    massagedidntshowedInInGroup.add(massage);
                    Changes.WeHaveNewMassageToShow();
                } else {
                    String massage = textField.getText();
                    AddMassageToHistoryAndMassageNotWrittenInGroup(massage);
                    Changes.WeHaveNewMassageToShow();
                    for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
                        entry.getValue().getDataToSendThatWeDidntSendThem().add("@" + massage);
                    }

                }
            }
        });

        root.getChildren().addAll(textField, sendLabel, clipRectangle);
    }

    public void AddTextFieldToGetServerIPAndServerPort() {
        ipTextField.setFont(Font.font(20));
        ipTextField.relocate(220, 56);
        portTextField.setFont(Font.font(20));
        portTextField.relocate(450, 56);
        Rectangle ipRectangle = new Rectangle(0, 0, 200, 42);
        ipRectangle.setArcWidth(15);
        ipRectangle.setArcHeight(15);
        ipTextField.setClip(ipRectangle);
        Rectangle portRectangle = new Rectangle(0, 0, 200, 42);
        portRectangle.setArcHeight(15);
        portRectangle.setArcWidth(15);
        portTextField.setClip(portRectangle);
        root.getChildren().addAll(ipTextField, portTextField);
    }

    private void makeNodesChangeTheY(int y, ArrayList<Node> nodes) {
        for (Node node : nodes) {
            if (node instanceof Rectangle) {
                int newx = (int) ((Rectangle) node).getX();
                int newy = (int) ((Rectangle) node).getY() + y;
                node.relocate(newx, newy);
                if (((Rectangle) node).getY() - y >= 119 & ((Rectangle) node).getY() - y <= 750) {
                    if (((Rectangle) node).getY() >= 750 | ((Rectangle) node).getY() <= 120) {
                        try {
                            root.getChildren().removeAll(node);
                        } catch (Exception e) {
                        }
                    }
                } else if (((Rectangle) node).getY() - y <= 120 | ((Rectangle) node).getY() - y >= 750) {
                    if (((Rectangle) node).getY() <= 750 & ((Rectangle) node).getY() >= 120) {
                        try {
                            root.getChildren().addAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
            } else {

                node.relocate(node.getLayoutX(), node.getLayoutY() + y);
                if (node.getLayoutY() - y >= 119 & node.getLayoutY() - y <= 750) {
                    if (node.getLayoutY() >= 750 | node.getLayoutY() <= 120) {
                        try {
                            root.getChildren().removeAll(node);
                        } catch (Exception e) {
                        }
                    }
                } else if (node.getLayoutY() - y <= 120 | node.getLayoutY() - y >= 750) {
                    if (node.getLayoutY() <= 750 & node.getLayoutY() >= 120) {
                        try {
                            root.getChildren().addAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    private void MakeContactsViewScrolling(Node node) {
        node.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                makeNodesChangeTheY((int) (event.getDeltaY() / 8), currentContactsNode);
            }
        });

    }

    private void AddGoToMissionselectionView(Stage primaryStage) {
        Label label = new Label("Missions");
        label.setTextFill(Paint.valueOf("White"));
        label.setFont(Font.font(20));
        label.relocate(27, 25);
        returnToMainMenu.setFill(Paint.valueOf("White"));
        returnToMainMenu.setArcHeight(20);
        returnToMainMenu.setArcWidth(20);
        returnToMainMenu.setOpacity(0.1);
        returnToMainMenu.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                returnToMainMenu.setOpacity(0.2);
            }
        });
        returnToMainMenu.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                returnToMainMenu.setOpacity(0.1);
            }
        });
        returnToMainMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getMissionSelectionView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        root.getChildren().addAll(label, returnToMainMenu);
    }

    public void SendConnectedClientDataToOther() {
        String data = "D@";
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            data += entry.getValue().getContactName() + "," + entry.getValue().getContactMoneyInGame() + "," + entry.getValue().getContactLevelInMission() + " ";
        }
        User user = Game.getGameInstance().getCurrentUserAccount();
        data += "Server:" + user.getAccountName() + "," + user.getMoney() + "," + user.getUserLevel();
        for (PVView pvView : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().values()) {
            pvView.AddDataToMassageToSendThatWeDidntSendThem(data);
        }

    }

    private void AddScoreBoardButton() {
        Circle circle = new Circle(725, 815, 60, Paint.valueOf("White"));
        circle.setOpacity(0.2);
        circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.setOpacity(0.4);
            }
        });
        circle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.setOpacity(0.2);
            }
        });
        Label scoreBoardLabel = new Label("ScoreBoard");
        scoreBoardLabel.setFont(Font.font(20));
        scoreBoardLabel.relocate(675, 805);
        scoreBoardLabel.setTextFill(Paint.valueOf("White"));
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ReloadCurrentPLayerSortedByMoneyAndViewWhenScoreBoardIsShowing();
                if (scoreboardRectangle.getY() == 900) {
                    AddScoreBoardRectangle();
                } else {
                    RemoveScoreBoardRectangle();
                }
            }
        });
        root.getChildren().addAll(scoreBoardLabel, circle);
        scoreboardRectangle.setArcWidth(40);
        scoreboardRectangle.setOpacity(0.5);
        scoreboardRectangle.setFill(Paint.valueOf("White"));
        scoreboardRectangle.setArcHeight(40);
        scoreboardRectangle.setViewOrder(-0.9);
        root.getChildren().addAll(scoreboardRectangle);
    }

    private void AddScoreBoardRectangle() {
        KeyValue rectangleY = new KeyValue(scoreboardRectangle.yProperty(), 150);
        KeyFrame rectangleFrame = new KeyFrame(Duration.seconds(1), rectangleY);
        Timeline timeline = new Timeline(rectangleFrame);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddScoreBoardItems();
            }
        });

    }

    private void RemoveScoreBoardRectangle() {
        KeyValue rectangleY = new KeyValue(scoreboardRectangle.yProperty(), 900);
        KeyFrame rectangleFrame = new KeyFrame(Duration.seconds(1), rectangleY);
        Timeline timeline = new Timeline(rectangleFrame);
        timeline.play();
        RemoveScoreBoardItemsFromViewAndDeleteOldNodesFromArray();

    }

    private void AddScoreBoardItems() {
        int StartYForPlayername = 160;
        int number = 1;
        for (String playerName : currentPlayerNameSortbyMoney) {
            Label labelResultForContact;
            if (!playerName.equals(Game.getGameInstance().getCurrentUserAccount().getAccountName())) {
                PVView pvView = findPvViewByUserName(playerName);
                labelResultForContact = new Label(number + " " + playerName + ": " + pvView.getContactMoneyInGame());

            }else{
                labelResultForContact = new Label(number + " " + playerName + ": " + Game.getGameInstance().getCurrentUserAccount().getMoney());

            }
            labelResultForContact.setTextFill(Paint.valueOf("Black"));
            labelResultForContact.setFont(Font.font(25));
            labelResultForContact.setStyle("-fx-background-color: rgb(114,144,174);-fx-arc-height: 30;-fx-arc-width: 30");
            labelResultForContact.relocate(500, StartYForPlayername);

            currentPlayerNodeSortbyMoney.add(labelResultForContact);
            labelResultForContact.setViewOrder(-0.95);
            root.getChildren().addAll(labelResultForContact);
            number++;
            StartYForPlayername += 50;
        }
    }

    private void RemoveScoreBoardItemsFromViewAndDeleteOldNodesFromArray() {
        for (Node node : currentPlayerNodeSortbyMoney) {
            root.getChildren().removeAll(node);
        }
        currentPlayerNodeSortbyMoney=new ArrayList<>();
    }

    private void SortCurrentPlayerScore() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> copy = new ArrayList<>(currentPlayerNameSortbyMoney);
        ArrayList<Integer> usersMoney = new ArrayList<>();
        for (String name : copy) {
            if (!name.equals(Game.getGameInstance().getCurrentUserAccount().getAccountName())) {
                usersMoney.add((Integer.valueOf(findPvViewByUserName(name).getContactMoneyInGame())));
            } else {
                usersMoney.add(Game.getGameInstance().getCurrentUserAccount().getMoney());
            }
        }
        while (copy.size() > 0) {
            int maxMoney = Collections.max(usersMoney);
            int index = usersMoney.indexOf((Integer) maxMoney);
            String name = copy.get(index);
            if (!name.equals(Game.getGameInstance().getCurrentUserAccount().getAccountName())) {
                if (Integer.valueOf(findPvViewByUserName(name).getContactMoneyInGame()).equals(maxMoney)) {
                    result.add(name);
                    copy.remove(index);
                    usersMoney.remove(index);
                }
            }else{
                if (Integer.valueOf(Game.getGameInstance().getCurrentUserAccount().getMoney()).equals(maxMoney)) {
                    result.add(name);
                    copy.remove(index);
                    usersMoney.remove(index);
                }
            }
        }
        currentPlayerNameSortbyMoney = new ArrayList<>(result);
    }

    private void AddCurrentPlayerInScoreBoardAndRemoveOldList() {
        currentPlayerNameSortbyMoney = new ArrayList<>();
        try {
            for (PVView pvView : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().values()) {
                currentPlayerNameSortbyMoney.add(pvView.getContactName());
            }
        }catch (Exception e){
//            e.printStackTrace();
        }
        currentPlayerNameSortbyMoney.add(Game.getGameInstance().getCurrentUserAccount().getAccountName());
    }

    public void ReloadCurrentPLayerSortedByMoneyAndViewWhenScoreBoardIsShowing() {
        AddCurrentPlayerInScoreBoardAndRemoveOldList();
        SortCurrentPlayerScore();
        if (scoreboardRectangle.getY()!=900){
            RemoveScoreBoardItemsFromViewAndDeleteOldNodesFromArray();
            AddScoreBoardItems();
        }
    }

    public static PVView findPvViewByUserName(String userName) {
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            if (entry.getValue().getContactName().equals(userName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void ShowThereIsAUserWithThisNameError(){
        Label error=new Label("There Is Another User With Your User Name.");
        error.relocate(780,130);
        error.setFont(Font.font(20));
        error.setTextFill(Paint.valueOf("White"));
        error.setStyle("-fx-background-color: rgb(50,0,0)");
        root.getChildren().addAll(error);
        Rectangle rectangle=new Rectangle(0,0,0,30);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        error.setClip(rectangle);
        KeyValue w=new KeyValue(rectangle.widthProperty(),500);
        KeyFrame wFrame=new KeyFrame(Duration.seconds(2),w);
        Timeline timeline=new Timeline(wFrame);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KeyValue opacity=new KeyValue(rectangle.opacityProperty(),0);
                KeyFrame opacityFrame=new KeyFrame(Duration.seconds(2),opacity);
                Timeline opacityTimeLine=new Timeline(opacityFrame);
                opacityTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        root.getChildren().removeAll(error);
                    }
                });
                opacityTimeLine.play();
            }
        });
        timeline.play();

    }

    private void AddBazarClick(Stage primaryStage){
        Label bazar=new Label("Bazaar");
        bazar.relocate(695,655);
        bazar.setFont(Font.font(20));
        bazar.setTextFill(Paint.valueOf("White"));
        Rectangle bazarRec=new Rectangle(680,620,90,100);
        bazarRec.setFill(Paint.valueOf("White"));
        bazarRec.setArcWidth(20);
        bazarRec.setArcHeight(20);
        bazarRec.setOpacity(0.2);
        root.getChildren().addAll(bazar,bazarRec);
        bazarRec.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bazarRec.setOpacity(0.4);
            }
        });
        bazarRec.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bazarRec.setOpacity(0.2);
            }
        });

        bazarRec.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    boolean checkServerOrGuest=GameView.getGameView().getStartMenuView().getServerOrGuest() instanceof ServerSocketRunnable;
                    boolean checkConnectedUsers=GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().size()!=0;
                    if (checkConnectedUsers | checkServerOrGuest ) {
                        try {
                            Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
                            setBazaarView(new BazaarView(Main.getPrimaryStage()));
                            primaryStage.setScene(GameView.getGameView().getHostAndGuestView().getBazaarView().getScene());
                            primaryStage.setFullScreen(true);
                        } catch (MissionNotLoaded e) {
                            PlayErrorSound();
                            ShowYouShouldBeInMissionAndConnectedToServerToAccessBazaar();
                        } catch (UnknownObjectException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ShowYouShouldBeInMissionAndConnectedToServerToAccessBazaar();
                    }
                }catch (Exception e){
                    ShowYouShouldBeInMissionAndConnectedToServerToAccessBazaar();
                }
            }
        });
    }

    private void ReloadStateOfUsersAndServer(){
        if (GameView.getGameView().getStartMenuView().getServerOrGuest()!=null) {
            for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
                if (Changes.getUserThatArePlayingMissionNow().contains(entry.getValue().getContactName())) {
                    entry.getValue().setUserIsPlayingAMissionAndAddLabel();
                } else {
                    entry.getValue().setUserIsNotPlayingAndRemoveTheLabel();
                }
            }
        }
    }

    public void AddReturnToGame(Stage primaryStage) {
        Label label = new Label("Game");
        label.setTextFill(Paint.valueOf("White"));
        label.setFont(Font.font(20));
        label.relocate(180, 25);
        Rectangle rectangle = new Rectangle(165, 20, 115, 45);
        rectangle.setFill(Paint.valueOf("White"));
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        rectangle.setOpacity(0.1);
        rectangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.setOpacity(0.2);
            }
        });
        rectangle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.setOpacity(0.1);
            }
        });
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameView.getGameView().getFarmView().getAnimationTimer().start();
                primaryStage.setScene(GameView.getGameView().getFarmView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        root.getChildren().addAll(label, rectangle);
    }

    public void RemoveReturnToMainMenuView(){
        if (root.getChildren().contains(returnToMainMenu)){
            root.getChildren().removeAll(returnToMainMenu);
        }
    }

    public void ShowYouShouldBeInMissionAndConnectedToServerToAccessBazaar(){
        Label error=new Label("You Should Be In A Mission And Connected To Server To Access The ServerBazaar.");
        error.relocate(780,130);
        error.setFont(Font.font(20));
        error.setTextFill(Paint.valueOf("White"));
        error.setStyle("-fx-background-color: rgb(50,0,0)");
        root.getChildren().addAll(error);
        Rectangle rectangle=new Rectangle(0,0,0,30);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        error.setClip(rectangle);
        KeyValue w=new KeyValue(rectangle.widthProperty(),800);
        KeyFrame wFrame=new KeyFrame(Duration.seconds(3),w);
        Timeline timeline=new Timeline(wFrame);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KeyValue opacity=new KeyValue(rectangle.opacityProperty(),0);
                KeyFrame opacityFrame=new KeyFrame(Duration.seconds(3),opacity);
                Timeline opacityTimeLine=new Timeline(opacityFrame);
                opacityTimeLine.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        root.getChildren().removeAll(error);
                    }
                });
                opacityTimeLine.play();
            }
        });
        timeline.play();

    }
}