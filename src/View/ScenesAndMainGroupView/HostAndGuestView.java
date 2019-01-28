package View.ScenesAndMainGroupView;

import FarmModel.Internet.Changes;
import FarmModel.Internet.ServerAndClientRunnable.ServerSocketRunnable;
import View.GameView;
import javafx.animation.AnimationTimer;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HostAndGuestView extends View.View {
    private Group rootHost = new Group();
    private Scene SceneHost = new Scene(rootHost, 1500, 700);
    private TextField userPort = new TextField("8050");
    private TextField ipTextField = new TextField("serverip");
    private TextField portTextField = new TextField("serverport");
    private int endHeightOfTheMassages = 120;
    private int endHeightOfTheContacts=120;
    private ServerSocketRunnable serverSocketRunnable;
    private ArrayList<String> massageNotWrittenInInGroup = new ArrayList<>();
    private ArrayList<String> historyMassage = new ArrayList<>();
    private ArrayList<Node> massageHistoryNodes =new ArrayList<>();
    private ArrayList<Node> currentContactsNode=new ArrayList<>();

    public ArrayList<String> getHistoryMassage() {
        return historyMassage;
    }

    public Scene getSceneHost() {
        return SceneHost;
    }

    public ServerSocketRunnable getServerSocketRunnable() {
        return serverSocketRunnable;
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
                if (now - lastTime > (second / 10)) {
                    //this check every 0.5 sec to upload every thing like PVView and IsNewMassage.
                    lastTime = now;
                    time += 1;
                    if (Changes.isThereAnyNewContact()) {
                        ReloadPVContacts();
                        Changes.ContactViewReloaded();
                    }
                    if (Changes.isThereAnyNewMassage()) {
                        try {
                            AddNewMassagesToAllocatedPvAndGroup();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Changes.MassagesAdded();
                    }
                }
            }
        };
        animationTimer.start();
        AddBackGround(primaryStage);
        AddGroupRectangleAndContactRectangle();
        AddBackgroundBlackRectangle();
        AddTextFieldToGetPort();
        AddTextFieldTOSendInGroup();

        try {
            for (Map.Entry<Socket, PVView> socketPVViewEntry : serverSocketRunnable.getConnectedSockets().entrySet()) {
                AddNewContactWhenItConnectToOurPort(socketPVViewEntry.getKey(), primaryStage);
            }
        } catch (Exception e) {
        }

    }

    private void MakeOkMagnifier(ImageView imageView) {
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String port = userPort.getText();
                serverSocketRunnable = new ServerSocketRunnable(port);

            }
        });
    }

    private void AddNewContactWhenItConnectToOurPort(Socket socket, Stage primaryStage) {
        Rectangle rectangle = new Rectangle(10, endHeightOfTheMassages, 300, 45);
        rectangle.setFill(Color.rgb(144, 144, 144));
        rectangle.setOpacity(0.6);
        Label contactLabel = new Label("C:" + socket.toString());
        contactLabel.relocate(15, endHeightOfTheContacts + 5);
        endHeightOfTheContacts += 45 + 10;
        contactLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HashMap<Socket, PVView> sockets = serverSocketRunnable.getConnectedSockets();
                primaryStage.setScene(sockets.get(socket).getScenePv());
            }
        });
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HashMap<Socket, PVView> sockets = serverSocketRunnable.getConnectedSockets();
                primaryStage.setScene(sockets.get(socket).getScenePv());
            }
        });
        currentContactsNode.add(rectangle);
        currentContactsNode.add(contactLabel);
        MakeContactsViewScrolling(rectangle);
        MakeContactsViewScrolling(contactLabel);
        rootHost.getChildren().addAll(rectangle, contactLabel);
    }

    private void AddServerIP() {
        ServerSocket serverSocket = GameView.getGameView().getHostAndGuestView().getServerSocketRunnable().getServerSocket();
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
            rootHost.getChildren().addAll(labelMassage);
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
                rootHost.getChildren().addAll(labelMassage);
                massageHistoryNodes.add(labelMassage);
            }
        }
    }

    public void ReloadPVContacts() {
        GameView.getGameView().setHostAndGuestView(new HostAndGuestView());
    }

    public void AddNewMassagesToAllocatedPvAndGroup() throws IOException {
        for (PVView pvView : GameView.getGameView().getHostAndGuestView().getServerSocketRunnable().getConnectedSockets().values()) {
            if (pvView.getMassagesNotWrittenInPVView().size() != 0) {
                for (Map.Entry<String, Integer> stringIntegerEntry : pvView.getMassagesNotWrittenInPVView().entrySet()) {
                    pvView.ShowDataInPV(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
                pvView.setDatasNotWrittenInPVViewAndTheXPosition(new HashMap<>());
            }
        }
        for (String string : massageNotWrittenInInGroup) {
            ShowDataInPV(string, 60);
        }
        massageNotWrittenInInGroup = new ArrayList<>();
    }

    private void AddDataImageOrGifsOrEmojiToPv(String path, int height, int width, int x) {
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.relocate(x, endHeightOfTheMassages);
        endHeightOfTheMassages += height + 10;
        rootHost.getChildren().addAll(imageView);
    }

    public void AddMassageToMassageNotWrittenAndHistory(String massage) {
        massageNotWrittenInInGroup.add(massage);
        historyMassage.add(massage);
    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
        rootHost.getChildren().addAll(BackGroundView);
    }

    private void AddBackgroundBlackRectangle() {
        Rectangle rectangle = new Rectangle(50, 100, 1450, 760);
        rectangle.setFill(Color.rgb(0, 0, 0));
        rectangle.setOpacity(0.5);
        rectangle.setArcWidth(50);
        rectangle.setArcHeight(50);

        rootHost.getChildren().addAll(rectangle);
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
                makeNodesChangeTheY((int)(event.getDeltaY()/8),massageHistoryNodes);
            }
        });

        rootHost.getChildren().addAll(rectangle);

        Rectangle rectangle2 = new Rectangle(775, 120, 700, 700);
        rectangle2.setFill(Color.rgb(0, 158, 130));
        rectangle2.setArcWidth(30);
        rectangle2.setArcHeight(30);
        rectangle2.setOpacity(0.4);

        rootHost.getChildren().addAll(rectangle2);
    }

    private void AddTextFieldToGetPort() {
        userPort.relocate(1200, 56);
        userPort.setFont(Font.font(20));
        rootHost.getChildren().addAll(userPort);

        //add Magnifier


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

            }
        });

        rootHost.getChildren().addAll(textField, sendLabel, clipRectangle);
    }

    private void AddTextFieldToGetServerIPAndServerPort() {
        ipTextField.setFont(Font.font(20));
        ipTextField.relocate(70, 56);
        portTextField.setFont(Font.font(20));
        portTextField.relocate(300, 56);
        Rectangle ipRectangle = new Rectangle(0, 0, 200, 60);
        ipTextField.setClip(ipRectangle);
        Rectangle portRectangle = new Rectangle(0, 0, 200, 60);
        portTextField.setClip(portRectangle);
        rootHost.getChildren().addAll(ipTextField, portTextField);
    }

    private void makeNodesChangeTheY(int y,ArrayList<Node> nodes){
        for (Node node: nodes) {
            if (node instanceof Rectangle) {
                int newx=(int)((Rectangle) node).getX();
                int newy=(int)((Rectangle) node).getY()+y;
                node.relocate(newx, newy);
                if (((Rectangle) node).getY() - y >= 119 & ((Rectangle) node).getY() - y <= 750) {
                    if (((Rectangle) node).getY() >= 750 | ((Rectangle) node).getY() <= 120) {
                        try {
                            rootHost.getChildren().removeAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
                else if (((Rectangle) node).getY() - y <= 120 | ((Rectangle) node).getY() - y >= 750) {
                    if (((Rectangle) node).getY() <= 750 & ((Rectangle) node).getY() >= 120) {
                        try {
                            rootHost.getChildren().addAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
            } else {

                node.relocate(node.getLayoutX(), node.getLayoutY() + y);
                if (node.getLayoutY() - y >= 119 & node.getLayoutY() - y <= 750) {
                    if (node.getLayoutY() >= 750 | node.getLayoutY() <= 120) {
                        try {
                            rootHost.getChildren().removeAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
                else if (node.getLayoutY() - y <= 120 | node.getLayoutY() - y >= 750) {
                    if (node.getLayoutY() <= 750 & node.getLayoutY() >= 120) {
                        try {
                            rootHost.getChildren().addAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    private void MakeContactsViewScrolling(Node node){
        node.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                makeNodesChangeTheY((int)(event.getDeltaY()/8),currentContactsNode);
            }
        });

    }


}
