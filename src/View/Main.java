package View;

import javafx.application.Application;
import javafx.stage.Stage;

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
        setPrimaryStage(primaryStage);

        primaryStage.setScene(GameView.getGameView().getStartMenuView().getSceneStartMenuView());
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}
