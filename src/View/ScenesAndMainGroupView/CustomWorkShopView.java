package View.ScenesAndMainGroupView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import View.View;
import java.io.File;

public class CustomWorkShopView extends View {
    private TextField inputingTextField;
    private CheckBox checkBoxField;
    private Group rootCustomWorkShopViewView = new Group();
    private Scene sceneCustomWorkShopView = new Scene(rootCustomWorkShopViewView, 1600, 900);

    public Scene getSceneCustomWorkShopView() {
        return sceneCustomWorkShopView;
    }

    public CustomWorkShopView(Stage primaryStage) {
        Start(primaryStage);
    }
    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddIcons();
        AddEgg();
        AddMilk();
        AddWool();
        AddCake();
        AddCookie();
        AddPowder();
        AddFabric();
        AddFlour();
        AddCarnivalDress();
        AddDecoration();
        AddSewing();

        AddEgg(520);
        AddMilk(520);
        AddWool(520);
        AddCake(520);
        AddCookie(520);
        AddPowder(520);
        AddFabric(520);
        AddFlour(520);
        AddCarnivalDress(520);
        AddDecoration(520);
        AddSewing(520);
    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\GameShop.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        primaryStage.setFullScreen(true);
        BackGroundView.setFitHeight(1200);
        BackGroundView.setFitWidth(2000);
        rootCustomWorkShopViewView.getChildren().addAll(BackGroundView);
        primaryStage.setScene(sceneCustomWorkShopView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddIcons() {


        Rectangle rect_1 = new Rectangle(500, 875);
        rect_1.setOpacity(0.6);
        rect_1.setArcHeight(70);
        rect_1.setArcWidth(70);
        rect_1.setFill(Color.rgb(64, 45, 67));
        rect_1.relocate(550, 110);

        Rectangle rect_5 = new Rectangle(450, 750);
        rect_5.setOpacity(0.6);
        rect_5.setArcHeight(50);
        rect_5.setArcWidth(50);
        rect_5.setFill(Color.rgb(64, 45, 67));
        rect_5.relocate(575, 200);


        Rectangle rect_2 = new Rectangle(500, 875);
        rect_2.setOpacity(0.6);
        rect_2.setArcHeight(70);
        rect_2.setArcWidth(70);
        rect_2.setFill(Color.rgb(64, 45, 67));
        rect_2.relocate(1070, 110);

        Rectangle rect_6 = new Rectangle(450, 750);
        rect_6.setOpacity(0.6);
        rect_6.setArcHeight(50);
        rect_6.setArcWidth(50);
        rect_6.setFill(Color.rgb(64, 45, 67));
        rect_6.relocate(1095, 200);
        inputingTextField = new TextField();
        inputingTextField.setFont(Font.font(20));
        inputingTextField.relocate(200, 200);
        rootCustomWorkShopViewView.getChildren().addAll(rect_1, rect_2, rect_5, rect_6,inputingTextField);

        File inputText = new File("Data\\Input.png");
        Image inputTextImage = new Image(inputText.toURI().toString());
        ImageView inputTextView = new ImageView(inputTextImage);
        inputTextView.setFitHeight(100);
        inputTextView.setFitWidth(200);
        inputTextView.relocate(700, 105);

        File outputText = new File("Data\\Output.png");
        Image outputTextImage = new Image(outputText.toURI().toString());
        ImageView outputTextView = new ImageView(outputTextImage);
        outputTextView.setFitHeight(100);
        outputTextView.setFitWidth(200);
        outputTextView.relocate(1200, 105);
        File nameText = new File("Data\\NameText.png");
        Image nameTextImage = new Image(nameText.toURI().toString());
        ImageView nameTextView = new ImageView(nameTextImage);
        nameTextView.setFitHeight(75);
        nameTextView.setFitWidth(150);
        nameTextView.relocate(25, 180);

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
                okButtonView.relocate(745,995);
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
                cancelButtonView.relocate(920,995);
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
        rootCustomWorkShopViewView.getChildren().addAll(outputTextView,inputTextView,nameTextView,okButtonView,okTextView,cancelButtonView,cancelTextView);
    }
    private void AddEgg() {
        Text text = new Text("Egg");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215);
        File fileIcon = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }

    private void AddWool() {
        int shift = 50;
        Text text = new Text("Wool");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddMilk() {
        int shift = 100;
        Text text = new Text("Milk");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Milk.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddCookie() {
        int shift = 150;
        Text text = new Text("Cookie");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddCake() {
        int shift = 200;
        Text text = new Text("Cake");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddPowder() {
        int shift = 250;
        Text text = new Text("Powder");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddFabric() {
        int shift = 300;
        Text text = new Text("Fabric");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Fabric.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddFlour() {
        int shift = 350;
        Text text = new Text("Flour");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddSewing() {
        int shift = 400;
        Text text = new Text("Sewing");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Sewing.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddDecoration() {
        int shift = 450;
        Text text = new Text("Adornment");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Adornment.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddCarnivalDress() {
        int shift = 500;
        Text text = new Text("CarnivalDress");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }

    private void AddEgg(int xShift) {
        Text text = new Text("Egg");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215);
        File fileIcon = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }

    private void AddWool(int xShift) {
        int shift = 50;
        Text text = new Text("Wool");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddMilk(int xShift) {
        int shift = 100;
        Text text = new Text("Milk");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Milk.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddCookie(int xShift) {
        int shift = 150;
        Text text = new Text("Cookie");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddCake(int xShift) {
        int shift = 200;
        Text text = new Text("Cake");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddPowder(int xShift) {
        int shift = 250;
        Text text = new Text("Powder");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddFabric(int xShift) {
        int shift = 300;
        Text text = new Text("Fabric");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Fabric.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddFlour(int xShift) {
        int shift = 350;
        Text text = new Text("Flour");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddSewing(int xShift) {
        int shift = 400;
        Text text = new Text("Sewing");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Sewing.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddDecoration(int xShift) {
        int shift = 450;
        Text text = new Text("Adornment");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\Adornment.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
    private void AddCarnivalDress(int xShift) {
        int shift = 500;
        Text text = new Text("CarnivalDress");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(600 + xShift, 215 + shift);
        File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight(50);
        imageViewIcon.setFitWidth(50);
        imageViewIcon.relocate(775 + xShift, 210 + shift);
        checkBoxField = new CheckBox();
        checkBoxField.relocate(950 + xShift, 222 + shift);
        rootCustomWorkShopViewView.getChildren().addAll(text,imageViewIcon,checkBoxField);
    }
}

