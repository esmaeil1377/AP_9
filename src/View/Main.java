package View;

import javafx.application.Application;
import javafx.stage.Stage;

import static View.View.PlayStartingSound;

//import static View.View.getRequest;

public class Main extends Application {
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        PlayStartingSound();
        setPrimaryStage(primaryStage);

        primaryStage.setScene(GameView.getGameView().getStartMenuView().getScene());
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}
