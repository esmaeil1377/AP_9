package View.ScenesAndMainGroupView;

import FarmModel.Internet.Changes;
import View.GameView;
import View.Main;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PVView extends View.View {
    private Group rootPV = new Group();
    private Scene scenePv = new Scene(rootPV, 1500, 700, Color.rgb(150, 150, 230));
    private String contactName;
    private String contactLevelInMission;
    private String contactMoneyInGame;
    private int endOfTheMassages = 65;
    private TextField inputingTextField;
    private HashMap<String, Integer> datasNotWrittenInPVViewAndTheXPosition = new HashMap<>();
    private ArrayList<String> dataToSendThatWeDidntSendThem = new ArrayList<>();
    Label labelContactName = new Label(getContactName());

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactMoneyInGame(String contactMoneyInGame) {
        this.contactMoneyInGame = contactMoneyInGame;
    }

    public void setContactLevelInMission(String contactLevelInMission) {
        this.contactLevelInMission = contactLevelInMission;
    }

    public Label getLabelContactName() {
        return labelContactName;
    }

    public ArrayList<String> getDataToSendThatWeDidntSendThem() {
        return dataToSendThatWeDidntSendThem;
    }

    public String getContactName() {
        return contactName;
    }

    public Scene getScenePv() {
        return scenePv;
    }

    public Group getRootPV() {
        return rootPV;
    }

    public PVView(String contactName) {
        this.contactName = contactName;
        Start(Main.getPrimaryStage());
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddBackgroundBlackRectangle();
        AddContactName();
        AddReturnToHostViewButton(primaryStage);
        AddSendMassageButton();

        AddTextFiledForMassage();

    }


    public void ShowDataInPV(String str, int xForLocationToDetermineTheOwner) throws IOException {
        if (str.length() < 6) {
            int x;
            if (xForLocationToDetermineTheOwner > 100) {
                x = xForLocationToDetermineTheOwner + 100;
            } else {
                x = xForLocationToDetermineTheOwner;
            }
            Label labelMassage = new Label(str);
            labelMassage.setFont(Font.font(20));
            labelMassage.relocate(x, endOfTheMassages);
            endOfTheMassages = endOfTheMassages + 20 + 10;
            rootPV.getChildren().addAll(labelMassage);
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

            }else if (str.substring(0, 6).equals("Image ")) {
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
                labelMassage.relocate(x, endOfTheMassages);
                endOfTheMassages = endOfTheMassages + 20 + 10;
                rootPV.getChildren().addAll(labelMassage);
            }
        }
    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\ShopBackground.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(primaryStage.getMaxHeight());
        BackGroundView.setFitWidth(primaryStage.getMaxWidth());
        rootPV.getChildren().addAll(BackGroundView);
    }

    private void AddBackgroundBlackRectangle(){
        Rectangle rectangle =new Rectangle(50,100,1450,750);
        rectangle.setFill(Color.rgb(0,0,0));
        rectangle.setOpacity(0.5);
        rectangle.setArcWidth(50);
        rectangle.setArcHeight(50);

        rootPV.getChildren().addAll(rectangle);
    }

    private void AddContactName(){
        Rectangle rectangle = new Rectangle(550, 61, Color.rgb(60, 125, 139));
        rectangle.relocate(0, 0);

        labelContactName.setFont(Font.font(20));
        labelContactName.relocate(60, 15);

        Label contactLevel=new Label("0");
        contactLevel.relocate(80,15);
        Label contactMoney=new Label("0");
    }

    private void AddTextFiledForMassage(){
        inputingTextField = new TextField();
        inputingTextField.setFont(Font.font(20));
        inputingTextField.relocate(0, 650);
    }

    private void AddSendMassageButton(){
        Button sendButton = new Button("send");
        sendButton.relocate(470, 648);
        sendButton.setFont(Font.font(20));
        sendButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String massage = inputingTextField.getText();
                try {

                    AddDataToDataNotWritten(massage, 300);
                    Changes.WeHaveNewMassageToShow();
                    AddDataToMassageToSendThatWeDidntSendThem(massage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void AddReturnToHostViewButton(Stage primaryStage){
        Rectangle returnToHostView = new Rectangle(40, 40, Color.rgb(200, 200, 255));
        returnToHostView.relocate(10, 10);
        returnToHostView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getHostAndGuestView().getSceneHost());
                primaryStage.setFullScreen(true);
            }
        });
        Label returnLabel = new Label("<");
        returnLabel.relocate(12, 0);
        returnLabel.setFont(Font.font(40));
        returnLabel.setTextFill(Paint.valueOf("White"));
        returnLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getHostAndGuestView().getSceneHost());
                primaryStage.setFullScreen(true);
            }
        });
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

    private void AddDataImageOrGifsOrEmojiToPv(String path, int height, int width, int x) {
        File file=new File(path);
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.relocate(x, endOfTheMassages);
        endOfTheMassages += height + 10;
        rootPV.getChildren().addAll(imageView);
    }

}
