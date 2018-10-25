package Model;

public class NextId {
    private static int NextId = 1;
    public int NextId(){
        this.NextId += 1;
        return NextId;
    }
}
