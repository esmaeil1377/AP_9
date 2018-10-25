package Model;

public class NextId {
    private static int NextId = 1;
    public static int NextId(){
        NextId += 1;
        return NextId;
    }
}
