package FarmController.Exceptions;

import FarmModel.Internet.Changes;
import View.GameView;
import View.Main;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;

public class MissionIsFinished extends Exception{
    public MissionIsFinished() throws MissionNotLoaded {
        PlayVictorySound();
        GameView.getGameView().getFarmView().getAnimationTimer().stop();
        GameView.getGameView().getFarmView().ShowMissionResultInTheEnd(Main.getPrimaryStage());
        Changes.WeHaveNewContact();
    }

    private void PlayVictorySound() {
        String path = "Data\\Voice\\Victory.mp3";
        String path1 = Paths.get(path).toUri().toString();
        AudioClip audioClip = new AudioClip(path1);
        audioClip.play();
    }
}
