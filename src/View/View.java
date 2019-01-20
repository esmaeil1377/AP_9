package View;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.Scanner;

import static FarmController.RequestAnalayzer.RequestAnalayzer;

public abstract class View {
    private static Scanner scanner = new Scanner(System.in);

//    public static void getRequest() {
//        String input;
//        while (true) {
//            input = scanner.nextLine();
//            try {
//                RequestAnalayzer(input);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public abstract void Start(Stage primaryStage);

    public static void PlayBubbleSound() {
        String path = "Data\\Voice\\Bubble.mp3";
        String path1 = Paths.get(path).toUri().toString();
        AudioClip audioClip = new AudioClip(path1);
        audioClip.play();
    }

}
