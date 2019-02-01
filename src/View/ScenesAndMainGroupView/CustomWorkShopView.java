package View.ScenesAndMainGroupView;

import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.CustomWorkShop;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
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

public class CustomWorkShopView<Static> extends View {
    double xShift = 0.768;
    double yShift = 0.768;
    private String workShopName;
    public Integer i = 1;
    private TextField inputingTextField;
    private CheckBox checkBoxField;
    private Group rootCustomWorkShopViewView = new Group();
    private Scene sceneCustomWorkShopView = new Scene(rootCustomWorkShopViewView, (int) (xShift * 1600), (int) (yShift * 900));

    public Scene getSceneCustomWorkShopView() {
        return sceneCustomWorkShopView;
    }

    public CustomWorkShopView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
        AddImage();
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
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        rootCustomWorkShopViewView.getChildren().addAll(BackGroundView);
        primaryStage.setScene(sceneCustomWorkShopView);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void AddIcons() {


        Rectangle rect_1 = new Rectangle((int) (xShift * 500), (int) (yShift * 875));
        rect_1.setOpacity(0.6);
        rect_1.setArcHeight(70);
        rect_1.setArcWidth(70);
        rect_1.setFill(Color.rgb(64, 45, 67));
        rect_1.relocate((int) (xShift * 550), (int) (yShift * 110));

        Rectangle rect_5 = new Rectangle((int) (xShift * 450), (int) (yShift * 750));
        rect_5.setOpacity(0.6);
        rect_5.setArcHeight(50);
        rect_5.setArcWidth(50);
        rect_5.setFill(Color.rgb(64, 45, 67));
        rect_5.relocate((int) (xShift * 575), (int) (yShift * 200));


        Rectangle rect_2 = new Rectangle((int) (xShift * 500), (int) (yShift * 875));
        rect_2.setOpacity(0.6);
        rect_2.setArcHeight(70);
        rect_2.setArcWidth(70);
        rect_2.setFill(Color.rgb(64, 45, 67));
        rect_2.relocate((int) (xShift * 1070), (int) (yShift * 110));

        Rectangle rect_6 = new Rectangle((int) (xShift * 450), (int) (yShift * 750));
        rect_6.setOpacity(0.6);
        rect_6.setArcHeight(50);
        rect_6.setArcWidth(50);
        rect_6.setFill(Color.rgb(64, 45, 67));
        rect_6.relocate((int) (xShift * 1095), (int) (yShift * 200));
        inputingTextField = new TextField();
        inputingTextField.setFont(Font.font(20));
        inputingTextField.relocate((int) (xShift * 200), (int) (yShift * 200));
        rootCustomWorkShopViewView.getChildren().addAll(rect_1, rect_2, rect_5, rect_6, inputingTextField);

        File inputText = new File("Data\\Input.png");
        Image inputTextImage = new Image(inputText.toURI().toString());
        ImageView inputTextView = new ImageView(inputTextImage);
        inputTextView.setFitHeight((int) (yShift * 100));
        inputTextView.setFitWidth((int) (xShift * 200));
        inputTextView.relocate((int) (xShift * 700), (int) (yShift * 105));

        File outputText = new File("Data\\Output.png");
        Image outputTextImage = new Image(outputText.toURI().toString());
        ImageView outputTextView = new ImageView(outputTextImage);
        outputTextView.setFitHeight((int) (yShift * 100));
        outputTextView.setFitWidth((int) (xShift * 200));
        outputTextView.relocate((int) (xShift * 1200), (int) (yShift * 105));
        File nameText = new File("Data\\NameText.png");
        Image nameTextImage = new Image(nameText.toURI().toString());
        ImageView nameTextView = new ImageView(nameTextImage);
        nameTextView.setFitHeight((int) (yShift * 75));
        nameTextView.setFitWidth((int) (xShift * 150));
        nameTextView.relocate((int) (xShift * 25), (int) (yShift * 180));

        File okButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image okButtonImage = new Image(okButton.toURI().toString());
        ImageView okButtonView = new ImageView(okButtonImage);
        okButtonView.setFitHeight((int) (yShift * 75));
        okButtonView.setFitWidth((int) (xShift * 160));
        okButtonView.relocate((int) (xShift * 750), (int) (yShift * 1000));
        okButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate((int) (xShift * 745), (int) (yShift * 995));
                okButtonView.setFitHeight((int) (yShift * 85));
                okButtonView.setFitWidth((int) (xShift * 170));
            }
        });
                okButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        okButtonView.setFitHeight((int) (yShift * 75));
                        okButtonView.setFitWidth((int) (xShift * 160));
                        okButtonView.relocate((int) (xShift * 750), (int) (yShift * 1000));

            }
        });
                okButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
