package FarmController.Exceptions;

import static View.View.PlayErrorSound;

public class WellIsNotEmpty extends Exception {
    public WellIsNotEmpty(){
        PlayErrorSound();
    }
}
