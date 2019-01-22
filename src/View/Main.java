package View;

import FarmController.Exceptions.FullWareHouse;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEmptyWell;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Request.TurnRequest;
import javafx.animation.AnimationTimer;
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

        AnimationTimer animationTimer=new AnimationTimer() {
            long time=-1;

            @Override
            public void handle(long now) {
                if(time==-1) time=now;
                if(now-time>1000000000){
                    time=now;
                    try {
                        new TurnRequest("turn 1");
                        System.out.println("one turn passed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        primaryStage.setScene(GameView.getGameView().getStartMenuView().getSceneStartMenuView());
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}
