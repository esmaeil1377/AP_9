package View.ScenesAndMainGroupView;

import FarmModel.Internet.Changes;
import View.GameView;
import View.Main;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PVView extends View.View {
    private Group root = new Group();
    private Scene scene = new Scene(root, 1500, 700, Color.rgb(150, 150, 230));
    private String contactName;
    private String contactLevelInMission;
    private String contactMoneyInGame;
    private int endHeightOfTheMassages = 120;
    private int endHeightOfTheContacts=120;
    private TextField inputingTextField;
    private HashMap<String, Integer> datasNotWrittenInPVViewAndTheXPosition = new HashMap<>();
    private ArrayList<String> dataToSendThatWeDidntSendThem = new ArrayList<>();
    private ArrayList<Node> massageHistoryNodes =new ArrayList<>();
    private ArrayList<Node> currentContactsNode=new ArrayList<>();
//    private ArrayList<String> massagedidntshowedInInGroup = new ArrayList<>();


    public String getContactMoneyInGame() {
        return contactMoneyInGame;
    }

    public String getContactLevelInMission() {
        return contactLevelInMission;
    }

    public void setContactMoneyInGame(String contactMoneyInGame) {
        this.contactMoneyInGame = contactMoneyInGame;
        AddUserMoneyToPvView();
    }

    public void setContactLevelInMission(String contactLevelInMission) {
        this.contactLevelInMission = contactLevelInMission;
        AddUserLevelToPvView();
    }


    public ArrayList<String> getDataToSendThatWeDidntSendThem() {
        return dataToSendThatWeDidntSendThem;
    }

    public String getContactName() {
        return contactName;
    }

    public Scene getScene() {
        return scene;
    }

    public Group getRoot() {
        return root;
    }

    public PVView(String contactName) {
        this.contactName = contactName;
        Start(Main.getPrimaryStage());
    }
    public void setDataToSendThatWeDidntSendThem(ArrayList<String> dataToSendThatWeDidntSendThem) {
        this.dataToSendThatWeDidntSendThem = dataToSendThatWeDidntSendThem;
    }

    public void AddDataToMassageToSendThatWeDidntSendThem(String str) {
        dataToSendThatWeDidntSendThem.add(str);
    }

    public void AddDataToDataNotWritten(String data, int i) {
        datasNotWrittenInPVViewAndTheXPosition.put(data, i);
    }

    public HashMap<String, Integer> getMassagesNotWrittenInPVView() {
        return datasNotWrittenInPVViewAndTheXPosition;
    }

    public void setDatasNotWrittenInPVViewAndTheXPosition(HashMap<String, Integer> datasNotWrittenInPVViewAndTheXPosition) {
        this.datasNotWrittenInPVViewAndTheXPosition = datasNotWrittenInPVViewAndTheXPosition;
    }

    @Override
    public void Start(Stage primaryStage) {
        AddShopBackgroundTBackground(primaryStage);
        AddBackgroundBlackRectangle();
        AddGroupRectangleAndContactRectangle();
        AddTextFieldTOSendInGroup();
        AddReturnTheGroup(primaryStage);
        AddUserNameToPvView();
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

    private void AddShopBackgroundTBackground(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
        root.getChildren().addAll(BackGroundView);
    }

    private void AddBackgroundBlackRectangle() {
        Rectangle rectangle = new Rectangle(50, 100, 1450, 760);
        rectangle.setFill(Color.rgb(0, 0, 0));
        rectangle.setOpacity(0.5);
        rectangle.setArcWidth(50);
        rectangle.setArcHeight(50);
        root.getChildren().addAll(rectangle);
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

        root.getChildren().addAll(rectangle);

        Rectangle rectangle2 = new Rectangle(775, 120, 700, 700);
        rectangle2.setFill(Color.rgb(0, 158, 130));
        rectangle2.setArcWidth(30);
        rectangle2.setArcHeight(30);
        rectangle2.setOpacity(0.4);
        MakeContactsViewScrolling(rectangle2);

        root.getChildren().addAll(rectangle2);
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
                TextField ipTextField=GameView.getGameView().getHostAndGuestView().getIpTextField();
                if (GameView.getGameView().getHostAndGuestView().getRoot().getChildren().contains(ipTextField)){
                    String massage=textField.getText();
                    if(getContactName().length()>7){
                        if(getContactName().substring(0,7).equals("Server:")){
                            Changes.AddMassageToMassageThatShouldSend(massage);
                        }else{
                            Changes.AddMassageToMassageThatShouldSend("#" + getContactName() + "#" + massage);
                        }
                    }else {
                        Changes.AddMassageToMassageThatShouldSend("#" + getContactName() + "#" + massage);
                    }
                    getMassagesNotWrittenInPVView().put(massage, 200);
                    Changes.WeHaveNewMassageToShow();
                }else {
                    String massage = textField.getText();
                    getMassagesNotWrittenInPVView().put(massage,200);
                    Changes.WeHaveNewMassageToShow();
                    getDataToSendThatWeDidntSendThem().add(massage);
                }
            }
        });

        root.getChildren().addAll(textField, sendLabel, clipRectangle);
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
                            root.getChildren().removeAll(node);
                        } catch (Exception e) {
                        }
                    }
                }
                else if (((Rectangle) node).getY() - y <= 120 | ((Rectangle) node).getY() - y >= 750) {
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
                }
                else if (node.getLayoutY() - y <= 120 | node.getLayoutY() - y >= 750) {
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

    private void MakeContactsViewScrolling(Node node){
        node.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                makeNodesChangeTheY((int)(event.getDeltaY()/8),currentContactsNode);
            }
        });

    }

    private void AddReturnTheGroup(Stage primaryStage){
        Label label=new Label("ChatRoom");
        label.setTextFill(Paint.valueOf("White"));
        label.setFont(Font.font(20));
        label.relocate(25,25);
        Rectangle rectangle=new Rectangle(20,20,110,45);
        rectangle.setFill(Paint.valueOf("White"));
        rectangle.setOpacity(0.1);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
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
                primaryStage.setScene(GameView.getGameView().getHostAndGuestView().getScene());
                primaryStage.setFullScreen(true);
            }
        });

        root.getChildren().addAll(label,rectangle);
    }

    private void AddUserNameToPvView(){
        Rectangle rectangle=new Rectangle(825,150,600,60);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        rectangle.setFill(Color.rgb(114,144,174));
        Label label=new Label("User Name: "+getContactName());
        label.setFont(Font.font(25));
        label.relocate(860,160);
        root.getChildren().addAll(rectangle,label);
    }

    private void AddUserMoneyToPvView(){
        Rectangle rectangle=new Rectangle(825,240,600,60);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        rectangle.setFill(Color.rgb(114,144,174));
        Label label=new Label("Money: "+getContactMoneyInGame());
        label.setFont(Font.font(25));
        label.relocate(860,260);
        root.getChildren().addAll(rectangle,label);
    }

    private void AddUserLevelToPvView(){
        Rectangle rectangle=new Rectangle(825,360,600,60);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        rectangle.setFill(Color.rgb(114,144,174));
        Label label=new Label("User Level: "+getContactLevelInMission());
        label.setFont(Font.font(25));
        label.relocate(860,370);
        root.getChildren().addAll(rectangle,label);
    }

}
