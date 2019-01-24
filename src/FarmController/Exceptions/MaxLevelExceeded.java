package FarmController.Exceptions;

import static View.View.PlayErrorSound;

public class MaxLevelExceeded extends Exception {
    public MaxLevelExceeded(){
        PlayErrorSound();
    }
}
