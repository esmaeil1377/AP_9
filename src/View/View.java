package View;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Mission;
import FarmModel.User;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

import static FarmController.RequestAnalayzer.RequestAnalayzer;

public abstract class View {
    private Group root;
    private Scene scene;

    public abstract void Start(Stage primaryStage) throws MissionNotLoaded, UnknownObjectException;


    public static void PlayBubbleSound() {
        String path = "Data\\Voice\\Bubble.mp3";
        String path1 = Paths.get(path).toUri().toString();
        AudioClip audioClip = new AudioClip(path1);
        audioClip.play();
    }

    public static void PlayErrorSound(){
        String path = "Data\\Voice\\Error0.wav";
        String path1 = Paths.get(path).toUri().toString();
        AudioClip audioClip = new AudioClip(path1);
        audioClip.play();
    }

    static void PlayStartingSound(){
        String path = "Data\\Voice\\BackgroundMusic1.mp3";
        String path1 = Paths.get(path).toUri().toString();
        AudioClip audioClip = new AudioClip(path1);
        audioClip.play();
    }
}