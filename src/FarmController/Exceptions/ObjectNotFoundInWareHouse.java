package FarmController.Exceptions;

import static View.View.PlayErrorSound;

public class ObjectNotFoundInWareHouse extends Exception {
    public ObjectNotFoundInWareHouse() {
        PlayErrorSound();
    }
}
