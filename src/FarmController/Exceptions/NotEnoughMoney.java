package FarmController.Exceptions;

import static View.View.PlayErrorSound;

public class NotEnoughMoney extends Exception {
    public NotEnoughMoney(){
        PlayErrorSound();
    }
}
