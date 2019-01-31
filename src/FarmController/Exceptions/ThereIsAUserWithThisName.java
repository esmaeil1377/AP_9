package FarmController.Exceptions;

import FarmModel.Internet.Changes;
import View.GameView;
import javafx.scene.control.TextField;

import static View.View.PlayErrorSound;

public class ThereIsAUserWithThisName extends Exception {
    public ThereIsAUserWithThisName(){
        PlayErrorSound();
    }
}
