package FarmController.Exceptions;

import static View.View.PlayErrorSound;

public class FullWareHouse extends Exception {

    public FullWareHouse(){
        PlayErrorSound();
    }
}
