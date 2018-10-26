package Model;

public class Yield extends Requests {
    private static Yield yield=new Yield();

    private Yield(){}

    public static Yield getYieldInstance() {
        return yield;
    }
}