//                        CustomWorkShop customWorkShop = new CustomWorkShop(1,workShopName,)
                    }
                });

        File okText = new File("Data\\Textures\\Service\\OkText.png");
        Image okTextImage = new Image(okText.toURI().toString());
        ImageView okTextView = new ImageView(okTextImage);
        okTextView.setFitHeight((int) (yShift * 30));
        okTextView.setFitWidth((int) (xShift * 100));
        okTextView.relocate((int) (xShift * 775), (int) (yShift * 1025));
        okTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate((int) (xShift * 745), (int) (yShift * 995));
                okButtonView.setFitHeight((int) (yShift * 85));
                okButtonView.setFitWidth((int) (xShift * 170));
            }
        });
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.setFitHeight((int) (yShift * 75));
                okButtonView.setFitWidth((int) (xShift * 150));
                okButtonView.relocate((int) (xShift * 750), (int) (yShift * 1000));
            }
        });

        File cancelButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image cancelButtonImage = new Image(cancelButton.toURI().toString());
        ImageView cancelButtonView = new ImageView(cancelButtonImage);
        cancelButtonView.setFitHeight((int) (yShift * 75));
        cancelButtonView.setFitWidth((int) (xShift * 160));
        cancelButtonView.relocate((int) (xShift * 925), (int) (yShift * 1000));
        cancelButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.relocate((int) (xShift * 920), (int) (yShift * 995));
                cancelButtonView.setFitHeight((int) (yShift * 85));
                cancelButtonView.setFitWidth((int) (xShift * 170));
                cancelButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        cancelButtonView.setFitHeight((int) (yShift * 75));
                        cancelButtonView.setFitWidth((int) (xShift * 160));
                        cancelButtonView.relocate((int) (xShift * 925), (int) (yShift * 1000));
                    }
                });

            }
        });
        File cancelText = new File("Data\\MenuClick\\Cancel.png");
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
        okTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cancelButtonView.setFitHeight((int) (yShift * 75));
                cancelButtonView.setFitWidth((int) (xShift * 160));
                cancelButtonView.relocate((int) (xShift * 925), (int) (yShift * 1000));
            }
        });
        rootCustomWorkShopViewView.getChildren().addAll(outputTextView, inputTextView, nameTextView, okButtonView, okTextView, cancelButtonView, cancelTextView);
    }

    private void AddEgg() {
        Text text = new Text("Egg");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * 215));
        File fileIcon = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * 210));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * 222));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddWool() {
        int shift = 50;
        Text text = new Text("Wool");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddMilk() {
        int shift = 100;
        Text text = new Text("Milk");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Milk.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddCookie() {
        int shift = 150;
        Text text = new Text("Cookie");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddCake() {
        int shift = 200;
        Text text = new Text("Cake");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddPowder() {
        int shift = 250;
        Text text = new Text("Powder");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddFabric() {
        int shift = 300;
        Text text = new Text("Fabric");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Fabric.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddFlour() {
        int shift = 350;
        Text text = new Text("Flour");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddSewing() {
        int shift = 400;
        Text text = new Text("Sewing");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Sewing.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddDecoration() {
        int shift = 450;
        Text text = new Text("Adornment");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Adornment.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (xShift * 50));
        imageViewIcon.setFitWidth((int) (yShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddCarnivalDress() {
        int shift = 500;
        Text text = new Text("CarnivalDress");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * 600), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * 805), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * 950), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddEgg(int xxShift) {
        Text text = new Text("Egg");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * 215));
        File fileIcon = new File("Data\\Textures\\Products\\Egg\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * 210));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * 222));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddWool(int xxShift) {
        int shift = 50;
        Text text = new Text("Wool");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Wool\\normal.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddMilk(int xxShift) {
        int shift = 100;
        Text text = new Text("Milk");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Milk.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddCookie(int xxShift) {
        int shift = 150;
        Text text = new Text("Cookie");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Cake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddCake(int xxShift) {
        int shift = 200;
        Text text = new Text("Cake");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\FlouryCake.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (xShift * 50));
        imageViewIcon.setFitWidth((int) (yShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddPowder(int xxShift) {
        int shift = 250;
        Text text = new Text("Powder");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\EggPowder.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddFabric(int xxShift) {
        int shift = 300;
        Text text = new Text("Fabric");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Fabric.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddFlour(int xxShift) {
        int shift = 350;
        Text text = new Text("Flour");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Flour.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddSewing(int xxShift) {
        int shift = 400;
        Text text = new Text("Sewing");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Sewing.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddDecoration(int xxShift) {
        int shift = 450;
        Text text = new Text("Adornment");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\Adornment.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    private void AddCarnivalDress(int xxShift) {
        int shift = 500;
        Text text = new Text("CarnivalDress");
        text.setFont(Font.font(25));
        text.setFill(Color.rgb(255, 255, 255));
        text.setStyle("-fx-font-weight: bold");
        text.relocate((int) (xShift * (600 + xxShift)), (int) (yShift * (215 + shift)));
        File fileIcon = new File("Data\\Textures\\Products\\CarnivalDress.png");
        Image imageIcon = new Image(fileIcon.toURI().toString());
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitHeight((int) (yShift * 50));
        imageViewIcon.setFitWidth((int) (xShift * 50));
        imageViewIcon.relocate((int) (xShift * (805 + xxShift)), (int) (yShift * (210 + shift)));
        checkBoxField = new CheckBox();
        checkBoxField.relocate((int) (xShift * (950 + xxShift)), (int) (yShift * (222 + shift)));
        rootCustomWorkShopViewView.getChildren().addAll(text, imageViewIcon, checkBoxField);
    }

    public void AddImage() {
        File fileIcon_1 = new File("Data\\Textures\\Workshops\\Custom\\1.png");
        Image imageIcon_1 = new Image(fileIcon_1.toURI().toString());
        File fileIcon_2 = new File("Data\\Textures\\Workshops\\Custom\\2.png");
        Image imageIcon_2 = new Image(fileIcon_2.toURI().toString());
        File fileIcon_3 = new File("Data\\Textures\\Workshops\\Custom\\3.png");
        Image imageIcon_3 = new Image(fileIcon_3.toURI().toString());
        File fileIcon_4 = new File("Data\\Textures\\Workshops\\Custom\\4.png");
        Image imageIcon_4 = new Image(fileIcon_4.toURI().toString());
        File fileIcon_5 = new File("Data\\Textures\\Workshops\\Custom\\5.png");
        Image imageIcon_5 = new Image(fileIcon_5.toURI().toString());
        ImageView imageViewIcon = new ImageView();
        File okButton = new File("Data\\Textures\\Service\\OkButton.png");
        Image okButtonImage = new Image(okButton.toURI().toString());
        ImageView okButtonView = new ImageView(okButtonImage);
        okButtonView.setFitHeight(50);
        okButtonView.setFitWidth(50);
        okButtonView.relocate(300, 500);
        okButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate(295, 495);
                okButtonView.setFitHeight(60);
                okButtonView.setFitWidth(60);
            }
        });
                okButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        okButtonView.setFitHeight(50);
                        okButtonView.setFitWidth(50);
                        okButtonView.relocate(300, 500);
                    }
                });
                okButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        i++;
                        if (i == 6)
                            i = 1;
                        if (i == 1)
                            imageViewIcon.setImage(imageIcon_1);
                        if (i == 2)
                            imageViewIcon.setImage(imageIcon_2);
                        if (i == 3)
                            imageViewIcon.setImage(imageIcon_3);
                        if (i == 4)
                            imageViewIcon.setImage(imageIcon_4);
                        if (i == 5)
                            imageViewIcon.setImage(imageIcon_5);


                    }
                });

        Text text = new Text(">");
        workShopName = text.getText();
        text.setFont(Font.font(30));
        text.setStyle("-fx-font-weight: bold");
        text.relocate(315, 500);
        text.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.relocate(295, 495);
                okButtonView.setFitHeight(60);
                okButtonView.setFitWidth(60);
            }
        });
        text.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                okButtonView.setFitHeight(50);
                okButtonView.setFitWidth(50);
                okButtonView.relocate(300, 500);
            }
        });
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                i++;
                if (i == 6)
                    i = 1;
                if (i == 1)
                    imageViewIcon.setImage(imageIcon_1);
                if (i == 2)
                    imageViewIcon.setImage(imageIcon_2);
                if (i == 3)
                    imageViewIcon.setImage(imageIcon_3);
                if (i == 4)
                    imageViewIcon.setImage(imageIcon_4);
                if (i == 5)
                    imageViewIcon.setImage(imageIcon_5);


            }
        });
        imageViewIcon.setImage(imageIcon_1);
        imageViewIcon.setFitHeight(250);
        imageViewIcon.setFitWidth(250);
        imageViewIcon.setViewport(new Rectangle2D(0, 0, 135, 140));
        imageViewIcon.relocate(25, 400);
        rootCustomWorkShopViewView.getChildren().addAll(imageViewIcon, okButtonView, text);
    }
}
